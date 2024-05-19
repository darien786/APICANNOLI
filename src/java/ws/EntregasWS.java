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
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.EntregaDAO;
import modelo.pojo.Entrega;
import modelo.pojo.Mensaje;

/**
 * REST Web Service
 *
 * @author cr7_k
 */
@Path("entregas")
public class EntregasWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EntregasWS
     */
    public EntregasWS() {
    }

    @GET
    @Path("obtenerEntregas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Entrega> obtenerEntregas() {

        return EntregaDAO.obtenerEntregas();
    }

    @GET
    @Path("obtenerEntregaPorId/{idEntrega}")
    @Produces(MediaType.APPLICATION_JSON)
    public Entrega obtenerEntregaPorId(@PathParam("idEntrega") Integer idEntrega) {
        return null;
    }

    @POST
    @Path("registrarEntrega")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarEntrega(String json) {
        if (json.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        } else {

            Gson gson = new Gson();
            Entrega entrega = gson.fromJson(json, Entrega.class);

            if (entrega != null) {
                return EntregaDAO.registrarEntrega(entrega);
            } else {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }

    @PUT
    @Path("modificarEntrega")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje modificarEntrega(String json) {
        if (json.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        } else {
            Gson gson = new Gson();
            Entrega entrega = gson.fromJson(json, Entrega.class);

            if (entrega != null) {
                return EntregaDAO.modificarEntrega(entrega);
            } else {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
    
    @DELETE
    @Path("eliminarEntrega")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje eliminarMensaje(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            
            Gson gson = new Gson();
            Entrega entrega = gson.fromJson(json, Entrega.class);
            
            if(entrega != null || entrega.getIdEntrega() > 0){
                return EntregaDAO.eliminarEntrega(entrega);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
}
