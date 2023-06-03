package crud.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DAOUsuario {

    //Metodo para agregar un nuevo usuario
    public Usuario insertar(String nombre, String aPaterno, String aMaterno, String usuario, String clave) {
        String q = "INSERT INTO usuario(name_user, a_paterno, a_materno, usuario, clave) VALUES('"
                + nombre + "','"
                + aPaterno + "','"
                + aMaterno + "','"
                + usuario + "','"
                + clave + "')";

        if (new DataBase().actualizar(q) > 0) {
            return new Usuario(nombre, aPaterno, aMaterno, usuario, clave);
        }
        return null;
    }

    //Metodo para modificar un usuario
    public int actualizar(int id, String nombre, String aPaterno, String aMaterno, String usuario, String clave) {
        String q = "UPDATE usuario SET name_user='"
                + nombre + "', a_paterno='"
                + aPaterno + "', a_materno='"
                + aMaterno + "', usuario='"
                + usuario + "', clave='"
                + clave + "' WHERE id_user = '"
                + id + "'";

        return new DataBase().actualizar(q);
    }

    //Metodo para obtener un usuario a partir de su id
    public Usuario obtenerRegistro(String id) {
        String q = "SELECT * FROM usuario WHERE id_user ='"
                + id + "'";

        List<Map> registros = new DataBase().ejecutar(q);
        Usuario usuario = null;
        for (Map registro : registros) {
            usuario = new Usuario((int) registro.get("id_user"),
                    (String) registro.get("name_user"), (String) registro.get("a_paterno"),
                    (String) registro.get("a_materno"), (String) registro.get("usuario"),
                    (String) registro.get("clave"));

        }
        return usuario;
    }

    //Metodo para obtener todos los usuarios
    public List obtenerRegistros() {
        String q = "SELECT * FROM usuario";

        List<Map> registros = new DataBase().ejecutar(q);
        List<Usuario> usuarios = new ArrayList();

        for (Map registro : registros) {
            Usuario usuario = new Usuario((int) registro.get("id_user"),
                    (String) registro.get("name_user"), (String) registro.get("a_paterno"),
                    (String) registro.get("a_materno"), (String) registro.get("usuario"),
                    (String) registro.get("clave"));
            usuarios.add(usuario);
        }
        return usuarios;

    }

    //Metodo para eliminar un usuario
    public int eliminar(String id) {
        String q =  "DELETE FROM usuario WHERE id_user='"
                + id + "'";
        return new DataBase().actualizar(q);
    }
}
