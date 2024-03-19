/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiuControlador;

import DIU.Fletes;
import DIU.Vehiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class ControladorFlete {
        private Fletes fletes;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = (Connection) conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public ControladorFlete() {
    }

    public ControladorFlete(Fletes fletes) {
        this.fletes = fletes;
    }

    public Fletes getFletes() {
        return fletes;
    }

    public void setFletes(Fletes fletes) {
        this.fletes = fletes;
    }
    
    public void InsertarFletes (Fletes f){
        try {
            String sql = "CALL InsertarFletes(?, ?, ?, ?)";
        CallableStatement statement = conectado.prepareCall(sql);
        
        // Establecer los parámetros del procedimiento almacenado
        statement.setString(1, f.getLugarRecogida());
        statement.setString(2, f.getDestino());
        statement.setInt(0, f.getTarifa());
        
        // Ejecutar el procedimiento almacenado
        int res = statement.executeUpdate();
        } catch (Exception e) {
            
            
        }
        
    }
    
    
}
