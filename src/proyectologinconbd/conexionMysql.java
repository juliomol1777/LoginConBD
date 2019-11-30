package proyectologinconbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexionMysql {    
    public static Connection conexion(){
        Connection conectar=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost/login";
            conectar = DriverManager.getConnection(url,"root","");
        } catch (ClassNotFoundException | SQLException e) {  
            JOptionPane.showMessageDialog(null, "Error de conexion" + e.getMessage());
        }
        return conectar;  
    }    
}
