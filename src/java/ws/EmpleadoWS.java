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
import modelo.EmpleadoDAO;
import modelo.pojo.DatosRegistroEmpleado;
import modelo.pojo.Empleado;
import modelo.pojo.Estatus;
import modelo.pojo.Mensaje;
import modelo.pojo.Persona;
import modelo.pojo.Rol;

/**
 * REST Web Service
 *
 * @author cr7_k
 */
@Path("empleados")
public class EmpleadoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmpleadoWS
     */
    public EmpleadoWS() {
    }

    @GET
    @Path("obtenerEstatus")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Estatus> obtenerEstatus(){
        
        return EmpleadoDAO.obtenerEstatus();
    }
    
    @GET
    @Path("obtenerRoles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rol> obtenerRoles(){
        
        return EmpleadoDAO.obtenerRoles();
    }
    
    @GET
    @Path("obtenerEmpleados")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empleado> obtenerEmpleados(){
        
        return EmpleadoDAO.obtenerEmpleados();
    }
    
    @GET
    @Path("obtenerEmpleadoPorId/{idEmpleado}")
    @Produces(MediaType.APPLICATION_JSON)
    public DatosRegistroEmpleado obtenerInformacionEmpleado(@PathParam("idEmpleado") Integer idEmpleado){
        
        return EmpleadoDAO.obtenerEmpleadoPorId(idEmpleado);
    }
    
    @POST
    @Path("registrarEmpleados")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarEmpleado(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            DatosRegistroEmpleado datosEmpleado = gson.fromJson(json, DatosRegistroEmpleado.class);
            
            Empleado empleado = datosEmpleado.getEmpleado();
            Persona persona = datosEmpleado.getPersona();
            
            
            if(empleado != null && persona != null){
                return EmpleadoDAO.registrarEmpleado(datosEmpleado);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
    
    @PUT
    @Path("modificarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarInformacionEmpleado(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            DatosRegistroEmpleado datosEmpleado = gson.fromJson(json, DatosRegistroEmpleado.class);
            
            if(datosEmpleado.getEmpleado() != null || datosEmpleado.getPersona() != null){
                return EmpleadoDAO.editarInformacionEmpleado(datosEmpleado);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }    
    
    @DELETE
    @Path("eliminarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje eliminarEmpleado(String json){
        if(json.isEmpty() ){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            
            Empleado empleado = gson.fromJson(json, Empleado.class);
            
            return EmpleadoDAO.eliminarEmpleado(empleado);
        }
    }
}
