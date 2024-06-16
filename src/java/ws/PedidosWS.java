/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.PedidoDAO;
import modelo.pojo.Estado;
import modelo.pojo.Mensaje;
import modelo.pojo.Pedido;

/**
 * REST Web Service
 *
 * @author cr7_k
 */
@Path("pedidos")
public class PedidosWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PedidosWS
     */
    public PedidosWS() {
    }

    @GET
    @Path("obtenerPedidos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Pedido> obtenerPedidos(){
        
        return PedidoDAO.obtenerPedidos();
    }
    
    
    @GET
    @Path("obtenerEstados")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Estado> obtenerEstados(){
        
        return PedidoDAO.obtenerEstados();
    }
    
    @GET
    @Path("obtenerPedidoPorId/{idPedido}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Pedido obtenerPedidoPorId(@PathParam("idPedido") Integer idPedido){
        
        return null;
    }
    
    @POST
    @Path("registrarPedido")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarPedido(String json){
       
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            
            Gson gson =  new Gson();
            Pedido pedido = gson.fromJson(json, Pedido.class);
            
            if(pedido != null){
                return PedidoDAO.registrarPedido(pedido);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
        
    }
    
}
