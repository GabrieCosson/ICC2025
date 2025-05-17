public class Triangulo extends FiguraGeometrica{
    public double lado0;
    public double lado1;
    public double lado2;
    public double altura;
    public Triangulo(double lado0, double lado1, double lado2){
        super("Triangulo");
        this.lado0 = lado0;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    public double area(){
        double area = 0;
        while(area == 0){
            double s = (lado0 + lado1 + lado2)/2;
            area = Math.sqrt(s * (s-lado0) * (s-lado1) * (s-lado2));
            altura = (area * 2)/lado0;
            return area;
        }
        return area;
    }
    public double perimetro(){
        return lado0 + lado1 + lado2;
    }
    public String toString() {
        double base = lado0;
        double area = 0;
        while(area == 0){
            double s = (lado0 + lado1 + lado2)/2;
            area = Math.sqrt(s * (s-lado0) * (s-lado1) * (s-lado2));
            altura = (area * 2)/lado0;
            return super.toString() + String.format("\nLados: %.2f, %.2f, %.2f\nBase: %.2f\nAltura: %.2f", lado0, lado1, lado2, base, altura);
            }
        return super.toString() + String.format("\nLados: %.2f, %.2f, %.2f\nBase: %.2f\nAltura: %.2f", lado0, lado1, lado2, base, altura);
    }
}