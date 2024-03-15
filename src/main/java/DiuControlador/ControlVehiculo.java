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
        String sql = "CALL GuardarVehiculo(?, ?, ?, ?)";
        CallableStatement statement = conectado.prepareCall(sql);
        
        // Establecer los parámetros del procedimiento almacenado
        statement.setString(1, vehiculo.getTipo());
        statement.setString(2, vehiculo.getMarca());
        statement.setString(3, vehiculo.getPlaca());
        statement.setInt(4, vehiculo.getAnio());
        
        // Ejecutar el procedimiento almacenado
        int res = statement.executeUpdate();
        
        // Verificar el resultado de la ejecución
        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Vehículo creado con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Error al crear el vehículo");
        }
        
        // Cerrar el statement
        statement.close();
    } catch (SQLException e) {
        // Manejar las excepciones
        e.printStackTrace();
    }
}

}
