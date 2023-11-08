import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ListadoPersonasApp {
    public static void main(String[] args) {
            //Funcion para pedir datos a consola
            Scanner consola = new Scanner(System.in);
            //Declaramos la lista fuera del while
            List<Persona> personas = new ArrayList<>();
            //Menu
            var salir = false;
            while (!salir){
                mostrarMenu();
                try{
                    salir = ejecutarOperacion(consola, personas);
                }catch (Exception e){
                    System.out.println("Ocurrio un error inesperado: " + e.getMessage());
                }
                System.out.println();

            }
        }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        //Revisamos la opcion entregada
        switch (opcion){
            case 1 -> {//Agregamos la opcion de agregar personas
                System.out.print("Ingresa el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Ingresa el numero: ");
                var numero = consola.nextLine();
                System.out.print("Ingresa el email: ");
                var email = consola.nextLine();
                //Crear objetos de persona
                var persona = new Persona(nombre,numero,email);
                //Agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");
            }
            case 2 ->{//Imprimir personas
                System.out.println("El listado de personas: ");
                //Mandamos a imprimir de manera eficiente
                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
            }
            case 3 ->{
                System.out.println("Hasta luego");
                salir = true;
            }
            default -> System.out.println("Opcion erronea: " + opcion);
        }
        return salir;
    }

    private static void mostrarMenu() {
        //Mostramos las opciones
        System.out.print("""
                *** Listado de personas ***
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Elige la opción: ");
    }
}
