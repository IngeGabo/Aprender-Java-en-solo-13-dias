package gm.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion(){
        Connection conexion = null;
        //Nombre de la base de datos
        var dataBase = "estudiantes_bd";
        //URL
        var url = "jdbc:mysql://localhost:3306/" + dataBase;
        //Usuario
        var usuario = "root";
        //Contraseña
        var password = "escuela212";
        //Cargamos la clase del driver de mysql en memoria
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Ocurrio un error en la conexión:" + e);
        }

        return conexion;
    }

    public static void main(String[] args) {
        //Probamos la conexion
        var conexion = Conexion.getConexion();
        if (conexion != null){
            System.out.println("conexion exitosa = " + conexion);
        }else{
            System.out.println("Error en la conexion");
        }
    }
}
