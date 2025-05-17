public class Rectangulo extends FiguraGeometrica{
    public double altura;
    public double base;
    public Rectangulo(double altura, double base){
        super("Rectangulo");
        this.altura= altura;
        this.base = base;
    }
    public double area(){
        return base * altura;
    }
    public double perimetro(){
        return ( 2 * base) + ( 2 * altura);
    }
    public String toString() {
        return super.toString() + String.format("\nBase: %.2f\nAltura: %.2f", altura, base);
    }
}