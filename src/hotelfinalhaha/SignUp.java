/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelfinalhaha;

import javax.swing.JPanel;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    Connection con;
    PreparedStatement pat;
    DefaultTableModel d;
    public SignUp() {
        initComponents();
        con = connector.Connect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        usname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        mbutton = new javax.swing.JRadioButton();
        fbutton = new javax.swing.JRadioButton();
        kButton1 = new com.k33ptoo.components.KButton();
        password = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        usname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        usname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usnameActionPerformed(evt);
            }
        });

        jLabel1.setText("Password");

        jLabel2.setText("Username");

        jLabel3.setText("Lastname");

        lname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });

        jLabel4.setText("Firstname");

        fname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(mbutton);
        mbutton.setText("Male");
        mbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbuttonActionPerformed(evt);
            }
        });

        buttonGroup1.add(fbutton);
        fbutton.setText("Female");

        kButton1.setText("SIGN UP");
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(usname)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(fname)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(mbutton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fbutton))
                        .addComponent(lname)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbutton)
                    .addComponent(fbutton))
                .addGap(18, 18, 18)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        
         try {
            String us = usname.getText();
            String fn = fname.getText();
            String ln = lname.getText();
           
            char[] passwordArray = password.getPassword(); // Use getPassword() instead of getText()
            String p = new String(passwordArray); // Convert to String if needed for storage

            // Always clear passwordArray after using
            java.util.Arrays.fill(passwordArray, '0');
             if (p.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
           password.setText("");
            return; // Exit the method if password is too short
             }
            // Check if the username already exists in the database
            pat = con.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ?");
            pat.setString(1, us);
            ResultSet rs = pat.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                // Username already exists
                JOptionPane.showMessageDialog(this, "Username is already taken. Please choose another one.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method, do not proceed with insertion
            }

            // Get the selected radio button value
            String gender = "";
            if (mbutton.isSelected()) {
                gender = "Male"; // Or use 1 for integer representation
            } else if (fbutton.isSelected()) {
                gender = "Female"; // Or use 2 for integer representation
            }

            // Proceed with inserting the new user (no need for userID as it is auto-increment)
            pat = con.prepareStatement("INSERT INTO users (username, password, firstName, lastName,Gender ) VALUES (?,?,?,?,?)");
            pat.setString(1, us);
            pat.setString(2, p);
            pat.setString(3, fn);
            pat.setString(4, ln);          
            pat.setString(5, gender);  // Insert the selected radio option
            

            pat.executeUpdate();

            JOptionPane.showMessageDialog(this, "Thank you for signing up! Your account has been successfully created.");

            // Clear fields
            usname.setText("");
            fname.setText("");
            lname.setText("");               
            password.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_kButton1ActionPerformed

    private void mbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton fbutton;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.k33ptoo.components.KButton kButton1;
    private javax.swing.JTextField lname;
    private javax.swing.JRadioButton mbutton;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField usname;
    // End of variables declaration//GEN-END:variables
}
