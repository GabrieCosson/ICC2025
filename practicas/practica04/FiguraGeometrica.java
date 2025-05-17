public abstract class FiguraGeometrica{
    public String nombre;
    public FiguraGeometrica(String nombre){
        this.nombre = nombre;
    }
    public abstract double area();
    public abstract double perimetro();
    public String toString(){
        return "Figura: " + nombre + ".";
    }
}