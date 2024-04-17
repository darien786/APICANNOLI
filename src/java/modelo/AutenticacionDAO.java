/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.pojo.Empleado;
import modelo.pojo.Mensaje;
import modelo.pojo.MensajeAutenticacion;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cr7_k
 */
public class AutenticacionDAO {
    
    public static MensajeAutenticacion inicioSesionEscritorio(Empleado empleado){
        MensajeAutenticacion mensaje = new MensajeAutenticacion();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
           try{
               Empleado sesionEmpleado = conexionBD.selectOne("autenticacion.inicioSesionEscritorio", empleado);
               int filasAfectadas = conexionBD.update("autenticacion.modificarSesion", sesionEmpleado);
               conexionBD.commit();
               
               if(sesionEmpleado != null && filasAfectadas > 0){
                   mensaje.setError(false);
                   mensaje.setMensaje("!Bienvenid@ " + sesionEmpleado.getNombreEmpleado() + "¡");
                   mensaje.setEmpleado(sesionEmpleado);
               }else{
                   mensaje.setMensaje("Usuario y/o contraseñas incorrectas");
               }
           }catch(Exception e){
               mensaje.setMensaje("Error al realizar la operacion, favor de intentarlo mas tarde.");
               e.printStackTrace();
           }finally{
               conexionBD.close();
           } 
        }else{
            mensaje.setMensaje("Error: Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde.");
        }
        
        return mensaje;
    }
    
    public static Mensaje cerrarSesion(Integer idEmpleado){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(Boolean.TRUE);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                 
                int filasAfectadas = conexionBD.update("autenticacion.modificarCerrarSesion", idEmpleado);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Adios");
                }
            }catch(Exception e){
                mensaje.setMensaje("Por el momento no se puede realizar esta operacion");
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }else{
            mensaje.setMensaje("Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde.");
        }
        
        return mensaje;
    }
}
