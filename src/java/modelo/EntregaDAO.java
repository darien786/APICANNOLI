/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.pojo.Entrega;
import modelo.pojo.Mensaje;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cr7_k
 */
public class EntregaDAO {
    
    public static List<Entrega> obtenerEntregas(){
        List<Entrega> listaEntregas = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
        
            try{
            
                listaEntregas = conexionBD.selectList("entrega.obtenerEntregas");
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        return listaEntregas;
    }
    
    public static Mensaje registrarEntrega(Entrega entrega){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                int filasAfectadas = conexionBD.insert("entrega.registrarEntrega", entrega);
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Registro éxitoso");
                }else{
                    mensaje.setMensaje("Registro fallido");
                }
                
            }catch(Exception e){
                e.printStackTrace();
                mensaje.setMensaje("Por el momento no se puede realizar esta operación, favor de intentarlo mas tarde.");
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde.");
        }
        
        return mensaje;
    }
    
    public static Mensaje modificarEntrega(Entrega entrega){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
            
                int filasAfectadas = conexionBD.update("entrega.editarEntrega", entrega);
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Modificación éxitoso");
                }else{
                    mensaje.setMensaje("Modificación fallida");
                }
                
            }catch(Exception e){
                e.printStackTrace();
                mensaje.setMensaje("Por el momento no se puede realizar la operacion, favor de intentarlo mas tarde.");
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde.");
        }
        
        return mensaje;
    }
    
    public static Mensaje eliminarEntrega(Entrega entrega){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
            
                int filasAfectadas = conexionBD.delete("entrega.eliminarEntrega", entrega);
                
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Eliminación exitosa");
                }else{
                    mensaje.setMensaje("Eliminación fallida");
                }
            }catch(Exception e){
                e.printStackTrace();
                mensaje.setMensaje("Por el momento no se puede realizar esta operación, favor de intentarlo mas tarde.");
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde.");
        }
        
        return mensaje;
    }
}
