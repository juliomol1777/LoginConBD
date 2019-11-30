package proyectologinconbd;
public class UsuarioClase {
    private String usuario;
    private String password;
    private String nombre;
    private String direccion;
    private int telefono;
    private String cargo;

    public UsuarioClase(){
    }

    public UsuarioClase(String nombre){
        this.nombre = nombre;
    }
    
    public UsuarioClase(String usuario, String password, String nombre, String direccion, int telefono, String cargo){
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cargo = cargo;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public int getTelefono(){
        return telefono;
    }

    public void setTelefono(int telefono){
        this.telefono = telefono;
    }

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    @Override
    public String toString(){
        return "Usuario= " + usuario + " , Password= " + password + " , Nombre= " + nombre + " , Direccion= " + direccion + " , Telefono= " + telefono + " , Cargo= " + cargo +'\n'+'\n';
    }
}
