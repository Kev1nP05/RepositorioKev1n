import java.util.Scanner;

public class Animal extends Mensajes{

    private String nombre;
    private int edad;
    private String raza;
    public final Scanner input = new Scanner(System.in);

    //Constructor por defecto
        public Animal() {
        this.nombre = "";
        this.edad = 0;
        this.raza = "";
    }

    //Constructor parametrizado
    public Animal(String nombre, int edad, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    //FUNCION PARA VALIDAR LETRAS
    public boolean soloLetras (String texto){
        return texto != null && !texto.isEmpty() && texto.matches("[a-zA-Z ]+");
    }

    //GETTERS Y SETTERS
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String mensaje) {
        while(true){
            System.out.print(mensaje);
            String texto = input.nextLine();
            if(!soloLetras(texto)){
                System.out.println(errorLetras);
            }else{
                this.nombre = texto;
                break;
            }
        }
        
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(String mensaje) {
        while(true){
            try{
                System.out.print(mensaje);
                int edadT = Integer.parseInt(input.nextLine());
                if(edadT < 0 || edadT > 15){
                    System.out.println("Error: edad invalida - Rango permitido (0 - 15).");
                }else{
                    this.edad = edadT;
                    break;
                }
                
            }catch (NumberFormatException e){
                System.out.println(errorNumeros);
            }
        }
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String mensaje) {
       while(true){
            System.out.print(mensaje);
            String texto = input.nextLine();
            if(!soloLetras(texto)){
                System.out.println(errorLetras);
            }else{
                this.raza = texto;
                break;
            }
        }
    }

    //METODOS
    public  void mostrarInfo(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Raza: " + getRaza());
    }

    public final void comer (){
        System.out.println("La mascota " + getNombre() + " esta comiendo");
    }
    

   
    
}

