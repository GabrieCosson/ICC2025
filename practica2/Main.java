public class Main{
    public static void main(String[] args){
        Reloj reloj = new Reloj(13, 11, 50);
            reloj.ajustarMinuto();
            reloj.ajustaHora();
            reloj.horaMaxima();
           System.out.println(reloj.mostrarHora());
    }
}
