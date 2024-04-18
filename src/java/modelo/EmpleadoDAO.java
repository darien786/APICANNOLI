/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import modelo.pojo.DatosRegistroEmpleado;
import modelo.pojo.Empleado;
import modelo.pojo.Estatus;
import modelo.pojo.Mensaje;
import modelo.pojo.Rol;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import utils.Utilidades;
import javafx.scene.image.Image;

/**
 *
 * @author cr7_k
 */
public class EmpleadoDAO {

    public static List<Estatus> obtenerEstatus() {
        List<Estatus> listaEstatus = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                listaEstatus = conexionBD.selectList("empleado.obtenerEstatus");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        }

        return listaEstatus;
    }

    public static List<Rol> obtenerRoles() {
        List<Rol> listaRoles = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {

                listaRoles = conexionBD.selectList("empleado.obtenerRoles");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listaRoles;
    }

    public static List<Empleado> obtenerEmpleados() {

        List<Empleado> empleados = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                empleados = conexionBD.selectList("empleado.obtenerEmpleados");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        }
        return empleados;
    }

    public static DatosRegistroEmpleado obtenerEmpleadoPorId(Integer idEmpleado) {
        DatosRegistroEmpleado empleadoSolicitado = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {

                empleadoSolicitado = conexionBD.selectOne("empleado.obtenerEmpleadoPorId", idEmpleado);

                File image = new File(empleadoSolicitado.getEmpleado().getFotografia());

                empleadoSolicitado.getEmpleado().setFotografiaBase64(Utilidades.convertirImagenABase64(image));

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        }

        return empleadoSolicitado;
    }

    public static Mensaje registrarEmpleado(DatosRegistroEmpleado empleado) {
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {

                conexionBD.insert("empleado.registrarEmpleado", empleado);
                conexionBD.commit();

                Image image = Utilidades.decodificarImagenBase64(empleado.getEmpleado().getFotografiaBase64());
                Utilidades.guardarImagen(empleado.getEmpleado().getFotografia(), image);

                if (empleado.getFilasAfectadas() > 0 && empleado.getError().isEmpty()) {
                    mensaje.setError(false);
                    mensaje.setMensaje("Registro éxitoso.");
                } else {
                    mensaje.setMensaje(empleado.getError());
                }

            } catch (Exception e) {
                mensaje.setMensaje("Por el momento no puede realizarse la operación, favor de intentarlo mas tarde.");
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        } else {
            mensaje.setMensaje("Por el momento no hay conexión con la base de datos.");
        }

        return mensaje;
    }

    public static Mensaje editarInformacionEmpleado(DatosRegistroEmpleado datosEmpleado) {
        Mensaje mensaje = new Mensaje();
        mensaje.setError(Boolean.TRUE);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {

                conexionBD.update("empleado.modificarEmpleado", datosEmpleado);
                conexionBD.commit();

                Image image = Utilidades.decodificarImagenBase64(datosEmpleado.getEmpleado().getFotografiaBase64());
                Utilidades.guardarImagen(datosEmpleado.getEmpleado().getFotografia(), image);

                if (datosEmpleado.getFilasAfectadas() > 0 && datosEmpleado.getError().isEmpty()) {
                    mensaje.setError(false);
                    mensaje.setMensaje("Modificación éxitosa.");
                } else {
                    mensaje.setMensaje(datosEmpleado.getError());
                }
            } catch (Exception e) {
                mensaje.setMensaje("Por el momento no puede realizarse la operación, favor de intentarlo mas tarde");
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }

        } else {
            mensaje.setMensaje("Por el momento no hay conexión con la base de datos.");
        }

        return mensaje;
    }

    public static Mensaje eliminarEmpleado(Empleado empleado) {
        Mensaje mensaje = new Mensaje();
        mensaje.setError(Boolean.TRUE);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {

                int filasAfectadas = conexionBD.delete("empleado.eliminarEmpleado", empleado);
                conexionBD.commit();

                if (filasAfectadas > 0) {
                    mensaje.setError(false);
                    mensaje.setMensaje("Eliminación exitósa");
                } else {
                    mensaje.setMensaje("Eliminación fallida");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        } else {
            mensaje.setMensaje("Por el momento no hay conexión con la base de datos.");
        }

        return mensaje;
    }
}
