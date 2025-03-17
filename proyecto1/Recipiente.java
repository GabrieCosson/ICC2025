public class Recipiente implements ServiciosRecipiente{
    public double radio;
    public double altura;
    public double cantidadLiquido;
    public double a, b, c, d, e, f, g;
    public boolean h, i, j, k, l, m, n;
    //metodo constructor, inicialzar datos
    public Recipiente(double radio, double altura, double cantidadLiquido){
         this.radio=radio;
         this.altura=altura;
         this.cantidadLiquido=cantidadLiquido;
    }
    public double capacidad(){
         a = Math.PI * altura * radio * radio;
         return a;
    }
    public double capacidadRestante(){
         b = capacidad() - cantidadLiquido; 
         return b;
    }
    public boolean estaVacio(){
         h = capacidadRestante() == 0;
         return h;
    }
    public boolean estaLleno(){
         i = capacidad() == cantidadLiquido;
         return i;
    }
    public double rellena(double cantidad){
        cantidadLiquido += cantidad;
         if (cantidadLiquido > capacidad()){
             double volumenRestante = cantidadLiquido - capacidad();
             return volumenRestante;
        } else {
             return cantidadLiquido;
        }
    }
    public double vacia(){
         cantidadLiquido = 0;
         return cantidadLiquido;
    }
    public void vierte(Recipiente otro){
         c = otro.capacidadRestante();
         if (c >= this.cantidadLiquido){
             otro.cantidadLiquido = otro.cantidadLiquido + this.cantidadLiquido;
             this.cantidadLiquido = 0.0;
         } else {
             otro.cantidadLiquido = otro.capacidad();
             this.cantidadLiquido = (this.cantidadLiquido - c );
         }
    }
    public boolean mismasDimensiones(Recipiente otro){
         j = (this.radio == otro.radio && this.altura == otro.altura); 
         return j;
    }
    public boolean mismaCapacidad(Recipiente otro){
         k = this.capacidad() == otro.capacidad();
         return k;
    }
    public boolean contieneMas(Recipiente otro){
         l = this.cantidadLiquido > otro.cantidadLiquido;
         return l;
    }
    public boolean cabeMas(Recipiente otro){
         m = this.capacidadRestante() > otro.capacidadRestante();
         return m;
    }
    public Recipiente creaContenedorJusto(){
         d = (this.cantidadLiquido) / (Math.PI * this.radio *this.radio);
         return new Recipiente(this.radio, d, this.cantidadLiquido);
    }
    public String muestra(){
         return("El recipiente tiene un radio de " + radio + "cm, y una altura de " + altura + "cm.\nUna capacidad total de " + capacidad() + "cm³ y contiene " + cantidadLiquido + "cm³ actualmente.");
    }
    public static void main(String[] args){
        //radio, altura, 
         Recipiente re1 = new Recipiente(10, 20, 4000);
         Recipiente re2 = new Recipiente(20, 5, 3000);
             System.out.println("El recipiente cuenta con los siguientes servicios:");
             System.out.println("\nCuenta con las siguientes especificaciones el recipiente principal:");
             System.out.println(re1.muestra());
             System.out.println("\nCuenta con las siguientes especificaciones el recipiente secundario:");
             System.out.println(re2.muestra());
             System.out.println("\nEl recipiente se le puede ingresar hasta " + re1.capacidadRestante() + " cm³ de liquido extra hasta llenarse.");
             System.out.println("\nTambien sabemos lo siguiente:");
             System.out.println("Esta vacio:"+ re1.estaVacio());
             System.out.println("Esta lleno:"+ re1.estaLleno());
             System.out.println("\nPodemos rellenar el recipiente y exhibir su cantidad o dar el excedente, en este caso se rellena 500 cm³ de liquido.");
             System.out.println("Tendra " + re1.rellena(500) + " cm³ cantidad de liquido el recipiente.");
             System.out.println("\nSe puede vaciar y terminar con una cantidad de " + re1.vacia() + " cm³ de liquido en el recipiente.");
             System.out.println("\nPodemos vertir el liquido del recipiente principal en el secundario y guardar el excendente en el principal, \ndando asi nuevos valores para cada recipiente:");
             re1.rellena(4000);
             re1.vierte(re2);
             System.out.println(re1.muestra());
             System.out.println(re2.muestra());
             re1.vacia();
             re2.vacia();
             re1.rellena(4000);
             re2.rellena(3000);
             System.out.println("\nPodemos comparar algunos parametros del recipiente principal con el recipiente secundario, esto de la forma:");
             System.out.println("Mismas dimensiones:" + re1.mismasDimensiones(re2));
             System.out.println("Misma capacacidad:" + re1.mismaCapacidad(re2));
             System.out.println("Contiene mas liquido:" + re1.contieneMas(re2));
             System.out.println("Cabe mas liquido:" + re1.cabeMas(re2));
             System.out.println("\nPodemos dar un nuevo recipiente que su capacidad sea igual a la cantidad de liquido puesto, \nconservando del recipiente principal el radio pero con nueva altura, demos este recipiente:");
             Recipiente re3 = re1.creaContenedorJusto();
             System.out.println(re3.muestra());
    }       
}
