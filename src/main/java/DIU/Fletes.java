/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Fletes {
    private String LugarRecogida;
    private String Destino;
    private Date FechaHora;
    private String Descripcionflete;
    private int tarifa;
    private String estado;

    public Fletes() {
    }

    public Fletes(String LugarRecogida, String Destino, Date FechaHora, String Descripcionflete, int tarifa) {
        this.LugarRecogida = LugarRecogida;
        this.Destino = Destino;
        this.FechaHora = FechaHora;
        this.Descripcionflete = Descripcionflete;
        this.tarifa = tarifa;
        this.estado = estado;
        
    }

    public String getLugarRecogida() {
        return LugarRecogida;
    }

    public void setLugarRecogida(String LugarRecogida) {
        this.LugarRecogida = LugarRecogida;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public Date getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(Date FechaHora) {
        this.FechaHora = FechaHora;
    }

    public String getDescripcionflete() {
        return Descripcionflete;
    }

    public void setDescripcionflete(String Descripcionflete) {
        this.Descripcionflete = Descripcionflete;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
