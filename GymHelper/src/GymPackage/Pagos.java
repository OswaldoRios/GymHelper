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
import java.time.LocalDate;
import java.util.Calendar;

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
    return new java.sql.Date(Calendar.getInstance().getTimeInMillis());
}
    
    
        public String id;
        public int flag=0;
        public int flag2=0;
        public int flag3=0;
        
        
    public void Pago() {
        
       
        try {

            id = JOptionPane.showInputDialog("Ingrese la matricula del cliente que hara el pago");
            System.out.println("Its " + id);
            rs = st.executeQuery("SELECT Nombre1_cliente from clientes WHERE Id_cliente = " + id);
            rs.next();
            rs.getString(1);
            
        }
            catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error:Ese numero de cliente no existe");
            flag=1;
        }
           try { 
         java.util.Date now = new java.util.Date(System.currentTimeMillis());
               
               
            String monto = JOptionPane.showInputDialog("De cuanto sera el pago de " + rs.getString(1) + "?");

            rs = st.executeQuery("select count(ID_PAGOS) from Pagos");
            rs.next();
            int ID_Pago = rs.getInt(1) + 1;

            String script = "INSERT INTO pagos values(?,?,?,?)";
            PreparedStatement psta = conn.prepareStatement(script);
            psta.setInt(1, ID_Pago);
            psta.setFloat(2, Float.parseFloat(monto));
            psta.setDate(3, new java.sql.Date((new Date(System.currentTimeMillis())).getTime()));
            psta.setString(4, id);
            
            System.out.println(ID_Pago);
            System.out.println(Float.parseFloat(monto));
            System.out.println(new java.sql.Date((new Date(System.currentTimeMillis())).getTime()));
            System.out.println(id);
            psta.execute();
            psta.close();
            JOptionPane.showMessageDialog(null, "Se realizo el pago exitosamente!");
            
        } catch (Exception x) {
            if(flag==0)
            JOptionPane.showMessageDialog(null, "Error: No se ingreso un monto valido");
             flag=1;
        }
           //Aqui se agregara lo de las membresias
      if(flag==0)
      {  
       
        try {
              rs = st.executeQuery("select vencimiento from membresias join pagos using "
                      + "(ID_Cliente) where ID_CLIENTE ="+id);
              rs.next();
              Date test= rs.getDate(1);
                 flag3=1;
                System.out.println("Membresia existente");
        }
            catch (Exception x) {
                System.out.println("No existe membresia aun");
                flag2=1;
              
        }
            if(flag2==1)
            {
        try {
              String script = "INSERT INTO membresias values(?,?,ADD_MONTHS(sysdate,-5))";
            PreparedStatement psta = conn.prepareStatement(script);
            psta.setInt(1, Integer.parseInt(id));
            psta.setBoolean(2, true);
            //psta.setDate(3, new java.sql.Date((new Date(System.currentTimeMillis())).getTime()));
            psta.execute();
            psta.close();
            System.out.println("Se agrego la membresia exitosamente");
        }
            catch (Exception x) {
                System.out.println("Error creating membership");
                
        }
            }
            if(flag3==1)
            {
        try {
            
            String script = "Update membresias set vencimiento = "
                    + "ADD_MONTHS(vencimiento,1) where ID_Cliente ="+id;
            PreparedStatement psta = conn.prepareStatement(script);
            psta.execute();
            psta.close();
            System.out.println("Se le agrego un mes de membresia");
        }
            catch (Exception x) {
                System.out.println("Error creating membership");
                
        }
            }
      
      
      
      }   
    }

}
