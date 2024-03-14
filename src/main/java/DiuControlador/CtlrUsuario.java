/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiuControlador;

import DIU.Conductor;
import DIU.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void CrearUsuario(Usuario   U){
        try {
            String SQL = "call GuardarUsuario('" 
                    + U.getNombre() +"',"
                    + "'" + U.getApellido() + "',"
                    + "'" + U.getCedula()+ "',"
                    + "'" + U.getContrasena()+ "',"
                    + "'" + U.getCorreo()+ "')";
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
}
