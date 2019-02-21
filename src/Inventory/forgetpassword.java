/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author murtaza
 */
public class forgetpassword extends javax.swing.JFrame {

      java.util.Date date;
    java.sql.Date sqldate;
    PreparedStatement ps;
   Connection con =connection.getConnection();
    public forgetpassword() throws SQLException{
         initComponents();
        date();
        jtxtpass.setEditable(false);
        
        
        
    }

    public String itemStateChanged(ItemEvent event) 
          {
               String txt = null;
       if (event.getStateChange() == ItemEvent.SELECTED) {
          Object item = event.getItem();
         
          if(jsecquestion.getSelectedItem().equals("What is Your Father Name"))
                  {
               txt = jsecans.getText();
                  }
          else if(jsecquestion.getSelectedItem().equals("What is Your Favourite Teacher name"))
          {
              txt = jsecans.getText();
           }
          else if(jsecquestion.getSelectedItem().equals("What is Your Pet Name"))
          {
              txt = jsecans.getText();
           }
          else if(jsecquestion.getSelectedItem().equals("What is your School Name"))
          {
              txt = jsecans.getText();
           }
          else
          {
              JOptionPane.showMessageDialog(null, "my custom error");
          }
       
       }
        return txt;
    }    
       private void date()
 { 
    jdob.setDateFormatString("dd/MM/yyyy");
 }
    private void conn()
   {
    try {
                   
            
                PreparedStatement pst=con.prepareStatement("select *from login where user='"+jtxtuser.getText().trim()+"'");
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            { 
                     jsecquestion.setSelectedItem(rs.getString("sec_ques"));
            }
            
            else
                    {
                        
                    JOptionPane.showMessageDialog(null, "User is not Registered either Misspelled");
                    jtxtuser.setText("");    
                    }
           
        }
        catch(SQLException | HeadlessException e)
        {
           JOptionPane.showMessageDialog(this, e);
        }
      
}
   
    private void jbtnclick()
            {
                try {
                 
                     jdob.setDateFormatString("dd/MM/yyyy");
        DateFormat sysDate = new SimpleDateFormat("dd/MM/yyyy");
        String date_to_store = sysDate.format(jdob.getDate());
        PreparedStatement pst;
        pst = con.prepareStatement("select *from login where sec_ans='"+jsecans.getText().trim()+"' and dob='"+date_to_store+"'");
        ResultSet rs=pst.executeQuery();
        if(rs.next())
            {
                jtxtpass.setText(rs.getString("password"));
            }
            else
                    {
                     JOptionPane.showMessageDialog(this, "Either Security Answer or Date Entred is Incorrect");
                    }
        rs.close();
        
          } 
                
                
     catch (SQLException ex) {
     Logger.getLogger(forgetpassword.class.getName()).log(Level.SEVERE, null, ex);
          }
            
            }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtxtpass = new javax.swing.JTextField();
        jdob = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jlogin = new javax.swing.JButton();
        jtxtuser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jsecquestion = new javax.swing.JComboBox<>();
        jsecans = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jclose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Forget Password Recovery");

        jPanel1.setBackground(new java.awt.Color(18, 165, 245));

        jtxtpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtpassFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-user-male-20.png"))); // NOI18N
        jLabel2.setText("User Name");

        jlogin.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlogin.setForeground(new java.awt.Color(1, 1, 1));
        jlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-password-20.png"))); // NOI18N
        jlogin.setText("Login");
        jlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jloginActionPerformed(evt);
            }
        });

        jtxtuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtuserFocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-today-20.png"))); // NOI18N
        jLabel7.setText("Date of Birth");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-password-20-2.png"))); // NOI18N
        jLabel4.setText("Password");

        jsecquestion.setForeground(new java.awt.Color(1, 1, 1));
        jsecquestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is Your Father Name", "What is Your Favourite Teacher name", "What is Your Pet Name", "What is your School Name" }));
        jsecquestion.setToolTipText("");
        jsecquestion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jsecquestionItemStateChanged(evt);
            }
        });
        jsecquestion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jsecquestionFocusGained(evt);
            }
        });
        jsecquestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsecquestionActionPerformed(evt);
            }
        });

        jsecans.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jsecansFocusGained(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-man-answering-a-question-20.png"))); // NOI18N
        jLabel8.setText("Security Answer");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-inquiry-20.png"))); // NOI18N
        jLabel6.setText("Security Question");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("        Forgot Password Recovery");

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(1, 1, 1));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-reset-20.png"))); // NOI18N
        jButton1.setText("Recover");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jclose.setBackground(new java.awt.Color(254, 254, 254));
        jclose.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jclose.setForeground(new java.awt.Color(1, 1, 1));
        jclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-multiply-20.png"))); // NOI18N
        jclose.setName("Close"); // NOI18N
        jclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtxtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jsecquestion, 0, 1, Short.MAX_VALUE)
                                .addComponent(jdob, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jsecans, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jclose, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jclose)
                .addGap(4, 4, 4)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsecquestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsecans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jlogin))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jlogin});

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

        setSize(new java.awt.Dimension(450, 510));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jbtnclick();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jsecquestionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jsecquestionItemStateChanged
        itemStateChanged(evt);
    }//GEN-LAST:event_jsecquestionItemStateChanged

    private void jsecquestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsecquestionActionPerformed

    }//GEN-LAST:event_jsecquestionActionPerformed

    private void jsecquestionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jsecquestionFocusGained
        
    }//GEN-LAST:event_jsecquestionFocusGained

    private void jsecansFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jsecansFocusGained
        
    }//GEN-LAST:event_jsecansFocusGained

    private void jtxtuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtuserFocusLost
        conn();
    }//GEN-LAST:event_jtxtuserFocusLost

    private void jtxtpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtpassFocusGained
       
    }//GEN-LAST:event_jtxtpassFocusGained

    private void jdobFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jdobFocusLost
       jbtnclick();
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jdobFocusLost

    private void jloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jloginActionPerformed
        login lgn=new login();
        lgn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jloginActionPerformed

    private void jcloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jcloseActionPerformed

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
            java.util.logging.Logger.getLogger(forgetpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgetpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgetpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgetpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new forgetpassword().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(forgetpassword.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jclose;
    private com.toedter.calendar.JDateChooser jdob;
    private javax.swing.JButton jlogin;
    private javax.swing.JTextField jsecans;
    private javax.swing.JComboBox<String> jsecquestion;
    private javax.swing.JTextField jtxtpass;
    private javax.swing.JTextField jtxtuser;
    // End of variables declaration//GEN-END:variables
}
