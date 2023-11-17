package test;

import datos.Conexion;
import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        
        Connection conexion = null;
        
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            UsuarioDAO usuarioDao = new UsuarioDAO();
            
        //Insertando un nuevo objeto de tipo usuario
//        Usuario nuevoUsuario = new Usuario("Berrys", "bbpichon");
//        int usuariosNuevos = usuarioDao.insertar(nuevoUsuario);
        
        //Actualizar registro de usuario existente
//        Usuario usuarioModificado = new Usuario(4,"BBerrys", "superbbpichon");
//        int usuariosModificados = usuarioDao.actualizar(usuarioModificado);

        //Eliminar usuarios
        Usuario usuarioEliminado = new Usuario(4);
        int usuariosEliminados = usuarioDao.eliminar(usuarioEliminado);
        
        //Listar registro en pantalla de usuarios
        List<Usuario> usuarios = usuarioDao.seleccionar();
        
        usuarios.forEach(usuario -> {
            System.out.println("Usuario: " + usuario);
        });
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
            }
        }
        
        
    }
}
