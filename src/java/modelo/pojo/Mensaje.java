
package modelo.pojo;

/**
 *
 * @author cr7_k
 */
public class Mensaje {
    private Boolean error;
    private String mensaje;

    public Mensaje() {
    }

    public Mensaje(Boolean error, String mensaje) {
        this.error = error;
        this.mensaje = mensaje;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
