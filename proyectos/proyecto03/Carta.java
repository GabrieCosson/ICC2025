public class Carta {
    private int feliz;  
    private int lentes;  
    private int sombrero;  
    private int alto;  
    private int cejas;  


    public Carta(int a1, int a2, int a3, int a4, int a5) {
        this.feliz = a1;
        this.lentes = a2;
        this.sombrero = a3;
        this.alto = a4;
        this.cejas = a5;
    }
    @Override
    public String toString() {
        return feliz + "" + lentes + "" + sombrero + "" + alto + "" + cejas;
    }
    
    public int getfeliz() { return feliz; }
    public int getlentes() { return lentes; }
    public int getsombrero() { return sombrero; }
    public int getalto() { return alto; }
    public int getcejas() { return cejas; }


}
