/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiuControlador;

import DIU.Conductor;
import java.awt.HeadlessException;
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
public class CtlrConductor {

    private Conductor conductor;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = (Connection) conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public CtlrConductor() {
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public void CrearConductor(Conductor C) {
        try {
            String SQL = "call GuardarConductor('"
                    + C.getNombre() + "', '"
                    + C.getApellido() + "', '"
                    + C.getFechaNacimiento() + "', '"
                    + C.getCedula() + "', '"
                    + C.getCorreoElectronico() + "', '"
                    + C.getCelular() + "', '"
                    + C.getTipoLicencia() + "', '"
                    + C.getContrasena() + "')"; // Corregido el error de concatenación
            ejecutar = (PreparedStatement) conectado.prepareCall(SQL);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Conductor CREADO CON ÉXITO");
            } else {
                JOptionPane.showMessageDialog(null, "REVISAR LA INFORMACIÓN INGRESADA");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
    }

    public Conductor obtenerConductor(int cedula) {
        String sql = "{CALL ObtenerConductor(?)}";
        try (CallableStatement statement = conectado.prepareCall(sql)) {
            statement.setInt(1, cedula);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Conductor conductor = new Conductor();
                    conductor.setNombre(resultSet.getString("NOMBRE"));
                    conductor.setApellido(resultSet.getString("APELLIDO"));
                    conductor.setFechaNacimiento(resultSet.getDate("FECHA_NACIMIENTO").toLocalDate());
                    conductor.setCedula(resultSet.getString("CEDULA"));
                    conductor.setCorreoElectronico(resultSet.getString("CORREOELECTRONICO"));
                    conductor.setCelular(resultSet.getString("CELULAR"));
                    conductor.setTipoLicencia(resultSet.getString("TIPO_LICENCIA"));
                    return conductor;
                } else {
                    JOptionPane.showMessageDialog(null, "Conductor no encontrado");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener el conductor: " + e.getMessage());
        }
        return null;
    }

    public void ActualizarConductor(Conductor C) {
        try {
            String SQL = "call ActualizarConductor('"
                    + C.getNombre() + "',"
                    + "'" + C.getApellido() + "',"
                    + "'" + C.getFechaNacimiento() + "',"
                    + "'" + C.getCedula() + "',"
                    + "'" + C.getCorreoElectronico() + "',"
                    + "'" + C.getTipoLicencia() + "')";
            ejecutar = (PreparedStatement) conectado.prepareCall(SQL);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Conductor CREADA CON ÉXITO");
            } else {
                JOptionPane.showMessageDialog(null, "REVISAR LA INFORMACIÓN INGRESADA");
            }
        } catch (Exception e) {
        }

    }

    public void eliminarConductor(int cedula) {
        String sql = "{CALL EliminarConductor(?)}";
        try (CallableStatement statement = conectado.prepareCall(sql)) {
            statement.setInt(1, cedula);
            int res = statement.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Conductor eliminado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún conductor con la cédula especificada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar el conductor: " + e.getMessage());
        }
    }

}
