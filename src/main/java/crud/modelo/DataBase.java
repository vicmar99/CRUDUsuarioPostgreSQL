package crud.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class DataBase {

    private final String DRIVER = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://localhost:5432/dbcrud";
    private final String USUARIO = "postgres";
    private final String PASSWORD = "123";
    private Connection conexion;

    public DataBase() {
        
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
        }
        
    }

    //Para realizar acciones sobre la bd Modificar, Agregar, Eliminar
    public int actualizar(String consulta) {
        try {
            Statement st = conexion.createStatement();
            return st.executeUpdate(consulta);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return 0;
    }

    //Para recuperar información de la bd
    public List ejecutar(String consulta) {
        ResultSet rs = null;
        List resultado = new ArrayList();
        try {
            Statement st = conexion.createStatement();
            rs = st.executeQuery(consulta);
            resultado = acomodarDatos(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    private List acomodarDatos(ResultSet rs) {
        List renglones = new ArrayList();
        try {
            int cantidadColumnas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Map<String, Object> renglon = new HashMap();
                for (int i = 1; i <= cantidadColumnas; i++) {
                    String nombreCampo = rs.getMetaData().getColumnName(i);
                    Object valor = rs.getObject(nombreCampo);
                    renglon.put(nombreCampo, valor);
                }
                renglones.add(renglon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return renglones;
    }

    //Ejecutar un procedimiento almacenado
    public boolean ejecutarProcedure(String nombre) {
        try {
            CallableStatement cs = conexion.prepareCall("{call " + nombre + "}");
            return cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
