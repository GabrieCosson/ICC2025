import java.util.Scanner;

public class Main {
    
    public static String descifraNulo(String texto, int y) {
        Scanner scanner = new Scanner(texto); 
        String mensaje = ""; 

        while (scanner.hasNext()) {
            String palabra = scanner.next();
            mensaje += palabra.charAt(y - 1); 
            
        }
        scanner.close(); 
        return mensaje; 
    }
    public static String descifraNulo2(String texto) {
        Scanner scanner = new Scanner(texto); 
        String mensaje = ""; 
        int i = 0;
        while ((texto.charAt(texto.length() - (i+1)) == ' ')){
            i++;
        }
        while (scanner.hasNext()) {
            String palabra = scanner.next();
            mensaje += palabra.charAt(i-1); 
            
        }

        scanner.close(); 
        return mensaje; 
    }
    public static boolean contieneNombre (String mensaje, String nombre){
        int j = 0;
        String resultado = "";
        for(int i = 0; i < mensaje.length(); i++ ){
            if (mensaje.toLowerCase().charAt(i) == nombre.toLowerCase().charAt(j)) {
                resultado += mensaje.toLowerCase().charAt(i);
                j++;
                if (j == nombre.length()) {
                    break;
                }
                
                }
            }
        return resultado.equals(nombre.toLowerCase());
    }
    public static String descifraPalabrasMarcadas (String m, String e){
        Scanner scanner = new Scanner(m); 
        Scanner scanner2 = new Scanner(e); 
        String mensaje = ""; 

        while (scanner.hasNext()) {
            String palabra = scanner.next();
            String palabra2 = scanner2.next();
            if (!(palabra.equals(palabra2))) {
                mensaje += (palabra +' ');
            }  
        }

        scanner.close(); 
        scanner2.close();
        return mensaje; 
    }
    public static String descifraPalabrasMarcadas2 (String m, String e){
        String mensaje = "";
        if (m.length() == e.length()) {
            for(int i = 0; i < m.length(); i++ ){
                if (m.charAt(i) != e.charAt(i)) {
                    mensaje += m.charAt(i);
                }
            }
        }
        return mensaje;    
    }
    public static void main(String[] args) {
        String texto = "Una niña destruye el remo, toma agua lentamente, estupida ";
        String texto2 = "Hola rusia, mi reto es naco, ia.";   
        String texto3 = "Hola como estas, me llamo Gabriel";
        String texto4 = "Hello como estas, me llamo gabriel"; 
        String texto5 = "Juan123, esta en el: ITAM";
        String texto6 ="Holi Susia, ni rito es taco, es.";
        String texto7 = "Mas agar, nunca mal";
        String nombre = "Juanita";
        System.out.println(Main.descifraNulo(texto7, 2)); 
        System.out.println(Main.descifraNulo2(texto)); 
        System.out.println(Main.descifraPalabrasMarcadas2(texto2,texto6));
        System.out.println(Main.descifraPalabrasMarcadas(texto3,texto4));
        System.out.println(Main.contieneNombre(texto5, nombre));

    }
}
