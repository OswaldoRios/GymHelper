/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GymPackage;


import static GymPackage.MainPage.rs;
import static GymPackage.NewCustomer.st;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.Debug.id;
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
                      {JOptionPane.showMessageDialog(null, "Disculpe pero no esta activa su membresia. \n Su ultimo pago fue el "+sdf.format(ultimo_pago)+" y su fecha de vencimiento es "+sdf.format(venci));}
              else if (new java.sql.Date((new Date(System.currentTimeMillis())).getTime()).before(venci)) //ya se vencio
                      {JOptionPane.showMessageDialog(null, "Adelante! Su fecha de vencimiento es: "+sdf.format(venci));}
              }
        }
            catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Perdon pero no existe esa matricula");
        }
        
        
    }
    
 
    
    
    
    
    
}
