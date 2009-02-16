/*
	Copyright (c) 2009 Olivier Chafik, All Rights Reserved
	
	This file is part of JNAerator (http://jnaerator.googlecode.com/).
	
	JNAerator is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	
	JNAerator is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.
	
	You should have received a copy of the GNU General Public License
	along with JNAerator.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.ochafik.lang.jnaerator.studio;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;

import org.anarres.cpp.LexerException;
import org.antlr.runtime.RecognitionException;

import com.ochafik.io.JTextAreaOutputStream;
import com.ochafik.io.ReadText;
import com.ochafik.io.TextAreaOutputStream;
import com.ochafik.io.WriteText;
import com.ochafik.lang.jnaerator.JNAerator;
import com.ochafik.lang.jnaerator.JNAeratorConfig;
import com.ochafik.swing.syntaxcoloring.CCTokenMarker;
import com.ochafik.swing.syntaxcoloring.JEditTextArea;
import com.ochafik.swing.syntaxcoloring.JavaTokenMarker;
import com.ochafik.swing.tree.DefaultTreeNode;
import com.ochafik.util.listenable.ListenableCollections;
import com.ochafik.util.listenable.ListenableList;
import com.ochafik.util.listenable.ListenableListModel;

/// https://jna.dev.java.net/servlets/ReadMsg?list=users&msgNo=1988
public class JNAeratorStudio extends JPanel {
	JEditTextArea sourceArea = new JEditTextArea();
	JEditTextArea resultArea = new JEditTextArea();
	JList resultsList = new JList();
	JTextArea errorsArea = new JTextArea();
	JTree sourceTree = new JTree(new Object[] { "source not parsed yet" });
	ListenableList<ResultContent> results = ListenableCollections.listenableList(new ArrayList<ResultContent>());
	
	static final File FILE = new File(".jnaeratorStudio.cpp");
	
	public void close() {
		try {
			WriteText.writeText(sourceArea.getText(), FILE);
		} catch (Exception ex) {}
	}
	public JNAeratorStudio() {
		super(new BorderLayout());
		sourceArea.setTokenMarker(new CCTokenMarker());
		resultArea.setTokenMarker(new JavaTokenMarker());
		resultsList.setModel(new ListenableListModel<ResultContent>(results));
		JComponent sourcePane = new JPanel(new BorderLayout()), resultPane = new JPanel(new BorderLayout());
		sourcePane.add("West", new JScrollPane(sourceTree));
		sourcePane.add("Center", sourceArea);
		resultPane.add("West", new JScrollPane(resultsList));
		resultPane.add("Center", resultArea);
		JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sourcePane, resultPane);
		add("Center", new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, new JScrollPane(errorsArea)));

		sourceTree.addTreeSelectionListener(new TreeSelectionListener() { public void valueChanged(TreeSelectionEvent e) {
			AbstractNode c = (AbstractNode)sourceTree.getSelectionPath().getLastPathComponent();
			sourceArea.setText(c == null ? "" : c.getContent());
		}});
		resultsList.addListSelectionListener(new ListSelectionListener() { public void valueChanged(javax.swing.event.ListSelectionEvent e) {
			ResultContent c = (ResultContent)resultsList.getSelectedValue();
			resultArea.setText(c == null ? "" : c.getContent());
		}});
		
		try {
			sourceArea.setText(ReadText.readText(FILE));
			sourceArea.scrollTo(0, 0);
		} catch (Exception ex) {}

		JButton actButton = new JButton("JNAerate !");
		actButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JNAeratorStudio.this.setEnabled(false);
				errorsArea.setText("");
				results.clear();
				resultArea.setText("");
				
				new Thread() {
					public void run() {
						final PrintStream out = System.out;
						final PrintStream err = System.err;
						JTextAreaOutputStream to = new JTextAreaOutputStream(errorsArea);
						PrintStream pto = new PrintStream(to);
						System.setOut(pto);
						System.setErr(pto);
						
						try {
							
							JNAeratorConfig config = new JNAeratorConfig();
							config.defaultLibrary = "studio";
							config.preprocessorConfig.includeStrings.add(sourceArea.getText());
							final JNAerator jnaerator = new JNAerator(config) {
								@Override
								public PrintWriter getClassSourceWriter(String className) throws FileNotFoundException {
									final ResultContent c = new ResultContent(className);
									results.add(c);
									return c.getPrintWriter();
								}
							}; 
							jnaerator.run();
							SwingUtilities.invokeLater(new Runnable() { public void run() {
								sourceTree.setModel(new DefaultTreeModel(new ElementNode(null, "ROOT", jnaerator.getSourceFiles())));
								sourceTree.revalidate();
								sourceTree.setRootVisible(true);
							}});
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							SwingUtilities.invokeLater(new Runnable() { public void run() {
								sourceArea.scrollTo(0, 0);
								JNAeratorStudio.this.setEnabled(true);
								System.setOut(out);
								System.setErr(err);
							}});
							
						}
					}
				}.start();
			}
		});
		add("North", actButton);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame(JNAeratorStudio.class.getSimpleName());
		final JNAeratorStudio js = new JNAeratorStudio();
		f.getContentPane().add("Center", js);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600);
		f.setVisible(true);
		Runtime.getRuntime().addShutdownHook(new Thread() { public void run() {
			js.close();
		}});
	}
}
