/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiuControlador;

import DIU.Conductor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    
    public void CrearConductor(Conductor   C){
        try {
            String SQL = "call GuardarConductor('" 
                    + C.getNombre() +"',"
                    + "'" + C.getApellido() + "',"
                    + "'" + C.getFechaNacimiento() + "',"
                    + "'" + C.getCedula()+ "',"
                    + "'" + C.getCorreoElectronico() + "',"
                    + "'" + C.getTipoLicencia()+"')";
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
    
    
}
