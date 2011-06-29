/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on Jun 7, 2011, 7:23:18 AM
 */
package org.freeeed.ui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JFileChooser;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.freeeed.main.FreeEedMain;
import org.freeeed.main.ParameterProcessing;

/**
 *
 * @author mark
 */
public class FreeEedUI extends javax.swing.JFrame {

    /** Creates new form Main */
    public FreeEedUI() {
	initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        menuItemOpenProject = new javax.swing.JMenuItem();
        menuItemSaveProject = new javax.swing.JMenuItem();
        menuItemSaveProjectAs = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        menuItemProjectSettings = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FreeEed - Graphical User Interface");

        fileMenu.setText("File");

        menuItemOpenProject.setText("Open project");
        menuItemOpenProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenProjectActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemOpenProject);

        menuItemSaveProject.setText("Save project");
        fileMenu.add(menuItemSaveProject);

        menuItemSaveProjectAs.setText("Save project as");
        fileMenu.add(menuItemSaveProjectAs);

        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemExit);

        mainMenu.add(fileMenu);

        editMenu.setText("Edit");

        menuItemProjectSettings.setText("Project settings");
        editMenu.add(menuItemProjectSettings);

        mainMenu.add(editMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        mainMenu.add(helpMenu);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
	new AboutDialog(this, true).setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
	exitApp();
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemOpenProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenProjectActionPerformed
	openProject();
    }//GEN-LAST:event_menuItemOpenProjectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	java.awt.EventQueue.invokeLater(new Runnable() {

	    @Override
	    public void run() {
		new FreeEedUI().setVisible(true);
	    }
	});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemOpenProject;
    private javax.swing.JMenuItem menuItemProjectSettings;
    private javax.swing.JMenuItem menuItemSaveProject;
    private javax.swing.JMenuItem menuItemSaveProjectAs;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setVisible(boolean b) {
	myInitComponents();
	super.setVisible(b);
    }

    private void myInitComponents() {
	setBounds(64, 40, 640, 400);
	setTitle("FreeEed - Open source eDiscovery - Operator Console");
    }

    private void exitApp() {
	if (!isExitAllowed()) {
	    return;
	}
	// TODO verify - is that a standard way to exit?
	setVisible(false);
	System.exit(0);
    }

    private boolean isExitAllowed() {
	return true;
    }

    private void openProject() {
	try {
	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	    fileChooser.addChoosableFileFilter(new ProjectFilter());
	    File f = null;
	    try {
		f = new File(new File(".").getCanonicalPath());
	    } catch (IOException e) {
		e.printStackTrace(System.out);
	    }
	    // Set the current directory
	    fileChooser.setCurrentDirectory(f);
	    fileChooser.setDialogTitle("Select project file");
	    fileChooser.showOpenDialog(this);
	    File selectedFile = fileChooser.getSelectedFile();
	    if (selectedFile == null) {
		return;
	    }
	    System.out.println("Reading project file: " + selectedFile.getPath());
	    Configuration processingParameters =
		    ParameterProcessing.collectProcessingParameters(selectedFile.getPath());
	    ParameterProcessing.echoProcessingParameters(processingParameters);
	    FreeEedMain.getInstance().setProcessingParameters(processingParameters);
	    updateTitle(processingParameters);
	} catch (Exception e) {
	    e.printStackTrace(System.out);
	}
    }

    private class ProjectFilter extends javax.swing.filechooser.FileFilter {

	@Override
	public boolean accept(File file) {
	    String filename = file.getName();
	    return filename.endsWith(".properties");
	}

	@Override
	public String getDescription() {
	    return "Project files";
	}
    }
        private void updateTitle(Configuration processingParameters) {
	String title = processingParameters.getString(ParameterProcessing.PROJECT_NAME);
	if (title != null) {
	    setTitle("FreeEed - " + title);
	} else {
	    setTitle("FreeEed");
	}
    }

}
