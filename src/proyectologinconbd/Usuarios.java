package proyectologinconbd;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuarios {
    private static UsuarioClase usu;
    static Connection con= conexionMysql.conexion();
    private static PreparedStatement pst;
    private static ResultSet rs;
    private static String sql;

    public static void agregarUsuarios(UsuarioClase usu) {
        sql = "insert into datoslogin(Usuario, password, nombre, direccion, telefono, cargo) values (?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, usu.getUsuario());
            pst.setString(2, usu.getPassword());
            pst.setString(3, usu.getNombre());
            pst.setString(4, usu.getDireccion());
            pst.setInt(5, usu.getTelefono());
            pst.setString(6, usu.getCargo());        
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            }
            else{
                JOptionPane.showMessageDialog(null, "Error de registro");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de registro" + e.getMessage());
        }
    }
    public static void eliminarUsuarios(UsuarioClase usu) {
        sql = "delete from datoslogin where nombre=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, usu.getNombre());   
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Registro eliminado con exito");
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e.getMessage());
        }
    }
    public static void actualizarUsuarios(UsuarioClase usu) {
        sql="update datoslogin set " +
                    "Usuario=?," +
                    "password=?," +
                    "direccion=?," +
                    "telefono=?," +
                    "cargo=? " +
                    "where nombre=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(6, usu.getNombre());
            pst.setString(1, usu.getUsuario());
            pst.setString(2, usu.getPassword());           
            pst.setString(3, usu.getDireccion());
            pst.setInt(4, usu.getTelefono());
            pst.setString(5, usu.getCargo());        
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Registro actualizado con exito");
            }
            else{
                JOptionPane.showMessageDialog(null, "Error de actualizacion");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de actualizacion" + e.getMessage());
        }
    }
    public static boolean existeUsuario(UsuarioClase usu){
        sql = "select * from datoslogin where nombre=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, usu.getNombre());
            rs=pst.executeQuery();
            if(rs.next()){
                return true;
            }
            else{
                return false;
            } 
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error de consulta" + e.getMessage());
        }
        return false;
    } 
    public static List<UsuarioClase> listarUsuarios(){
        sql = "select * from datoslogin";
        List lista= new ArrayList<>();
        try {
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                usu= new UsuarioClase();
                usu.setUsuario(rs.getString("Usuario"));
                usu.setPassword(rs.getString("password"));
                usu.setNombre(rs.getString("nombre"));
                usu.setDireccion(rs.getString("direccion"));
                usu.setTelefono(rs.getInt("telefono"));
                usu.setCargo(rs.getString("cargo"));
                lista.add(usu);
            }
            return lista;     
        } catch (HeadlessException | SQLException e) {
            return null;
        }
    } 
    public static DefaultTableModel listarTabla(DefaultTableModel tablaModelo){
        sql = "select * from datoslogin";
        String[] lista= new String[6];
        try {
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                lista[0]=rs.getString("Usuario");
                lista[1]=rs.getString("password");
                lista[2]=rs.getString("nombre");
                lista[3]=rs.getString("direccion");
                lista[4]= String.valueOf(rs.getInt("telefono"));
                lista[5]=rs.getString("cargo");
                tablaModelo.addRow(lista);
               }
            return tablaModelo;     
        } catch (HeadlessException | SQLException e) {
            return null;
        }
    } 
    public static DefaultTableModel filtrarTabla(DefaultTableModel tablaModelo, String valor){
        sql = "select * from datoslogin where nombre like'%"+valor+"%'";
        String[] lista= new String[6];
        try {
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                lista[0]=rs.getString("Usuario");
                lista[1]=rs.getString("password");
                lista[2]=rs.getString("nombre");
                lista[3]=rs.getString("direccion");
                lista[4]= String.valueOf(rs.getInt("telefono"));
                lista[5]=rs.getString("cargo");
                tablaModelo.addRow(lista);
               }
            return tablaModelo;     
        } catch (HeadlessException | SQLException e) {
            return null;
        }
    }   
}
