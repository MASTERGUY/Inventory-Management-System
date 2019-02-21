package Inventory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class signup extends javax.swing.JFrame {

    java.util.Date date;
    java.sql.Date sqldate;
    Connection con =connection.getConnection();
    public signup() {
        initComponents();
    jdob.setDateFormatString("dd/MM/yyyy");
    }
   
 
       private void clear()
       {
           jtxtuser.setText("");
           jsecquestion.setSelectedIndex(0);
           jsecans.setText("");
           jdob.setToolTipText("");
           jtxtpass.setText("");
           jtxtpassconfrm.setText("");
       }
           
    @SuppressWarnings("deprecation")
	private void conn()
   {
    try {
      if(jtxtuser.getText().trim().equals("") || jtxtpass.getText().trim().equals("") || jtxtpassconfrm.getText().trim().equals("") || jsecans.getText().trim().equals(""))
          {
                   JOptionPane.showMessageDialog(null, "Fill Up All Required Fields");
           }
               else
             {
                 String sql1 = "SELECT user FROM login WHERE user ='" + jtxtuser.getText().trim() + "'";  
       try {
    Statement ctstmt = con.createStatement();
    
           ResultSet rs = ctstmt.executeQuery(sql1) ;
     if(rs.next()) {
      JOptionPane.showMessageDialog(null, "User Already Exist plesase choose different UserName");
     }
     else 
     {
         if(jtxtpass.getText().trim().equals(jtxtpassconfrm.getText().trim())) 
             {
                if(jtxtpass.getText().trim().equals(jtxtuser.getText().trim()))
             {
                         JOptionPane.showMessageDialog(null,"Username And Password Can not be Same");
                         jtxtpass.setText("");
                         jtxtpassconfrm.setText("");
             }
                else
                     {
                     jdob.setDateFormatString("dd/MM/yyyy");
        DateFormat sysDate = new SimpleDateFormat("dd/MM/yyyy");
        String date_to_store = sysDate.format(jdob.getDate());
                 Connection con =connection.getConnection();
                   String sql="INSERT into login VALUES(ID,'"+jtxtuser.getText().trim()+"','"+jsecquestion.getSelectedItem()+"','"+jsecans.getText().trim()+"','"+date_to_store+"','"+jadmin.getSelectedItem()+"','"+jtxtpass.getText().trim()+"')";
                     PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.executeUpdate();
                     
                         JOptionPane.showMessageDialog(null,"User Created Successfully");
                         clear();
                     }
                  }
                         else{
                         JOptionPane.showMessageDialog(null, "Password does not match");
                               }

     }
    } catch (SQLException e) {
    JOptionPane.showMessageDialog(null, e);
    }
}
}
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
}
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jhome = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtxtuser = new javax.swing.JTextField();
        jsecans = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jsgnup = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jadmin = new javax.swing.JComboBox<>();
        jsecquestion = new javax.swing.JComboBox<>();
        jdob = new com.toedter.calendar.JDateChooser();
        jtxtpass = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jtxtpassconfrm = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Signup");
        setLocationByPlatform(true);

        jPanel1.setBackground(new java.awt.Color(18, 165, 245));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("                         Sign Up                  ");

        jhome.setBackground(new java.awt.Color(245, 245, 245));
        jhome.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jhome.setForeground(new java.awt.Color(1, 1, 1));
        jhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-password-20.png"))); // NOI18N
        jhome.setText("Back  to Home");
        jhome.setBorder(null);
        jhome.setBorderPainted(false);
        jhome.setContentAreaFilled(false);
        jhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jhomeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-password-20-2.png"))); // NOI18N
        jLabel2.setText("Password");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-today-20.png"))); // NOI18N
        jLabel7.setText("Date of Birth");

        jsgnup.setBackground(new java.awt.Color(255, 255, 255));
        jsgnup.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsgnup.setForeground(new java.awt.Color(1, 1, 1));
        jsgnup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-add-user-male-20.png"))); // NOI18N
        jsgnup.setText("Signup Now");
        jsgnup.setBorder(null);
        jsgnup.setBorderPainted(false);
        jsgnup.setContentAreaFilled(false);
        jsgnup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsgnupActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-inquiry-20.png"))); // NOI18N
        jLabel6.setText("Security Question");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-password-20-2.png"))); // NOI18N
        jLabel3.setText("Confirm Password");

        jadmin.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jadmin.setForeground(new java.awt.Color(1, 1, 1));
        jadmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jadmin.setToolTipText("");
        jadmin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jadminItemStateChanged(evt);
            }
        });
        jadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jadminActionPerformed(evt);
            }
        });

        jsecquestion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsecquestion.setForeground(new java.awt.Color(1, 1, 1));
        jsecquestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is Your Father Name", "Who is Your Favourite Teacher", "What is Your Pet Name", "What is your School Name" }));
        jsecquestion.setToolTipText("");
        jsecquestion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jsecquestionItemStateChanged(evt);
            }
        });
        jsecquestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsecquestionActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-crown-20.png"))); // NOI18N
        jLabel9.setText("Is Admin");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-man-answering-a-question-20.png"))); // NOI18N
        jLabel8.setText("Security Answer");

        jCheckBox1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(1, 1, 1));
        jCheckBox1.setText("Show Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/icons8-user-male-20.png"))); // NOI18N
        jLabel1.setText("User Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtpassconfrm, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jadmin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jhome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jsgnup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtxtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdob, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jsecquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jsecans, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtxtpass, jtxtpassconfrm, jtxtuser});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jadmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtpassconfrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsgnup)
                .addGap(18, 18, 18)
                .addComponent(jhome)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtxtpass, jtxtpassconfrm, jtxtuser});

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

        setSize(new java.awt.Dimension(462, 615));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jsgnupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsgnupActionPerformed
         try {
            conn();
        } catch (Exception ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jsgnupActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
      if(jCheckBox1.isSelected()){
            jtxtpass.setEchoChar((char)0);
            jtxtpassconfrm.setEchoChar((char)0 );
        }else{
          jtxtpass.setEchoChar('*');
          jtxtpassconfrm.setEchoChar('*');
        }
       
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jsecquestionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jsecquestionItemStateChanged

    }//GEN-LAST:event_jsecquestionItemStateChanged

    private void jsecquestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsecquestionActionPerformed

    }//GEN-LAST:event_jsecquestionActionPerformed

    private void jadminItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jadminItemStateChanged

    }//GEN-LAST:event_jadminItemStateChanged

    private void jadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jadminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jadminActionPerformed

    private void jhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jhomeActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jhomeActionPerformed

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
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jadmin;
    private com.toedter.calendar.JDateChooser jdob;
    private javax.swing.JButton jhome;
    private javax.swing.JTextField jsecans;
    private javax.swing.JComboBox<String> jsecquestion;
    private javax.swing.JButton jsgnup;
    private javax.swing.JPasswordField jtxtpass;
    private javax.swing.JPasswordField jtxtpassconfrm;
    private javax.swing.JTextField jtxtuser;
    // End of variables declaration//GEN-END:variables
}
