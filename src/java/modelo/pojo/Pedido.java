
package modelo.pojo;

import java.util.Date;

/**
 *
 * @author lizet
 */
public class Pedido {
    
    private Integer idPedido;
    private String fechaPedido;
    private String fechaEntrega;
    private String nombreCliente;
    private String telefono;
    private Integer cantidad;
    private Float abono;
    private Float total;
    private String descripcion;
    private String fotografia;
    private Integer id_formaPago;
    private Integer id_estado;

    public Pedido() {
    }

    public Pedido(Integer idPedido, String fechaPedido, String fechaEntrega, String nombreCliente, String telefono, Integer cantidad, Float abono, Float total, String descripcion, String fotografia, Integer id_formaPago, Integer id_estado) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.cantidad = cantidad;
        this.abono = abono;
        this.total = total;
        this.descripcion = descripcion;
        this.fotografia = fotografia;
        this.id_formaPago = id_formaPago;
        this.id_estado = id_estado;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getAbono() {
        return abono;
    }

    public void setAbono(Float abono) {
        this.abono = abono;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public Integer getId_formaPago() {
        return id_formaPago;
    }

    public void setId_formaPago(Integer id_formaPago) {
        this.id_formaPago = id_formaPago;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

}