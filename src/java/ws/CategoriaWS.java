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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.CategoriaDAO;
import modelo.pojo.Categoria;
import modelo.pojo.Mensaje;

/**
 * REST Web Service
 *
 * @author cr7_k
 */
@Path("categorias")
public class CategoriaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CategoriaWS
     */
    public CategoriaWS() {
    }
    
    @GET
    @Path("obtenerCategorias")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Categoria> obtenerCategorias(){
       
        return CategoriaDAO.obtenerCategorias();
        
    }
    
    @GET
    @Path("obtenerCategoriaPorId/{idCategoria}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categoria obtenerCategoriaPorId(@PathParam("idCategoria") Integer idCategoria){
        return CategoriaDAO.obtenerCategoriaPorId(idCategoria);
    }

    @POST
    @Path("registrarCategoria")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarCategoria(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Categoria categoria = gson.fromJson(json, Categoria.class);
            
            if(categoria != null){
                return CategoriaDAO.registrarCategoria(categoria);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
    
    @PUT
    @Path("editarCategoria")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje modificarCategoria(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Categoria categoria = gson.fromJson(json, Categoria.class);
            
            if(categoria != null){
                return CategoriaDAO.modificarCategoria(categoria);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    
    }
    
    @DELETE
    @Path("eliminarCategoria")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje eliminarCategoria(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Categoria categoria = gson.fromJson(json, Categoria.class);
            
            if(categoria.getIdCategoria() != null){
                return CategoriaDAO.eliminarCategoria(categoria);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
}
