/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.awt.HeadlessException;
import java.sql.*;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author murtaza
 */
@SuppressWarnings("serial")
public class company extends javax.swing.JFrame {

    DefaultTableModel dm;
    Connection con =connection.getConnection();
    ResultSet rst=null;
    PreparedStatement pst=null;
    public company() {
        initComponents();
        table_comp();
        date();
        clear();
    }
private void date(){
        
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        jcompdate.setText(sqlDate.toString());
    }
    
    private void table_comp () 
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
private void update_comp() {
          try {
            String sql = "update company_details set comp_name='"+jcompname.getText().trim()+"',prdct_name='"+jproduct_name.getText().trim()+"',prdct_category='"+jproductcateg.getText().trim()+"',comp_address='"+jcompadd.getText().trim()+"',comp_phno='"+jcompphno.getText().trim()+"',comp_email='"+jcompemail.getText().trim()+"' where comp_id='"+jcompid.getText().trim()+"'"; 
            pst = con.prepareStatement(sql); 
            pst.execute();
            JOptionPane.showMessageDialog(null, "updated");
                    } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }  

    }

public void add_comp(){
    
        try{
            
            
            
        if ( jcompname.getText().trim().equals("") || jproduct_name.getText().trim().equals("") || jproductcateg.getText().trim().equals("")|| jcompadd.getText().trim().equals("")|| jcompphno.getText().trim().equals(""))
          {
                   JOptionPane.showMessageDialog(null, "Fill Up All Required Fields");
           }
             else{
            String sql="INSERT into company_details VALUES('"+jcompid.getText().trim()+"','"+jcompname.getText().trim()+"','"+jproduct_name.getText().trim()+"','"+jproductcateg.getText().trim()+"','"+jcompadd.getText().trim()+"','"+jcompphno.getText().trim()+"','"+jcompemail.getText().trim()+"','"+jcompdate.getText().trim()+"')";
     PreparedStatement stmt = con.prepareStatement(sql);
            int result = stmt.executeUpdate();
            
            
if (result > 0) {
    JOptionPane.showMessageDialog(null,"Company Added Successfully");
    DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
        dm.addRow( new Object[] {jcompid.getText(),jcompname.getText(),jproduct_name.getText(),jproductcateg.getText(),jcompadd.getText(),jcompphno.getText(),jcompemail.getText(),jcompdate.getText()});
           
    clear();
         
        }
        }
        
        }
    
    catch(HeadlessException e){
    JOptionPane.showMessageDialog(null, e);
    }
       
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"You Can Not Add Same Company With Same Company ID Again" );
        }
    
    }
private void dirty_hack(){
            try {
            int a,b;
            String sql=String.valueOf("Select count(comp_id) from company_details ORDER BY count(comp_id) DESC LIMIT 1");
            pst=con.prepareStatement(sql);
            rst=pst.executeQuery(sql);
            if(rst.next())
            {
            a=rst.getInt("count(comp_id)");
            Integer i=a;
            i++;
              if(i >0 && i<=9)
              {
                jcompid.setText("COR-" + "0000" + String.valueOf(i).trim());
              }
              else if(i >=10 && i<=99)
              {
                  
                jcompid.setText("COR-" + "000" + String.valueOf(i).trim());
              }
              else if(i >=100 && i<=999)
              {
                  
                jcompid.setText("COR-" + "00" + String.valueOf(i).trim());
              }
              else if(i >=1000 && i<=9999)
              {
                  
                jcompid.setText("COR-" + "0" + String.valueOf(i).trim());
              }
              else if(i >=10000)
              {
                  
                jcompid.setText("COR-" + String.valueOf(i).trim());
              }
            
            }
            else 
                 {
                int c=0;
                b=c+1;
                jcompid.setText("COR-" + "0000" + String.valueOf(b).trim());
            }
            
           
    } catch (SQLException ex) {
            Logger.getLogger(purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
private void clear(){
        dirty_hack();
        jcompname.setText("");
        jproduct_name.setText("");
        jproductcateg.setText("");
        jcompadd.setText("");
        jcompphno.setText("");
        jcompemail.setText("");
        }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcompphno = new javax.swing.JTextField();
        jback = new javax.swing.JButton();
        jcompadd = new javax.swing.JTextField();
        jcn = new javax.swing.JLabel();
        jcp = new javax.swing.JLabel();
        jpc = new javax.swing.JLabel();
        jcompupdate = new javax.swing.JButton();
        jcompid = new javax.swing.JTextField();
        jcrd = new javax.swing.JLabel();
        jce = new javax.swing.JLabel();
        jcompdetails = new javax.swing.JLabel();
        jpn = new javax.swing.JLabel();
        jproduct_name = new javax.swing.JTextField();
        jca = new javax.swing.JLabel();
        jcompdate = new javax.swing.JTextField();
        jcr = new javax.swing.JLabel();
        jsavecomp = new javax.swing.JButton();
        jproductcateg = new javax.swing.JTextField();
        jcompemail = new javax.swing.JTextField();
        jcompname = new javax.swing.JTextField();
        jlabeltxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(18, 165, 245));

        jcompphno.setForeground(new java.awt.Color(1, 1, 1));
        jcompphno.setNextFocusableComponent(jcompemail);
        jcompphno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcompphnoFocusGained(evt);
            }
        });
        jcompphno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcompphnoActionPerformed(evt);
            }
        });
        jcompphno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcompphnoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcompphnoKeyPressed(evt);
            }
        });

        jback.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jback.setForeground(new java.awt.Color(1, 1, 1));
        jback.setText("Back");
        jback.setNextFocusableComponent(jcompname);
        jback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbackActionPerformed(evt);
            }
        });

        jcompadd.setForeground(new java.awt.Color(1, 1, 1));
        jcompadd.setNextFocusableComponent(jcompphno);

        jcn.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcn.setForeground(new java.awt.Color(1, 1, 1));
        jcn.setText("Company Name");

        jcp.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcp.setForeground(new java.awt.Color(1, 1, 1));
        jcp.setText("Company Phone-No");

        jpc.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jpc.setForeground(new java.awt.Color(1, 1, 1));
        jpc.setText("Product Categoory");

        jcompupdate.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcompupdate.setForeground(new java.awt.Color(1, 1, 1));
        jcompupdate.setText("Update Existing Company Details");
        jcompupdate.setNextFocusableComponent(jtable);
        jcompupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcompupdateActionPerformed(evt);
            }
        });

        jcompid.setForeground(new java.awt.Color(1, 1, 1));

        jcrd.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcrd.setForeground(new java.awt.Color(1, 1, 1));
        jcrd.setText("Company Registery Date");

        jce.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jce.setForeground(new java.awt.Color(1, 1, 1));
        jce.setText("Company E-Mail ID");

        jcompdetails.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jcompdetails.setForeground(new java.awt.Color(255, 255, 0));
        jcompdetails.setText("                                                                                          Company Details Entry");

        jpn.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jpn.setForeground(new java.awt.Color(1, 1, 1));
        jpn.setText("Product Name");

        jproduct_name.setForeground(new java.awt.Color(1, 1, 1));
        jproduct_name.setNextFocusableComponent(jproductcateg);

        jca.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jca.setForeground(new java.awt.Color(1, 1, 1));
        jca.setText("Company Address");

        jcompdate.setForeground(new java.awt.Color(1, 1, 1));
        jcompdate.setNextFocusableComponent(jsavecomp);
 

        jcr.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcr.setForeground(new java.awt.Color(1, 1, 1));
        jcr.setText("Company Register ID");

        jsavecomp.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsavecomp.setForeground(new java.awt.Color(1, 1, 1));
        jsavecomp.setText("Add New Company Details");
        jsavecomp.setNextFocusableComponent(jcompupdate);
        jsavecomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsavecompActionPerformed(evt);
            }
        });

        jproductcateg.setForeground(new java.awt.Color(1, 1, 1));
        jproductcateg.setNextFocusableComponent(jcompadd);
        jproductcateg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jproductcategActionPerformed(evt);
            }
        });

        jcompemail.setForeground(new java.awt.Color(1, 1, 1));
        jcompemail.setNextFocusableComponent(jcompdate);
        jcompemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcompemailKeyTyped(evt);
            }
        });

        jcompname.setForeground(new java.awt.Color(1, 1, 1));
        jcompname.setNextFocusableComponent(jproduct_name);

        jlabeltxt.setFocusTraversalPolicyProvider(true);
       
        jtable.setForeground(new java.awt.Color(1, 1, 1));
        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company Reg ID", "Company Name", "Product Name", "Product Category", "Comapny Address", "Company Phone-no", "Company E-Mail ID", "Company Reg Date"
            }
        ));
        jtable.setColumnSelectionAllowed(true);
        jtable.setNextFocusableComponent(jback);
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable);
        jtable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcompdetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jpc, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jpn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jcompid, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcompname, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jproduct_name, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jproductcateg, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcrd)
                            .addComponent(jcp)
                            .addComponent(jca, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jce, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcompdate, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcompphno, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcompemail, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcompadd, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jcompupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jsavecomp, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(166, 166, 166))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jback, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(223, 223, 223)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(680, 680, 680)
                    .addComponent(jlabeltxt)
                    .addContainerGap(680, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcompdetails)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcompadd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jback, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcompphno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jce, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcompemail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcrd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcompdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcompid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcr, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcompname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jproduct_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jproductcateg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jsavecomp, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jcompupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(360, 360, 360)
                    .addComponent(jlabeltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(360, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1370, 750));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcompphnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcompphnoFocusGained

    }//GEN-LAST:event_jcompphnoFocusGained

    private void jcompphnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcompphnoActionPerformed

    }//GEN-LAST:event_jcompphnoActionPerformed

    private void jcompphnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcompphnoKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
            || (vChar == KeyEvent.VK_BACK_SPACE)
            || (vChar == KeyEvent.VK_DELETE))) {
        evt.consume();
        }
    }//GEN-LAST:event_jcompphnoKeyTyped

    private void jcompphnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcompphnoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcompphnoKeyPressed

    private void jcompemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcompemailKeyTyped

    }//GEN-LAST:event_jcompemailKeyTyped

    private void jsavecompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsavecompActionPerformed

        add_comp();

    }//GEN-LAST:event_jsavecompActionPerformed

    private void jcompupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcompupdateActionPerformed
        int i=jtable.getSelectedRow();
        DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
        if (i>=0){

            dm.setValueAt(jcompid.getText(), jtable.getSelectedRow(), 0);
            dm.setValueAt(jcompname.getText(), jtable.getSelectedRow(), 1);
            dm.setValueAt(jproduct_name.getText(), jtable.getSelectedRow(), 2);
            dm.setValueAt(jproductcateg.getText(), jtable.getSelectedRow(), 3);
            dm.setValueAt(jcompadd.getText(), jtable.getSelectedRow(), 4);
            dm.setValueAt(jcompphno.getText(), jtable.getSelectedRow(), 5);
            dm.setValueAt(jcompemail.getText(), jtable.getSelectedRow(), 6);

            update_comp();
            clear();

        }
    }//GEN-LAST:event_jcompupdateActionPerformed

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {                                    
        if(jlabeltxt.getText().equals("purchase"))
        {
            purchase prchse =new purchase();
            prchse.jcompname.setText(jtable.getValueAt(jtable.getSelectedRow(), 1).toString());
        prchse.jprdctname.setText(jtable.getValueAt(jtable.getSelectedRow(), 2).toString());
        prchse.jcateg.setText(jtable.getValueAt(jtable.getSelectedRow(), 3).toString());
        jlabeltxt.setText("");
        prchse.setVisible(true);
        this.setVisible(false);
        
        }
        else if(jlabeltxt.getText().equals("")){
        jcompid.setText(jtable.getValueAt(jtable.getSelectedRow(), 0).toString());
        jcompname.setText(jtable.getValueAt(jtable.getSelectedRow(), 1).toString());
        jproduct_name.setText(jtable.getValueAt(jtable.getSelectedRow(), 2).toString());
        jproductcateg.setText(jtable.getValueAt(jtable.getSelectedRow(), 3).toString());
        jcompadd.setText(jtable.getValueAt(jtable.getSelectedRow(), 4).toString());
        jcompphno.setText(jtable.getValueAt(jtable.getSelectedRow(), 5).toString());
        jcompemail.setText(jtable.getValueAt(jtable.getSelectedRow(), 6).toString());
    
        
        } 
        
    }

    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
            if(jlabeltxt.getText().equals("purchase"))
        {
            
      jcompid.setVisible(false);
      jcompname.setVisible(false);
      jproduct_name.setVisible(false);
      jproductcateg.setVisible(false);
      jcompadd.setVisible(false);
      jcompphno.setVisible(false);
      jcompemail.setVisible(false);
      jcompdate.setVisible(false);
      jsavecomp.setVisible(false);
      jcompupdate.setVisible(false);
      jcr.setVisible(false);
      jcn.setVisible(false);
      jpn.setVisible(false);
      jpc.setVisible(false);
      jca.setVisible(false);
      jcp.setVisible(false);
      jce.setVisible(false);
      jcrd.setVisible(false);
      jback.setVisible(false);
      jcompdetails.setText("                                                                                          Select An Entry From Table");
        
        }
        else if(jlabeltxt.getText().equals("")){
        jcompid.setVisible(true);
      jcompname.setVisible(true);
      jproduct_name.setVisible(true);
      jproductcateg.setVisible(true);
      jcompadd.setVisible(true);
      jcompphno.setVisible(true);
      jcompemail.setVisible(true);
      jcompdate.setVisible(true);
      jsavecomp.setVisible(true);
      jcompupdate.setVisible(true);
      jcr.setVisible(true);
      jcn.setVisible(true);
      jpn.setVisible(true);
      jpc.setVisible(true);
      jca.setVisible(true);
      jcp.setVisible(true);
      jce.setVisible(true);
      jcrd.setVisible(true);
      jback.setVisible(true);
      jcompdetails.setText("                                                                                          Company Details Entry");
    jcompid.setEditable(false);
        jcompid.setEnabled(false);
        jcompdate.setEditable(false);
        jcompdate.setEnabled(false);
        
        
        } 
        
        
        clear();
    }//GEN-LAST:event_formWindowOpened

    private void jproductcategActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jproductcategActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jproductcategActionPerformed

    private void jbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbackActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_jbackActionPerformed

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
            java.util.logging.Logger.getLogger(company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new company().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jback;
    private javax.swing.JLabel jca;
    private javax.swing.JLabel jce;
    private javax.swing.JLabel jcn;
    private javax.swing.JTextField jcompadd;
    private javax.swing.JTextField jcompdate;
    private javax.swing.JLabel jcompdetails;
    private javax.swing.JTextField jcompemail;
    private javax.swing.JTextField jcompid;
    private javax.swing.JTextField jcompname;
    private javax.swing.JTextField jcompphno;
    private javax.swing.JButton jcompupdate;
    private javax.swing.JLabel jcp;
    private javax.swing.JLabel jcr;
    private javax.swing.JLabel jcrd;
    public javax.swing.JLabel jlabeltxt;
    private javax.swing.JLabel jpc;
    private javax.swing.JLabel jpn;
    private javax.swing.JTextField jproduct_name;
    private javax.swing.JTextField jproductcateg;
    private javax.swing.JButton jsavecomp;
    public javax.swing.JTable jtable;
    // End of variables declaration//GEN-END:variables
}
