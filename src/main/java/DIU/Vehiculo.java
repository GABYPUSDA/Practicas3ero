/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU;

/**
 *
 * @author kevin
 */
public class Vehiculo {
    private int idVehiculo;
    private String tipo;
    private String marca;
    private String placa;
    private int anio;
    private Conductor conductor;

    public Vehiculo() {
    }

    public Vehiculo(int idVehiculo, String tipo, String marca, String placa, int anio, Conductor conductor) {
        this.idVehiculo = idVehiculo;
        this.tipo = tipo;
        this.marca = marca;
        this.placa = placa;
        this.anio = anio;
        this.conductor = conductor;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
    
    
}
