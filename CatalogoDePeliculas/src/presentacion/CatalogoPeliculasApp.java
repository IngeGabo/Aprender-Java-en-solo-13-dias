package presentacion;

import dominio.Pelicula;
import servicio.IServicioPelicula;
// import servicio.ServicioPeliculaLista;
import servicio.ServicioPeliculasArchivo;

import java.util.Scanner;


public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        // Agregamos la implementación de servio
        IServicioPelicula servicioPelicula = new ServicioPeliculasArchivo();
        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOperacion(consola, servicioPelicula);
            }catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }//Fin del while
    }
    private static void mostrarMenu(){
        System.out.print("""
                *** Catalogo de peliculas ***
                1. Agregar pelicula
                2. Lista peliculas
                3. Buscar pelicula
                4. Salir
                Elige una opción: 
                """);
    }

    private static boolean ejecutarOperacion(Scanner consola, IServicioPelicula servicioPelicula){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> {
                System.out.println("Introducce el nombre de la pelicula: ");
                var nombrePelicula = consola.nextLine();
                servicioPelicula.agregarPeliculas(new Pelicula(nombrePelicula));
            }case 2 -> servicioPelicula.listaPeliculas();
            case 3 -> {
                System.out.print("Introducce la pelicula que buscas: ");
                var buscar = consola.nextLine();
                servicioPelicula.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Hasta pronto!!");
                salir = true;
            }
            default -> System.out.println("Opción no reconocida: " + opcion);
        }
        return salir;
    }
}
