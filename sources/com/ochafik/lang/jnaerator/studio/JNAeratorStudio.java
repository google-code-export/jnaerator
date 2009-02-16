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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.anarres.cpp.LexerException;
import org.antlr.runtime.RecognitionException;

import com.ochafik.io.JTextAreaOutputStream;
import com.ochafik.io.ReadText;
import com.ochafik.io.TextAreaOutputStream;
import com.ochafik.io.WriteText;
import com.ochafik.lang.SyntaxUtils;
import com.ochafik.lang.jnaerator.JNAerator;
import com.ochafik.lang.jnaerator.JNAeratorConfig;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.swing.syntaxcoloring.CCTokenMarker;
import com.ochafik.swing.syntaxcoloring.JEditTextArea;
import com.ochafik.swing.syntaxcoloring.JavaTokenMarker;
import com.ochafik.swing.syntaxcoloring.SyntaxUtilities;
import com.ochafik.swing.syntaxcoloring.TokenMarker;
import com.ochafik.swing.tree.DefaultTreeNode;
import com.ochafik.util.SystemUtils;
import com.ochafik.util.listenable.ListenableCollections;
import com.ochafik.util.listenable.ListenableComboModel;
import com.ochafik.util.listenable.ListenableList;
import com.ochafik.util.listenable.ListenableListModel;

/// https://jna.dev.java.net/servlets/ReadMsg?list=users&msgNo=1988
public class JNAeratorStudio extends JPanel {
	JEditTextArea sourceArea = textArea(new JavaTokenMarker());
	JEditTextArea resultArea = textArea(new CCTokenMarker());
//	JList resultsList = new JList();
	JComboBox resultsListCombo = new JComboBox();
	JTextArea errorsArea = new JTextArea();
	JSplitPane sp;
	ListenableList<ResultContent> results = ListenableCollections.listenableList(new ArrayList<ResultContent>());
	static MouseWheelListener mouseWheelListener = new MouseWheelListener() {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			JEditTextArea ta = SyntaxUtils.as(e.getSource(), JEditTextArea.class);
			if (ta == null)
				return;
			
			int line = ta.getFirstLine();
			if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
				int u = e.getUnitsToScroll();
				line += u > 0 ? 1 : -1;
				if (line < 0)
					line = 0;
				else if (line >= ta.getLineCount())
					line = ta.getLineCount() - 1;
				
				ta.setFirstLine(line);
			} 
			//ta.scrollRectToVisible(rect);
		}
		
	};
	
	static JEditTextArea textArea(TokenMarker marker) {
		JEditTextArea ta = new JEditTextArea() {
			@Override
			public void processKeyEvent(KeyEvent evt) {
				if (SystemUtils.isMacOSX()) {
					int m = evt.getModifiers();
					if ((m & InputEvent.META_MASK) != 0) {
						m = (m & ~InputEvent.META_MASK) | InputEvent.CTRL_MASK;
						evt = new KeyEvent(evt.getComponent(), evt.getID(), evt.getWhen(), m, evt.getKeyCode(), evt.getKeyChar(), evt.getKeyLocation());
						if (evt.getID() == KeyEvent.KEY_TYPED)
							return;
					}
				}
				super.processKeyEvent(evt);
			}
		};
		ta.setFocusTraversalKeysEnabled(false);
		ActionMap actionMap2 = ta.getActionMap();
		InputMap inputMap = ta.getInputMap();
		
//		
//		for (KeyStroke ks : inputMap.keys()) {
//			int m = ks.getModifiers();
//			if ((m & InputEvent.CTRL_MASK) != 0) {
//				m = (m & ~InputEvent.CTRL_MASK) | InputEvent.META_MASK;
//				Object object = inputMap.get(ks);
//				inputMap.remove(ks);
//				inputMap.put(KeyStroke.getKeyStroke(ks.getKeyChar(), m), object);
//			}
//		}
		ta.addMouseWheelListener(mouseWheelListener);
		ta.setPreferredSize(new Dimension(200, 300));
		ta.setTokenMarker(marker);
		return ta;
	}
	static final File FILE = new File(".jnaeratorStudio.cpp");
	
	public void close() {
		try {
			WriteText.writeText(sourceArea.getText(), FILE);
		} catch (Exception ex) {}
	}
	JTabbedPane sourceTabs = new JTabbedPane(JTabbedPane.TOP), resultTabs = new JTabbedPane(JTabbedPane.TOP);
	//JButton actButton = new JButton("JNAerate !");
	
	Action 
		switchOrientationAction = new AbstractAction("Switch Orientation") {
			@Override
			public void actionPerformed(ActionEvent e) {
				sp.setOrientation(sp.getOrientation() == JSplitPane.HORIZONTAL_SPLIT ? JSplitPane.VERTICAL_SPLIT : JSplitPane.HORIZONTAL_SPLIT);
			}
		},
		generateAction = new AbstractAction("JNAerate !") {
			@Override
			public void actionPerformed(ActionEvent e) {
				generate();
			}
		}
	;
	
	JPanel errorsPane = new JPanel(new BorderLayout());
	public JNAeratorStudio() {
		super(new BorderLayout());
		resultsListCombo.setModel(new ListenableComboModel<ResultContent>(results));
		
		JToolBar tb = new JToolBar();
		tb.add(generateAction);
		tb.add(switchOrientationAction);
		//tb.setOrientation(JToolBar.VERTICAL);
		add("North", tb);
		
		JComponent sourcePane = new JPanel(new BorderLayout()), resultPane = new JPanel(new BorderLayout());
		sourcePane.add("Center", sourceArea);
		//sourcePane.add("South", actButton);
		sourceTabs.addTab("Source", sourcePane);
		
		
		resultPane.add("North", resultsListCombo);
		resultPane.add("Center", resultArea);
		sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sourceTabs, resultTabs);
		sp.setOneTouchExpandable(true);
		
		errorsPane.add("Center", new JScrollPane(errorsArea));
		
		resultTabs.add("JNAeration Results", resultPane);
		resultTabs.add("Errors", errorsPane);
		add("Center", sp);
		//add("Center", new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, new JScrollPane(errorsArea)));

		resultsListCombo.addItemListener(new ItemListener() { public void itemStateChanged(ItemEvent e) {
			ResultContent c = (ResultContent)resultsListCombo.getSelectedItem();
			resultArea.setText(c == null ? "" : c.getContent());
			resultArea.scrollTo(0, 0);
		}});
		
		try {
			sourceArea.setText(ReadText.readText(FILE));
			sourceArea.scrollTo(0, 0);
		} catch (Exception ex) {}
	}
	
	protected void generate() {

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
						String title = "Parsing Tree";
						for (int i = sourceTabs.getTabCount(); i-- != 0;) {
							if (title.equals(sourceTabs.getTitleAt(i))) {
								sourceTabs.removeTabAt(i);
								break;
							}
						}
								
						final JTree parsedTree = new JTree(new ElementNode(null, "ROOT", jnaerator.getSourceFiles()));
						final JEditTextArea selectionContent = textArea(new CCTokenMarker());
						
						parsedTree.addTreeSelectionListener(new TreeSelectionListener() { public void valueChanged(TreeSelectionEvent e) {
							TreePath selectionPath = parsedTree.getSelectionPath();
							AbstractNode c = selectionPath == null ? null : (AbstractNode)selectionPath.getLastPathComponent();
							selectionContent.setText(c == null ? "" : c.getContent());
							selectionContent.scrollTo(0, 0);
						}});
						JPanel parsePane = new JPanel(new BorderLayout());
						parsePane.add("West", new JScrollPane(parsedTree));
						parsePane.add("Center", selectionContent);
						
						sourceTabs.addTab(title, parsePane);
						if (resultsListCombo.getItemCount() > 0)
							resultsListCombo.setSelectedIndex(0);
					}});
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					SwingUtilities.invokeLater(new Runnable() { public void run() {
						sourceArea.scrollTo(0, 0);
						JNAeratorStudio.this.setEnabled(true);
						System.setOut(out);
						System.setErr(err);
						
						setTabTitle(resultTabs, errorsPane, "Errors (" + errorsArea.getLineCount() + ")");
					}});
					
				}
			}
		}.start();
	}


	private static void setTabTitle(JTabbedPane tabs, Component c, String string) {
		for (int i = tabs.getTabCount(); i-- != 0;) {
			if (tabs.getTabComponentAt(i) == c) {
				tabs.setTitleAt(i, string);
				return;
			}
				
		}
	}

	public static void main(String[] args) {
		JFrame f = new JFrame(JNAeratorStudio.class.getSimpleName());
		final JNAeratorStudio js = new JNAeratorStudio();
		f.getContentPane().add("Center", js);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 800);
		f.setVisible(true);
		Runtime.getRuntime().addShutdownHook(new Thread() { public void run() {
			js.close();
		}});
	}
}
