/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiuControlador;

import DIU.Conductor;
import DIU.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class CtlrUsuario {
    private Conductor conductor;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = (Connection) conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public CtlrUsuario() {
    }

    public CtlrUsuario(Conductor conductor) {
        this.conductor = conductor;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public void CrearUsuario(Usuario U){
        try {
            String SQL = "call GuardarUsuario('" 
                    + U.getNombre() +"',"
                    + "'" + U.getApellido() + "',"
                    + "'" + U.getCorreo()+ "',"
                    + "'" + U.getContrasena()+ "',"
                    + "'" + U.getCedula()+ "')";
            ejecutar = (PreparedStatement) conectado.prepareCall(SQL);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Usuario CREADO CON ÉXITO");
            } else {
                JOptionPane.showMessageDialog(null, "REVISAR LA INFORMACIÓN INGRESADA");
            }
        } catch (Exception e) {
        }

    }
    public boolean IniciarSesionUsuario(Usuario d) {
        boolean usuarioEncontrado = false;
        try {
            String SQL = "CALL IniciarSesionUsuario(?, ?, ?)";
            CallableStatement statement = conectado.prepareCall(SQL);
            statement.setString(1, d.getCorreo());
            statement.setString(2, d.getContrasena());
            statement.registerOutParameter(3, java.sql.Types.BOOLEAN);
            statement.execute();

            usuarioEncontrado = statement.getBoolean(3);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());
        } finally {
            try {
                if (conectado != null) {
                    conectado.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
        return usuarioEncontrado;
    }
    
    public boolean verificarTipoUsuario(String correo, String contrasena) {
        boolean esConductor = false;
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL VerificarTipoUsuario(?, ?, ?)}";
            CallableStatement statement = conectado.prepareCall(sql);
            statement.setString(1, correo);
            statement.setString(2, contrasena);
            statement.registerOutParameter(3, java.sql.Types.BOOLEAN);
            statement.execute();

            // Obtener el resultado
            esConductor = statement.getBoolean(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return esConductor;
    }
    
    
}
