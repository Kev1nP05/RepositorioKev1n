package src.com.tienda.mascotas.modelo;

import src.com.tienda.mascotas.excepciones.ValidacionException;

/**
 * Clase que representa un Perro, hereda de Animal.
 * Incluye características específicas de los perros como la capacidad de ser guía.
 */
public class Perro extends Animal {
    private boolean esGuia;

    /**
     * Constructor por defecto que inicializa un perro con valores predeterminados.
     */
    public Perro() {
        super();
        this.esGuia = false;
    }

    /**
     * Constructor parametrizado que inicializa todos los atributos del perro.
     * @param nombre Nombre del perro
     * @param edad Edad del perro en años
     * @param raza Raza del perro
     * @param esGuia Indica si el perro es de asistencia o guía
     */
    public Perro(String nombre, int edad, String raza, boolean esGuia) {
        super(nombre, edad, raza);
        this.esGuia = esGuia;
    }

    // GETTERS Y SETTERS

    /**
     * Obtiene si el perro es de guía o asistencia.
     * @return true si es perro guía, false en caso contrario
     */
    public boolean getEsGuia() {
        return esGuia;
    }

    /**
     * Establece si el perro es de guía con validación de entrada.
     * @param mensaje Mensaje a mostrar para solicitar la información
     * @throws ValidacionException si la respuesta no es "sí" o "no"
     */
    public void setEsGuia(String mensaje) throws ValidacionException {
        while(true) {
            try {
                System.out.print(mensaje);
                String respuesta = input.nextLine().trim().toLowerCase();
                
                if (!respuesta.equals("si") && !respuesta.equals("no")) {
                    throw new ValidacionException("Error: Respuesta inválida. Debe escribir 'si' o 'no'.");
                }
                this.esGuia = respuesta.equals("si");
                break;
            
            } catch(ValidacionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Simula el ladrido del perro.
     */
    public void ladrar() {
        System.out.println("El perro " + getNombre() + " está ladrando: ¡Guau guau!");
    }

    /**
     * Muestra toda la información del perro, incluyendo características específicas.
     * Sobrescribe el método de la clase padre para incluir información adicional.
     */
    @Override
    public void mostrarInfo() {
        System.out.println("=== DATOS DEL PERRO ===");
        super.mostrarInfo();
        System.out.println("¿Es perro guía?: " + (getEsGuia() ? "Sí" : "No"));
        comer();
        ladrar();
        System.out.println("---------------------");
    }
}