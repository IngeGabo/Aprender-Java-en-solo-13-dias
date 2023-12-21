package gm.datos;

import gm.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//Este import fue manual
import static gm.conexion.Conexion.getConexion;

//DAO - Data Access Object
public class EstudiantesDAO {
    public List<Estudiante> listarEstudianes(){
        //Creas una lista
        List<Estudiante> estudiantes = new ArrayList<>();

        //PreparedStatement es una subclase de Statement utilizada para ejecutar sentencias SQL en la base de datos.
        PreparedStatement ps;
        //ResultSet es una clase que representa el resultado de una consulta en una base de datos. Se utiliza para recorrer los datos devueltos por una consulta SELECT.
        ResultSet rs;
        Connection con = getConexion();
        //La consulta de SQL
        String sql = "SELECT * FROM estudiante ORDER BY id_estudiante";
        try {
            //Usamos la consulta
            ps = con.prepareStatement(sql);
            //Resibimos la consulta
            rs = ps.executeQuery();
            while (rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error: " + e.getMessage());
        }finally {
            try {
                con.close();
            }catch(Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }

        }

        return estudiantes;
    }

    // Find by id
    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if (rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar estudiantes: " + e.getMessage());
        }finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la base de datos: " +e.getMessage());
            }
        }
        return false;
    }

    //Add estudiante
    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiante(nombre, apellido, telefono, email) VALUES(?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,estudiante.getNombre());
            ps.setString(2,estudiante.getApellido());
            ps.setString(3,estudiante.getTelefono());
            ps.setString(4,estudiante.getEmail());
            ps.execute(); //En este caso como no es consulta y es acción se ocupa este comando
            return true;
        }catch (Exception e){
            System.out.println("Error al agregar: " + e.getMessage());
        }finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexion" + e.getMessage());
            }
        }
        return false;
    }

    //Modifica estudiante
    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE estudiante SET nombre = ?, apellido = ?, telefono = ?, email = ? WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Ocurrio un error al modificar estudiante: " + e.getMessage());
        }finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    //Eliminar estudiantes
    public boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al eliminar estudiante: " + e.getMessage());
        }finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }
    public static void main(String[] args) {
        var estudiantesDAO = new EstudiantesDAO();

        //Eliminar estudiantes
//        Estudiante estudianteEliminar = new Estudiante(4);
//        boolean eliminado = estudiantesDAO.eliminarEstudiante(estudianteEliminar);
//        if (eliminado)
//            System.out.println("estudiante que se elimino = " + estudianteEliminar);
//        else
//            System.out.println("No se elimino al estudiante = " + estudianteEliminar);

        //Agregar estudiantes
//        Estudiante nuevoEstudiante = new Estudiante("Shell", "Zavala", "5552456314", "Shell@gmail.com");
//        boolean agregar = estudiantesDAO.agregarEstudiante(nuevoEstudiante);
//        if (agregar)
//            System.out.println("Estudiante agregado: " + nuevoEstudiante);
//        else
//            System.out.println("No se agrego el estudiante: " + nuevoEstudiante);

        //Modificar estudiantes
//        Estudiante modificacionEstudiante = new Estudiante(1, "Juan Carlos", "Perez", "5577441122", "Juan@gmail.com");
//        boolean modificado = estudiantesDAO.modificarEstudiante(modificacionEstudiante);
//        if (modificado)
//            System.out.println("El modifico Estudiante = " + modificacionEstudiante);
//        else
//            System.out.println("No se modifico Estudiante = " + modificacionEstudiante);


        //Listado de personajes
        System.out.println("Listado de estudiantes: ");
        List<Estudiante> estudiantes = estudiantesDAO.listarEstudianes();
        estudiantes.forEach(System.out::println);

        //Buscar por Id
        //Estudiante estudiante1 = new Estudiante(4);
        //System.out.println("estudiante antes de la busqueda = " + estudiante1);
        //boolean encontrado = estudiantesDAO.buscarEstudiantePorId(estudiante1);
        //if (encontrado)
        //  System.out.println("Estudiante encontrado: " + estudiante1);
        //else
        //  System.out.println("No se encontro estudiantes: " + estudiante1.getIdEstudiante());
    }
}
