public class Main{
    public static void main(String[]args){
        Triangulo triangulo0 = new Triangulo(3.0, 4.0, 5.0);
        Rectangulo rectangulo0 = new Rectangulo(5.0, 4.0);
        Cuadrado cuadrado0 = new Cuadrado(5.0);
        FiguraGeometrica cuadrado1 = new Cuadrado(6.0);
        System.out.println(triangulo0);
        triangulo0.area();
        System.out.println("Área: " + triangulo0.area() + "\nPerímetro: " + triangulo0.perimetro());
        System.out.println(rectangulo0);
        System.out.println("Área: " + rectangulo0.area() + "\nPerímetro: " + rectangulo0.perimetro());
        System.out.println(cuadrado0);
        System.out.println("Área: " + cuadrado0.area() + "\nPerímetro: " + cuadrado0.perimetro());
        System.out.println(cuadrado1);
        System.out.println("Área: " + cuadrado1.area() + "\nPerímetro: " + cuadrado1.perimetro());
    }
}