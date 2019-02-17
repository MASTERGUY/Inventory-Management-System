/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

/**
 *
 * @author murtaza
 */

public class dataclass {
    public static void main(String[] args){
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
  }
 public static String csid,csname,prid,prname,prcategory,prqty,prmrp;
public  void  setcsid()
        {
                     csid =String.valueOf(csid);
                     
        }
public static String getcsid()
        {
                     return csid;
        }
public  void setcsname()
        {
                     csname=String.valueOf(csname);
                     
        }
public static String getcsname()
        {
                     return csname;
        }

public  void setprid()
        {   
                     prid=String.valueOf(prid);
        }
public static String getprid()
        {
                     return prid;
        }
        
public  void setprname()
        {
                     prid=String.valueOf(prname);
        }
public static  String getprname()
        {
                     return prname;
        }

public  void setprcategory()
        {
                     prcategory=String.valueOf(prcategory);
        }
public static String getprcategory()
        {
                     return prcategory;
        }

public  void setprqty()
        {
                     prqty=String.valueOf(prmrp);
        }

public static String getprqty()
        {
                     return prqty;
        }
public  void setprmrp()
        {
                     prmrp=String.valueOf(prmrp);
        }

public static String getprmrp()
        {
                     return prmrp;
        }
         

    void csid(String toString) {
        setcsid();
        getcsid();
    }

    void csname(String toString) {
        setcsname();
        getcsname();
    }
    
    void prid(String toString) {
        setprid();
        getprid();
    }
    
    void prname(String trim) {
        setprname();
        getcsname();
    }

    void prcategory(String trim) {
        setprcategory();
        getprcategory();
    }
    void prqty(String trim) {
        setprqty();
        getprqty();
    }
    void prmrp(String trim) {
        setprmrp();
        getprmrp();
    }


}
