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
public class DatosRegistroEmpleado {
    private Persona persona;
    private Empleado empleado;
    private int filasAfectadas;
    private String error;

    public DatosRegistroEmpleado() {
    }

    public DatosRegistroEmpleado(Persona persona, Empleado empleado, int filasAfectadas, String error) {
        this.persona = persona;
        this.empleado = empleado;
        this.filasAfectadas = filasAfectadas;
        this.error = error;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getFilasAfectadas() {
        return filasAfectadas;
    }

    public void setFilasAfectadas(int filasAfectadas) {
        this.filasAfectadas = filasAfectadas;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
       
}
