
package modelo.pojo;

/**
 *
 * @author lizet
 */
public class DatosRegistroPedido {
    
    private Persona cliente;
    private Pedido pedido;
    private Integer filasAfectadas;
    private String error;

    public DatosRegistroPedido() {
    }

    public DatosRegistroPedido(Persona cliente, Pedido pedido, Integer filasAfectadas, String error) {
        this.cliente = cliente;
        this.pedido = pedido;
        this.filasAfectadas = filasAfectadas;
        this.error = error;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getFilasAfectadas() {
        return filasAfectadas;
    }

    public void setFilasAfectadas(Integer filasAfectadas) {
        this.filasAfectadas = filasAfectadas;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
    
}
