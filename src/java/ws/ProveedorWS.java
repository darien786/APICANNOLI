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
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.ProveedorDAO;
import modelo.pojo.Mensaje;
import modelo.pojo.Proveedor;
import utils.Utilidades;

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
    
    @GET
    @Path("obtenerProveedores")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proveedor> obtenerProveedores(){
        List<Proveedor> listaProveedores = null;
        listaProveedores = ProveedorDAO.obtenerProveedores();
        return listaProveedores;
    }
    
    @GET
    @Path("obtenerProveedor/{idProveedor}")
    @Produces(MediaType.APPLICATION_JSON)  
    public Proveedor obtenerProveedor(@PathParam("idProveedor") Integer idProveedor){
        Proveedor proveedor = null;
        proveedor = ProveedorDAO.obtenerProveedor(idProveedor);
        return proveedor;
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
    public Mensaje eliminarProveedor(@FormParam("idProveedor") Integer idProveedor){
        Mensaje mensaje = null;
        mensaje = ProveedorDAO.eliminarProveedor(idProveedor);
        
        return mensaje;
    }
     
}
