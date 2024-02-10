/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.pojo.Mensaje;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cr7_k
 */
public class EmpleadoDAO {
    
    public static Mensaje registrarEmpleado(){
        Mensaje mensaje = null;
        mensaje.setError(Boolean.TRUE);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                
            }catch(Exception e){
            
                
            }
        }
        
        return mensaje;
    }
}
