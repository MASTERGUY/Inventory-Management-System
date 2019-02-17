/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author murtaza
 */
@SuppressWarnings("serial")
public class saleslist extends javax.swing.JFrame {

    DefaultTableModel dm;
    Connection con =connection.getConnection();
    ResultSet rst=null;
    PreparedStatement pst=null;
    java.util.Date date;
    java.sql.Date sqldate;
    public saleslist() {
        initComponents();
        table(); 
        date();
    }

    private void date()
 { 
    jxdtpckr.setFormats(new String[]{"yyyy-MM-dd"});
    jxdtpckr2.setFormats(new String[]{"yyyy-MM-dd"});
 }
 
private void search()
    {
         try  {
            
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        jxdtpckr.setFormats(dateFormat);
        jxdtpckr2.setFormats(dateFormat);
        DateFormat sysDate = new SimpleDateFormat("yyyy/MM/dd");
        String date_to_store = sysDate.format(jxdtpckr.getDate());
        String date_to_store1 = sysDate.format(jxdtpckr2.getDate());
        
      
        String sql=("Select inv_id,cus_id,cus_name,inv_date,prdct_id,prdct_name,prdct_category,prdct_mrp,prdct_qnty,prdct_disc,prdct_total,trans_mode,trans_bank,trans_gtotal,trans_tpayment,trans_rpayment from sales where inv_date between '"+date_to_store+"' and '"+date_to_store1+"'");
        pst=con.prepareStatement(sql);
        DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
        dm.setRowCount(0);
        rst=pst.executeQuery(sql);
        ResultSetMetaData rsmd = rst.getMetaData();
        int columnCount = rsmd.getColumnCount();
       DefaultTableModel dm1 = (DefaultTableModel) jtable.getModel();

        
        while (rst.next()) 
        {
            String[] a = new String[columnCount];
            for(int i = 0; i < columnCount; i++)
            {
                a[i] = rst.getString(i+1);

            }
            dm1.addRow(a);
        } 
        jtable.setDefaultEditor(Object.class, null);
        
        } 
        
        
        catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
   private void table() 
    {
        try  {
        String sql= ("Select * from inventory.sales");
        pst=con.prepareStatement(sql);
         DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
        rst=pst.executeQuery(sql);
        ResultSetMetaData rsmd = rst.getMetaData();
        int columnCount = rsmd.getColumnCount();

        
        while (rst.next()) 
        {
            String[] a = new String[columnCount];
            for(int i = 0; i < columnCount; i++)
            {
                a[i] = rst.getString(i+1);

            }
            dm.addRow(a);
        } 
        jtable.setDefaultEditor(Object.class, null);
        } 
        
        
        catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("deprecation")
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpurchaselable1 = new javax.swing.JLabel();
        jxdtpckr = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jsearch = new javax.swing.JButton();
        jxdtpckr2 = new org.jdesktop.swingx.JXDatePicker();
        jback = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sold Products Details");

        jPanel1.setBackground(new java.awt.Color(18, 165, 245));

        jpurchaselable1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jpurchaselable1.setForeground(new java.awt.Color(255, 255, 0));
        jpurchaselable1.setText("                                                                                         Sold Product Details List");

        jxdtpckr.setNextFocusableComponent(jxdtpckr2);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("To Date");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("From Date");

        jsearch.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsearch.setForeground(new java.awt.Color(1, 1, 1));
        jsearch.setText("Search");
        jsearch.setNextFocusableComponent(jxdtpckr);
        jsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsearchActionPerformed(evt);
            }
        });

        jxdtpckr2.setNextFocusableComponent(jsearch);

        jback.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jback.setForeground(new java.awt.Color(1, 1, 1));
        jback.setText("Back");
        jback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbackActionPerformed(evt);
            }
        });

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Customer ID", "Customer Name", "Invoice Date", "Product ID", "Product Name", "Product Category", "Product Mrp", "Product Quantity", "Product Discription", "Product Total", "Transcation Mode", "Transaction Bank", "Transaction Cheque", "Grand Total", "Total Payment", "Pending Payment"
            }
        ));
        jScrollPane2.setViewportView(jtable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpurchaselable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jxdtpckr, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jxdtpckr2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jsearch)
                        .addGap(70, 70, 70)
                        .addComponent(jback, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jback, jsearch});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpurchaselable1)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxdtpckr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsearch)
                    .addComponent(jback, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxdtpckr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jback, jsearch});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1370, 750));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsearchActionPerformed
        search();
    }//GEN-LAST:event_jsearchActionPerformed

    private void jbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbackActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_jbackActionPerformed



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
            java.util.logging.Logger.getLogger(saleslist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(saleslist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(saleslist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(saleslist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new saleslist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jback;
    private javax.swing.JLabel jpurchaselable1;
    private javax.swing.JButton jsearch;
    private javax.swing.JTable jtable;
    private org.jdesktop.swingx.JXDatePicker jxdtpckr;
    private org.jdesktop.swingx.JXDatePicker jxdtpckr2;
    // End of variables declaration//GEN-END:variables
}
