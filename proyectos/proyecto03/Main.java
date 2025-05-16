import java.util.Random;
public class Main {
    public class jugador {

    }
    public class monton{
        ListaLigada lista = new ListaLigada();
        }
        Random rand = new Random(2);
        static void barajear(){
            
        }
    }
    public static void main(String[] args) {
        Carta[] mazo = new Carta[96]; 
        
        int indice = 0; 

        for (int a1 = 0; a1 <= 1; a1++) {
            for (int a2 = 0; a2 <= 1; a2++) {
                for (int a3 = 0; a3 <= 1; a3++) {
                    for (int a4 = 0; a4 <= 1; a4++) {
                        for (int a5 = 0; a5 <= 1; a5++) {
                            for (int i = 0; i < 3; i++) {
                                mazo[indice++] = new Carta(a1, a2, a3, a4, a5);
                            }
                        }
                    }
                }
            }
        }


        }
    }
}
