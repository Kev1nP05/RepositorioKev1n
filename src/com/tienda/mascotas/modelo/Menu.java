package src.com.tienda.mascotas.modelo;
import java.util.ArrayList;
import java.util.Scanner;

import src.com.tienda.mascotas.excepciones.ValidacionException;

/**
 * Clase que gestiona el menú principal del sistema de tienda de mascotas.
 * Controla la interacción con el usuario y la gestión de animales.
 */
public class Menu extends Mensajes {
    private final ArrayList<Animal> animales;
    private final Scanner input;

    /**
     * Constructor que inicializa las estructuras de datos necesarias.
     */
    public Menu() {
        animales = new ArrayList<>();
        input = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal y gestiona las opciones del usuario.
     */
    public void menuPrincipal() {
        int opcion;
        do {
           
                System.out.println("\n--- SISTEMA DE GESTIÓN VETERINARIA ---");
                System.out.println("1. Registrar Perro");
                System.out.println("2. Registrar Gato");
                System.out.println("3. Mostrar registro de animales");
                System.out.println("4. Salir del programa");
                System.out.println("----------------------------------------");
                
                opcion = leerEntero("Seleccione una opción: ");

                switch (opcion) {
                    case 1 -> registrarPerro();
                    case 2 -> registrarGato();
                    case 3 -> mostrarAnimales();
                    case 4 -> System.out.println("¡Gracias por usar el sistema! Hasta luego :)");
                    default -> System.out.println("Error: Opción inválida. Debe ser un número entre 1 y 4.");
                }
            
        } while (opcion != 4);
        
        input.close();
    }

    /**
     * Registra un nuevo perro en el sistema.
     * Maneja excepciones específicas durante el proceso de registro.
     */
    private void registrarPerro() {
        
        try {
            System.out.println("\n=== REGISTRO DE PERRO ===");
            Perro perro = new Perro();
            
            perro.setNombre(mensajeNombre);
            perro.setEdad(mensajeEdad);
            perro.setRaza(mensajeRaza);
            perro.setEsGuia(mensajeGuiador);
            
            registrarAnimal(perro);
            System.out.println("¡Perro registrado correctamente!");
            
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en los datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado al registrar perro: " + e.getMessage());
        }
    }

    /**
     * Registra un nuevo gato en el sistema.
     * Maneja excepciones específicas durante el proceso de registro.
     */
    private void registrarGato() {
        try {
            System.out.println("\n=== REGISTRO DE GATO ===");
            Gato gato = new Gato();
            
            gato.setNombre(mensajeNombre);
            gato.setEdad(mensajeEdad);
            gato.setRaza(mensajeRaza);
            gato.setCazaRatones(mensajeCazador);
            
            registrarAnimal(gato);
            System.out.println("¡Gato registrado correctamente!");
            
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en los datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado al registrar gato: " + e.getMessage());
        }
    }

    /**
     * Muestra todos los animales registrados en el sistema.
     */
    private void mostrarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("\nNo hay animales registrados en el sistema.");
            return;
        }
        
        System.out.println("\n=== LISTA DE ANIMALES REGISTRADOS ===");
        for (int i = 0; i < animales.size(); i++) {
            System.out.println("\nAnimal #" + (i + 1));
            animales.get(i).mostrarInfo();
        }
        System.out.println("\nTotal de animales registrados: " + Animal.getContadorAnimales());
    }

    /**
     * Registra un animal en la lista de animales.
     * @param animal Animal a registrar
     */
    private void registrarAnimal(Animal animal) {
        animales.add(animal);
    }

    /**
     * Lee un número entero desde la entrada estándar con validación.
     * @param mensaje Mensaje a mostrar para solicitar el número
     * @return número entero válido ingresado por el usuario
     */
    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(errorNumeros);
    }
}
}

}