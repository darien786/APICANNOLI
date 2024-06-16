/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.pojo.Estado;
import modelo.pojo.Mensaje;
import modelo.pojo.Pedido;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cr7_k
 */
public class PedidoDAO {
    
    public static List<Pedido> obtenerPedidos(){
        List<Pedido> listaPedidos = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        
        if(conexionBD != null){
            
            try{
                
                listaPedidos = conexionBD.selectList("pedido.obtenerPedidos");
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }
        return listaPedidos;
    }
    
    public static Mensaje registrarPedido(Pedido pedido){
        Mensaje  mensaje = new Mensaje(true, "");
        SqlSession conexionBD = MyBatisUtil.getSession();
        
        if(conexionBD != null){
            
            try{
                
                int filasAfectadas = conexionBD.insert("pedido.registrarPedido", pedido);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    mensaje.setError(false);
                    mensaje.setMensaje("Registro éxitoso");
                }else{
                    mensaje.setMensaje("Registro fallido");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
            
        }else{
            mensaje.setMensaje("Por el momento no hay conexion con a base de datos. ");
        }
        
        return mensaje;
    }
    
    public static Mensaje modificarPedido(Pedido pedido){
    
        return null;
    }
    
    public static List<Estado> obtenerEstados(){
        List<Estado> listaEstado = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                listaEstado = conexionBD.selectList("pedido.obtenerEstados");
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }
        
        return listaEstado;
    }
}
