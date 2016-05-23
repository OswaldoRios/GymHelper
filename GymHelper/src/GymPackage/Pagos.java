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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author ozzIE This class will verify if the customer ID has paid yet
 */
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.net.aso.a;
import oracle.net.aso.d;
import oracle.net.aso.e;
import oracle.net.aso.f;
import oracle.net.aso.g;
import oracle.net.aso.h;
import oracle.net.aso.i;
import oracle.security.o5logon.b;

public class Pagos {

    private static java.sql.Date getCurrentDate() {
       
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());

    }
    
    

    public void Pago() {
        String id;

        try {

            id = JOptionPane.showInputDialog("Ingrese la matricula del cliente que hara el pago");
            System.out.println("Its " + id);
            rs = st.executeQuery("SELECT Nombre1_cliente from clientes WHERE Id_cliente = " + id);
            rs.next();
            rs.getString(1);

         DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
         Date date = new Date();
         System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
            
               
               
            String monto = JOptionPane.showInputDialog("De cuanto sera el pago de " + rs.getString(1) + "?");

            rs = st.executeQuery("select count(id_cliente) from pagos where id_cliente = " + id);
            rs.next();
            int ID_Pago = rs.getInt(1) + 1;

            String script = "INSERT INTO pagos values(?,?,TO_DATE(?,  'YYYY-MM-DD\"T\"HH24:MI:SS\"Z\"'),?)";
            PreparedStatement psta = conn.prepareStatement(script);
            psta.setInt(1, ID_Pago);
            psta.setFloat(2, Float.parseFloat(monto));
            psta.setString(3, dateFormat.format(date));
            psta.setString(4, id);
            JOptionPane.showMessageDialog(null, "Se realizo el pago exitosamente!");
            System.out.println(ID_Pago);
            System.out.println(Float.parseFloat(monto));
            System.out.println(dateFormat.format(date));
            System.out.println(id);
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "error");

        }

        /*
         if (!MainPage.ID.isEmpty())
         {
         String confirm = JOptionPane.showInputDialog("Cuanto desea pagar el cliente?");
            
          
          
         try {
                  
         System.out.println(ID_Pago);
         } catch (SQLException ex) {
         Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
         }
               
         try {
         String script = ("");
         PreparedStatement psta = conn.prepareStatement(script); 
         psta.setString(1, a);
         } catch (SQLException ex) {
         Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
         }
          
         //String d= "to_date('"+getCurrentDate()+"','yyyy,mm,dd'";
          
         try{
          
         System.out.println(getCurrentDate());
           
         System.out.println(getCurrentDate());
           
         psta.setDate(2, java.sql.Date.valueOf(LocalDate.MIN));
         psta.setDouble(3, c);
         psta.execute();
         psta.close(); 
           
         }
         catch(Exception e)
         {
         System.out.println("It didnt work ");
         }
        
         }
         else
         {JOptionPane.showMessageDialog(null,"Por favor indique que cliente realizara el pago");}
         */
    }

}
