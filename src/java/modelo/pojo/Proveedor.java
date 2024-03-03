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
public class Proveedor {
    private Integer idProveedor;
    private String nombreProveedor;
    private String telefono;
    private String compania;
    private Integer estatus;
    

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor, String nombreProveedor, String telefono, String compania, Integer estatus) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefono = telefono;
        this.compania = compania;
        this.estatus = estatus;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }
    
}