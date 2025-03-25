import java.util.Scanner;
public class Main{
 

    public static void main(String[] args){
 

        Reloj reloj = new Reloj(0, 0, 0);
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoja un metodo de reiniciar el reloj \n 1.-For \n 2.-While \n 3.-Do-while");
        int opcion = sc.nextInt();
        sc.nextLine();    
        System.out.println("Ingresa la hora");
        reloj.hora = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Ingresa los minutos");
        reloj.minuto = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Ingresa los segundos");
        reloj.segundo = sc.nextInt();
        sc.nextLine(); 
        switch (opcion) {
            case 1:
                for(int i=0; i != reloj.hora + reloj.minuto + reloj.segundo; ){
                    reloj.incrementarSegundos();
                    System.out.println(reloj.mostrarHora()); 
                }
                break;
            case 2:
                while ((reloj.hora != 0 || reloj.minuto != 0 || reloj.segundo != 0)) {
                    reloj.incrementarSegundos();
                    System.out.println(reloj.mostrarHora());
                }
                break;
            case 3:
                do {
                    reloj.incrementarSegundos();
                    System.out.println(reloj.mostrarHora());
                } while ((reloj.hora != 0 || reloj.minuto != 0 || reloj.segundo != 0));
                break;
        
            default:
            System.out.println("Solo hay 3 opciones");
                break;
        }
    }
 

}
