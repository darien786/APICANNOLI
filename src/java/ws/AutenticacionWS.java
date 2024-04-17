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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.AutenticacionDAO;
import modelo.pojo.Empleado;
import modelo.pojo.Mensaje;
import modelo.pojo.MensajeAutenticacion;

/**
 * REST Web Service
 *
 * @author cr7_k
 */
@Path("autenticacion")
public class AutenticacionWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AutenticacionWS
     */
    public AutenticacionWS() {
    }

    
    @POST
    @Path("inicioSesionEscritorio")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MensajeAutenticacion inicioSesionEscritorio(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Empleado empleado = gson.fromJson(json, Empleado.class);
            
            if(empleado != null ){
                return AutenticacionDAO.inicioSesionEscritorio(empleado);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
    
    @GET
    @Path("cerrarSesionEscritorio/{idEmpleado}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje cerrarSesion(@PathParam("idEmpleado") Integer idEmpleado){
        if(idEmpleado < 0){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            return AutenticacionDAO.cerrarSesion(idEmpleado);
        }
    }
}
