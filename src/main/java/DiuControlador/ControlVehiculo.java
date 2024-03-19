/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiuControlador;

import DIU.Conductor;
import DIU.Vehiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class ControlVehiculo {

    private Vehiculo vehiculo;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = (Connection) conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public ControlVehiculo() {
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void CrearVehiculo(Vehiculo vehiculo) {
        try {
            // Preparar la llamada al procedimiento almacenado
            String sql = "CALL agregar_vehiculo(?, ?, ?, ?, ?)";
            CallableStatement statement = conectado.prepareCall(sql);

            // Establecer los parámetros del procedimiento almacenado
            statement.setString(1, vehiculo.getTipo());
            statement.setString(2, vehiculo.getMarca());
            statement.setString(3, vehiculo.getPlaca());
            statement.setInt(4, vehiculo.getAnio());

            // Registrar el parámetro de salida para la ID del vehículo
            statement.registerOutParameter(5, Types.INTEGER);

            // Ejecutar el procedimiento almacenado
            statement.execute();

            // Obtener el valor del parámetro de salida (ID del vehículo)
            int vehiculo_id = statement.getInt(5);
            System.out.println("Se creó el vehículo con ID: " + vehiculo_id);

            // Cerrar el statement
            statement.close();

            // Si llegamos aquí, podemos asumir que el vehículo se creó correctamente
            JOptionPane.showMessageDialog(null, "Vehículo creado con éxito con ID: " + vehiculo_id);
        } catch (SQLException e) {
            // Manejar las excepciones
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear el vehículo: " + e.getMessage());
        }
    }

}
