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
    
    public static List<Proveedor> obtenerProveedores(){
        List<Proveedor> listaProveedores = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                listaProveedores = conexionBD.selectList("proveedor.obtenerProveedores");
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }
        
        return listaProveedores;
    }
    
    public static Mensaje registrarProveedor(Proveedor proveedor){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(false);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                int filasAfectadas = conexionBD.insert("proveedor.registrarProveedor",proveedor);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Registro éxitoso");
                }else{
                    mensaje.setMensaje("Registro fallido");
                }
            }catch(Exception e){
                mensaje.setMensaje("Por el momento no se puede realizar la operacion, favor de intentarlo mas tarde.");
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde");
        }
        return mensaje;
    }
    
    public static Mensaje modificarProveedor(Proveedor proveedor){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                int filasAfectadas = conexionBD.update("proveedor.editarProveedor", proveedor);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Modificación exitosa");
                }else{
                    mensaje.setMensaje("Modificación fallida");
                }
                
            }catch(Exception e){
                e.printStackTrace();
                mensaje.setMensaje("Por el momento no see puede realizar esta operación, favor de intentarlo mas tarde.");
            }finally{
                conexionBD.close();
            }
        }else{
            
        }
        return mensaje;
    }
    
    public static Mensaje eliminarProveedor(Proveedor proveedor){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                int filasAfectadas = conexionBD.delete("proveedor.eliminarProveedor", proveedor);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Eliminación exitosa");
                }else{
                    mensaje.setMensaje("Eliminación fallida");
                }
            }catch(Exception e){
                e.printStackTrace();
                mensaje.setMensaje("Por el momento no se puede realizar la operacion, favor de intentarlo mas tarde.");
            
            }finally{
                conexionBD.close();
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde.");
        }
        
        return mensaje;
    }
}
