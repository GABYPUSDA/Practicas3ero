/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU;



/**
 *
 * @author DELL
 */
public class Conductor extends Usuario {
    private int idConductor;
    private int idUsuario; // Referencia al usuario
    private String tipoLicencia;
    private String telefono;

    public Conductor() {
    }

    public Conductor(int idConductor, int idUsuario, String tipoLicencia, String telefono) {
        this.idConductor = idConductor;
        this.idUsuario = idUsuario;
        this.tipoLicencia = tipoLicencia;
        this.telefono = telefono;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
