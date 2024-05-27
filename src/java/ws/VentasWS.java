/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

    public VentasWS() {

    }

    @GET
    @Path("obtenerVentas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Venta> obtenerVentas() {
        List<Venta> listaVentas = null;
        listaVentas = VentasDAO.obtenerVentas();
        return listaVentas;
    }

    @GET
    @Path("obtenerVentaPorId/{idVenta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Venta obtenerVentaPorId(@PathParam("idVenta") Integer idVenta){
        return VentasDAO.obtenerVentaPorId(idVenta);
    }
    
    @POST
    @Path("registrarVenta")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarVenta(String json) {
        if (json.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        } else {
            Gson gson = new Gson();
            Venta venta = gson.fromJson(json, Venta.class);

            if (venta != null) {
                return VentasDAO.registrarVenta(venta);
            } else {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }

    @POST
    @Path("registrarProductoEnVenta")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarProductoEnVenta(String json) {
        if (json.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        } else {
            Gson gson = new Gson();
            Map<String, Integer> datos = gson.fromJson(json, new TypeToken<Map<String, Integer>>() {
            }.getType());

            if (datos.containsKey("idVenta") && datos.containsKey("idProducto")) {
                int idVenta = datos.get("idVenta");
                int idProducto = datos.get("idProducto");
                return VentasDAO.registrarProductoEnVenta(idVenta, idProducto);
            } else {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }

}
