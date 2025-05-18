import java.util.Random;

public class Main {
   
    static class Monton {
        Carta[] mazo;
        int j = 0;
        public void crearmazo() {
            mazo = new Carta[96]; 
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
        
        void barajear() {
            Random rand = new Random(2);
            for (int i = mazo.length - 1; i > 0; i--) {
                int j = rand.nextInt(i + 1);
                Carta temp = mazo[i];
                mazo[i] = mazo[j];
                mazo[j] = temp;
            }
            }
        public Carta sacarcarta(){
            return mazo[j++];
        }
        }
    static class Jugador {
        
    }

    public static void main(String[] args) {
        Monton monton = new Monton(); 
        monton.crearmazo();
        monton.barajear();
        
        for (int i = 0; i < 96; i++) {
            System.out.println(monton.sacarcarta());
        }
    }
}
