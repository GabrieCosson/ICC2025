import java.io.*;
public class Carta {
    private int sueter;  
    private int lentes;  
    private int sombrero;  
    private int guantes;  
    private int bufanda;  
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m"; //rojo
    public static final String ANSI_GREEN = "\u001B[32m"; //verde
    public static final String ANSI_YELLOW = "\u001B[33m"; //amarillo
    public static final String ANSI_BLUE = "\u001B[34m"; //azul
    public static final String ANSI_CYAN = "\u001B[36m"; //cyan
    public Carta(int sueter, int lentes, int sombrero, int guantes, int bufanda) {
        this.sueter = sueter;
        this.lentes = lentes;
        this.sombrero = sombrero;
        this.guantes = guantes;
        this.bufanda = bufanda;
    }
    public String toString() {
        return (sueter == 0 ? ANSI_RED + "sueter" + ANSI_RESET : ANSI_BLUE + "sueter" + ANSI_RESET) + 
               (lentes == 0 ? ANSI_GREEN + "lentes" + ANSI_RESET : ANSI_CYAN + "lentes" + ANSI_RESET) + 
               (sombrero == 0 ? ANSI_RED + "sombrero" + ANSI_RESET : ANSI_YELLOW + "sombrero" + ANSI_RESET) + 
               (guantes == 0 ? ANSI_CYAN + "guantes" + ANSI_RESET : ANSI_GREEN + "guantes" + ANSI_RESET) + 
               (bufanda == 0 ? ANSI_YELLOW + "bufanda" + ANSI_RESET : ANSI_BLUE + "bufanda" + ANSI_RESET);
    }
    public int diferenciasCon(Carta otra) {
        int dif = 0;
        if (this.sueter != otra.sueter) dif++;
        if (this.lentes != otra.lentes) dif++;
        if (this.sombrero != otra.sombrero) dif++;
        if (this.guantes != otra.guantes) dif++;
        if (this.bufanda != otra.bufanda) dif++;
        return dif;
    }
}
