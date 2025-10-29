package src.com.tienda.mascotas.modelo;

import src.com.tienda.mascotas.excepciones.ValidacionException;

/**
 * Clase que representa un Gato, hereda de Animal.
 * Incluye características específicas de los gatos como habilidad para cazar ratones.
 */
public class Gato extends Animal {
    private boolean cazaRatones;

    /**
     * Constructor por defecto que inicializa un gato con valores predeterminados.
     */
    public Gato() {
        super();
        this.cazaRatones = false;
    }

    /**
     * Constructor parametrizado que inicializa todos los atributos del gato.
     * @param nombre Nombre del gato
     * @param edad Edad del gato en años
     * @param raza Raza del gato
     * @param cazaRatones Indica si el gato caza ratones
     */
    public Gato(String nombre, int edad, String raza, boolean cazaRatones) {
        super(nombre, edad, raza);
        this.cazaRatones = cazaRatones;
    }

    // GETTERS Y SETTERS

    /**
     * Obtiene si el gato caza ratones.
     * @return true si caza ratones, false en caso contrario
     */
    public boolean getCazaRatones() {
        return cazaRatones;
    }

    /**
     * Establece si el gato caza ratones con validación de entrada.
     * @param mensaje Mensaje a mostrar para solicitar la información
     * @throws ValidacionException si la respuesta no es "sí" o "no"
     */
    public void setCazaRatones(String mensaje) throws ValidacionException {
        while(true) {
            try {
                System.out.print(mensaje);
                String respuesta = input.nextLine().toLowerCase();
                
                if (!respuesta.equals("si") && !respuesta.equals("no")) {
                    throw new ValidacionException("Error: Respuesta invalida. Debe escribir 'si' o 'no'.");
                }
                
                this.cazaRatones = respuesta.equals("si");
                break;
            } catch(ValidacionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Simula el maullido del gato.
     */
    public void maullar() {
        System.out.println("El gato " + getNombre() + " esta maullando: ¡Miau!");
    }

    /**
     * Muestra toda la información del gato, incluyendo características específicas.
     * Sobrescribe el método de la clase padre para incluir información adicional.
     */
    @Override
    public void mostrarInfo() {
        System.out.println("=== DATOS DEL GATO ===");
        super.mostrarInfo();
        System.out.println("¿Caza ratones?: " + (getCazaRatones() ? "Sí" : "No"));
        comer();
        maullar();
        System.out.println("---------------------");
    }
}