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
public class Categoria {
    private Integer idCategoria;
    private String nombreCategoria;
    private String fotografia;
    private Integer estatus;
    private String nombreEstatus;
    
    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nombreCategoria, String fotografia, Integer estatus, String nombreEstatus) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.fotografia = fotografia;
        this.estatus = estatus;
        this.nombreEstatus = nombreEstatus;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String descripcion) {
        this.fotografia = fotografia;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }    
  
    public String getNombreEstatus() {
        return nombreEstatus;
    }

    public void setNombreEstatus(String nombreEstatus) {
        this.nombreEstatus = nombreEstatus;
    }
    
}
