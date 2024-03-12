
package modelo.pojo;

import java.util.Date;

/**
 *
 * @author lizet
 */
public class Pedido {
    
     private Integer numeroPedido;
    private Date fecha;
    private Integer cliente;
    private String formaPago;
    private String descripcion;
    private String fotografia;

    public Pedido() {
    }

    public Pedido(Integer numeroPedido, Date fecha, Integer cliente, String formaPago, String descripcion, String fotografia) {
        this.numeroPedido = numeroPedido;
        this.fecha = fecha;
        this.cliente = cliente;
        this.formaPago = formaPago;
        this.descripcion = descripcion;
        this.fotografia = fotografia;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
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
    
    
    
}
