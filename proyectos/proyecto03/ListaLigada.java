public class ListaLigada{
    class Nodo{
        private Carta elemento;
        private Nodo siguiente;
        public Nodo(Carta elemento){
            this.elemento = elemento;
        }
    }
    public Nodo cabeza;
    static int tamaño;
    public ListaLigada() {
        cabeza = null;
        tamaño = 0;
    }
    public void agregarCarta(Carta carta){
        Nodo agregado = new Nodo(carta);
        if(cabeza ==null){
            cabeza = agregado;
        }else{
           Nodo ubicacion = cabeza;
            while(ubicacion.siguiente != null){
                ubicacion = ubicacion.siguiente;
            }
            ubicacion.siguiente = agregado;
            tamaño++;
        }  
    }
    public Nodo obtenerUltima() {
        if (cabeza == null) return null;
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual;
    }
    public int tamaño() {
        return tamaño;
    }
}
