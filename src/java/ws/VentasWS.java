/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import modelo.VentasDAO;
import modelo.pojo.Mensaje;
import modelo.pojo.Venta;

/**
 *
 * @author Usuario
 */
@Path("ventas")
public class VentasWS {
    @Context
    private UriInfo context;
    
    public VentasWS(){
        
    }
    
    @GET
    @Path("obtenerVentas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Venta> obtenerVentas(){
        List<Venta> listaVentas = null;
        listaVentas = VentasDAO.obtenerVentas();
        return listaVentas;
    }
    
    @POST
    @Path("registrarVenta")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarVenta(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Venta venta = gson.fromJson(json, Venta.class);
            
            if(venta != null){
                return VentasDAO.registrarVenta(venta);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
}
