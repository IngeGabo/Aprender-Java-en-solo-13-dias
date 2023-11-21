package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculaLista implements IServicioPelicula {
    private final List<Pelicula> peliculas;

    //Constructor vacio para inicializar la lista
    public ServicioPeliculaLista(){
        this.peliculas = new ArrayList<>();
    }

    //Función para enlistar las películas en el catálogo
    @Override
    public void listaPeliculas() {
        System.out.println("Listado de peliculas...");
        peliculas.forEach(System.out::println);
    }

    //Función para agregar nuevas peliculas
    @Override
    public void agregarPeliculas(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    //Regresa el indice de la pelicula asignada
    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var indice = peliculas.indexOf(pelicula);
        if (indice == -1)
            System.out.println("No se encontro la pelicula = " + pelicula);
        else
            System.out.println("Pelicula encontrada en el indice: " + indice);
    }

    //presentacion.CatalogoPeliculasApp para hacer pruebas
    public static void main(String[] args) {
        //Creamos objetos de tipo pelicula
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("SuperMan");
        var pelicula3 = new Pelicula("Flash");
        //Creamos el servicio (Patron de disenio service)
        IServicioPelicula servicioPelicula = new ServicioPeliculaLista();
        //Agregamos las peliculas
        servicioPelicula.agregarPeliculas(pelicula1);
        servicioPelicula.agregarPeliculas(pelicula2);
        servicioPelicula.agregarPeliculas(pelicula3);
        //Listamos las peliculas
        servicioPelicula.listaPeliculas();
        //Buscar pelicula
        servicioPelicula.buscarPelicula(new Pelicula("OldBoy"));
    }
}
