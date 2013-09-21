/*    
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
package org.freeeed.ui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;

import org.freeeed.ec2.S3Agent;
import org.freeeed.services.Settings;
import org.jets3t.service.S3ServiceException;

/**
 *
 * @author mark
 */
public class S3SetupUI extends javax.swing.JDialog {
    private Frame parent;

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form EC2SetupUI
     */
    public S3SetupUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        accessKeyIdLabel = new javax.swing.JLabel();
        accessKeyIdText = new javax.swing.JTextField();
        secretAccessKeyLabel = new javax.swing.JLabel();
        secretAccessKeyText = new javax.swing.JTextField();
        projectBucketLabel = new javax.swing.JLabel();
        projectBucketText = new javax.swing.JTextField();
        createBucketButton = new javax.swing.JButton();
        verifyKeysButton = new javax.swing.JButton();
        assignBucketButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectList = new javax.swing.JList();
        projectListLabel = new javax.swing.JLabel();
        listProjectsButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setTitle("S3 Setup");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        accessKeyIdLabel.setText("Access Key ID");

        secretAccessKeyLabel.setText("Secret Access Key");

        projectBucketLabel.setText("Project bucket");

        projectBucketText.setEditable(false);

        createBucketButton.setText("Create");
        createBucketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBucketButtonActionPerformed(evt);
            }
        });

        verifyKeysButton.setText("Verify keys");
        verifyKeysButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyKeysButtonActionPerformed(evt);
            }
        });

        assignBucketButton.setText("Select");
        assignBucketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBucketButtonActionPerformed(evt);
            }
        });

        projectList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(projectList);

        projectListLabel.setText("Projects");

        listProjectsButton.setText("List");
        listProjectsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listProjectsButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.setToolTipText("Select a project and start working on it");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verifyKeysButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(projectListLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(listProjectsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(projectBucketText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(accessKeyIdLabel)
                                    .addComponent(secretAccessKeyLabel)
                                    .addComponent(projectBucketLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 120, Short.MAX_VALUE)
                                        .addComponent(assignBucketButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(createBucketButton))
                                    .addComponent(secretAccessKeyText)
                                    .addComponent(accessKeyIdText)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(okButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accessKeyIdLabel)
                    .addComponent(accessKeyIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secretAccessKeyLabel)
                    .addComponent(secretAccessKeyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verifyKeysButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectBucketLabel)
                    .addComponent(createBucketButton)
                    .addComponent(assignBucketButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(projectBucketText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectListLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(listProjectsButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void verifyKeysButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyKeysButtonActionPerformed
        verifyKeys();
    }//GEN-LAST:event_verifyKeysButtonActionPerformed

    private void assignBucketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBucketButtonActionPerformed
        assignBucket();
    }//GEN-LAST:event_assignBucketButtonActionPerformed

    private void createBucketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBucketButtonActionPerformed
        createBucket();
    }//GEN-LAST:event_createBucketButtonActionPerformed

    private void listProjectsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listProjectsButtonActionPerformed
        listProjects();
    }//GEN-LAST:event_listProjectsButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        okButtonClicked();
    }//GEN-LAST:event_okButtonActionPerformed

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        if (returnStatus == RET_OK) {
            collectData();
        }
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(S3SetupUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(S3SetupUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(S3SetupUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(S3SetupUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                S3SetupUI dialog = new S3SetupUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accessKeyIdLabel;
    private javax.swing.JTextField accessKeyIdText;
    private javax.swing.JButton assignBucketButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createBucketButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listProjectsButton;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel projectBucketLabel;
    private javax.swing.JTextField projectBucketText;
    private javax.swing.JList projectList;
    private javax.swing.JLabel projectListLabel;
    private javax.swing.JLabel secretAccessKeyLabel;
    private javax.swing.JTextField secretAccessKeyText;
    private javax.swing.JButton verifyKeysButton;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;

    private void showData() {
        Settings settings = Settings.getSettings();
        accessKeyIdText.setText(settings.getAccessKeyId());
        secretAccessKeyText.setText(settings.getSecretAccessKey());
        projectBucketText.setText(settings.getProjectBucket());
    }

    private void collectData() {
        Settings settings = Settings.getSettings();
        settings.setAccessKeyId(accessKeyIdText.getText());
        settings.setSecretAccessKey(secretAccessKeyText.getText());
        settings.setProjectBucket(projectBucketText.getText());
        settings.save();
    }

    @Override
    public void setVisible(boolean b) {
        if (b) {
            showData();            
        }
        super.setVisible(b);
    }

    private void verifyKeys() {
        collectData();
        S3Agent agent = new S3Agent();
        if (agent.isConnectionGood()) {
            JOptionPane.showMessageDialog(this, "Congrats! It works.");
        } else {
            JOptionPane.showMessageDialog(this, "Sorry, please check the keys.");
        }
    }

    private void assignBucket() {
        Settings settings = Settings.getSettings();
        try {
            S3Agent agent = new S3Agent();
            String[] buckets = agent.getBucketList();
            String bucket = (String) JOptionPane.showInputDialog(null,
                    "Choose your project bucket", "Select",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    buckets, settings.getProjectBucket());
            if (bucket != null) {
                bucket = bucket.trim();
                projectBucketText.setText(bucket);
                settings.setProjectBucket(bucket);
            }

        } catch (S3ServiceException e) {
            JOptionPane.showMessageDialog(this, "Please verify your AWS keys");
        }
    }

    private void createBucket() {
        Settings settings = Settings.getSettings();
        String bucket = JOptionPane.showInputDialog(this, "Please choose your bucket name\nBuckets are unique across all Amazon S3");
        if (bucket == null) {
            return;
        }
        bucket = bucket.trim();
        S3Agent agent = new S3Agent();
        String createdBucket = agent.createBucket(bucket);
        if (createdBucket != null) {
            JOptionPane.showMessageDialog(this, "Bucket " + createdBucket + " was successfully created");
            projectBucketText.setText(createdBucket);
            settings.setProjectBucket(createdBucket);
        } else {
            JOptionPane.showMessageDialog(this, "Bucket names have to be unique across all Amazon S3\n"
                    + "Also, did you check your keys?");
        }
    }

    private void listProjects() {
        S3Agent agent = new S3Agent();
        String[] projects = agent.getProjectList();
        projectList.setListData(projects);
    }

    private void okButtonClicked() {
        collectData();
        String projectFileName = (String) projectList.getSelectedValue();
        if (projectFileName != null) {
            S3Agent agent = new S3Agent();
            agent.getProjectFromS3(projectFileName);
            FreeEedUI instance = FreeEedUI.getInstance();
            instance.openProject(new File(projectFileName));            
        }
        doClose(RET_OK);
    }
}