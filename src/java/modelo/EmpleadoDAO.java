/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.pojo.DatosRegistroEmpleado;
import modelo.pojo.Empleado;
import modelo.pojo.Mensaje;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cr7_k
 */
public class EmpleadoDAO {
 
    public static List<Empleado> obtenerEmpleados(){
        List<Empleado> empleados = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{       
                empleados = conexionBD.selectList("empleado.obtenerEmpleados");
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }
        return empleados;
    }
    
    public static Empleado obtenerEmpleadoPorId(Empleado empleado){
        Empleado empleadoSolicitado = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                empleadoSolicitado = conexionBD.selectOne("empleado.obtenerEmpleadoPorId", empleado);
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        
        }
        
        return empleadoSolicitado;
    }
    
    public static Mensaje registrarEmpleado(DatosRegistroEmpleado empleado){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                conexionBD.insert("empleado.registrarEmpleado", empleado);
                conexionBD.commit();
                
                if(empleado.getFilasAfectadas() > 0 && empleado.getError().isEmpty()){
                    mensaje.setError(false);
                    mensaje.setMensaje("Empleado registrado con exito");
                }else{
                    mensaje.setMensaje(empleado.getError());
                }
                
            }catch(Exception e){
                mensaje.setMensaje("Por el momento no puede realizarse la operación, favor de intentarlo mas tarde.");
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }else{
            mensaje.setMensaje("Error: Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde.");
        }
        
        return mensaje;
    }
    
    public static Mensaje editarInformacionEmpleado(DatosRegistroEmpleado datosEmpleado){
        Mensaje mensaje = new Mensaje();
        mensaje.setError(Boolean.TRUE);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                conexionBD.update("empleado.modificarEmpleado", datosEmpleado);
                conexionBD.commit();
                
                if(datosEmpleado.getFilasAfectadas() > 0 && datosEmpleado.getError().isEmpty()){
                    mensaje.setError(false);
                    mensaje.setMensaje("Información modificada con éxito");
                }else{
                    mensaje.setMensaje(datosEmpleado.getError());
                }
            }catch(Exception e){
                mensaje.setMensaje("Por el momento no puede realizarse la operación, favor de intentarlo mas tarde");
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        
        }else{
            mensaje.setMensaje("Error: Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde.");
        }
        
        return mensaje;
    }
}
