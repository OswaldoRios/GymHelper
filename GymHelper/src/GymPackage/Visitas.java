/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GymPackage;


import ConnectionPack.ConnectionClass;
import static ConnectionPack.ConnectionClass.sta;
import static GymPackage.MainPage.conn;
import static GymPackage.MainPage.rs;
import static GymPackage.NewCustomer.st;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import oracle.net.aso.d;
import oracle.net.aso.e;
import oracle.security.o5logon.b;
/**
 *
 * @author ozzIE
 */
public class Visitas {
    
    Date date = new Date();
    SimpleDateFormat sd = new SimpleDateFormat();
    
    public void visitas(int a) {
     //  String TimeStamp= date.toString();
        try {
            ConnectionPack.ConnectionClass miconexion = new ConnectionPack.ConnectionClass();
            conn = ConnectionClass.Enlace(conn);
            st = sta(st);
           // rs = st.executeQuery("select * from visitas where matricula = "+a);
            rs = st.executeQuery("select visitas from visitas where matricula = "+a);
            rs.next();
            rs.getInt(1);
            //System.out.println(rs.getInt(1));
            int mod =rs.getInt(1)+1;
            String script = ("UPDATE visitas SET visitas= "+mod +"WHERE matricula = "+a);
            PreparedStatement psta = conn.prepareStatement(script);
            psta.execute();
            psta.close();   
           
          
            

        } catch (Exception x) {
            System.out.println("It didnt work");
        }
        
        
    }
    
 
    
    
    
    
    
}
