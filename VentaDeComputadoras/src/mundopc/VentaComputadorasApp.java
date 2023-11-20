package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

public class VentaComputadorasApp {
    public static void main(String[] args) {
        //Creamos objetos
        Raton ratonLenovo = new Raton("Bluetooth", "Lenovo");
        Teclado tecladoLenovo = new Teclado("Bluetooth", "Lenovo");
        Monitor monitorGhia = new Monitor("GHIA", 27);
        Raton ratonRazer = new Raton("USB","Razer");
        Teclado tecladoRazer = new Teclado("USB", "Razer");
        Monitor monitorHP = new Monitor("HP", 75);
        Raton ratonJuguete = new Raton("C", "Patito");
        Teclado tecladoJuguete = new Teclado("C", "Patito");
        Monitor monitorJuguete = new Monitor("Quak", 15);
        //Creamos una computadora
        Computadora computadorahp = new Computadora("Computadora HP", monitorGhia, tecladoLenovo, ratonLenovo);
        Computadora computadoraGamer = new Computadora("ComputadoraGamer", monitorHP, tecladoRazer, ratonRazer);
        Computadora computadoraJuguete = new Computadora("Computadora de Juguete", monitorJuguete, tecladoJuguete, ratonJuguete);
        //Creamos ordenes
        Orden orden1 = new Orden();
        Orden orden2 = new Orden();
        Orden orden3 = new Orden();
        Orden orden4 = new Orden();
        orden1.agregarComputadoras(computadorahp);
        orden1.agregarComputadoras(computadoraGamer);
        orden1.agregarComputadoras(computadoraJuguete);
        orden2.agregarComputadoras(computadorahp);
        orden3.agregarComputadoras(computadoraJuguete);
        orden3.agregarComputadoras(computadoraGamer);
        orden4.agregarComputadoras(computadorahp);
        orden4.agregarComputadoras(computadorahp);
        orden1.imprimirOrden();
        System.out.println();
        orden2.imprimirOrden();
        System.out.println();
        orden3.imprimirOrden();
        System.out.println();
        orden4.imprimirOrden();
        }

    }
