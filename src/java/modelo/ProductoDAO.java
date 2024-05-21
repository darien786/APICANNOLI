
package modelo;

import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import modelo.pojo.Mensaje;
import modelo.pojo.Producto;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import utils.Utilidades;

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
    
    public static List<Producto> obtenerProductoPorCategoria(Integer idCategoria){
        List<Producto> listaProductos = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if( conexionBD != null){
            try{
                
                listaProductos = conexionBD.selectList("producto.obtenerProductosPorCategoria", idCategoria);
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }
        
        return listaProductos;
    }
    
    public static List<Producto> obtenerProductos(){
        List<Producto> listaProductos = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                listaProductos = conexionBD.selectList("producto.obtenerProductos");
                
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
                mensaje.setMensaje("Por el momento no se puede realizar la operación.");
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexión con la base de datos.");
        }
        
        return mensaje;
    }
    
    
    public static Mensaje modificarProducto(Producto producto){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                int filasAfectadas = conexionBD.update("producto.editarProducto", producto);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Modificación exitosa");
                }else{
                    mensaje.setMensaje("Modificación fallida");
                }
                
            }catch(Exception e){
                e.printStackTrace();
                mensaje.setMensaje("Por el momento no se puede realizar esta operación.");
            }finally{
                conexionBD.close();
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexión con la base de datos.");
        }
        
        return mensaje;
    }
    
    public static Mensaje eliminarProducto(Producto producto){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
            
                int filasAfectadas = conexionBD.delete("producto.eliminarProducto", producto);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Eliminación exitósa");
                }else{
                    mensaje.setMensaje("Eliminación fallida");
                }
                
            }catch(Exception e){
                mensaje.setMensaje("Por el momento no se puede realizar esta operación.");
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexión con la base de datos.");
        }
        
        return mensaje;
        
    }
}
