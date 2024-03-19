/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiuControlador;

import DIU.Conductor;
import DIU.Fletes;
import DIU.Usuario;
import DiuVista.Fletes1;
import DiuVista.FormConductor;
import DiuVista.Login1;
import DiuVista.ModoUser;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.ConsoleHandler;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class CtlrUsuario {

    private Conductor conductor;
    private Usuario usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void CrearUsuario(Usuario U, Conductor C) {
        try {
            // Llamar al procedimiento almacenado
            CallableStatement stmt = conectado.prepareCall("{call crear_usuario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            // Configurar los parámetros de entrada para Usuario
            stmt.setString(1, U.getNombre());
            stmt.setString(2, U.getApellido());
            stmt.setDate(3, new java.sql.Date(U.getFechaNacimiento().getTime()));
            stmt.setString(4, U.getCedula());
            stmt.setString(5, U.getCorreo());
            stmt.setString(6, U.getContrasenia());
            stmt.setString(7, U.getRol().toString()); // Enum 'conductor' o 'pasajero'

            // Establecer parámetros adicionales si el rol es conductor
            if (U.getRol().equals("conductor")) {
                stmt.setString(8, C.getTipoLicencia());
                stmt.setString(9, C.getTelefono());
            } else {
                stmt.setNull(8, Types.VARCHAR);
                stmt.setNull(9, Types.VARCHAR);
            }

            // Configurar el parámetro de salida
            stmt.registerOutParameter(10, Types.INTEGER);

            // Ejecutar el procedimiento almacenado
            stmt.execute();

            // Obtener el valor del parámetro de salida
            int usuario_id = stmt.getInt(10);
            System.out.println("Se creó el usuario con ID: " + usuario_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void iniciarSesion(Usuario us) {
        try {
            String SQL = "SELECT ROL FROM usuario WHERE Correo = ? AND Contrasenia = ?";
            PreparedStatement statement = conectado.prepareStatement(SQL);
            statement.setString(1, us.getCorreo());
            statement.setString(2, us.getContrasenia());

            ResultSet res = statement.executeQuery();

            if (res.next()) {
                String rol = res.getString("ROL");

                // Cerrar recursos
                res.close();
                statement.close();

                // Redirigir según el rol
                if (rol.equals("conductor")) {
                    Fletes1 f1 = new Fletes1();
                    f1.setVisible(true);
                } else {
                    ModoUser mu = new ModoUser();
                    mu.setVisible(true);
                }

                // Cerrar la ventana de inicio de sesión
                Login1 l = new Login1();
                l.dispose();
            } else {
                // Cerrar recursos
                res.close();
                statement.close();

                // Mostrar mensaje de error de inicio de sesión
                JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos.");
            }
        } catch (SQLException e) {
            // Manejar errores de SQL
            e.printStackTrace();
        } finally {
            // Cerrar la conexión (si es apropiado hacerlo aquí)
            try {
                if (conectado != null) {
                    conectado.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /* public boolean IniciarSesionUsuario(Usuario d) {
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
    
     */
}
