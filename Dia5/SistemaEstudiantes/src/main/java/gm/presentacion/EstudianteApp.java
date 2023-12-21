package gm.presentacion;

import gm.datos.EstudiantesDAO;
import gm.dominio.Estudiante;

import java.util.Scanner;

public class EstudianteApp {
    public static void main(String[] args) {
        boolean salir = false;
        Scanner consola = new Scanner(System.in);
        EstudiantesDAO servicioEstudiante = new EstudiantesDAO();
        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOperacion(consola, servicioEstudiante);
            }catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
        }
    }
    private static void mostrarMenu(){
        System.out.println("""
                *** Sistema de Estudiantes ***
                1. Listar Estudiantes
                2. Buscar estudiante
                3. Agragar Estudiante
                4. Modifica Estudiante
                5. Eliminar Estudiante
                6. Salir
                Elige una opción:
                """);
    }
    private static boolean ejecutarOperacion(Scanner consola, EstudiantesDAO servivioEstudiante){
        int opcion = Integer.parseInt(consola.nextLine());
        boolean salir = false;
        switch (opcion){
            case 1 -> { //Listar Estudiante
                System.out.println("Listado de estudiantes");
                var estudiantes = servivioEstudiante.listarEstudianes();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> { //Buscar Estudiante
                System.out.print("Introduce el ID del estudiante a buscar: ");
                int idEstudiante = Integer.parseInt(consola.nextLine());
                Estudiante estudianteABuscar = new Estudiante(idEstudiante);
                boolean encontrado = servivioEstudiante.buscarEstudiantePorId(estudianteABuscar);
                if (encontrado)
                    System.out.println("Se encontro el estudiante: " + estudianteABuscar);
                else
                    System.out.println("No se encontro al estudiante: " + estudianteABuscar);
            }
            case 3 -> { //Agregar estudiante
                System.out.println("Agregar estudiante");
                System.out.print("Nombre: ");
                String nombre = consola.nextLine();
                System.out.print("Apellido: ");
                String apellido = consola.nextLine();
                System.out.print("Telefono: ");
                String telefono = consola.nextLine();
                System.out.print("Email: ");
                String email = consola.nextLine();
                //Crear el objeto sin el id
                Estudiante estudianteAgregar = new Estudiante(nombre,apellido,telefono,email);
                boolean agregar = servivioEstudiante.agregarEstudiante(estudianteAgregar);
                if (agregar)
                    System.out.println("Estudiante agregado: " + estudianteAgregar);
                else
                    System.out.println("No se agrego el estudiante: " + estudianteAgregar);
            }
            case 4 ->{ //Modificar estudiante
                System.out.println("Estudiante a modificar: ");
                System.out.print("Ingresa el Id del estudiante a modificar: ");
                int idModificar = Integer.parseInt(consola.nextLine());
                System.out.println("Inglesa los nuevos datos");
                System.out.print("Nombre: ");
                String nombre = consola.nextLine();
                System.out.print("Apellido: ");
                String apellido = consola.nextLine();
                System.out.print("Telefono: ");
                String telefono = consola.nextLine();
                System.out.print("Email: ");
                String email = consola.nextLine();
                //Crear el objeto para modificar
                Estudiante modificacionEstudiante = new Estudiante(idModificar, nombre, apellido, telefono, email);
                boolean modificado = servivioEstudiante.modificarEstudiante(modificacionEstudiante);
                if (modificado)
                    System.out.println("El modifico Estudiante = " + modificacionEstudiante);
                else
                    System.out.println("No se modifico Estudiante = " + modificacionEstudiante);
            }
            case 5 ->{//Eliminar usuario
                System.out.println("Eliminar usuario");
                System.out.println("Ingrese el ID del usuario a eliminar: ");
                int idEliminar = Integer.parseInt(consola.nextLine());
                Estudiante estudianteEliminar = new Estudiante(idEliminar);
                boolean eliminado = servivioEstudiante.eliminarEstudiante(estudianteEliminar);
                if (eliminado)
                    System.out.println("estudiante que se elimino = " + estudianteEliminar);
                else
                    System.out.println("No se elimino al estudiante = " + estudianteEliminar);
            }
            case 6 ->{
                System.out.println("Hasta pronto!!");
                salir = true;
            }
            default -> System.out.println("Opción no reconocida: " + opcion);
            }
            return salir;
    }
}