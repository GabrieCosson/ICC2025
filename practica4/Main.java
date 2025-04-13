public class Main{
    public static void main(String[] args){
        ListaLigada lista = new ListaLigada();
        //lista declarada;
        System.out.println("La lista actual es: " + lista );
        lista.insertarElemento(10);
        lista.insertarElemento(11);
        lista.insertarElemento(12);
        lista.insertarElemento(13);
        lista.insertarElemento(14);
        System.out.println("La lista despues de agregar 5 elemento es: " + lista);
        lista.eliminarElemento(10);
        System.out.println("La lista despues de eliminar la cabeza es: " + lista);
        lista.eliminarElemento(12);
        System.out.println("La lista despues de eliminar un elemento albitrario que no es la cabeza ni el final es: " + lista);
    }
}