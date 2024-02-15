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
public class Empleado {
    private Integer idEmpleado;
    private Integer persona;
    private String curp;
    private String username;
    private String correo;
    private String contrasenia;
    private Integer rol;
    private Integer estatus;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado, Integer persona, String curp, String username, String correo, String contrasenia, Integer rol, Integer estatus) {
        this.idEmpleado = idEmpleado;
        this.persona = persona;
        this.curp = curp;
        this.username = username;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.estatus = estatus;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getPersona() {
        return persona;
    }

    public void setPersona(Integer persona) {
        this.persona = persona;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

}
