
package modelo;

import java.util.List;
import modelo.pojo.Mensaje;
import modelo.pojo.Venta;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Usuario
 */
public class VentasDAO {
    public static List<Venta> obtenerVentas() {
        List<Venta> ventas = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                ventas = conexionBD.selectList("ventas.obtenerVentas");
            } catch (Exception e) {
                System.err.println("Error obteniendo las ventas");
            } finally {
                conexionBD.close();
            }
        } else {
            System.err.println("Sin conexión con la base de datos");
        }
        return ventas;
    }
    
     public static Mensaje registrarVenta(Venta venta) {
        Mensaje mensaje = new Mensaje();
        mensaje.setError(false);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {

                int filasAfectadas = conexionBD.insert("ventas.registrarVenta", venta);
                conexionBD.commit();

                if (filasAfectadas > 0) {
                    mensaje.setError(false);
                    mensaje.setMensaje("Registro éxitoso");
                } else {
                    mensaje.setMensaje("Registro fallido");
                }
            } catch (Exception e) {
                mensaje.setMensaje("Por el momento no se puede realizar la operación, favor de intentarlo mas tarde.");
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        } else {
            mensaje.setMensaje("Por el momento no hay conexion con la base de datos.");
        }
        return mensaje;
    }
}
