package crud.modelo;


public class Usuario {
   
    private int id;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String usuario;
    private String clave;

    public Usuario() {
    }

    public Usuario(String nombre, String aPaterno, String aMaterno, String usuario, String clave) {
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Usuario(int id, String nombre, String aPaterno, String aMaterno, String usuario, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.usuario = usuario;
        this.clave = clave;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
            
    
}
