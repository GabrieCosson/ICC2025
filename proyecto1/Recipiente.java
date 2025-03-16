public class Recipiente implements ServiciosRecipiente{

    public double radio;
    public double altura;
    public double capacidadTotal;
    public double cantidadLiquido;
    public Recipiente(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        this.capacidadTotal = 3.14159 * altura * radio * radio;  
        this.cantidadLiquido = 0; 
    }
    public double capacidad(){
        return (capacidadTotal);
    }
    public double capacidadRestante(){
        double volumenRestante = capacidadTotal - cantidadLiquido;
        return volumenRestante
    }
    public boolean estaVacio(){
        return (volumenRestante == 0);

    }
    public boolean estaLleno(){
        return(capacidadTotal == cantidadLiquido);

    }
    public double rellena(double cantidad){
        cantidadLiquido += cantidad;
        if (cantidadLiquido > capacidadTotal) {
            double resultado = cantidadLiquido - capacidadTotal;
            cantidadLiquido = capacidadTotal;
            return(resultado);
            
        } else {
            return 0;
        }

    }
    public double vacia(){
        double resultado2 = cantidadLiquido;
        cantidadLiquido = 0;
        return resultado2;
    }
    public void vierte(Recipiente otro){

    }
    public boolean mismasDimensiones(Recipiente otro){
        return true;
    }
    public boolean mismaCapacidad(Recipiente otro){
        return true;
    }
    public boolean contieneMas(Recipiente otro){
        return true;
    }
    public boolean cabeMas(Recipiente otro){
        return true;
    }
    public Recipiente creaContenedorJusto(){


    }
    public String muestra(){
        return("Nuestro recipiente tiene un: \n Radio de " + radio + "centimetros, y una altura de " + altura + "centimetros. \n Una capacidad total de " + capacidadTotal + "mililitros. \n Y contiene " + cantidadLiquido + "mililitros actualmente.");
    }

}
