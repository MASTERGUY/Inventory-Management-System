 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/*
/**
 *
 * @author murtaza
 */
@SuppressWarnings("serial")
public class sales extends javax.swing.JFrame {

     DefaultTableModel dm;
    Connection con =connection.getConnection();
    ResultSet rst=null;
    PreparedStatement pst=null;
    java.util.Date date;
    java.sql.Date sqldate;
    public sales() 
    {
        initComponents();
        table();
        date();
        enabled();
        dirtyhack();
    }
 
    
    private void enabled()
    {
        jinvid.setEditable(false);
        jinvid.setEnabled(false);
        jcusid.setEditable(false);
        jcusid.setEnabled(false);
        jprdctid.setEditable(false);
        jprdctid.setEnabled(false);
        jcusname.setEnabled(false);
        jcusname.setEditable(false);
        jinvdate.setEnabled(false);
        jinvdate.setEditable(false);
        jprdctname.setEnabled(false);
        jprdctname.setEditable(false);
        jprdctcateg.setEnabled(false);
        jprdctcateg.setEditable(false);
        jcostprice.setEditable(false);
        jcostprice.setEnabled(false);
        jgtotal.setEditable(false);
        jprdcttotal.setEditable(false);
        jpymntdue.setEnabled(false);
        jpymntdue.setEditable(false);
    }
    private void date(){
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        jinvdate.setText(sqlDate.toString());
    }
    
    private void dirtyhack(){
         
        try {
            int a,b;
            
            String sql=String.valueOf("Select count(inv_id) from sales ORDER BY count(inv_id) DESC LIMIT 1");
            pst=con.prepareStatement(sql);
            rst=pst.executeQuery(sql);
            if(rst.next())
            {
            a=rst.getInt("count(inv_id)");
            Integer i=a;
            i++;
              if(i >0 && i<=9)
              {
                jinvid.setText("INV-" + "0000" + String.valueOf(i).trim());
              }
              else if(i >=10 && i<=99)
              {
                  
                jinvid.setText("INV-" + "000" + String.valueOf(i).trim());
              }
              else if(i >=100 && i<=999)
              {
                  
                jinvid.setText("INV-" + "00" + String.valueOf(i).trim());
              }
              else if(i >=1000 && i<=9999)
              {
                  
                jinvid.setText("INV-" + "0" + String.valueOf(i).trim());
              }
              else if(i >=10000)
              {
                  
                jinvid.setText("INV-" + String.valueOf(i).trim());
              }
            
            }
            else 
                 {
                int c=0;
                b=c+1; 
                jinvid.setText("INV-" + "0000" + String.valueOf(b).trim());
                }
            
                } 
        catch (SQLException ex) {
            Logger.getLogger(purchase.class.getName()).log(Level.SEVERE, null, ex);
                                 }
        
}
    public void clear()
    {
        dirtyhack();
        jcusid.setText("");
        jcusname.setText("");
        jprdctid.setText("");
        jprdctname.setText("");
        jprdctcateg.setText("");
        jcostprice.setText("");
        jcp.setText("");
        jsellingprice.setText("");
        jqtnty.setText("");
        jselldiscount.setText("");
        jdiscount.setText("");
        jbankname.setText("");
        jchequeno.setText("");
        jgtotal.setText("");
        jtpymnt.setText("");
        jpymntdue.setText("");
        jprdcttotal.setText("");
        
    }
    private float table () 
    {
        dm=(DefaultTableModel) jtable.getModel();
        jtable.setDefaultEditor(Object.class, null);
        float rc=jtable.getRowCount();
        float total=0;
        for(int i=0; i< rc; i++)
        {
            total=total+Float.parseFloat(jtable.getValueAt(i, 5).toString());
        }
        return total;
    }
    
    private void total() 
    {
        try{
        float a,b,c,d,e,f,g; 
        a=Float.parseFloat(jqtnty.getText().trim()); 
            b=Float.parseFloat(jcostprice.getText().trim());
            f=Float.parseFloat(jsellingprice.getText().trim());
            c=a*b;
            e=((f*c)/100);
            g=c+e;
            d=g-Float.parseFloat(jdiscount.getText().trim());
           jprdcttotal.setText(Float.toString(d).trim());    
        }
        catch(NumberFormatException | NullPointerException e){ 
            JOptionPane.showMessageDialog(null,e);
       }
    }
private void sells()
{
    try{
        float a,b,c,d,e,f,g; 
        a=Float.parseFloat(jqtnty.getText().trim()); 
            b=Float.parseFloat(jcostprice.getText().trim());
            f=Float.parseFloat(jsellingprice.getText().trim());
            c=a*b;
            
            e=((f*c)/100);
            g=c+e;
            jselldiscount.setText(String.valueOf(g).trim());
}
             catch(NumberFormatException | NullPointerException e){ 
            JOptionPane.showMessageDialog(null,e);

}
}
  
   public void qty(){
        if(jqtnty.getText().equals("0"))
        {
            JOptionPane.showMessageDialog(null, "Quantity cant be zero");
            jqtnty.setText("");
        }
        try{
        int a,b;
        float c,d,e;
        a=Integer.parseInt(jlblqty.getText().trim());
        b=Integer.parseInt(jqtnty.getText().trim());
        if(a < b)
        {
            JOptionPane.showMessageDialog(null,"Purchased Stock is less then Entered Quantity ");
            jqtnty.setText("");
        }
        else
                {
                    c=Float.parseFloat(jqtnty.getText().trim()); 
                    d=Float.parseFloat(jcostprice.getText().trim());
                    e=c*d;
                    jcp.setText(String.valueOf(e).trim());
                }
        
       }
       catch(NumberFormatException|HeadlessException e){
           
       }
   }

    public void itemStateChanged(ItemEvent event) {
       if (event.getStateChange() == ItemEvent.SELECTED) {
          if(jtransmode.getSelectedItem().equals("Cash"))
                  {
                      jbankname.setEditable(false);
                      jbankname.setEnabled(false);
                      jchequeno.setEnabled(false);
                      jchequeno.setEditable(false);
                  }
          else if(jtransmode.getSelectedItem().equals("Cheque"))
          {
              
                      jbankname.setEditable(true);
                      jbankname.setEnabled(true);
                      jchequeno.setEnabled(true);
                      jchequeno.setEditable(true);
                  
          }
       }
       
    }       


   public void add(){
    
        try{
            if ( jcusid.getText().trim().equals("") || jcusname.getText().trim().equals("") || jprdctname.getText().trim().equals("") || jprdctcateg.getText().trim().equals("") || jsellingprice.getText().trim().equals("") || jdiscount.getText().trim().equals("") || jqtnty.getText().trim().equals("") ||  jgtotal.getText().trim().equals("")|| jinvdate.getText().trim().equals("") || jtpymnt.getText().trim().equals("") || jpymntdue.getText().trim().equals("") )
            {
                JOptionPane.showMessageDialog(null, "Fill Up All Required Fields");
            }
             else
            {
            String sql="INSERT into sales VALUES('"+jinvid.getText().trim()+"' ,'"+jcusid.getText().trim()+"' ,'"+jcusname.getText().trim()+"' ,'"+jinvdate.getText().trim()+"','"+jprdctid.getText().trim()+"','"+jprdctname.getText().trim()+"' ,'"+jprdctcateg.getText().trim()+"' ,'"+jsellingprice.getText().trim()+"' ,'"+jqtnty.getText().trim()+"' ,'"+jdiscount.getText().trim()+"' ,'"+jprdcttotal.getText().trim()+"' ,'"+jtransmode.getSelectedItem()+"','"+jbankname.getText().trim()+"','"+jchequeno.getText().trim()+"','"+jgtotal.getText().trim()+"','"+jtpymnt.getText().trim()+"','"+jpymntdue.getText().trim()+"')";
            PreparedStatement stmt = con.prepareStatement(sql);
            pst=con.prepareStatement(sql);
           int result = stmt.executeUpdate();
          if(result > 0)
          {
            JOptionPane.showMessageDialog(null,"Product Added Successfully");
            clear();
                dataclass.csid="";
                dataclass.csname="";
                dataclass.prid="";
                dataclass.prname="";
                dataclass.prcategory="";
                dataclass.prqty="";
                dataclass.prmrp="";
                
            DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
        dm.setRowCount(0);
          }
        }
        }
   
    catch(HeadlessException | SQLException e){
    JOptionPane.showMessageDialog(null, e);
    }
   }
    public void addcart()
    {
        if(jprdctid.getText().equals("") || jprdctname.getText().equals("") || jprdctcateg.getText().equals("") || jsellingprice.getText().equals("") || jdiscount.getText().equals("") || jprdcttotal.getText().equals(""))
       {
        JOptionPane.showMessageDialog(null, "Enter all Details before Adding it to Cart");
       }
        else{
            
             DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
            dm.addRow( new Object[] {jprdctid.getText(),jprdctname.getText(),jcostprice.getText(),jqtnty.getText(),jsellingprice.getText(),jdiscount.getText(),jprdcttotal.getText()});
        jprdctid.setText("");
            jprdctname.setText("");
            jprdctcateg.setText("");
            jcostprice.setText("");
            jcp.setText("");
            jsellingprice.setText("");
            jselldiscount.setText("");
            jqtnty.setText("");
            jlblqty.setText("");
            jdiscount.setText("");
            jprdcttotal.setText("");
        }
    }

    public void pendingpymnt(){
        
        try
        {
            float a,b,c;
        a=Float.parseFloat(jgtotal.getText().trim());
        b=Float.parseFloat(jtpymnt.getText().trim());
        c=a-b;
        jpymntdue.setText(String.valueOf(c));
        }
        catch(NumberFormatException e){ 
       }
    }
    private void anotherhack()
    {
         try{
            
        
        if (dataclass.csid.equals(""))
        {
        } else {
            jcusid.setText(dataclass.getcsid().trim());
            jcusname.setText(dataclass.getcsname().trim());
         }
        if(dataclass.prid.equals(""))
        {
        }else{
            jprdctid.setText(dataclass.getprid().trim());
                jprdctname.setText(dataclass.getprname().trim());
                jprdctcateg.setText(dataclass.getprcategory().trim());
                jcostprice.setText(dataclass.getprmrp().trim());
                jlblqty.setText(dataclass.getprqty().trim());
        }
        }
        catch(NullPointerException e)
        {
            
            
        }
    }
 
    

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jback = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jpurchaselable1 = new javax.swing.JLabel();
        jprdctid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jprdctname = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jprdctcateg = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jsellingprice = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jdiscount = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jaddcart = new javax.swing.JButton();
        jqntyftch = new javax.swing.JLabel();
        jqtnty = new javax.swing.JTextField();
        jlblqty = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jprdcttotal = new javax.swing.JTextField();
        btnredirect1 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jcostprice = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jselldiscount = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jcp = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jbankname = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jchequeno = new javax.swing.JTextField();
        jtransmode = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jgtotal = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jtpymnt = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jpymntdue = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jinvid = new javax.swing.JTextField();
        jcusid = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jcusname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jinvdate = new javax.swing.JTextField();
        btnredirect = new javax.swing.JButton();
        jpurchaselable = new javax.swing.JLabel();
        jsave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales");
        setForeground(java.awt.Color.white);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(18, 165, 245));

        jback.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jback.setForeground(new java.awt.Color(1, 1, 1));
        jback.setText("Back");
        jback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbackActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(18, 165, 245));

        jpurchaselable1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jpurchaselable1.setForeground(new java.awt.Color(255, 255, 0));
        jpurchaselable1.setText("                                                                                 Product Details");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Product Register ID");

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(1, 1, 1));
        jLabel18.setText("Product Name ");

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(1, 1, 1));
        jLabel19.setText("Product Category");

        jprdctcateg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jprdctcategActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(1, 1, 1));
        jLabel20.setText("Profit");

        jsellingprice.setFocusCycleRoot(true);
        jsellingprice.setNextFocusableComponent(jdiscount);
        jsellingprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsellingpriceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jsellingpriceKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(1, 1, 1));
        jLabel21.setText("Discount");

        jdiscount.setFocusCycleRoot(true);
        jdiscount.setNextFocusableComponent(jprdcttotal);
        jdiscount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jdiscountFocusGained(evt);
            }
        });
        jdiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdiscountActionPerformed(evt);
            }
        });
        jdiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdiscountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jdiscountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdiscountKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(1, 1, 1));
        jLabel23.setText("Quantity");

        jLabel24.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(1, 1, 1));
        jLabel24.setText("RS");

        jaddcart.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jaddcart.setForeground(new java.awt.Color(1, 1, 1));
        jaddcart.setText("Add to Cart");
        jaddcart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaddcartActionPerformed(evt);
            }
        });

        jqntyftch.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jqntyftch.setForeground(new java.awt.Color(0, 255, 76));

        jqtnty.setFocusCycleRoot(true);
        jqtnty.setNextFocusableComponent(jsellingprice);
        jqtnty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jqtntyFocusGained(evt);
            }
        });
        jqtnty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jqtntyActionPerformed(evt);
            }
        });
        jqtnty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jqtntyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jqtntyKeyTyped(evt);
            }
        });

        jlblqty.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlblqty.setForeground(new java.awt.Color(255, 10, 0));

        jLabel22.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(1, 1, 1));
        jLabel22.setText("Selling Price");

        jprdcttotal.setFocusCycleRoot(true);
        jprdcttotal.setNextFocusableComponent(jaddcart);
        jprdcttotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jprdcttotalFocusGained(evt);
            }
        });
        jprdcttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jprdcttotalActionPerformed(evt);
            }
        });
        jprdcttotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jprdcttotalKeyPressed(evt);
            }
        });

        btnredirect1.setForeground(new java.awt.Color(1, 1, 1));
        btnredirect1.setText("...");
        btnredirect1.setFocusCycleRoot(true);
        btnredirect1.setNextFocusableComponent(jqtnty);
        btnredirect1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnredirect1ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(1, 1, 1));
        jLabel32.setText("Cost Price");

        jcostprice.setFocusCycleRoot(true);
        jcostprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcostpriceKeyTyped(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(1, 1, 1));
        jLabel34.setText("%");

        jselldiscount.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jselldiscount.setForeground(new java.awt.Color(0, 255, 76));

        jLabel35.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(1, 1, 1));
        jLabel35.setText("RS");

        jcp.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcp.setForeground(new java.awt.Color(255, 10, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(btnredirect1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jprdctid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jprdctname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jprdctcateg, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jqtnty, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcostprice, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlblqty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addComponent(jaddcart, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                                .addComponent(jqntyftch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jdiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                            .addComponent(jsellingprice))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel34)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                                .addComponent(jselldiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jprdcttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jpurchaselable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jpurchaselable1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jprdctid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnredirect1))))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jsellingprice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jselldiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jlblqty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jcp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jprdcttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(jaddcart, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jprdctname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jprdctcateg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcostprice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jqntyftch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jqtnty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel3.setBackground(new java.awt.Color(18, 165, 245));

        jLabel26.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 0));
        jLabel26.setText("                                                                Transaction Details");

        jLabel27.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(1, 1, 1));
        jLabel27.setText("Transaction Mode");

        jLabel28.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(1, 1, 1));
        jLabel28.setText("Bank Name");

        jbankname.setNextFocusableComponent(jchequeno);

        jLabel29.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(1, 1, 1));
        jLabel29.setText("Cheque No");

        jchequeno.setNextFocusableComponent(jgtotal);

        jtransmode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cheque", "Cash" }));
        jtransmode.setToolTipText("");
        jtransmode.setNextFocusableComponent(jbankname);
        jtransmode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtransmodeItemStateChanged(evt);
            }
        });
        jtransmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtransmodeActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(1, 1, 1));
        jLabel30.setText("Grand Total");

        jgtotal.setNextFocusableComponent(jprdcttotal);
        jgtotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jgtotalFocusGained(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(1, 1, 1));
        jLabel31.setText("Total Payment");

        jtpymnt.setNextFocusableComponent(jsave);
        jtpymnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtpymntKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtpymntKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtpymntKeyReleased(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(1, 1, 1));
        jLabel33.setText("Payment Due");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jchequeno, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbankname, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtransmode, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtpymnt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addGap(31, 31, 31)
                                        .addComponent(jgtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jpymntdue, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtransmode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbankname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jgtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtpymnt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchequeno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpymntdue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jtable.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Product Category", "Cost Price", "Selling Price", "Discount", "Product Total"
            }
        ));
        jtable.setColumnSelectionAllowed(true);
        jtable.getTableHeader().setReorderingAllowed(false);
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable);
        jtable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.setBackground(new java.awt.Color(18, 165, 245));

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(1, 1, 1));
        jLabel15.setText("Invoice ID");

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(1, 1, 1));
        jLabel16.setText("Customer Register ID");

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(1, 1, 1));
        jLabel17.setText("Customer Name");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("                                          Invoice Details");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(1, 1, 1));
        jLabel14.setText("Invoice Creation Date");

        jinvdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jinvdateActionPerformed(evt);
            }
        });

        btnredirect.setForeground(new java.awt.Color(1, 1, 1));
        btnredirect.setText("...");
        btnredirect.setFocusCycleRoot(true);
        btnredirect.setNextFocusableComponent(btnredirect1);
        btnredirect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnredirectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnredirect, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jcusname)
                                .addComponent(jinvdate))
                            .addComponent(jcusid, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jinvid, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jcusid, jcusname, jinvdate, jinvid});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jinvid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcusid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnredirect))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcusname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jinvdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jpurchaselable.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jpurchaselable.setForeground(new java.awt.Color(255, 255, 0));
        jpurchaselable.setText("                                                                                          Sell Product");

        jsave.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsave.setForeground(new java.awt.Color(1, 1, 1));
        jsave.setText("Save");
        jsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpurchaselable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jsave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jback)
                                        .addGap(55, 55, 55))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane1))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jback, jsave});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jpurchaselable)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jsave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jback))
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jback, jsave});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1370, 749));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked

        jprdctid.setText((jtable.getValueAt(jtable.getSelectedRow(), 0).toString().trim()));
        jprdctname.setText(jtable.getValueAt(jtable.getSelectedRow(), 1).toString().trim());
        jprdctcateg.setText(jtable.getValueAt(jtable.getSelectedRow(), 2).toString().trim());
        jcostprice.setText(jtable.getValueAt(jtable.getSelectedRow(), 3).toString().trim());
        jsellingprice.setText(jtable.getValueAt(jtable.getSelectedRow(), 4).toString().trim());
        jdiscount.setText(jtable.getValueAt(jtable.getSelectedRow(), 5).toString().trim());
        jprdcttotal.setText(jtable.getValueAt(jtable.getSelectedRow(), 6).toString().trim());
    }//GEN-LAST:event_jtableMouseClicked

    private void btnredirectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnredirectActionPerformed
        customers csm =new customers();
        csm.jlabletxt.setText("customers");
        csm.setVisible(true);
        
         
    }//GEN-LAST:event_btnredirectActionPerformed

    private void jsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsaveActionPerformed
        add();
                
    }//GEN-LAST:event_jsaveActionPerformed

    private void jgtotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jgtotalFocusGained
       jgtotal.setText(Float.toString((float) table()));
    }//GEN-LAST:event_jgtotalFocusGained

    private void jtransmodeItemStateChanged(java.awt.event.ItemEvent evt) { 
        itemStateChanged(evt);
   }                                           

    private void jtpymntKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpymntKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
            || (vChar == KeyEvent.VK_BACK_SPACE)
            || (vChar == KeyEvent.VK_DELETE)
            || (vChar == KeyEvent.VK_PERIOD)
            || (vChar == KeyEvent.VK_DECIMAL))) {
        evt.consume();
        }
        
    }//GEN-LAST:event_jtpymntKeyTyped

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       anotherhack();
    }//GEN-LAST:event_formWindowActivated


    private void jtpymntKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpymntKeyReleased
            pendingpymnt();        
    }//GEN-LAST:event_jtpymntKeyReleased

    private void btnredirect1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnredirect1ActionPerformed
        purchase prchse =new purchase();
        prchse.jlabel1txt.setText("purchase");
        prchse.setVisible(true);
    }//GEN-LAST:event_btnredirect1ActionPerformed

    private void jprdcttotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jprdcttotalFocusGained
        total();
    }//GEN-LAST:event_jprdcttotalFocusGained

    private void jqtntyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jqtntyKeyReleased
       
    }//GEN-LAST:event_jqtntyKeyReleased
    
    private void jqtntyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jqtntyKeyTyped
 char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
            || (vChar == KeyEvent.VK_BACK_SPACE)
            || (vChar == KeyEvent.VK_DELETE))) {
        evt.consume();
        }
        qty();
    }//GEN-LAST:event_jqtntyKeyTyped


    private void jaddcartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaddcartActionPerformed
        addcart();
    }//GEN-LAST:event_jaddcartActionPerformed

    private void jdiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdiscountKeyReleased
        
    }//GEN-LAST:event_jdiscountKeyReleased



    private void jdiscountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdiscountKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
            || (vChar == KeyEvent.VK_BACK_SPACE)
            || (vChar == KeyEvent.VK_DELETE)
            || (vChar == KeyEvent.VK_PERIOD)
            || (vChar == KeyEvent.VK_DECIMAL))){
        evt.consume();
        }
    }//GEN-LAST:event_jdiscountKeyTyped


    private void jbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbackActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_jbackActionPerformed

    private void jcostpriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcostpriceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jcostpriceKeyTyped

    private void jsellingpriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jsellingpriceKeyReleased
        sells();
    }//GEN-LAST:event_jsellingpriceKeyReleased

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
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sales().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnredirect;
    public javax.swing.JButton btnredirect1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jaddcart;
    private javax.swing.JButton jback;
    private javax.swing.JTextField jbankname;
    private javax.swing.JTextField jchequeno;
    public javax.swing.JTextField jcostprice;
    public javax.swing.JLabel jcp;
    public javax.swing.JTextField jcusid;
    public javax.swing.JTextField jcusname;
    private javax.swing.JTextField jdiscount;
    private javax.swing.JTextField jgtotal;
    private javax.swing.JTextField jinvdate;
    private javax.swing.JTextField jinvid;
    public javax.swing.JLabel jlblqty;
    public javax.swing.JTextField jprdctcateg;
    public javax.swing.JTextField jprdctid;
    public javax.swing.JTextField jprdctname;
    private javax.swing.JTextField jprdcttotal;
    private javax.swing.JLabel jpurchaselable;
    private javax.swing.JLabel jpurchaselable1;
    private javax.swing.JTextField jpymntdue;
    private javax.swing.JLabel jqntyftch;
    public javax.swing.JTextField jqtnty;
    private javax.swing.JButton jsave;
    private javax.swing.JLabel jselldiscount;
    public javax.swing.JTextField jsellingprice;
    private javax.swing.JTable jtable;
    private javax.swing.JTextField jtpymnt;
    private javax.swing.JComboBox<String> jtransmode;
    // End of variables declaration//GEN-END:variables
}
