/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GymPackage;


import ConnectionPack.ConnectionClass;
import static GymPackage.MainPage.conn;
import static GymPackage.MainPage.rs;
import static GymPackage.NewCustomer.st;
import java.awt.Color;
import static java.awt.Color.RED;
import static java.awt.Color.red;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import static jdk.nashorn.internal.objects.NativeJava.type;
/**
 *
 * @author ozzIE
 */
public class Visitas {
    
    public String idV;
    public Date venci;
    
   
    public void visitas() {
     //  String TimeStamp= date.toString();
             
       try {
               
              ConnectionPack.ConnectionClass miconexion = new ConnectionPack.ConnectionClass();
            conn = ConnectionClass.Enlace(conn);
            
              idV = JOptionPane.showInputDialog("Ingrese la marticula a verificar");
              rs = st.executeQuery("select max(FECHA_PAGO) from Pagos where ID_Cliente ="+idV);
              rs.next();
              Date ultimo_pago = rs.getDate(1);
              System.out.println(ultimo_pago);
              if(ultimo_pago==null)
              { JOptionPane.showMessageDialog(null, "Disculpe pero nunca se a realizado un pago en esta cuenta");  }
              else
              {
                  SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
              rs = st.executeQuery("select vencimiento from membresias where ID_Cliente ="+idV);
              rs.next();
              venci= rs.getDate(1);
              System.out.println("La fecha de vencimiento es"+sdf.format(venci));
              if (new java.sql.Date((new Date(System.currentTimeMillis())).getTime()).after(venci)) //ya se vencio
                      {
                       JOptionPane.showMessageDialog(null,"                          Disculpe pero no esta activa su membresia. \n Su ultimo pago fue el "+sdf.format(ultimo_pago)+" y su fecha de vencimiento es "+sdf.format(venci));
                       String script2 = ("UPDATE membresias SET activa = 0 WHERE ID_Cliente ="+idV);
                       //System.out.println("Still recognizing"+idV);
                       PreparedStatement psta = conn.prepareStatement(script2);
                       psta.execute();
                       psta.close();
                      }
              else if (new java.sql.Date((new Date(System.currentTimeMillis())).getTime()).before(venci)) //Activo
                      {
                       
                  
                  
                      JOptionPane.showMessageDialog(null, "Adelante! Su fecha de vencimiento es: "+sdf.format(venci));
                      String script3 = "UPDATE membresias SET activa = 1 WHERE ID_Cliente ="+idV;
                      PreparedStatement psta = conn.prepareStatement(script3);
                      psta.execute();
                      psta.close(); 
                      }
              }
        }
            catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Perdon pero no existe esa matricula");
        }
        
        
    }
    
 
    
    
    
    
    
}
