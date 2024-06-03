/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.pojo.Mensaje;
import modelo.pojo.Venta;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Usuario
 */
public class VentasDAO {

    public static List<Venta> obtenerVentas() {
        List<Venta> ventas = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                ventas = conexionBD.selectList("ventas.obtenerVentas");
            } catch (Exception e) {
                System.err.println("Error obteniendo las ventas");
            } finally {
                conexionBD.close();
            }
        } else {
            System.err.println("Sin conexión con la base de datos");
        }
        return ventas;
    }

    public static Venta obtenerVentaPorId(Integer idVenta) {
        Venta venta = new Venta();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                venta = conexionBD.selectOne("venta.obtenerVentaPorId", idVenta);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        }

        return venta;
    }

    public static Mensaje registrarVenta(Venta venta) {
        Mensaje mensaje = new Mensaje();
        mensaje.setError(false);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {

                int filasAfectadas = conexionBD.insert("ventas.registrarVenta", venta);
                conexionBD.commit();

                if (filasAfectadas > 0) {
                    mensaje.setError(false);
                    mensaje.setMensaje("Registro éxitoso");
                } else {
                    mensaje.setMensaje("Registro fallido");
                }
            } catch (Exception e) {
                mensaje.setMensaje("Por el momento no se puede realizar la operación, favor de intentarlo mas tarde.");
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        } else {
            mensaje.setMensaje("Por el momento no hay conexion con la base de datos.");
        }
        return mensaje;
    }

    public static Mensaje registrarProductoEnVenta(int idVenta, int idProducto) {
        Mensaje mensaje = new Mensaje();
        mensaje.setError(false);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                Map<String, Object> params = new HashMap<>();
                params.put("idVenta", idVenta);
                params.put("idProducto", idProducto);

                int filasAfectadas = conexionBD.insert("ventas.registrarProductoEnVenta", params);
                conexionBD.commit();

                if (filasAfectadas > 0) {
                    mensaje.setMensaje("Registro éxitoso");
                } else {
                    mensaje.setMensaje("Registro fallido");
                }
            } catch (Exception e) {
                mensaje.setMensaje("Por el momento no se puede realizar la operación, favor de intentarlo mas tarde.");
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        } else {
            mensaje.setMensaje("Por el momento no hay conexión con la base de datos.");
        }
        return mensaje;
    }
}
