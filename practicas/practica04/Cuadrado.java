public class Cuadrado extends FiguraGeometrica{
    public double lado;
    public Cuadrado(double lado){
        super("Cuadrado");
        this.lado = lado;
    }
    public double area(){
        return lado * lado;
    }
    public double perimetro(){
        return lado * 4;
    }
    public String toString() {
        return super.toString() + String.format("\nLado: %.2f", lado);
    }
}