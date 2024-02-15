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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.EmpleadoDAO;
import modelo.pojo.DatosRegistroEmpleado;
import modelo.pojo.Mensaje;

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

    @POST
    @Path("registrarEmpleados")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarEmpleado(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            DatosRegistroEmpleado empleado = gson.fromJson(json, DatosRegistroEmpleado.class);
            
            if(empleado != null){
                return EmpleadoDAO.registrarEmpleado(empleado);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
}
