/*
 * Copyright 2004 - 2013 Herb Bowie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.powersurgepub.psexplorer;

  import com.powersurgepub.xos2.*;
  import java.awt.*;
  import java.io.*;
  import java.util.*;

/**
   A Swing program that will retrieve and display important environmental
   information. Used for debugging.
 */
public class PSExplorer 
    extends javax.swing.JFrame {
		
	public  final static String  VERSION                  = "1.10";
  public  final static char    CARRIAGE_RETURN          = '\r';
	public  final static char    LINE_FEED                = '\n';
	public  final static String  LINE_FEED_STRING         = "\n";
  
  /** 
   Creates new form PSExplorer. 
   */
  public PSExplorer() {
    initComponents();
    getRootPane().putClientProperty
        ("defeatSystemEventQueueCheck", Boolean.TRUE);
    outputTextArea.setVisible (true);
    setVisible (true);
    // outputScrollPane.setPreferredSize (new Dimension (240, 180));
    
    displayLine ("*** PSExplorer Start ***");
    displayLine ("Version " + VERSION);
    
    // Display System Properties
    Properties p = System.getProperties();
    Enumeration props = p.propertyNames();
    displayLine ("=== System Properties ===");
    while (props.hasMoreElements()) {
      String propName = (String)props.nextElement();
      String property = p.getProperty(propName);
      if (propName.equals ("line.separator")) {
        displayText (propName + ": ");
        for (int i = 0; i < property.length(); i++) {
          if (i > 0) {
            displayText ("/");
          }
          if (property.charAt(i) == CARRIAGE_RETURN) {
            displayText ("CR (ASCII 13)");
          } else
          if (property.charAt(i) == LINE_FEED) {
            displayText ("LF (ASCII 10)");
          } else {
            displayText (String.valueOf (property.charAt(i)));
          }
        }
        displayLine(" ");
      } else {
        displayLine (propName + ": " + property);
      }
    } // end while more elements
    // validate();
    
    displayDirectory (new File (System.getProperty ("user.home")),
        "wisdom", false, PSFileFilter.CONTAINS);
    
    if (System.getProperty ("os.name", "Windows").equals("Mac OS X")) {
      displayDirectory (new File (System.getProperty ("user.home") + "/Library/Preferences"),
          "com.powersurgepub", false, PSFileFilter.BEGINS_WITH);
      displayDirectory (new File ("/Library/Preferences"),
          "com.powersurgepub", false, PSFileFilter.BEGINS_WITH);
    }
    
    // Display Browswer Launcher info
    displayLine (" ");
    try {
      BrowserLauncher.openURL ("http://www.powersurgepub.com/");
      displayLine("BrowserLauncher openURL executed without exception");
    } catch (IOException e) {
      displayLine("Attempt to open URL returned exception: " + e.toString());
    }
    
    displayLine("BrowserLauncher loaded without errors? "
        + String.valueOf(BrowserLauncher.getLoadedWithoutErrors()));
    displayLine("BrowserLauncher JVM Switch: " 
        + String.valueOf(BrowserLauncher.getJVMSwitch()));
    displayLine("BrowserLauncher Browser: "
        + BrowserLauncher.locateBrowser().toString());
    
    displayLine(" ");
    
    displayLine ("*** PSExplorer End ***");
  } // end constructor
  
  /**
     Display directory entries.
   */
  private void displayDirectory (File dir, 
      String findValue, boolean caseSensitive, int location) {
    displayLine ("");
    displayLine ("Selected contents of directory " + dir.toString());
    if (! dir.exists()) {
      displayLine ("  Directory does not exist!");
    }
    else
    if (! dir.canRead()) {
      displayLine ("  Cannot access directory!");
    } else {
      FilenameFilter filter 
          = new PSFileFilter (findValue, caseSensitive, location);
      String[] dirEntry = dir.list(filter);
      if (dirEntry == null) {
        displayLine ("  No eligible files found!");
      } else {
        for (int i = 0; i < dirEntry.length; i++) {
          displayLine ("  " + dirEntry [i]);
        }
      }
    }
  }
  
  /**
     Display another output line.
   */
  private void displayLine (String info) {
    displayText (info
      + LINE_FEED_STRING);
  }
  
  /**
     Display some text.
   */
  private void displayText (String info) {
    outputTextArea.append (info);
    outputTextArea.setCaretPosition (outputTextArea.getDocument().getLength());
    validate();
  }
  
  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  private void initComponents() {//GEN-BEGIN:initComponents
    java.awt.GridBagConstraints gridBagConstraints;

    outputScrollPane = new javax.swing.JScrollPane();
    outputTextArea = new javax.swing.JTextArea();
    headerLabel = new javax.swing.JLabel();

    getContentPane().setLayout(new java.awt.GridBagLayout());

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("PSExplorer");
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        exitForm(evt);
      }
    });

    outputTextArea.setColumns(40);
    outputTextArea.setLineWrap(true);
    outputTextArea.setRows(20);
    outputTextArea.setWrapStyleWord(true);
    outputScrollPane.setViewportView(outputTextArea);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.weighty = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
    getContentPane().add(outputScrollPane, gridBagConstraints);

    headerLabel.setText("Environmental Information:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
    getContentPane().add(headerLabel, gridBagConstraints);

    pack();
  }//GEN-END:initComponents
  
  /** Exit the Application */
  private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
    System.exit(0);
  }//GEN-LAST:event_exitForm
  
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    new PSExplorer().show();
  }
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel headerLabel;
  private javax.swing.JScrollPane outputScrollPane;
  private javax.swing.JTextArea outputTextArea;
  // End of variables declaration//GEN-END:variables
  
}
