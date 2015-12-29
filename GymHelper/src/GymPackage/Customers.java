/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GymPackage;

import ConnectionPack.ConnectionClass;
import static GymPackage.MainPage.conn;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


/**
 *
 * @author ozzIE
 * All the customer info will be found here
 */
public class Customers {
    
    public int cust1 =00001;
    public int cust2 =00002;
    public int cust3 =00003;
    public int cust4 =00004;
    public int cust5 =00005;

    public Customers() {
        
     
        
        
    }
    
  public void BorrarCliente()
          
  {
      
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
  
  public void ClienteNuevo()
          
  {
  
      System.out.println("testing out adding new client");
      
      
  
  
  
  }
          
         
  
  
  
  
    
    
    
    
    
}
