/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;


import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author murtaza
 */
@SuppressWarnings("serial")
public class customers extends javax.swing.JFrame {

    /**
     * Creates new form customers
     */
     DefaultTableModel dm;
    Connection con =connection.getConnection();
    ResultSet rst=null;
    PreparedStatement pst=null;
    public customers() {
        initComponents();
        table_cus();
       clear();
        
    }
private void table_cus () 
    {
        
        try  {
        String sql=("Select * from customer_details");
        pst=con.prepareStatement(sql);
        rst=pst.executeQuery(sql);
        DefaultTableModel dm = (DefaultTableModel) jtablecs.getModel();
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
        jtablecs.setDefaultEditor(Object.class, null);
        }
        catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
private void update_cus() {
          try {
            String sql = "update customer_details set cus_name='"+jcusname.getText()+"',cus_address='"+jcusadd.getText()+"',cus_phno='"+jcusphno.getText()+"',cus_email='"+jcusemail.getText()+"',cus_idprooftype='"+jidprf.getSelectedItem()+"',cus_idproof='"+jidprfans.getText()+"' where cus_id='"+jcusid.getText()+"'"; 
            pst = con.prepareStatement(sql); 
            pst.execute();
            JOptionPane.showMessageDialog(null, "updated");
                    } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }  

    }

public void add_cus(){
    
        try{
            
            
            
        if ( jcusadd.getText().trim().equals("") || jcusadd.getText().trim().equals("") || jcusphno.getText().trim().equals("") ||jidprfans.getText().trim().equals(""))
          {
                   JOptionPane.showMessageDialog(null, "Fill Up All Required Fields");
           }
             else{
            String sql="INSERT into customer_details VALUES('"+jcusid.getText().trim()+"','"+jcusname.getText().trim()+"','"+jcusadd.getText().trim()+"','"+jcusphno.getText().trim()+"','"+jcusemail.getText().trim()+"','"+jidprf.getSelectedItem()+"','"+jidprfans.getText().trim()+"')";
     PreparedStatement stmt = con.prepareStatement(sql);
     
            int result = stmt.executeUpdate();
            
if (result > 0) {
    JOptionPane.showMessageDialog(null,"Customer Added Successfully");
    DefaultTableModel dm = (DefaultTableModel) jtablecs.getModel();
        dm.addRow( new Object[] {jcusid.getText(),jcusname.getText(),jcusadd.getText(),jcusphno.getText(),jcusemail.getText(),jidprf.getSelectedItem(),jidprfans.getText()});
    
    clear();
                
        }
        }
        
        }
    
    catch(HeadlessException e){
    JOptionPane.showMessageDialog(null, e);
    }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"You Can Not Add Same Customer With Same Customer ID Again" );
        }
       
        
    
    }
private void dirty_hack(){
            try {
            int a,b;
            String sql=String.valueOf("Select count(cus_id) from customer_details ORDER BY count(cus_id) DESC LIMIT 1");
            pst=con.prepareStatement(sql);
            rst=pst.executeQuery(sql);
            if(rst.next())
            {
            a=rst.getInt("count(cus_id)");
            Integer i=a;
            i++;
              if(i >0 && i<=9)
              {
                jcusid.setText("CUR-" + "0000" + String.valueOf(i).trim());
              }
              else if(i >=10 && i<=99)
              {
                  
                jcusid.setText("CUR-" + "000" + String.valueOf(i).trim());
              }
              else if(i >=100 && i<=999)
              {
                  
                jcusid.setText("CUR-" + "00" + String.valueOf(i).trim());
              }
              else if(i >=1000 && i<=9999)
              {
                  
                jcusid.setText("CUR-" + "0" + String.valueOf(i).trim());
              }
              else if(i >=10000)
              {
                  
                jcusid.setText("CUR-" + String.valueOf(i).trim());
              }
            
            }
            else 
                 {
                int c=0;
                b=c+1;
                jcusid.setText("CUR-" + "0000" + String.valueOf(b).trim());
            }
      
            } catch (SQLException ex) {
            Logger.getLogger(purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
private void clear(){
        dirty_hack();
        jcusname.setText("");
        jcusadd.setText("");
        jcusphno.setText("");
        jcusemail.setText("");
        jidprf.setSelectedIndex(0);
        jidprfans.setText("");
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcustomerentry = new javax.swing.JLabel();
        jca = new javax.swing.JLabel();
        jdelete = new javax.swing.JButton();
        jcusphno = new javax.swing.JTextField();
        jcp = new javax.swing.JLabel();
        jcusid = new javax.swing.JTextField();
        jback = new javax.swing.JButton();
        jidprf = new javax.swing.JComboBox<>();
        jci = new javax.swing.JLabel();
        jcr = new javax.swing.JLabel();
        jce = new javax.swing.JLabel();
        jcip = new javax.swing.JLabel();
        jcusname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablecs = new javax.swing.JTable();
        jcusemail = new javax.swing.JTextField();
        jcn = new javax.swing.JLabel();
        jcussave = new javax.swing.JButton();
        jcusupdate = new javax.swing.JButton();
        jidprfans = new javax.swing.JTextField();
        jcusadd = new javax.swing.JTextField();
        jlabletxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customers Entry");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(18, 165, 245));

        jcustomerentry.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jcustomerentry.setForeground(new java.awt.Color(255, 255, 0));
        jcustomerentry.setText("                                                                                          Customer Entry");

        jca.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jca.setForeground(new java.awt.Color(1, 1, 1));
        jca.setText("Customer Address");

        jdelete.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jdelete.setForeground(new java.awt.Color(1, 1, 1));
        jdelete.setText("Delete customer");
        jdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdeleteActionPerformed(evt);
            }
        });

        jcusphno.setForeground(new java.awt.Color(1, 1, 1));
        jcusphno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcusphnoFocusGained(evt);
            }
        });
        jcusphno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcusphnoActionPerformed(evt);
            }
        });
        jcusphno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcusphnoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcusphnoKeyPressed(evt);
            }
        });

        jcp.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcp.setForeground(new java.awt.Color(1, 1, 1));
        jcp.setText("Customer Phone-No");

        jcusid.setForeground(new java.awt.Color(1, 1, 1));

        jback.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jback.setForeground(new java.awt.Color(1, 1, 1));
        jback.setText("Back");
        jback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbackActionPerformed(evt);
            }
        });

        jidprf.setForeground(new java.awt.Color(1, 1, 1));
        jidprf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adhar Card", "Driving License", "Pan Card", "Passport No" }));
        jidprf.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jidprfItemStateChanged(evt);
            }
        });
        jidprf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jidprfFocusGained(evt);
            }
        });
        jidprf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jidprfActionPerformed(evt);
            }
        });

        jci.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jci.setForeground(new java.awt.Color(1, 1, 1));
        jci.setText("Customer ID Proof");

        jcr.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcr.setForeground(new java.awt.Color(1, 1, 1));
        jcr.setText("Customer Register ID");

        jce.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jce.setForeground(new java.awt.Color(1, 1, 1));
        jce.setText("Customer E-Mail ID");

        jcip.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcip.setForeground(new java.awt.Color(1, 1, 1));
        jcip.setText("Customer ID Proof");

        jcusname.setForeground(new java.awt.Color(1, 1, 1));

        jtablecs.setForeground(new java.awt.Color(1, 1, 1));
        jtablecs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Register ID", "Customer Name", "Customer Address", "Customer Ph-no", "Customer E-Mail-Id", "Customer ID Proof Type", "Customer ID Proof"
            }
        ));
        jtablecs.setColumnSelectionAllowed(true);
        jtablecs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtablecsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtablecs);
        jtablecs.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jcusemail.setForeground(new java.awt.Color(1, 1, 1));
        jcusemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcusemailKeyTyped(evt);
            }
        });

        jcn.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcn.setForeground(new java.awt.Color(1, 1, 1));
        jcn.setText("Customer Name");

        jcussave.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcussave.setForeground(new java.awt.Color(1, 1, 1));
        jcussave.setText("Add New Customer");
        jcussave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcussaveActionPerformed(evt);
            }
        });

        jcusupdate.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcusupdate.setForeground(new java.awt.Color(1, 1, 1));
        jcusupdate.setText("Update Existing Customer");
        jcusupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcusupdateActionPerformed(evt);
            }
        });

        jidprfans.setForeground(new java.awt.Color(1, 1, 1));
        jidprfans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jidprfansKeyTyped(evt);
            }
        });

        jcusadd.setForeground(new java.awt.Color(1, 1, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(jcusid, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(jcusname, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jca, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(jcusadd, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcp)
                                .addGap(105, 105, 105)
                                .addComponent(jcusphno, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jce, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(jcusemail, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jcussave, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jcusupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jback, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcip, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jci, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(103, 103, 103)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jidprfans)
                                    .addComponent(jidprf, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
                    .addComponent(jcustomerentry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(647, 647, 647)
                    .addComponent(jlabletxt)
                    .addContainerGap(713, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jcusadd, jcusemail, jcusid, jcusname, jcusphno, jidprf, jidprfans});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcustomerentry)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jcr, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcusid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jcn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcusname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcusadd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcusphno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jce, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcusemail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jci, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jidprf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcip, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jidprfans, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jcussave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jcusupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jback, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(348, 348, 348)
                    .addComponent(jlabletxt)
                    .addContainerGap(372, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jcusadd, jcusemail, jcusid, jcusname, jcusphno, jidprf, jidprfans});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jcusemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcusemailKeyTyped

    }//GEN-LAST:event_jcusemailKeyTyped

    private void jcusphnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcusphnoFocusGained
        
    }//GEN-LAST:event_jcusphnoFocusGained

    private void jcusphnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcusphnoActionPerformed
        
    }//GEN-LAST:event_jcusphnoActionPerformed

    private void jcusphnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcusphnoKeyTyped
        char vChar = evt.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE))) {
                        evt.consume();
                    }
    }//GEN-LAST:event_jcusphnoKeyTyped

    private void jcusphnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcusphnoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcusphnoKeyPressed

    private void jcussaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcussaveActionPerformed
   
       add_cus();
    }//GEN-LAST:event_jcussaveActionPerformed

    private void jcusupdateActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int i=jtablecs.getSelectedRow();
        DefaultTableModel dm = (DefaultTableModel) jtablecs.getModel();
        if (i>=0){
            dm.setValueAt(jcusid.getText(), jtablecs.getSelectedRow(), 0);
            dm.setValueAt(jcusname.getText(), jtablecs.getSelectedRow(), 1);
            dm.setValueAt(jcusadd.getText(), jtablecs.getSelectedRow(), 2);
            dm.setValueAt(jcusphno.getText(), jtablecs.getSelectedRow(), 3);
            dm.setValueAt(jcusemail.getText(), jtablecs.getSelectedRow(), 4);
            dm.setValueAt(jidprf.getSelectedItem(), jtablecs.getSelectedRow(), 5);
            dm.setValueAt(jidprfans.getText(), jtablecs.getSelectedRow(), 6);
          
           update_cus();
           clear();
            

        }
    }

    private void jdeleteActionPerformed(java.awt.event.ActionEvent evt) {                                        
        int i=jtablecs.getSelectedRow();
        if(i>=0){
            try {
                String sql = "delete from customer_details where cus_id='"+jcusid.getText()+"'";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Selected Customer Is Deleted");
                dm.removeRow(jtablecs.getSelectedRow());
                
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Error No Row Selected");
        }
        clear();
    }

    private void jbackActionPerformed(java.awt.event.ActionEvent evt) {                                      

           this.setVisible(false);
    }

    private void jtablecsMouseClicked(java.awt.event.MouseEvent evt) {                                      
 if(jlabletxt.getText().equals("customers"))
        {
            
           
            
        dataclass.csid=(jtablecs.getValueAt(jtablecs.getSelectedRow(), 0).toString());
        dataclass.csname=(jtablecs.getValueAt(jtablecs.getSelectedRow(), 1).toString());
        this.setVisible(false);
        jlabletxt.setText("");
       
        
        }
 else if(jlabletxt.getText().equals("")){
        jcusid.setText(jtablecs.getValueAt(jtablecs.getSelectedRow(), 0).toString());
        jcusname.setText(jtablecs.getValueAt(jtablecs.getSelectedRow(), 1).toString());
        jcusadd.setText(jtablecs.getValueAt(jtablecs.getSelectedRow(), 2).toString());
        jcusphno.setText(jtablecs.getValueAt(jtablecs.getSelectedRow(), 3).toString());
        jcusemail.setText(jtablecs.getValueAt(jtablecs.getSelectedRow(), 4).toString());
        jidprf.setSelectedItem(jtablecs.getValueAt(jtablecs.getSelectedRow(), 5).toString());
        jidprfans.setText(jtablecs.getValueAt(jtablecs.getSelectedRow(), 6).toString());
 }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  

        if(jlabletxt.getText().equals("customers"))
        {
            jcusid.setVisible(false);
            jcusname.setVisible(false);
            jcusadd.setVisible(false);
            jcusphno.setVisible(false);
            jcusemail.setVisible(false);
            jidprf.setVisible(false);
            jidprfans.setVisible(false);
            jcussave.setVisible(false);
            jcusupdate.setVisible(false);
            jdelete.setVisible(false);
            jcr.setVisible(false);
            jci.setVisible(false);
            jcn.setVisible(false);
            jca.setVisible(false);
            jcp.setVisible(false);
            jce.setVisible(false);
            jci.setVisible(false);
            jcip.setVisible(false);
            jback.setVisible(false);
            jcustomerentry.setText("                                                                                          Select An Entry From Table");
            
            
        
        }
 else if(jlabletxt.getText().equals("")){

             jcusid.setEditable(false);
        jcusid.setEnabled(false);
        jlabletxt.setVisible(false);
        jidprfans.setEditable(false);
        jidprfans.setEnabled(false);
            jcusid.setVisible(true);
            jcusname.setVisible(true);
            jcusadd.setVisible(true);
            jcusphno.setVisible(true);
            jcusemail.setVisible(true);
            jidprf.setVisible(true);
            jidprfans.setVisible(true);
            jcussave.setVisible(true);
            jcusupdate.setVisible(true);
            jdelete.setVisible(true);
            jcr.setVisible(true);
             jci.setVisible(true);
            jcn.setVisible(true);
            jca.setVisible(true);
            jcp.setVisible(true);
            jce.setVisible(true);
            jci.setVisible(true);
            jcip.setVisible(true);
            jcustomerentry.setText("                                                                                          Customer Entry");
        clear();

 }
                                     
    }




    private void jidprfFocusGained(java.awt.event.FocusEvent evt) {                                   
        jidprfans.setEditable(true);
        jidprfans.setEnabled(true);
       
    }

private void jidprfItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jidprfItemStateChanged
        
    }//GEN-LAST:event_jidprfItemStateChanged


private void jidprfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jidprfActionPerformed
   
       
    }//GEN-LAST:event_jidprfActionPerformed
    
private void jidprfansKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jidprfansKeyTyped
   
       
    }//GEN-LAST:event_jidprfansKeyTyped
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         //</editor-fold>
         
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new customers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jback;
    private javax.swing.JLabel jca;
    private javax.swing.JLabel jce;
    private javax.swing.JLabel jci;
    private javax.swing.JLabel jcip;
    private javax.swing.JLabel jcn;
    private javax.swing.JLabel jcp;
    private javax.swing.JLabel jcr;
    private javax.swing.JTextField jcusadd;
    private javax.swing.JTextField jcusemail;
    private javax.swing.JTextField jcusid;
    private javax.swing.JTextField jcusname;
    private javax.swing.JTextField jcusphno;
    private javax.swing.JButton jcussave;
    private javax.swing.JLabel jcustomerentry;
    private javax.swing.JButton jcusupdate;
    private javax.swing.JButton jdelete;
    private javax.swing.JComboBox<String> jidprf;
    private javax.swing.JTextField jidprfans;
    public javax.swing.JLabel jlabletxt;
    public javax.swing.JTable jtablecs;
    // End of variables declaration//GEN-END:variables
}
