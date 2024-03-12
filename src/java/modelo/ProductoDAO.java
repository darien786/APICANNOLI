/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.pojo.Mensaje;
import modelo.pojo.Producto;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cr7_k
 */
public class ProductoDAO {

    public static Producto obtenerProductoPorId(Integer idProducto){
        Producto producto = new Producto();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
            
                producto = conexionBD.selectOne("producto.obtenerProductoPorId", idProducto);
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }
        
        return producto;
    }
    
    public static List<Producto> obtenerProductos(){
        List<Producto> listaProductos = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                listaProductos = conexionBD.selectList("producto.obtenerListaProductos");
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }
           
        return listaProductos;
    }
    
    public static Mensaje registrarProducto(Producto producto){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                int filasAfectadas = conexionBD.insert("producto.registrarProducto", producto);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Registro éxitoso");
                }else{
                    mensaje.setMensaje("Registro fallido");
                }
                
            }catch(Exception e){
                mensaje.setMensaje("Por el momento no se puede realizar la operación, favor de intentarlo mas tarde");
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde");
        }
        
        return mensaje;
    }
    
    
    public static Mensaje modificarProducto(Producto producto){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                int filasAfectadas = conexionBD.update("producto.editarProducto", mensaje);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Modificación exitosa");
                }else{
                    mensaje.setMensaje("Modificación fallida");
                }
                
            }catch(Exception e){
                e.printStackTrace();
                mensaje.setMensaje("Por el momento no se puede realizar esta operación, favor de intentarlo mas tarde");
            }finally{
                conexionBD.close();
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde");
        }
        
        return mensaje;
    }
    
    public static Mensaje eliminarProducto(Producto producto){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
            
                int filasAfectadas = conexionBD.delete("producto.eliminarEmpleado");
                conexionBD.close();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Eliminación exitosa");
                }else{
                    mensaje.setMensaje("Eliminación fallida");
                }
                
            }catch(Exception e){
                mensaje.setMensaje("Por el momento no se puede realizar esta operación, favor de intentarlo mas tarde.");
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexión con lña base de datos, favor de intentarlo mas tarde.");
        }
        
        return mensaje;
        
    }
}
