import java.awt.*;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        int operandoUno = SolicitudDatos();
        int operandoDos = SolicitudDatos();
        Menu();
        int resultado = Operacion(operandoUno,operandoDos);
        System.out.println("El resultado es: " + resultado);
    }
    public static void Menu() {
        System.out.println("********* Menu de Calculadora *********");
        System.out.println("1 para suma");
        System.out.println("2 para resta");
        System.out.println("3 para multiplicación");
        System.out.println("4 para división");
    }
    public static int SolicitudDatos(){
        System.out.println("Ingrese un numero: ");
        Scanner consola = new Scanner(System.in);
        return Integer.parseInt(consola.nextLine());
    }
    public static int Operacion(int operandoUno,int operandoDos){
        System.out.println("Ingrese la operación a efectuar");
        int operador = SolicitudDatos();
        return switch (operador) {
            case 1 -> operandoUno + operandoDos;
            case 2 -> operandoUno - operandoDos;
            case 3 -> operandoUno * operandoDos;
            case 4 -> operandoUno / operandoDos;
            default -> {
                System.out.println("Operación no valida");
                yield 0;
            }
        };
    }
}
