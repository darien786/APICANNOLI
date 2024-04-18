/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.pojo.Mensaje;
import modelo.pojo.Proveedor;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cr7_k
 */
public class ProveedorDAO {

    public static List<Proveedor> obtenerProveedores() {
        List<Proveedor> proveedores = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                proveedores = conexionBD.selectList("proveedor.obtenerProveedores");
            } catch (Exception e) {
                System.err.println("Error obteniendo los proveedores");
            } finally {
                conexionBD.close();
            }
        } else {
            System.err.println("Sin conexion con la base de datos");
        }
        return proveedores;
    }
    
     public static Proveedor obtenerProveedor(Integer idProveedor) {
        Proveedor proveedor = new Proveedor();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                proveedor = conexionBD.selectOne("proveedor.obtenerProveedor", idProveedor);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        } else {
            System.err.println("Sin conexion con la base de datos");
        }
        return proveedor;
    }

    public static Mensaje registrarProveedor(Proveedor proveedor) {
        Mensaje mensaje = new Mensaje();
        mensaje.setError(false);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {

                int filasAfectadas = conexionBD.insert("proveedor.registrarProveedor", proveedor);
                conexionBD.commit();

                if (filasAfectadas > 0) {
                    mensaje.setError(false);
                    mensaje.setMensaje("Registro éxitoso");
                } else {
                    mensaje.setMensaje("Registro fallido");
                }
            } catch (Exception e) {
                mensaje.setMensaje("Por el momento no se puede realizar la operacion, favor de intentarlo mas tarde.");
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        } else {
            mensaje.setMensaje("Por el momento no hay conexion con la base de datos.");
        }
        return mensaje;
    }

    public static Mensaje modificarProveedor(Proveedor proveedor) {
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {

                int filasAfectadas = conexionBD.update("proveedor.editarProveedor", proveedor);
                conexionBD.commit();

                if (filasAfectadas > 0) {
                    mensaje.setError(false);
                    mensaje.setMensaje("Modificación exitósa");
                } else {
                    mensaje.setMensaje("Modificación fallida");
                }

            } catch (Exception e) {
                e.printStackTrace();
                mensaje.setMensaje("Por el momento no se puede realizar esta operación.");
            } finally {
                conexionBD.close();
            }
        } else {
            mensaje.setMensaje("Por el momento no hay conexión con la base de datos.");
        }
        return mensaje;
    }

    public static Mensaje eliminarProveedor(Integer idProveedor) {
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = mybatis.MyBatisUtil.getSession();

        if (conexionBD != null) {
            try {
                int numFilasAfectadas = conexionBD.delete("proveedor.eliminarProveedor", idProveedor);
                if (numFilasAfectadas > 0) {
                    conexionBD.commit();
                    respuesta.setError(false);
                    respuesta.setMensaje("Eliminación exitósa");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("Eliminación faliida.");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje("Por el momento no se puede realizar la operación.");
            } finally {
                conexionBD.close();
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento no hay conexión con la base de datos.");
        }

        return respuesta;
    }
}
