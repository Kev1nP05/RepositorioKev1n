
public class Gato  extends Animal{

    
    private boolean cazaRatones;
    
     // Constructor por defecto
    public Gato() {
        super(); // Llama al constructor vacío de Animal
        this.cazaRatones = false;
    }
    //Constructor parametrizado
    public Gato(String nombre, int edad, String raza, boolean cazaRatones) {
        super(nombre, edad, raza);
        this.cazaRatones = cazaRatones;
       
    }

    //GETTERS Y SETTERS

    public boolean getCazaRatones(){
        return cazaRatones;
    }

    public void setCazaRatones(String mensaje){
        while(true){
            System.out.print(mensaje);
            String  respuesta = input.nextLine().toLowerCase();

            if(!respuesta.equals("si") && !respuesta.equals("no")) {
            System.out.print("Respuesta inválida. Escribe [sí o no]\n");
            }else{
             this.cazaRatones = respuesta.equals("si");
             break;
            }
       }
    }

    public void maullar(){
        System.out.println("El gato " + getNombre() + " esta maullando");
    }

    

    @Override
    public void mostrarInfo() {
        System.out.println("=== DATOS DEL GATO ===");
        super.mostrarInfo();
        System.out.println("El gato caza ratones?: " + (getCazaRatones() ? "Sí" : "No"));
        comer();
        maullar();
        
    }


    
}
