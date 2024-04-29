/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

/**
 *
 * @author cr7_k
 */
public class Entrega {
    private Integer idEntrega;
    private String fechaEntrega;
    private String descripcion;
    private Integer idEmpleado;
    private Integer idProveedor;
    private String nombreEmpleado;
    private String nombreProveedor;

    public Entrega() {
    }

    public Entrega(Integer idEntrega, String fechaEntrega, String descripcion, Integer idEmpleado, Integer idProveedor) {
        this.idEntrega = idEntrega;
        this.fechaEntrega = fechaEntrega;
        this.descripcion = descripcion;
        this.idEmpleado = idEmpleado;
        this.idProveedor = idProveedor;
    }

    public Integer getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer empleado) {
        this.idEmpleado = empleado;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    
}
