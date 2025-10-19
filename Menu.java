import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Mensajes {
    private final ArrayList<Animal> animales;
    private final Scanner input; 

    public Menu() {
       animales = new ArrayList<>();
       input = new Scanner(System.in);
    }

    // Menú principal
    public void menuPrincipal() {
    int opcion;
    do {
        System.out.println("\n--- MENU VETERINARIA ---");
        System.out.println("1. Registrar Perro");
        System.out.println("2. Registrar Gato");
        System.out.println("3. Mostrar registro de animales");
        System.out.println("4. Salir del programa\n");
        opcion = leerEntero("Seleccione una opcion: ");

        switch (opcion) {
            case 1 -> registrarPerro();
            case 2 -> registrarGato();
            case 3 -> mostrarAnimales();
            case 4 -> System.out.println("Gracias por usar el programa, hasta luego :)");
            default -> System.out.println("Error: opcion invalida -> (1-4).");
        }
    } while (opcion != 4);
}

 // Registrar un perro
    private void registrarPerro() {
        System.out.println("\n===INGRESO DE DATOS DEL PERRO===");
        Perro perro = new Perro();
        perro.setNombre(mensajeNombre);
        perro.setEdad(mensajeEdad);
        perro.setRaza(mensajeRaza);
        perro.setEsGuia(mensajeGuiador);
        registrarAnimal(perro);
        System.out.println("Perro registrado correctamente!.");
    }

    // Registrar un gato
    private void registrarGato() {
        System.out.println("\n===INGRESO DE DATOS DEL GATO===");
        Gato gato = new Gato();
        gato.setNombre(mensajeNombre);
        gato.setEdad(mensajeEdad);
        gato.setRaza(mensajeRaza);
        gato.setCazaRatones(mensajeCazador);
        registrarAnimal(gato);
        System.out.println("Gato registrado correctamente.");
    }

   

    // Mostrar todos los animales
    private void mostrarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales para mostrar.");
            return;
        }
        System.out.println("\nLista de animales:");
        for (Animal a : animales) {
            a.mostrarInfo();
            System.out.println("");
        }
    }
    // Metodo para registrar en la lista
    private void registrarAnimal(Animal animal){
        animales.add(animal);
    }
    // Metodo para leer la OPC
     private int leerEntero(String mensaje){
        try{
            System.out.print(mensaje);
            return Integer.parseInt(input.nextLine());
        }catch (NumberFormatException e){
            System.out.println(errorNumeros);
            return 0;
        }
    }
}