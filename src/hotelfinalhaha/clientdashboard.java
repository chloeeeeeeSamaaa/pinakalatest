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
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class clientdashboard extends javax.swing.JFrame {

    /**
     * Creates new form clientdashboard
     */
    Connection con;
    PreparedStatement pat;
    ResultSet rs;
    public clientdashboard() {
        initComponents();
        con = connector.Connect();
        RoomNo();
        displayClientFirstName();
        
        jPanel2.removeAll();
      jPanel2.add(jPanel01);
       jPanel2.repaint();
        jPanel2.revalidate();
jTable1.setDefaultEditor(Object.class, null);
jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    private void displayClientFirstName() {
    try {
        pat = con.prepareStatement("SELECT firstName FROM users WHERE userID = ?");
        pat.setInt(1, Login.UID);
        ResultSet rs = pat.executeQuery();
        if (rs.next()) {
            String fname = rs.getString("firstName");
            jLabel1.setText("Welcome, " + fname + "!");
        } else {
            jLabel1.setText("Welcome!");
        }
    } catch (SQLException ex) {
        Logger.getLogger(clientdashboard.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error fetching user name.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public void RoomNo() {
        try {
        pat = con.prepareStatement("SELECT DISTINCT roomID FROM rooms");
        ResultSet rs = pat.executeQuery();
        txtro.removeAllItems();
        while (rs.next()) {
            txtro.addItem(rs.getString("roomID"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(clientdashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
private String autoID(int UID) {
    String newReserveID = "R001";  // Default ID if no reservations are found
    try {
        // Fetch the last reservationNo for the given userID
        pat = con.prepareStatement("SELECT reservationNo FROM reservations WHERE userID = ? ORDER BY reservationNo DESC LIMIT 1");
        pat.setInt(1, UID);  // Use the parameter UID
        ResultSet rs = pat.executeQuery();
        
        if (rs.next()) {
            String lastID = rs.getString("reservationNo");  // reservationNo is assumed to be like "R001"
            int numericPart = Integer.parseInt(lastID.substring(1)); // Get number part
            newReserveID = "R" + String.format("%03d", numericPart + 1); // e.g., R002, R003...
        }
    } catch (SQLException ex) {
        Logger.getLogger(clientdashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    return newReserveID;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        kGradientPanel4 = new com.k33ptoo.components.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel01 = new javax.swing.JPanel();
        kGradientPanel5 = new com.k33ptoo.components.KGradientPanel();
        kGradientPanel6 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel02 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel03 = new javax.swing.JPanel();
        txtcheckout = new com.toedter.calendar.JDateChooser();
        txtcheckin = new com.toedter.calendar.JDateChooser();
        txtro = new javax.swing.JComboBox<>();
        kButton1 = new com.k33ptoo.components.KButton();
        jPanel04 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1100, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.setMinimumSize(new java.awt.Dimension(240, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Home");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 124, 200, -1));

        kGradientPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("My Reservations");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel3)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 222, 200, -1));

        kGradientPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Book a room");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel4)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 320, 200, -1));

        kGradientPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Payments");

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel5)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 418, 200, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(848, 550));
        jPanel2.setLayout(new java.awt.CardLayout());

        jPanel01.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel5.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel5.setkBorderRadius(20);

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        kGradientPanel6.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel6.setkBorderRadius(20);
        kGradientPanel6.setPreferredSize(new java.awt.Dimension(380, 170));

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel1.setText(".");

        javax.swing.GroupLayout jPanel01Layout = new javax.swing.GroupLayout(jPanel01);
        jPanel01.setLayout(jPanel01Layout);
        jPanel01Layout.setHorizontalGroup(
            jPanel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel01Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel01Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel01Layout.createSequentialGroup()
                        .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel01Layout.setVerticalGroup(
            jPanel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel01Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(298, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel01, "card3");

        jPanel02.setBackground(new java.awt.Color(255, 255, 255));
        jPanel02.setPreferredSize(new java.awt.Dimension(848, 550));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ReservationNo", "RoomNumber", "CheckIn", "CheckOut", "Amount", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel02Layout = new javax.swing.GroupLayout(jPanel02);
        jPanel02.setLayout(jPanel02Layout);
        jPanel02Layout.setHorizontalGroup(
            jPanel02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel02Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel02Layout.setVerticalGroup(
            jPanel02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel02Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jPanel2.add(jPanel02, "card2");

        jPanel03.setBackground(new java.awt.Color(255, 255, 255));

        kButton1.setText("Book now");
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel03Layout = new javax.swing.GroupLayout(jPanel03);
        jPanel03.setLayout(jPanel03Layout);
        jPanel03Layout.setHorizontalGroup(
            jPanel03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel03Layout.createSequentialGroup()
                .addGroup(jPanel03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel03Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(jPanel03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtro, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtcheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel03Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        jPanel03Layout.setVerticalGroup(
            jPanel03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel03Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(txtcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtcheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel03, "card4");

        jPanel04.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PaymentID", "ReservationID", "PaymentMethod", "AmountPaid", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel04Layout = new javax.swing.GroupLayout(jPanel04);
        jPanel04.setLayout(jPanel04Layout);
        jPanel04Layout.setHorizontalGroup(
            jPanel04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel04Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel04Layout.setVerticalGroup(
            jPanel04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel04Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        jPanel2.add(jPanel04, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kGradientPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseClicked
        // TODO add your handling code here:
        jPanel2.removeAll();
      jPanel2.add(jPanel01);
       jPanel2.repaint();
        jPanel2.revalidate();
    }//GEN-LAST:event_kGradientPanel1MouseClicked

    private void kGradientPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel2MouseClicked
        // TODO add your handling code here:
        jPanel2.removeAll();
      jPanel2.add(jPanel02);
       jPanel2.repaint();
        jPanel2.revalidate();
    }//GEN-LAST:event_kGradientPanel2MouseClicked

    private void kGradientPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel3MouseClicked
        // TODO add your handling code here:
        jPanel2.removeAll();
      jPanel2.add(jPanel03);
       jPanel2.repaint();
        jPanel2.revalidate();
    }//GEN-LAST:event_kGradientPanel3MouseClicked

    private void kGradientPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel4MouseClicked
        // TODO add your handling code here:
         jPanel2.removeAll();
      jPanel2.add(jPanel04);
       jPanel2.repaint();
        jPanel2.revalidate();
    }//GEN-LAST:event_kGradientPanel4MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
      if (txtcheckin.getDate() == null || txtcheckout.getDate() == null || 
        txtro.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields", "Missing Information", JOptionPane.WARNING_MESSAGE);
        return;
    }

    SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
    String StartDate = df1.format(txtcheckin.getDate());
    String EndDate = df1.format(txtcheckout.getDate());
    String roomNo = txtro.getSelectedItem().toString();

    LocalDate today = LocalDate.now();
    LocalDate checkInDate = txtcheckin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate checkOutDate = txtcheckout.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    if (checkInDate.isBefore(today)) {
        JOptionPane.showMessageDialog(this, "Check-in date cannot be before today's date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!checkOutDate.isAfter(checkInDate)) {
        JOptionPane.showMessageDialog(this, "Check-out date must be after the check-in date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Get room and roomType info
        String roomType = null, oc = null;
        double roomAmountPerNight = 0;
        int roomTypeID = 0;

        pat = con.prepareStatement(
            "SELECT rt.roomTypeID, rt.type, rt.occupancy, rt.price " +
            "FROM rooms r " +
            "JOIN roomtypes rt ON r.roomTypeID = rt.roomTypeID " +
            "WHERE r.roomID = ?"
        );
        pat.setString(1, roomNo);
        ResultSet rs = pat.executeQuery();
        if (rs.next()) {
            roomTypeID = rs.getInt("roomTypeID");
            roomType = rs.getString("type");
            oc = rs.getString("occupancy");
            roomAmountPerNight = rs.getDouble("price");
        }

        if (roomType == null || oc == null) {
            JOptionPane.showMessageDialog(this, "Room details not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calculate amount
        long diffInMillis = txtcheckout.getDate().getTime() - txtcheckin.getDate().getTime();
        long numberOfNights = diffInMillis / (1000 * 60 * 60 * 24);
        double totalAmount = numberOfNights * roomAmountPerNight;

        // Check if the room type is already booked for the selected dates
        pat = con.prepareStatement(
            "SELECT r.* FROM reservationdetails rd " +
            "JOIN reservations r ON rd.reservationID = r.reservationID " +
            "WHERE rd.roomID = ? AND r.roomTypeID = ? AND (" +
            "(? >= r.checkIn AND ? <= r.checkOut) OR " +  // New check-in date is between existing reservation
            "(? >= r.checkIn AND ? <= r.checkOut) OR " +  // New check-out date is between existing reservation
            "(r.checkIn >= ? AND r.checkIn <= ?) OR " +  // Existing check-in date is between new dates
            "(r.checkOut >= ? AND r.checkOut <= ?))"     // Existing check-out date is between new dates
        );
        pat.setString(1, roomNo); // Room selected by the user
        pat.setInt(2, roomTypeID); // RoomTypeID to ensure only the same room type is checked
        pat.setString(3, StartDate);  // New check-in date
        pat.setString(4, EndDate);    // New check-out date
        pat.setString(5, StartDate);  // New check-in date
        pat.setString(6, EndDate);    // New check-out date
        pat.setString(7, StartDate);  // Existing check-in date
        pat.setString(8, EndDate);    // Existing check-out date
        pat.setString(9, StartDate);  // Existing check-in date
        pat.setString(10, EndDate);   // Existing check-out date

        rs = pat.executeQuery();
        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "This room type is already booked for the selected dates.", "Booking Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get next reservationNo for the user
        int reservationNo = 1;
        pat = con.prepareStatement("SELECT COUNT(*) FROM reservations WHERE userID = ?");
        pat.setInt(1, Login.UID);
        ResultSet resCount = pat.executeQuery();
        if (resCount.next()) {
            reservationNo = resCount.getInt(1) + 1;
        }

        // Insert into reservations with per-user reservationNo
        pat = con.prepareStatement(
            "INSERT INTO reservations (userID, reservationNo, checkIn, checkOut, status, roomTypeID) VALUES (?, ?, ?, ?, ?, ?)"
        );
        pat.setInt(1, Login.UID);
        pat.setInt(2, reservationNo);
        pat.setString(3, StartDate);
        pat.setString(4, EndDate);
        pat.setString(5, "Approved");
        pat.setInt(6, roomTypeID);
        pat.executeUpdate();

        // Get reservationID
        pat = con.prepareStatement("SELECT LAST_INSERT_ID()");
        rs = pat.executeQuery();
        int reservationID = 0;
        if (rs.next()) {
            reservationID = rs.getInt(1);
        }

        // Insert into reservationdetails
        pat = con.prepareStatement(
            "INSERT INTO reservationdetails (reservationID, roomID, amount) VALUES (?, ?, ?)"
        );
        pat.setInt(1, reservationID);
        pat.setString(2, roomNo);
        pat.setDouble(3, totalAmount);
        pat.executeUpdate();

        // Update room status to Occupied
        pat = con.prepareStatement("UPDATE rooms SET roomStatus = 'Occupied' WHERE roomID = ?");
        pat.setString(1, roomNo);
        pat.executeUpdate();

        JOptionPane.showMessageDialog(this, "Reservation added successfully. Your Reservation No is: " + reservationNo);

    } catch (SQLException ex) {
        Logger.getLogger(clientdashboard.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_kButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(clientdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientdashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel01;
    private javax.swing.JPanel jPanel02;
    private javax.swing.JPanel jPanel03;
    private javax.swing.JPanel jPanel04;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel5;
    private com.k33ptoo.components.KGradientPanel kGradientPanel6;
    private com.toedter.calendar.JDateChooser txtcheckin;
    private com.toedter.calendar.JDateChooser txtcheckout;
    private javax.swing.JComboBox<String> txtro;
    // End of variables declaration//GEN-END:variables
}
