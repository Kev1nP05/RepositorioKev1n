package src.com.tienda.mascotas.modelo;
import java.util.Scanner;

import src.com.tienda.mascotas.excepciones.ValidacionException;

/**
 * Clase abstracta que representa un animal genérico.
 * Contiene atributos y métodos comunes para todas las clases hijas.
 * Implementa funcionalidades base como validación y contador de instancias.
 */
public abstract class Animal extends Mensajes {
    private static int contadorAnimales = 0;
    private String nombre;
    private int edad;
    private String raza;
 Scanner input = new Scanner(System.in); // Cambiado a private

    /**
     * Constructor por defecto que incrementa el contador global de animales.
     */
    public Animal() {
        this.nombre = "";
        this.edad = 0;
        this.raza = "";
        contadorAnimales++;
    }

    /**
     * Constructor parametrizado que inicializa todos los atributos.
     * @param nombre Nombre del animal
     * @param edad Edad del animal en años
     * @param raza Raza del animal
     */
    public Animal(String nombre, int edad, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        contadorAnimales++;
    }

    /**
     * Valida que una cadena contenga solo letras y espacios.
     * @param texto Cadena a validar
     * @return true si la cadena contiene solo letras, false en caso contrario
     */
    protected boolean soloLetras(String texto) { // Cambiado a protected
        return texto != null && !texto.trim().isEmpty() && texto.matches("[a-zA-Z ]+");
    }

    // GETTERS Y SETTERS

    /**
     * Obtiene el total de animales creados en el sistema.
     * @return número total de animales registrados
     */
    public static int getContadorAnimales() {
        return contadorAnimales;
    }

    /**
     * Obtiene el nombre del animal.
     * @return nombre del animal
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del animal con validación.
     * @param mensaje Mensaje a mostrar para solicitar el nombre
     * @throws IllegalArgumentException si el nombre está vacío o contiene números
     */
    public void setNombre(String mensaje) {
        while(true) {
            try {
                System.out.print(mensaje);
                String texto = input.nextLine().trim();
                
                if (!soloLetras(texto)) {
                    throw new IllegalArgumentException(errorLetras);
                }

                this.nombre = texto;
                break;
                
               
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Obtiene la edad del animal.
     * @return edad del animal en años
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del animal con validación de rango.
     * @param mensaje Mensaje a mostrar para solicitar la edad
     * @throws ValidacionException si la edad está fuera del rango permitido
     * @throws NumberFormatException si la entrada no es un número válido
     */
    public void setEdad(String mensaje) throws ValidacionException{
        while (true) {
            try {
                System.out.print(mensaje);
                int edadT = Integer.parseInt(input.nextLine());

                if (edadT < 0 || edadT > 15) {
                    throw new ValidacionException("Error: Edad inválida. El rango permitido es de 0 a 15 años.");
                }
                
                this.edad = edadT;
                break;

            } catch (NumberFormatException e) {
                System.out.println(errorNumeros);
            } catch (ValidacionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Obtiene la raza del animal.
     * @return raza del animal
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Establece la raza del animal con validación.
     * @param mensaje Mensaje a mostrar para solicitar la raza
     * @throws IllegalArgumentException si la raza está vacía o contiene números
     */
    public void setRaza(String mensaje) {
        while(true) {
            try {
                System.out.print(mensaje);
                String texto = input.nextLine().trim();
                
                
                if (!soloLetras(texto)) {
                    throw new IllegalArgumentException(errorLetras);
                }
                this.raza = texto;
                break;
            
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // MÉTODOS

    /**
     * Muestra la información básica del animal.
     */
    public void mostrarInfo() {
        System.out.println("ID Interno: " + generarIDInterno());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad() + " años");
        System.out.println("Raza: " + getRaza());
    }

    /**
     * Simula la acción de comer del animal.
     */
    public final void comer() {
        System.out.println("La mascota " + getNombre() + " está comiendo");
    }

    /**
     * Genera un ID interno único para el animal.
     * Solo visible para las clases hijas.
     * @return ID único generado para el animal
     */
    protected String generarIDInterno() {
        return "ANIMAL-" + contadorAnimales + "-" + System.currentTimeMillis();
    }
}