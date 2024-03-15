/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU;

import DIU.Usuario;
import DIU.Usuario;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author DELL
 */
public class Conductor extends Usuario {
  private int idConductor;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String cedula;
    private String correoElectronico;
    private String celular;
    private String tipoLicencia; 

    public Conductor() {
    }

    public Conductor(int idConductor, String nombre, String apellido, LocalDate fechaNacimiento, String cedula, String correoElectronico, String celular, String tipoLicencia) {
        this.idConductor = idConductor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.celular = celular;
        this.tipoLicencia = tipoLicencia;
    }

    

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }



    
    
    public static void mes(JComboBox cbMes) {

        cbMes.addItem("1");
        cbMes.addItem("2");
        cbMes.addItem("3");
        cbMes.addItem("4");
        cbMes.addItem("5");
        cbMes.addItem("6");
        cbMes.addItem("7");
        cbMes.addItem("8");
        cbMes.addItem("9");
        cbMes.addItem("10");
        cbMes.addItem("11");
        cbMes.addItem("12");

    }

    public static void dia(JComboBox cbMes, JComboBox cbDias) {
        cbDias.removeAllItems();
        String mesSeleccionado = cbMes.getSelectedItem().toString();
        if (mesSeleccionado.equals("1") || mesSeleccionado.equals("3") || mesSeleccionado.equals("5")
                || mesSeleccionado.equals("7") || mesSeleccionado.equals("8") || mesSeleccionado.equals("10")
                || mesSeleccionado.equals("12")) {
            cbDias.addItem("1");
            cbDias.addItem("2");
            cbDias.addItem("3");
            cbDias.addItem("4");
            cbDias.addItem("5");
            cbDias.addItem("6");
            cbDias.addItem("7");
            cbDias.addItem("8");
            cbDias.addItem("9");
            cbDias.addItem("10");
            cbDias.addItem("11");
            cbDias.addItem("12");
            cbDias.addItem("13");
            cbDias.addItem("14");
            cbDias.addItem("15");
            cbDias.addItem("16");
            cbDias.addItem("17");
            cbDias.addItem("18");
            cbDias.addItem("19");
            cbDias.addItem("20");
            cbDias.addItem("21");
            cbDias.addItem("22");
            cbDias.addItem("23");
            cbDias.addItem("24");
            cbDias.addItem("25");
            cbDias.addItem("26");
            cbDias.addItem("27");
            cbDias.addItem("28");
            cbDias.addItem("29");
            cbDias.addItem("30");
            cbDias.addItem("31");

        } else if (mesSeleccionado.equals("2")) {
            cbDias.addItem("1");
            cbDias.addItem("2");
            cbDias.addItem("3");
            cbDias.addItem("4");
            cbDias.addItem("5");
            cbDias.addItem("6");
            cbDias.addItem("7");
            cbDias.addItem("8");
            cbDias.addItem("9");
            cbDias.addItem("10");
            cbDias.addItem("11");
            cbDias.addItem("12");
            cbDias.addItem("13");
            cbDias.addItem("14");
            cbDias.addItem("15");
            cbDias.addItem("16");
            cbDias.addItem("17");
            cbDias.addItem("18");
            cbDias.addItem("19");
            cbDias.addItem("20");
            cbDias.addItem("21");
            cbDias.addItem("22");
            cbDias.addItem("23");
            cbDias.addItem("24");
            cbDias.addItem("25");
            cbDias.addItem("26");
            cbDias.addItem("27");
            cbDias.addItem("28");
        } else {
            cbDias.addItem("1");
            cbDias.addItem("2");
            cbDias.addItem("3");
            cbDias.addItem("4");
            cbDias.addItem("5");
            cbDias.addItem("6");
            cbDias.addItem("7");
            cbDias.addItem("8");
            cbDias.addItem("9");
            cbDias.addItem("10");
            cbDias.addItem("11");
            cbDias.addItem("12");
            cbDias.addItem("13");
            cbDias.addItem("14");
            cbDias.addItem("15");
            cbDias.addItem("16");
            cbDias.addItem("17");
            cbDias.addItem("18");
            cbDias.addItem("19");
            cbDias.addItem("20");
            cbDias.addItem("21");
            cbDias.addItem("22");
            cbDias.addItem("23");
            cbDias.addItem("24");
            cbDias.addItem("25");
            cbDias.addItem("26");
            cbDias.addItem("27");
            cbDias.addItem("28");
            cbDias.addItem("29");
            cbDias.addItem("30");
        }
    }

    

    
}
