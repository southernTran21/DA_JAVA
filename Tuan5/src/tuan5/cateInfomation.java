/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan5;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class cateInfomation extends javax.swing.JFrame {

    /**
     * Creates new form cateInfomation
     */
    public cateInfomation(String b, String type) {
        initComponents();
        if (type.equals("")) {
            Type = type;
        } else {
            PreparedStatement ps;
            ResultSet rs;
            
            Type = type;

            txtID.setEnabled(true);

            String query = "SELECT * FROM `loaisp` where Tenloai = '" + b + "'";
            try {
                ps = Data.DatabaseInfo.getConnection().prepareStatement(query);

                rs = ps.executeQuery();

                while (rs.next()) {
                    txtID.setText(rs.getString("Maloai"));
                    txtName.setText(rs.getString("Tenloai"));
                }

            } catch (SQLException ex) {
            }
        }
    }

    String Type = "";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CatID");

        jLabel2.setText("CatName");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(txtID))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(btnOK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnOK)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        if (Type.equals("")) {
            if (txtName.getText().equals("") || txtID.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Không được để dữ liệu trống");
            } else {
                PreparedStatement ps;
                String query = "INSERT INTO `loaisp`(`Maloai`, `Tenloai`) VALUES (?,?)";
                try {
                    ps = Data.DatabaseInfo.getConnection().prepareStatement(query);

                    ps.setString(1, txtID.getText());
                    ps.setString(2, txtName.getText());

                    if (ps.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "Thêm Thành Công");
                        this.setVisible(false);
                        LoaiSanPham form = new LoaiSanPham();
                        form.setVisible(true);
                    }

                } catch (SQLException ex) {
                }
            }

        } else if(Type.equals("SUA")) {       
            System.out.println("check");
            PreparedStatement ps;
            String query = "UPDATE `loaisp` SET `Tenloai`= ? WHERE Maloai = ?";
            try {
                ps = Data.DatabaseInfo.getConnection().prepareStatement(query);

                ps.setString(2, txtID.getText());
                ps.setString(1, txtName.getText());
                
                System.out.println("query: " +query );

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Sửa Thành Công");
                    LoaiSanPham form = new LoaiSanPham();
                    form.setVisible(true);
                    this.setVisible(false);

                }

            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_btnOKActionPerformed

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
            java.util.logging.Logger.getLogger(cateInfomation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cateInfomation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cateInfomation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cateInfomation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cateInfomation("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
