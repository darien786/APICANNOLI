/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.pojo.Categoria;
import modelo.pojo.Mensaje;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cr7_k
 */
public class CategoriaDAO {
    
    public static List<Categoria> obtenerCategorias(){
        List<Categoria> listaCategorias = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                listaCategorias = conexionBD.selectList("categoria.obtenerCategorias");
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }
        
        return listaCategorias;
    }
    
    public static Mensaje registrarCategoria(Categoria categoria){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
              
                int filasAfectadas = conexionBD.insert("categoria.registrarCategoria", categoria);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Registro éxitoso");
                }else{
                    mensaje.setMensaje("Registro fallido");
                }
            }catch(Exception e){
                mensaje.setMensaje("Por el momento no se puede relaizar esta operacion, favor de intentarlo mas tarde.");
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde.");
        }
        
        return mensaje;
    }
    
    
    public static Mensaje modificarCategoria(Categoria categoria){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                int filasAfectadas = conexionBD.update("categoria.editarCategoria", categoria);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Modificacion exitosa");
                }else{
                    mensaje.setMensaje("Modificacion fallida");
                }
            }catch(Exception e){
                e.printStackTrace();
                mensaje.setMensaje("Por el momento no se puede realizar esta operacion, favor de intentarlo mas tarde.");
            }finally{
                conexionBD.close();
            }
        
        }else{
            mensaje.setMensaje("Por el momento no hay conexión con la base de datos.");
        }
        
        return mensaje;
    }
    
    public static Mensaje eliminarCategoria(Categoria categoria){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                int productosCategoria = conexionBD.selectOne("categoria.productosCategoria", categoria);
                
                if(productosCategoria <= 0){
                    int filasAfectadas = conexionBD.delete("categoria.eliminarCategoria", categoria);
                    conexionBD.commit();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Eliminación exitósa");
                }else{
                    mensaje.setMensaje("Eliminación fallida");
                }
                }else{
                    mensaje.setMensaje("No se puede eliminar esta categoria, tiene productos asocidos");
                }
                  
            }catch(Exception e){
                e.printStackTrace();
                mensaje.setMensaje("Por el momento no se puede realizar esta operacion, favor de intentarlo mas tarde.");
            }finally{
                conexionBD.close();
            }
            
        }else{
            mensaje.setMensaje("Por el momento no hay conexión con la base de datos.");
        }
        
        return mensaje;
    }
}
