package mundopc.servicio;

import mundopc.modelo.Computadora;

import java.util.ArrayList;
import java.util.List;

public class Orden {
    //Declaración de atributos
    private final int idOrden;
    private final List<Computadora> computadoras;
    private static int contadorOrden;
    //Constructor Vacio
    public Orden(){
        computadoras = new ArrayList<>();
        idOrden = ++contadorOrden;
    }
    //Metodo para agregar computadoras a la lista
    public void agregarComputadoras(Computadora computadora){
        computadoras.add(computadora);
    }
    //Metodo para imprimir orden
    public void imprimirOrden(){
        System.out.println("La orden #" + idOrden);
        //Se ocupa el metodo size para que diga el tamaño de la lista
        System.out.println("Total de computadoras: " +computadoras.size());
        //Lo siguiente es un for que por cada uno que tenga lo va a imprimir
        computadoras.forEach(System.out::println);
    }

}
