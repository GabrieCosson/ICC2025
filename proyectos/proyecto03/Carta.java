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
    public int getSueter() { return sueter; }
    public int getLentes() { return lentes; }
    public int getSombrero() { return sombrero; }
    public int getGuantes() { return guantes; }
    public int getBufanda() { return bufanda; }
    
    public int diferenciasCon(Carta otra) {
        int dif = 0;
        if (this.sueter != otra.sueter) dif++;
        if (this.lentes != otra.lentes) dif++;
        if (this.sombrero != otra.sombrero) dif++;
        if (this.guantes != otra.guantes) dif++;
        if (this.bufanda != otra.bufanda) dif++;
        return dif;
    }
    public String toString() {
        return (sueter == 0 ? ANSI_RED + "sueter"  : ANSI_BLUE + "sueter") + 
               (lentes == 0 ? ANSI_GREEN + "lentes"  : ANSI_CYAN + "lentes" ) + 
               (sombrero == 0 ? ANSI_RED + "sombrero" : ANSI_YELLOW + "sombrero" ) + 
               (guantes == 0 ? ANSI_CYAN + "guantes" : ANSI_GREEN + "guantes" ) + 
               (bufanda == 0 ? ANSI_YELLOW + "bufanda" : ANSI_BLUE + "bufanda") + 
               ANSI_RESET;
    }
}