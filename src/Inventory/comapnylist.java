/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author murtaza
 */
@SuppressWarnings("serial")
public class comapnylist extends javax.swing.JFrame {

   DefaultTableModel dm;
    Connection con =connection.getConnection();
    ResultSet rst=null;
    PreparedStatement pst=null;
    public comapnylist() {
        initComponents();
        table();
        date();
    }
    private void date()
    {
   
    jdate.setDateFormatString("yyyy-MM-dd");
  
    }

    private void table () 
    {
        
        try  {
        String sql=("Select * from company_details");
        pst=con.prepareStatement(sql);
        rst=pst.executeQuery(sql);
        DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
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
     private void sid()
    {
        jscompname.setText("");
        jsprdctname.setText("");
        jsprdctcateg.setText("");
        jsphno.setText("");
        try  {
        String sql="Select * from company_details where comp_id='"+jsid.getText().trim()+"' ";
        pst=con.prepareStatement(sql);
         DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
         dm.setRowCount(0);
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
        private void scompname()
    {
        jsid.setText("");
        jsprdctname.setText("");
        jsprdctcateg.setText("");
        jsphno.setText("");
        try  {
        String sql="Select * from company_details where comp_name='"+jscompname.getText().trim()+"'";
        pst=con.prepareStatement(sql);
         DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
         dm.setRowCount(0);
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
         private void sprdctname()
    {
        jscompname.setText("");
        jsid.setText("");
        jsprdctcateg.setText("");
        jsphno.setText("");
        try  {
        String sql=("Select * from comapny_details where prdct_name='"+jsprdctname.getText().trim()+"'");
        pst=con.prepareStatement(sql);
         DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
         dm.setRowCount(0);
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
         private void sprdctcateg()
    {
        jscompname.setText("");
        jsprdctname.setText("");
        jsid.setText("");
        jsphno.setText("");
        try  {
        String sql=("Select * from company_details where prdct_category='"+jsprdctcateg.getText().trim()+"'");
        pst=con.prepareStatement(sql);
         DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
         dm.setRowCount(0);
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
         private void sphno()
    {
        jscompname.setText("");
        jsprdctname.setText("");
        jsid.setText("");
        jsprdctcateg.setText("");
        jdate.setDate(java.util.Date.from(Instant.MIN));
        try  {
        String sql=("Select * from company_details where comp_phno='"+jsphno.getText().trim()+"'");
        pst=con.prepareStatement(sql);
         DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
         dm.setRowCount(0);
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
         private void compdate()
    {
        jsid.setText("");
        jscompname.setText("");
        jsprdctname.setText("");
        jsprdctcateg.setText("");
        jsphno.setText("");
         try  {
            
        DateFormat sysDate = new SimpleDateFormat("yyyy-MM-dd");
        String date_to_store = sysDate.format(jdate.getDate());
        
      
        String sql=("Select * from company_details where comp_date='"+date_to_store+"' ");
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
         
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jback = new javax.swing.JButton();
        jscompname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jsid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jall = new javax.swing.JButton();
        jpurchaselable1 = new javax.swing.JLabel();
        jsearchdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jsphno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jsprdctname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jsprdctcateg = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jdate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Company Details List");

        jPanel1.setBackground(new java.awt.Color(18, 165, 245));
        jPanel1.setForeground(new java.awt.Color(1, 1, 1));

        jback.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jback.setForeground(new java.awt.Color(1, 1, 1));
        jback.setText("Back");
        jback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbackActionPerformed(evt);
            }
        });

        jscompname.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jscompname.setForeground(new java.awt.Color(1, 1, 1));
        jscompname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jscompnameKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Search By product Category");

        jsid.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsid.setForeground(new java.awt.Color(1, 1, 1));
        jsid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsidKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Search By Product Name");

        jall.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jall.setForeground(new java.awt.Color(1, 1, 1));
        jall.setText("Show All Data");
        jall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jallActionPerformed(evt);
            }
        });

        jpurchaselable1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jpurchaselable1.setForeground(new java.awt.Color(255, 255, 0));
        jpurchaselable1.setText("                                                                                           Company Details List");

        jsearchdate.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsearchdate.setForeground(new java.awt.Color(1, 1, 1));
        jsearchdate.setText("Search Date");
        jsearchdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsearchdateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Search By ID");

        jsphno.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsphno.setForeground(new java.awt.Color(1, 1, 1));
        jsphno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsphnoKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Search By Date");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("Search By Ph-no");

        jsprdctname.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsprdctname.setForeground(new java.awt.Color(1, 1, 1));
        jsprdctname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsprdctnameKeyReleased(evt);
            }
        });

        jtable.setBackground(new java.awt.Color(254, 254, 254));
        jtable.setForeground(new java.awt.Color(1, 1, 1));
        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company Reg ID", "Company Name", "Product Name", "Product Category", "Comapny Address", "Company Phone-no", "Company E-Mail ID", "Company Reg Date"
            }
        ));
        jtable.setColumnSelectionAllowed(true);
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable);
        jtable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jsprdctcateg.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsprdctcateg.setForeground(new java.awt.Color(1, 1, 1));
        jsprdctcateg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsprdctcategKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Search By Comp Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsid, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jscompname, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jsprdctname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jsprdctcateg, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jsphno, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(451, 451, 451)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jsearchdate))
                            .addComponent(jpurchaselable1, javax.swing.GroupLayout.PREFERRED_SIZE, 1339, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(552, 552, 552)
                .addComponent(jall)
                .addGap(35, 35, 35)
                .addComponent(jback, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpurchaselable1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jall)
                    .addComponent(jback, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jsid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jscompname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jsprdctname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jsprdctcateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jsphno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addComponent(jsearchdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jall, jback});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1376, 750));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {                                    
        
    }

    private void jsidKeyReleased(java.awt.event.KeyEvent evt) {                                 
        sid();        
    }

    private void jscompnameKeyReleased(java.awt.event.KeyEvent evt) {                                       
        scompname();
    }

    private void jsprdctnameKeyReleased(java.awt.event.KeyEvent evt) {                                        
        sprdctname();
    }
    private void jsprdctcategKeyReleased(java.awt.event.KeyEvent evt) {                                         
        sprdctcateg();
    }

    private void jallActionPerformed(java.awt.event.ActionEvent evt) {                                     
        DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
        dm.setRowCount(0);
        table();

    }

    private void jsphnoKeyReleased(java.awt.event.KeyEvent evt) {                                   
        sphno();
    }

    private void jsearchdateActionPerformed(java.awt.event.ActionEvent evt) {                                            
        compdate();
    }

    private void jbackActionPerformed(java.awt.event.ActionEvent evt) {                                      

        this.setVisible(false);
    }

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
            java.util.logging.Logger.getLogger(comapnylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(comapnylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(comapnylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(comapnylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new comapnylist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jall;
    private javax.swing.JButton jback;
    private com.toedter.calendar.JDateChooser jdate;
    private javax.swing.JLabel jpurchaselable1;
    private javax.swing.JTextField jscompname;
    private javax.swing.JButton jsearchdate;
    private javax.swing.JTextField jsid;
    private javax.swing.JTextField jsphno;
    private javax.swing.JTextField jsprdctcateg;
    private javax.swing.JTextField jsprdctname;
    public javax.swing.JTable jtable;
    // End of variables declaration//GEN-END:variables
}
