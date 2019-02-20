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
public class purchase extends javax.swing.JFrame {

    DefaultTableModel dm;
    Connection con =connection.getConnection();
    ResultSet rst=null;
    PreparedStatement pst=null;
     public purchase() {
        initComponents();
        
    table();
        date();
        clear();
        jid.setEditable(false);
        jid.setEnabled(false);
        jtotal.setEditable(false);
        jdate.setEnabled(false);
        jdate.setEditable(false);
        jcompname.setEnabled(false);
        jcompname.setEditable(false);
        jprdctname.setEnabled(false);
        jprdctname.setEditable(false);
        jcateg.setEnabled(false);
        jcateg.setEditable(false);
        jlabel1txt.setVisible(false);
    }
    

    private void date(){
        
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        jdate.setText(sqlDate.toString());
    }
    




    private void dirtyhack(){
        try {
            int a,b;
            String sql=String.valueOf("Select count(ID) from purchase ORDER BY count(ID) DESC LIMIT 1");
            pst=con.prepareStatement(sql);
            rst=pst.executeQuery(sql);
            if(rst.next())
            {
            a=rst.getInt("count(ID)");
            Integer i=a;
            i++;
              if(i >0 && i<=9)
              {
                jid.setText("PUR-" + "0000" + String.valueOf(i).trim());
              }
              else if(i >=10 && i<=99)
              {
                  
                jid.setText("PUR-" + "000" + String.valueOf(i).trim());
              }
              else if(i >=100 && i<=999)
              {
                  
                jid.setText("PUR-" + "00" + String.valueOf(i).trim());
              }
              else if(i >=1000 && i<=9999)
              {
                  
                jid.setText("PUR-" + "0" + String.valueOf(i).trim());
              }
              else if(i >=10000)
              {
                  
                jid.setText("PUR-" + String.valueOf(i).trim());
              }
            
            }
            else 
                 {
                int c=0;
                b=c+1;
                
                jid.setText("PUR-" + "0000" + String.valueOf(b).trim());
            }
            
           
    } catch (SQLException ex) {
            Logger.getLogger(purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void clear(){
        dirtyhack();
        jcompname.setText("");
        jprdctname.setText("");
        jcateg.setText("");
        jqtnty.setText("");
        jprice.setText("");
        jtotal.setText("");
        jdiscri.setText("");
        jdiscount.setText("");
    }
    private void table () 
    {
        
        try  {
        String sql=("Select * from purchase");
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
    
    private void total() {
       try
       {
        float a,b,c,d,e; 
        
            a =Float.parseFloat(jqtnty.getText().trim()); 
            b =Float.parseFloat(jprice.getText().trim());
            c=a*b;
            d=((Float.parseFloat(jdiscount.getText().trim())*100)/c);
        jdiscrs.setText(String.valueOf(d).trim());
            
        e=c-Float.parseFloat(jdiscount.getText().trim());
            
           jtotal.setText(Float.toString(e).trim());   
       }
       catch(NullPointerException e)
       {
           JOptionPane.showMessageDialog(null,e);
       }
        
 
}
 
private void update() {
          try {
            String sql = "update purchase set comp_name='"+jcompname.getText().trim()+"', prdct_name='"+jprdctname.getText().trim()+"',prdct_category='"+jcateg.getText().trim()+"',prdct_discription='"+jdiscri.getText()+"' where ID='"+jid.getText()+"' "; 
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Table Updated");
                    } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }  

    }


   public void add(){
    
        try{
            
            
            
        if ( jcompname.getText().trim().equals("") || jprdctname.getText().trim().equals("") || jcateg.getText().trim().equals("") || jqtnty.getText().trim().equals("") || jprice.getText().trim().equals("") || jtotal.getText().trim().equals("") || jdiscri.getText().trim().equals("")|| jdate.getText().trim().equals(""))
          {
                   JOptionPane.showMessageDialog(null, "Fill Up All Required Fields");
           }
             else{
            
            String sql="INSERT into purchase VALUES('"+jid.getText().trim()+"','"+jcompname.getText().trim()+"','"+jprdctname.getText().trim()+"','"+jcateg.getText().trim()+"','"+jqtnty.getText().trim()+"','"+jprice.getText().trim()+"','"+jdiscount.getText().trim()+"','"+jtotal.getText().trim()+"','"+jdiscri.getText().trim()+"','"+jdate.getText().trim()+"')";
     PreparedStatement stmt = con.prepareStatement(sql);
     int result = stmt.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null,"Product Added Successfully");
if (result > 0) {
    DefaultTableModel dm = (DefaultTableModel) jtable.getModel();
        dm.addRow( new Object[] {jid.getText().trim(),jcompname.getText().trim(),jprdctname.getText().trim(),jcateg.getText().trim(),jqtnty.getText().trim(),jprice.getText().trim(),jdiscount.getText().trim(),jtotal.getText().trim(),jdiscri.getText().trim(),jdate.getText().trim()});
        
        }
        }
        
        }
    
    catch(HeadlessException | NullPointerException e){
    JOptionPane.showMessageDialog(null, e);
    }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"You Can Not Add Same Product With Same Product ID Again" );
        }
       
    
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jtable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jlabel1txt = new javax.swing.JLabel();
        jupdate = new javax.swing.JButton();
        jpc = new javax.swing.JLabel();
        jdiscount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        btnredirect = new javax.swing.JButton();
        jid = new javax.swing.JTextField();
        jqtnty = new javax.swing.JTextField();
        jprdctname = new javax.swing.JTextField();
        jpn = new javax.swing.JLabel();
        jdiscrs = new javax.swing.JLabel();
        jdate = new javax.swing.JTextField();
        jcn = new javax.swing.JLabel();
        jtotal = new javax.swing.JTextField();
        jpp = new javax.swing.JLabel();
        jpd = new javax.swing.JLabel();
        jrs = new javax.swing.JLabel();
        jpt = new javax.swing.JLabel();
        jpq = new javax.swing.JLabel();
        jpr = new javax.swing.JLabel();
        jper = new javax.swing.JLabel();
        jprice = new javax.swing.JTextField();
        jppd = new javax.swing.JLabel();
        jpurchaselable = new javax.swing.JLabel();
        jcateg = new javax.swing.JTextField();
        jcompname = new javax.swing.JTextField();
        jsave = new javax.swing.JButton();
        jpdd = new javax.swing.JLabel();
        jdiscri = new javax.swing.JTextField();
        jback = new javax.swing.JButton();

        jtable1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jtable1.setForeground(new java.awt.Color(1, 1, 1));
        jtable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Company Name", "Product Name", "Product Category", "Product Quantity", "Product Price", "Product Discount", "Product Total", "Product Discription", "Product Purchase Date"
            }
        ));
        jtable1.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jtable1);
        jtable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Purchase");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(18, 165, 245));

        jupdate.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jupdate.setForeground(new java.awt.Color(1, 1, 1));
        jupdate.setText("Update");
        jupdate.setNextFocusableComponent(jtable);
        jupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jupdateActionPerformed(evt);
            }
        });

        jpc.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jpc.setForeground(new java.awt.Color(1, 1, 1));
        jpc.setText("Product Category");

        jdiscount.setFocusCycleRoot(true);
        jdiscount.setNextFocusableComponent(jtotal);
       
    
        jdiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdiscountKeyTyped(evt);
            }
          
        });

        jtable.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jtable.setForeground(new java.awt.Color(1, 1, 1));
        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Company Name", "Product Name", "Product Category", "Product Quantity", "Product Price", "Product Discount", "Product Total", "Product Discription", "Product Purchase Date"
            }
        ));
        jtable.setColumnSelectionAllowed(true);
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable);
        jtable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnredirect.setForeground(new java.awt.Color(1, 1, 1));
        btnredirect.setText("...");
        btnredirect.setFocusCycleRoot(true);
        btnredirect.setNextFocusableComponent(jqtnty);
        btnredirect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnredirectActionPerformed(evt);
            }
        });

       
   
        jqtnty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jqtntyKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jqtntyKeyPressed(evt);
            }
        });

        jpn.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jpn.setForeground(new java.awt.Color(1, 1, 1));
        jpn.setText("Product Name ");

        jdiscrs.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jdiscrs.setForeground(new java.awt.Color(0, 255, 76));

      

        jcn.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcn.setForeground(new java.awt.Color(1, 1, 1));
        jcn.setText("Company Name ");

        jtotal.setFocusCycleRoot(true);
        jtotal.setNextFocusableComponent(jdiscri);
        jtotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtotalFocusGained(evt);
            }
        });
      

        jpp.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jpp.setForeground(new java.awt.Color(1, 1, 1));
        jpp.setText("Product Price");

        jpd.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jpd.setForeground(new java.awt.Color(1, 1, 1));
        jpd.setText("Product Discount");

        jrs.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jrs.setForeground(new java.awt.Color(1, 1, 1));
        jrs.setText("RS");

        jpt.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jpt.setForeground(new java.awt.Color(1, 1, 1));
        jpt.setText("Product Total");

        jpq.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jpq.setForeground(new java.awt.Color(1, 1, 1));
        jpq.setText("Product Quantity");

        jpr.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jpr.setForeground(new java.awt.Color(1, 1, 1));
        jpr.setText("Product Register ID");

        jper.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jper.setForeground(new java.awt.Color(1, 1, 1));
        jper.setText("%");

        jprice.setFocusCycleRoot(true);
        jprice.setNextFocusableComponent(jdiscount);
        jprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jpriceKeyTyped(evt);
            }
        });

        jppd.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jppd.setForeground(new java.awt.Color(1, 1, 1));
        jppd.setText("Product Purchase Date");

        jpurchaselable.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jpurchaselable.setForeground(new java.awt.Color(255, 255, 0));
        jpurchaselable.setText("                                                                                        Purchase Product");



        jsave.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsave.setForeground(new java.awt.Color(1, 1, 1));
        jsave.setText("Save");
        jsave.setNextFocusableComponent(jupdate);
        jsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsaveActionPerformed(evt);
            }
        });

        jpdd.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jpdd.setForeground(new java.awt.Color(1, 1, 1));
        jpdd.setText("Product  Discription");

        jdiscri.setNextFocusableComponent(jsave);

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jpurchaselable, javax.swing.GroupLayout.PREFERRED_SIZE, 1342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jpr, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jpq)
                        .addGap(56, 56, 56)
                        .addComponent(jqtnty, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpdd)
                        .addGap(77, 77, 77)
                        .addComponent(jdiscri, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jpn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jprdctname, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jpd, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jrs, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jdiscrs, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jper))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jpc, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jcateg, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jpt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jsave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(jupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jcn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnredirect, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jcompname, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jpp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jprice, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jppd)
                                .addGap(57, 57, 57)
                                .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addComponent(jback, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(690, 690, 690)
                    .addComponent(jlabel1txt)
                    .addContainerGap(690, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jback, jsave, jupdate});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jpurchaselable)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jpr, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpq, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jqtnty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jpdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdiscri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jcn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnredirect))
                    .addComponent(jcompname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jpp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jprice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jppd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jpn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jprdctname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jpd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jrs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jdiscrs, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jper, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jpc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcateg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jpt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jsave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jback, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(360, 360, 360)
                    .addComponent(jlabel1txt)
                    .addContainerGap(360, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jback, jsave, jupdate});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1370, 750));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents



    private void jqtntyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jqtntyKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
            || (vChar == KeyEvent.VK_BACK_SPACE)
            || (vChar == KeyEvent.VK_DELETE))) {
        evt.consume();
        }
    }//GEN-LAST:event_jqtntyKeyTyped

    private void jqtntyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jqtntyKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jqtntyKeyPressed

    private void jpriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpriceKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
            || (vChar == KeyEvent.VK_BACK_SPACE)
            || (vChar == KeyEvent.VK_DELETE)
                )) {
        evt.consume();
        }
    }//GEN-LAST:event_jpriceKeyTyped

    private void jtotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtotalFocusGained
        total();
    }//GEN-LAST:event_jtotalFocusGained

    private void jsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsaveActionPerformed

        add();
        clear();
    }//GEN-LAST:event_jsaveActionPerformed

    private void jupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jupdateActionPerformed
        int i=jtable.getSelectedRow();
        if (i>=0){

            dm.setValueAt(jid.getText(), jtable.getSelectedRow(), 0);
            dm.setValueAt(jcompname.getText(), jtable.getSelectedRow(), 1);
            dm.setValueAt(jprdctname.getText(), jtable.getSelectedRow(), 1);
            dm.setValueAt(jcateg.getText(), jtable.getSelectedRow(), 2);
            dm.setValueAt(jdiscri.getText(), jtable.getSelectedRow(), 6);

            update();
            clear();

        }
    }//GEN-LAST:event_jupdateActionPerformed

    private void btnredirectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnredirectActionPerformed
        company cmpy = new company();
        cmpy.jlabeltxt.setText("purchase");
        cmpy.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnredirectActionPerformed

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

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked
       if(jlabel1txt.getText().equals("purchase"))
{
    
   
    dataclass.prid=(jtable.getValueAt(jtable.getSelectedRow(), 0).toString().trim());
    dataclass.prname=(jtable.getValueAt(jtable.getSelectedRow(), 2).toString().trim());
    dataclass.prcategory=(jtable.getValueAt(jtable.getSelectedRow(), 3).toString().trim());
    dataclass.prqty=(jtable.getValueAt(jtable.getSelectedRow(), 4).toString().trim());
    dataclass.prmrp=(jtable.getValueAt(jtable.getSelectedRow(), 5).toString().trim());
    this.setVisible(false);
    
    
  
}
else if (jlabel1txt.getText().equals(""))
{
    

        jid.setText(jtable.getValueAt(jtable.getSelectedRow(), 0).toString().trim());
        jcompname.setText(jtable.getValueAt(jtable.getSelectedRow(), 1).toString().trim());
        jprdctname.setText(jtable.getValueAt(jtable.getSelectedRow(), 2).toString().trim());
        jcateg.setText(jtable.getValueAt(jtable.getSelectedRow(), 3).toString().trim());
        jqtnty.setText(jtable.getValueAt(jtable.getSelectedRow(), 4).toString().trim());
        jprice.setText(jtable.getValueAt(jtable.getSelectedRow(), 5).toString().trim());
        jdiscount.setText(jtable.getValueAt(jtable.getSelectedRow(), 6).toString().trim());
        jtotal.setText(jtable.getValueAt(jtable.getSelectedRow(), 7).toString().trim());
        jdiscri.setText(jtable.getValueAt(jtable.getSelectedRow(), 8).toString().trim());
        jdate.setText(jtable.getValueAt (jtable.getSelectedRow(), 9).toString().trim());
}
    }//GEN-LAST:event_jtableMouseClicked

    private void jbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbackActionPerformed

   
 this.setVisible(false);
       
    }//GEN-LAST:event_jbackActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(jlabel1txt.getText().equals("purchase"))
{
    
   
    jid.setVisible(false);
    jcompname.setVisible(false);
    jprdctname.setVisible(false);
    jcateg.setVisible(false);
    jqtnty.setVisible(false);
    jprice.setVisible(false);
    jdiscount.setVisible(false);
    jtotal.setVisible(false);
    jdiscri.setVisible(false);
    jdate.setVisible(false);
    jsave.setVisible(false);
    jupdate.setVisible(false);
    btnredirect.setVisible(false);
    jpr.setVisible(false);
    jcn.setVisible(false);
    jpn.setVisible(false);
    jpc.setVisible(false);
    jpq.setVisible(false);
    jpp.setVisible(false);
    jpd.setVisible(false);
    jpt.setVisible(false);
    jpdd.setVisible(false);
    jppd.setVisible(false);
    jrs.setVisible(false);
    jper.setVisible(false);
    jdiscri.setVisible(false);
    jback.setVisible(false);
    jpurchaselable.setText("                                                                                        Select An Entry From Table");
    
    
  
}
else if (jlabel1txt.getText().equals(""))
{
    
jid.setVisible(true);
    jcompname.setVisible(true);
    jprdctname.setVisible(true);
    jcateg.setVisible(true);
    jqtnty.setVisible(true);
    jprice.setVisible(true);
    jdiscount.setVisible(true);
    jtotal.setVisible(true);
    jdiscri.setVisible(true);
    jdate.setVisible(true);
    jsave.setVisible(true);
    jupdate.setVisible(true);
    btnredirect.setVisible(true);
    jpr.setVisible(true);
    jcn.setVisible(true);
    jpn.setVisible(true);
    jpc.setVisible(true);
    jpq.setVisible(true);
    jpp.setVisible(true);
    jpd.setVisible(true);
    jpt.setVisible(true);
    jpdd.setVisible(true);
    jppd.setVisible(true);
    jrs.setVisible(true);
    jper.setVisible(true);
    jdiscri.setVisible(true);
    jback.setVisible(true);
    jpurchaselable.setText("                                                                                        Purchase Product");
}
              
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new purchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnredirect;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jback;
    public javax.swing.JTextField jcateg;
    private javax.swing.JLabel jcn;
    public javax.swing.JTextField jcompname;
    private javax.swing.JTextField jdate;
    private javax.swing.JTextField jdiscount;
    protected javax.swing.JTextField jdiscri;
    private javax.swing.JLabel jdiscrs;
    public javax.swing.JTextField jid;
    public javax.swing.JLabel jlabel1txt;
    private javax.swing.JLabel jpc;
    private javax.swing.JLabel jpd;
    private javax.swing.JLabel jpdd;
    private javax.swing.JLabel jper;
    private javax.swing.JLabel jpn;
    private javax.swing.JLabel jpp;
    private javax.swing.JLabel jppd;
    private javax.swing.JLabel jpq;
    private javax.swing.JLabel jpr;
    public javax.swing.JTextField jprdctname;
    public javax.swing.JTextField jprice;
    private javax.swing.JLabel jpt;
    private javax.swing.JLabel jpurchaselable;
    private javax.swing.JTextField jqtnty;
    private javax.swing.JLabel jrs;
    private javax.swing.JButton jsave;
    public javax.swing.JTable jtable;
    public javax.swing.JTable jtable1;
    private javax.swing.JTextField jtotal;
    private javax.swing.JButton jupdate;
    // End of variables declaration//GEN-END:variables
}
