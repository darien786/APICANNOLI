/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

/**
 *
 * @author Usuario
 */
public class Venta {

    private int idVenta;
    private String fechaVenta;
    private int cantidad;
    private float total;
    private int idFormaPago;

    public Venta() {
    }

    public Venta(int idVenta, String fechaVenta, int cantidad, float total, int idFormaPago) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.cantidad = cantidad;
        this.total = total;
        this.idFormaPago = idFormaPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }
}
