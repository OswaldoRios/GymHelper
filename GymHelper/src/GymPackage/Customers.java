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
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ozzIE All the customer info will be found here
 */
public class Customers {

    public int m;

    public void BorrarCliente() {

        /*   int a;
         a=Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del contacto que quiere borrar"));
         try {
            
         ConnectionPack.ConnectionClass miconexion = new ConnectionPack.ConnectionClass();
         conn = ConnectionClass.Enlace(conn);
         String sqlinsertar = "delete from CLIENTE WHERE id_cliente = ?";
         PreparedStatement psta = conn.prepareStatement(sqlinsertar);
         psta.setInt(1, a);
         psta.execute();
         psta.close();
         JOptionPane.showMessageDialog(null, "Registro Modificado Borrado");
         } catch (Exception e) {
         System.out.println(e.getCause());
         }
      
         */
    }

    public void ClienteNuevo(String a, String b, String c, String d, String e,
            String f, String g, int h, String i, String j) {

       
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("MMM dd yyyy");
        String timeStamp = sd.format(date);
        try {

            ConnectionPack.ConnectionClass miconexion = new ConnectionPack.ConnectionClass();
            conn = ConnectionClass.Enlace(conn);
            st = sta(st);
            rs = st.executeQuery("select max(matricula) from clientes where matricula >0");
            rs.next();
            System.out.println(rs.getInt(1));
            m = rs.getInt(1) + 1;

            String script = "insert into clientes values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement psta = conn.prepareStatement(script);
            psta.setString(1, a);
            psta.setString(2, b);
            psta.setString(3, c);
            psta.setString(4, d);
            psta.setString(5, e);
            psta.setString(6, f);
            psta.setString(7, g);
            psta.setInt(8, h);
            psta.setString(9, i);
            psta.setString(10, j);
            psta.setInt(11, m);
            psta.execute();
            psta.close();

            JOptionPane.showMessageDialog(null, "El cliente fue agregado correctamente!");
            JOptionPane.showMessageDialog(null, "Su matricula es " + m);
            
            st = sta(st);
            rs = st.executeQuery("select * from clientes where matricula =" + m);
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
            

        } catch (Exception x) {
            System.out.println("It didnt work");
        }
       
    }

}
