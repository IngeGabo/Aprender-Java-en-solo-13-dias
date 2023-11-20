package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;

public class Main {
    public static void main(String[] args) {
        //Creamos objetos
        Raton ratonLenovo = new Raton("Bluetooth", "Lenovo");
        System.out.println("ratonLenovo = " + ratonLenovo);
        Teclado tecladoLenovo = new Teclado("Bluetooth", "Lenovo");
        System.out.println("tecladoLenovo = " + tecladoLenovo);
        Monitor monitorGhia = new Monitor("GHIA", 27);
        System.out.println("monitorGhia = " + monitorGhia);
        //Creamos una computadora
        Computadora computadorahp = new Computadora("Computadora HP", monitorGhia, tecladoLenovo, ratonLenovo);
        System.out.println("computadorahp = " + computadorahp);
        }
    }
