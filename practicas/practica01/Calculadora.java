import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args){
    int opcion;
    double n1, n2;
    double result;
    String texto;
    Scanner sc = new Scanner(System.in);
    System.out.println("CALCULADORA \n ");
    System.out.println("Escoge una de las siguientes operacione \n \n 1.-Suma \n 2.-Multiplicacion \n 3.-Division \n 4.-Gritar");
    opcion = sc.nextInt();
    sc.nextLine();
    if (opcion == 4) {
        System.out.println("Ingresa el texto");
        texto = sc.nextLine();
        System.out.println(texto.toUpperCase() + "!!");

    } else {
        System.out.println("Ingresa el primer numero");
        n1 = sc.nextDouble();
        System.out.println("Ingresa el segundo numero");
        n2 = sc.nextDouble();    
        if (opcion == 1){
            result = n1 + n2;
            System.out.println(result);
            }
        
        else if (opcion == 2){
            result = n1 * n2;
            System.out.println(result);
            }

        else if (opcion == 3){
            result = n1 / n2;
            System.out.println(result);
            }
        else
            System.out.println("ERROR");
        }
    }
    
    
}


