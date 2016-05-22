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
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ozzIE All the customer info will be found here
 */
public class Customers {

   static public String matri; 
    
    public void EditCliente(String a, String b, String c, String d, String e,
            String f, String g, String h, String i, String j)
    {   
        
        
         //String m = JOptionPane.showInputDialog(null);
        
        try {
            
            ConnectionPack.ConnectionClass miconexion = new ConnectionPack.ConnectionClass();
            conn = ConnectionClass.Enlace(conn);
            
            rs = st.executeQuery("SELECT * FROM clientes WHERE Id_cliente="+ Customers.matri);
            rs.next();
            // System.out.println("The id: is "+rs.getString(1));
           
            String script = ("UPDATE clientes SET Nombre1_cliente = ?, Nombre2_cliente = ?, Apellido1_cliente = ?, Apellido2_cliente = ?, Direccion = ?, Ciudad = ?, Estado = ?, Codigo_Postal = ?, Tel1 = ?, Tel2 = ? WHERE id_cliente="+Customers.matri);
            
                PreparedStatement psta = conn.prepareStatement(script); 
            
                psta.setString(1, a);
                psta.setString(2, b);
                psta.setString(3, c);
                psta.setString(4, d);
                psta.setString(5, e);
                psta.setString(6, f);
                psta.setString(7, g);
                psta.setString(8, h);
                psta.setString(9, i);
                psta.setString(10, j);
               
               
                psta.execute();
                psta.close();

            JOptionPane.showMessageDialog(null, "Se actualizo la informacion exitosamente!");
           
        } catch (Exception x) {
            System.out.println("It didnt work");
        }
      }
    
    public void BorrarCliente() {

         try {
            
            String script = ("DELETE FROM clientes WHERE id_cliente="+Customers.matri);
            
            
            PreparedStatement psta = conn.prepareStatement(script); 
            
                psta.execute();
                psta.close();

            JOptionPane.showMessageDialog(null, "Se elimino el cliente exitosamente!");
            
        } catch (Exception x) {
            System.out.println("It didnt work");
        }
    }

    public void ClienteNuevo(String a, String b, String c, String d, String e,
            String f, String g, String h, String i, String j) {

       int m;
      
        try {

            ConnectionPack.ConnectionClass miconexion = new ConnectionPack.ConnectionClass();
            conn = ConnectionClass.Enlace(conn);
            st = sta(st);
            rs = st.executeQuery("select max(Id_cliente) from clientes where Id_cliente >0");
            rs.next();
            System.out.println(rs.getInt(1));
            m = rs.getInt(1)+1;

            String script = "insert into clientes values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement psta = conn.prepareStatement(script);
            psta.setInt(1, m);
            psta.setString(2, a);
            psta.setString(3, b);
            psta.setString(4, c);
            psta.setString(5, d);
            psta.setString(6, e);
            psta.setString(7, f);
            psta.setString(8, g);
            psta.setString(9, h);
            psta.setString(10, i);
            psta.setString(11, j);
            
            psta.execute();
            psta.close();

            JOptionPane.showMessageDialog(null, "El cliente fue agregado correctamente!");
            JOptionPane.showMessageDialog(null, "Su matricula es " + m);
            /* Aqui se pueden almacenar visitas pero no lo usaremos
            st = sta(st);
            rs = st.executeQuery("select * from clientes where Id_cliente =" + m);
            rs.next();
            rs.getString(1); //First Name
            rs.getString(3); //Last Name
            rs.getInt(11);   //Matricula
            
                                    
            String script2 = ("insert into visitas values (?,?,?,?,?)");
            PreparedStatement psta2 = conn.prepareStatement(script2);
            psta2.setInt(1, rs.getInt(11));
            psta2.setString(2, rs.getString(1));
            psta2.setString(3, rs.getString(3));
            psta2.setString(4, timeStamp);
            psta2.setInt(5, 1);
            psta2.execute();
            psta2.close();
            System.out.println(timeStamp);
          */  

        } catch (Exception x) {
            System.out.println("It didnt work");
        }
       
    }

}
