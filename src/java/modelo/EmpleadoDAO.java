/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.pojo.DatosRegistroEmpleado;
import modelo.pojo.Mensaje;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cr7_k
 */
public class EmpleadoDAO {
    
    public static Mensaje registrarEmpleado(DatosRegistroEmpleado empleado){
        Mensaje mensaje = null;
        mensaje.setError(Boolean.TRUE);
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
}
