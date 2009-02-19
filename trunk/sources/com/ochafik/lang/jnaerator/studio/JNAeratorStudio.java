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
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import com.ochafik.io.JTextAreaOutputStream;
import com.ochafik.io.ReadText;
import com.ochafik.io.WriteText;
import com.ochafik.lang.SyntaxUtils;
import com.ochafik.lang.jnaerator.JNAerator;
import com.ochafik.lang.jnaerator.JNAeratorConfig;
import com.ochafik.swing.syntaxcoloring.CCTokenMarker;
import com.ochafik.swing.syntaxcoloring.JEditTextArea;
import com.ochafik.swing.syntaxcoloring.JavaTokenMarker;
import com.ochafik.swing.syntaxcoloring.TokenMarker;
import com.ochafik.util.SystemUtils;
import com.ochafik.util.listenable.ListenableCollections;
import com.ochafik.util.listenable.ListenableComboModel;
import com.ochafik.util.listenable.ListenableList;

/// https://jna.dev.java.net/servlets/ReadMsg?list=users&msgNo=1988
@SuppressWarnings("serial")
public class JNAeratorStudio extends JPanel {
	private static final long serialVersionUID = -6061806156049213635L;
	private static final String PREF_RADIX = "JNAeratorStudio.";
	JEditTextArea sourceArea = textArea(new JavaTokenMarker());
	JEditTextArea resultArea = textArea(new CCTokenMarker());
	JTextField libraryName = new JTextField("test");
	JLabel classCountLabel = new JLabel("JNAerated class :");
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
		}
		
	};
	
	public File getFile() {
		File dir = new File(System.getProperty("user.home"));
		dir = new File(dir, ".jnaeratorStudio");
		dir = new File(dir, "pad");
		if (!dir.exists())
			dir.mkdirs();
		return new File(dir, "input.h");
	}
	void save() throws IOException {
		WriteText.writeText(sourceArea.getText(), getFile());
	}
	static JEditTextArea textArea(TokenMarker marker) {
		JEditTextArea ta = new JEditTextArea() {
			private static final long serialVersionUID = 1L;
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
			@Override
			public Dimension getMinimumSize() {
				return new Dimension(100, 100);
			}
		};
		ta.setBorder(BorderFactory.createLoweredBevelBorder());
		ta.setFocusTraversalKeysEnabled(false);
		ta.addMouseWheelListener(mouseWheelListener);
		ta.setPreferredSize(new Dimension(200, 300));
		ta.setTokenMarker(marker);
		return ta;
	}
	//static final File FILE = new File(".jnaeratorStudio.cpp");
	
	public void close() {
		try {
			save();
		} catch (Exception ex) {}
	}
	JTabbedPane sourceTabs = new JTabbedPane(JTabbedPane.TOP), resultTabs = new JTabbedPane(JTabbedPane.TOP);
	//JButton actButton = new JButton("JNAerate !");
	
	void switchOrientation() {
		boolean hor = sp.getOrientation() == JSplitPane.HORIZONTAL_SPLIT;
		int l = sp.getDividerLocation(), d = hor ? sp.getWidth() : sp.getHeight();
		sp.setOrientation(hor ? JSplitPane.VERTICAL_SPLIT : JSplitPane.HORIZONTAL_SPLIT);
		if (d != 0)
			sp.setDividerLocation(l / (double)d);
	}
	
	Action 
		switchOrientationAction = new AbstractAction("Switch Orientation") {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchOrientation();
			}
		},
		generateAction = new AbstractAction("JNAerate !") {
			@Override
			public void actionPerformed(ActionEvent e) {
				generate();
			}
		},
		aboutJNAeratorAction = new AbstractAction("About JNAerator") {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = new URL("http://code.google.com/p/jnaerator/wiki/AboutJNAeratorStudio");
					System.out.println("About JNAerator: " + url);
					SystemUtils.runSystemOpenURL(url);
				} catch (Exception ex) {
					
					displayError(ex);
				}
			}
		},
		aboutJNAAction = new AbstractAction("About JNA") {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = new URL("http://jna.dev.java.net/");
					System.out.println("About JNA: " + url);
					SystemUtils.runSystemOpenURL(url);
				} catch (Exception ex) {
					
					displayError(ex);
				}
			}
		}
	;
	
	JPanel errorsPane = new JPanel(new BorderLayout());
	public JNAeratorStudio() {
		super(new BorderLayout());
		resultsListCombo.setModel(new ListenableComboModel<ResultContent>(results));
		
		//animator.setAcceleration(.2f); 
		//animator.setDeceleration(.2f);
		
		JToolBar tb = new JToolBar();
		tb.add(generateAction);
		tb.add(switchOrientationAction);
		tb.add(aboutJNAeratorAction);
		tb.add(aboutJNAAction);
		//tb.setOrientation(JToolBar.VERTICAL);
		add("North", tb);
		
		JComponent sourcePane = new JPanel(new BorderLayout()), resultPane = new JPanel(new BorderLayout());
		Box libBox = Box.createHorizontalBox();
		libBox.add(new JLabel("Library Name :", JLabel.RIGHT));
		libBox.add(libraryName);
		sourcePane.add("North", libBox);//raryName);
		sourcePane.add("Center", sourceArea);
		sourceTabs.addTab("Source", sourcePane);
		
		
		Box resChoiceBox = Box.createHorizontalBox();
		resChoiceBox.add(classCountLabel);
		resChoiceBox.add(resultsListCombo);
		resultPane.add("North", resChoiceBox);
		resultPane.add("Center", resultArea);
		sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sourceTabs, resultTabs);
		sp.setOneTouchExpandable(true);
		sp.setResizeWeight(0.5);
		//sp.setDividerLocation(0.5);
		
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
			sourceArea.setText(ReadText.readText(getFile()));
			sourceArea.scrollTo(0, 0);
		} catch (Exception ex) {}
	}
	
	protected void generate() {

		try {
			save();
		} catch (IOException e1) {
			displayError(e1);
			return;
		}
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
					config.defaultLibrary = libraryName.getText();
//					config.addFile(getFile(), "");
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
						classCountLabel.setText("JNAerated classes (" + results.size() + ") :");
						setTabTitle(resultTabs, errorsPane, "Errors (" + (errorsArea.getLineCount() - 1) + ")");
					}});
					
				}
			}
		}.start();
	}


	private void displayError(Exception e) {
		JOptionPane.showMessageDialog(this, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
	}
	private static void setTabTitle(JTabbedPane tabs, Component c, String string) {
		for (int i = tabs.getTabCount(); i-- != 0;) {
			Component tc = tabs.getComponent(i);//tabs.getTabComponentAt(i); 
			if (tc == c) {
				tabs.setTitleAt(i, string);
				return;
			}
				
		}
	}

	static Preferences prefNode() {
		return Preferences.userNodeForPackage(JNAeratorStudio.class);
	}
	public static String getPref(String name, String defaultValue) {
		return prefNode().get(JNAeratorStudio.PREF_RADIX + name, defaultValue);
	}	
	public static void setPref(String name, String value) {
		prefNode().put(JNAeratorStudio.PREF_RADIX + name, value);
	}
	public static void setPref(String name, boolean value) {
		prefNode().putBoolean(JNAeratorStudio.PREF_RADIX + name, value);
	}
	public static boolean getPref(String name, boolean defaultValue) {
		return prefNode().getBoolean(JNAeratorStudio.PREF_RADIX + name, defaultValue);
	}
	public static void setPref(String name, double value) {
		prefNode().putDouble(JNAeratorStudio.PREF_RADIX + name, value);
	}
	public static double getPref(String name, double defaultValue) {
		return prefNode().getDouble(JNAeratorStudio.PREF_RADIX + name, defaultValue);
	}
	public static void setPref(String name, int value) {
		prefNode().putInt(JNAeratorStudio.PREF_RADIX + name, value);
	}
	public static int getPref(String name, int defaultValue) {
		return prefNode().getInt(JNAeratorStudio.PREF_RADIX + name, defaultValue);
	}
	
	public static void main(String[] args) {
		try {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
		
		String ver = "";
		try {
			ver = " " + ReadText.readText(JNAeratorStudio.class.getClassLoader().getResourceAsStream("VERSION"));
		} catch (Exception ex) {}
		
		final JFrame f = new JFrame((JNAeratorStudio.class.getSimpleName() + ver).trim());
		final JNAeratorStudio js = new JNAeratorStudio();
		f.getContentPane().add("Center", js);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			js.sp.setOrientation(getPref("splitPane.orientation", JSplitPane.HORIZONTAL_SPLIT));
			js.sp.setDividerLocation(getPref("splitPane.dividedLocation", 0.5));
			f.setSize(getPref("window.width", 800), getPref("height", 600));
			f.setExtendedState(getPref("window.extendedState", JFrame.NORMAL));
		} catch (Exception ex) {
			ex.printStackTrace();
			f.setExtendedState(JFrame.MAXIMIZED_BOTH);
			f.setSize(800, 800);
		}
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					setPref("window.width", f.getWidth());
					setPref("window.height", f.getHeight());
					setPref("window.extendedState", f.getExtendedState());
					setPref("splitPane.orientation", js.sp.getOrientation());
					setPref("splitPane.dividedLocation", getProportionalDividerLocation(js.sp));
					prefNode().flush();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		Runtime.getRuntime().addShutdownHook(new Thread() { public void run() {
			js.close();	
		}});
		
		f.setVisible(true);
		
	}
	protected static double getProportionalDividerLocation(JSplitPane sp) {
		boolean hor = sp.getOrientation() == JSplitPane.HORIZONTAL_SPLIT;
		int l = sp.getDividerLocation(), d = hor ? sp.getWidth() : sp.getHeight();
		sp.setOrientation(hor ? JSplitPane.VERTICAL_SPLIT : JSplitPane.HORIZONTAL_SPLIT);
		return d != 0 ? l / (double)d : 0.5;
	}
}
