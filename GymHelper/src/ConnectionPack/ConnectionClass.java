
package ConnectionPack;


import java.sql.*;
import java.io.*;
import javax.swing.*;

public class ConnectionClass {

    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;

    
    static String usrname = "gym";
    static String password = "gym";
    static String url = "jdbc:oracle:thin:@localhost:1521:xe";

    public static Connection Enlace(Connection conn) throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, usrname, password);
            System.out.println("Successful Connection!\n");
        } catch (ClassNotFoundException e) {
            System.out.print("Connection Failed\n");
        }
        return conn;
    }

    public static Statement sta(Statement st) throws SQLException {
        conn = Enlace(conn);
        st = conn.createStatement();
        return st;
    }

    public static ResultSet EnlEst(ResultSet rs) throws SQLException {
        st = sta(st);
        rs = st.executeQuery("select * from countries");
        return rs;
    }

    public static void main(String[] args) throws SQLException {
        Enlace(conn);
    }
    
    
}
