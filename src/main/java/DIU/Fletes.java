/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU;

import java.sql.Date;
import javax.swing.JComboBox;

/**
 *
 * @author DELL
 */
public class Fletes {
    private int id;
    private String LugarRecogida;
    private String Destino;
    private Date FechaHora;
    private String Descripcionflete;
    private int tarifa;
    private String estado;

    public Fletes() {
    }

    public Fletes(int id, String LugarRecogida, String Destino, Date FechaHora, String Descripcionflete, int tarifa, String estado) {
        this.id =id;
        this.LugarRecogida = LugarRecogida;
        this.Destino = Destino;
        this.FechaHora = FechaHora;
        this.Descripcionflete = Descripcionflete;
        this.tarifa = tarifa;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
