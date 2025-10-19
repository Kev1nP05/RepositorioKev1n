
public class Perro  extends Animal{

    
    private boolean esGuia;

     //Constructor por defecto
    public Perro() {
        super(); 
        this.esGuia = false;
    }
    
    //Constructor parametrizado
    public Perro(String nombre, int edad, String raza, boolean esGuia) {
        super(nombre, edad, raza);
        this.esGuia = esGuia;
       
    }

    //GETTERS Y SETTERS

    public boolean getEsGuia(){
        return esGuia;
    }

    public void setEsGuia(String mensaje){
        while(true){
            System.out.print(mensaje);
            String  respuesta = input.nextLine().toLowerCase();
            
            if(!respuesta.equals("si") && !respuesta.equals("no")) {
            System.out.print("Respuesta inválida. Escribe [sí o no]\n");
            }else{
             this.esGuia = respuesta.equals("si");
             break;
            }
        
         }
   }

    public void ladrar(){
        System.out.println("El perro " + getNombre() + " esta ladrando");
    }

    

    @Override
    public void mostrarInfo() {
        System.out.println("=== DATOS DEL PERRO ===");
        super.mostrarInfo();
        System.out.println("El perro es guia?: " + (getEsGuia() ? "Sí"  : "No"));
        comer();
        ladrar();
    }


    
}
