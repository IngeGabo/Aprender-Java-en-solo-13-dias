package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPelicula{

    private static String NOMBRE_ARCHIVO = "Peliculas.txt";
    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //Si ya existe el archivo, No se vuelve a crear
            if (archivo.exists()){
                System.out.println("El archivo ya existe!");
            }else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir un archivo:" + e.getMessage());
        }
    }
    @Override
    public void listaPeliculas() {
        //Volvemos a abrir el achivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Listado de Peliculas");
            //abimos el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            //Leamos linea a linea el archivo
            String linea;
            linea = entrada.readLine();
            //Leemos todas las lineas disponibre
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //Antes de terminar volvemos a leer la siguiente linea
                linea = entrada.readLine();
            }
            //Cerramos el archivo
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error abriendo el achivo: " + e.getMessage());
        }
    }

    @Override
    public void agregarPeliculas(Pelicula pelicula) {
         boolean anexar = false;
         var archivo = new File(NOMBRE_ARCHIVO);
         try {
             //Revisamos si ya existe
             anexar= archivo.exists();
             var salida = new PrintWriter(new FileWriter(archivo, anexar));
             //Agramos la pelicula
             salida.println(pelicula);
             salida.close();
             System.out.println("Se agrego al archivo: " + pelicula);
         }catch (Exception e){
             System.out.println("Ocurrio un error al agregar una pelicula" + e.getMessage());
         }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //abrimos el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();
            while (lineaTexto != null){
                //Buscamos sin importar mayusculas o minusculas
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                //Leamos la siguiente linea antes de la siguiente iteración
                lineaTexto = entrada.readLine();
                indice++;
            }//Fin del whil
            //Imprimimos los resultados de la busqueda
            if (encontrada){
                System.out.println("Pelicula "+ lineaTexto + " Encontrada en la linea " +indice);
            }else System.out.println("No se encontro la pelicula " +pelicula.getNombre());
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar pelicula: " + e.getMessage());
        }
    }
}
