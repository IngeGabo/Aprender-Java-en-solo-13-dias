package servicio;

import dominio.Pelicula;

public interface IServicioPelicula {
    public void listaPeliculas();
    public void agregarPeliculas(Pelicula pelicula);
    public void buscarPelicula(Pelicula pelicula);
}
