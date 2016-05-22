/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GymPackage;

import ConnectionPack.ConnectionClass;
import static ConnectionPack.ConnectionClass.sta;
import static GymPackage.MainPage.conn;
import static GymPackage.NewCustomer.rs;
import static GymPackage.NewCustomer.st;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;


/**
 *
 * @author ozzIE
 * This class will verify if the customer ID has paid yet
 */
import java.util.Date;
import javax.swing.JOptionPane;
import oracle.net.aso.a;
import oracle.net.aso.d;
import oracle.net.aso.e;
import oracle.net.aso.f;
import oracle.net.aso.g;
import oracle.net.aso.h;
import oracle.net.aso.i;
import oracle.security.o5logon.b;
public class Pagos{
    
    private static java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
}
    

    public void Pago(){
        
          int confirm = JOptionPane.showConfirmDialog(null, "Realizar pago de Mensualidad?");
        
        if (confirm == 0)
        {
          Date date = new Date();
          String datef = "dd,MMM,yyyy";
          SimpleDateFormat simple = new SimpleDateFormat(datef);
          System.out.println(simple.format(date));
          
          
          //String d= "to_date('"+getCurrentDate()+"','yyyy,mm,dd'";
          
       /* try{
          
            System.out.println(getCurrentDate());
           
            System.out.println(getCurrentDate());
            String script = "INSERT INTO pagos values(?,?,?)";
            PreparedStatement psta = conn.prepareStatement(script);
            psta.setInt(1, p);
            psta.setDate(2, java.sql.Date.valueOf(LocalDate.MIN));
            psta.setDouble(3, c);
            psta.execute();
            psta.close(); 
           
        }
        catch(Exception e)
        {
            System.out.println("It didnt work ");
        }
        */
        }
        
    }
    
    
   
  
    
    
}
