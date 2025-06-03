public class ListaLigada{
    class Nodo{
        public Carta elemento;
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
    public boolean estaVacia(){
        return cabeza == null;
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
    public String toString(){
        if(cabeza == null){
            return "La lista esta vacía.";
        }else{
            Nodo ubicacion = cabeza;
            String visual = ubicacion.elemento.toString();
            while(ubicacion.siguiente != null){
                visual += "->" + ubicacion.siguiente.elemento.toString();
                ubicacion = ubicacion.siguiente;
            }
            visual += "-> null";
            return visual;
        }
    }
    public Carta[] toArray() {
        Carta[] array = new Carta[tamaño];
        Nodo actual = cabeza;
        int index = 0;
        while (actual != null) {
            array[index++] = actual.elemento;
            actual = actual.siguiente;
        }
        return array;
    }
}