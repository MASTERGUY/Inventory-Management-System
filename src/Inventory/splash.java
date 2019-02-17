/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import javax.swing.JOptionPane;

/**
 *
 * @author murtaza
 */
public class splash {
    public static void main (String[] args)
    {
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
    
        splashlogo sl =new splashlogo();
    sl.setVisible(true);
    try{
        for (int i=0;i<=100;i++)
            
        {
              sl.jpb.setValue(i);
        
            Thread.sleep(30);
            
            if(i>0 & i<=29)
            {
                sl.jlbl.setText("Starting");
                
            }
            if(i>=30 & i<=59)
            {
                sl.jlbl.setText("Establishing Secure Connection");
                
            }
            if(i>=60 & i<=79)
            {
                sl.jlbl.setText("Enabling GUI Interface");
                
            }
            if(i>=80 & i<=100)
            {
                sl.jlbl.setText("Cleaning Up For Faster Speed Boot");
                
            }
            
          if(i==100)
          {
              sl.setVisible(false);
              login lgn=new login();
            lgn.setVisible(true);
          }
            
        }
        
    }catch(InterruptedException e)
    {
        JOptionPane.showMessageDialog(sl, e);
    }
    }
}
