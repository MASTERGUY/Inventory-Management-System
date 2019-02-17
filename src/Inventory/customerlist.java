/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author murtaza
 */
@SuppressWarnings("serial")
public class customerlist extends javax.swing.JFrame {

   DefaultTableModel dm;
    Connection con =connection.getConnection();
    ResultSet rst=null;
    PreparedStatement pst=null;
    public customerlist() {
        initComponents();
        table();
         
    }
private void table () 
    {
        
        try  {
        String sql=("Select * from customer_details");
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
        jsname.setText("");
        jsphno.setText("");
        jsidprooftype.setText("");
        try  {
        String sql="Select * from customer_details where cus_id='"+jsid.getText().trim()+"' ";
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
        private void sname()
    {
        jsid.setText("");
        jsphno.setText("");
        jsidprooftype.setText("");
        try  {
        String sql="Select * from customer_details where cus_name='"+jsname.getText().trim()+"'";
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
        jsname.setText("");
        jsid.setText("");
        jsidprooftype.setText("");
        try  {
        String sql=("Select * from customer_details where cus_phno='"+jsphno.getText().trim()+"'");
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
         private void sidprftype()
    {
        jsname.setText("");
        jsphno.setText("");
        jsid.setText("");
        try  {
        String sql=("Select * from customer_details where cus_idprooftype='"+jsidprooftype.getText().trim()+"'");
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
         private void sidprf()
    {
        jsname.setText("");
        jsphno.setText("");
        jsid.setText("");
        try  {
        String sql=("Select * from customer_details where cus_idproof='"+jsidproof.getText().trim()+"'");
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpurchaselable1 = new javax.swing.JLabel();
        jall = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jsid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jsname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jsphno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jsidprooftype = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jsidproof = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Details List");

        jPanel1.setBackground(new java.awt.Color(18, 165, 245));
        jPanel1.setForeground(new java.awt.Color(1, 1, 1));

        jpurchaselable1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jpurchaselable1.setForeground(new java.awt.Color(255, 255, 0));
        jpurchaselable1.setText("                                                                                           Customer Details List");

        jall.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jall.setForeground(new java.awt.Color(1, 1, 1));
        jall.setText("Show All Data");
        jall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jallActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Search By ID");

        jsid.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsidKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Search By Name");

        jsname.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsnameKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Search By Phone-No");

        jsphno.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsphno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsphnoKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Search By ID Proof Type");

        jsidprooftype.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsidprooftype.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsidprooftypeKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Search By ID Proof");

        jsidproof.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsidproof.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsidproofKeyReleased(evt);
            }
        });

        jtable.setForeground(new java.awt.Color(1, 1, 1));
        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Register ID", "Customer Name", "Customer Address", "Customer Ph-no", "Customer E-Mail-Id", "Customer ID Proof Type", "Customer ID Proof"
            }
        ));
        jtable.setColumnSelectionAllowed(true);
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
        
        });
        jScrollPane1.setViewportView(jtable);

        jback.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jback.setForeground(new java.awt.Color(1, 1, 1));
        jback.setText("Back");
        jback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpurchaselable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(33, 33, 33)
                                .addComponent(jsid, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(jsname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jsphno, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jsidprooftype, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jsidproof, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(557, 557, 557)
                .addComponent(jall)
                .addGap(44, 44, 44)
                .addComponent(jback, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpurchaselable1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jall)
                    .addComponent(jback, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jsidprooftype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jsidproof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jsname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jsphno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jsid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jsid, jsidprooftype, jsname, jsphno});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jall, jback});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1370, 750));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jsidKeyReleased(java.awt.event.KeyEvent evt) {                                 
        sid();
    }

    private void jsnameKeyReleased(java.awt.event.KeyEvent evt) {                                   
        sname();
    }

    private void jsphnoKeyReleased(java.awt.event.KeyEvent evt) {                                   
        sphno();
    }

    private void jsidprooftypeKeyReleased(java.awt.event.KeyEvent evt) {                                          
        sidprftype();
    }



    private void jsidproofKeyReleased(java.awt.event.KeyEvent evt) {                                      
        sidprf();
    }

    private void jallActionPerformed(java.awt.event.ActionEvent evt) {                                     
        DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
        dm.setRowCount(0);
        table();
        
    }

    private void jbackActionPerformed(java.awt.event.ActionEvent evt) {                                      

        this.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(customerlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customerlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customerlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customerlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customerlist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jall;
    private javax.swing.JButton jback;
    private javax.swing.JLabel jpurchaselable1;
    private javax.swing.JTextField jsid;
    private javax.swing.JTextField jsidproof;
    private javax.swing.JTextField jsidprooftype;
    private javax.swing.JTextField jsname;
    private javax.swing.JTextField jsphno;
    public javax.swing.JTable jtable;
    // End of variables declaration//GEN-END:variables
}
