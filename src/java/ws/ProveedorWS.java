/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.ProveedorDAO;
import modelo.pojo.Mensaje;
import modelo.pojo.Proveedor;

/**
 * REST Web Service
 *
 * @author cr7_k
 */
@Path("proveedores")
public class ProveedorWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProveedorWS
     */
    public ProveedorWS() {
    }

    @POST
    @Path("registrarProveedor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarProveedor(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Proveedor proveedor = gson.fromJson(json, Proveedor.class);
            
            if(proveedor != null){
                return ProveedorDAO.registrarProveedor(proveedor);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
    
    @PUT
    @Path("modificarProveedor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarProveedor(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Proveedor proveedor = gson.fromJson(json, Proveedor.class);
            
            if(proveedor != null){
                return ProveedorDAO.modificarProveedor(proveedor);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
    
    @DELETE
    @Path("eliminarProveedor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje eliminarProveedor(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Proveedor proveedor = gson.fromJson(json, Proveedor.class);
            
            if(proveedor != null){
                return ProveedorDAO.eliminarProveedor(proveedor);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
}
