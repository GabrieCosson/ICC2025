public class ListaLigada{
    class Nodo{
        private Object elemento;
        private Nodo siguiente;
        //referencia al nodo siguiente
        public Nodo(Object elemento){
            this.elemento = elemento;
        }
    }
    Nodo cabeza;
    static int tamaño = 0;
    public ListaLigada(){
        cabeza = null;
        tamaño = 0;
        //lista vacia y variable de clase que indica el tamaño
    }
    public void insertarElemento(int elemento){
        Nodo nuevo = new Nodo (elemento);
        if (cabeza == null){
            cabeza = nuevo;
           tamaño++;
        }else{
            Nodo ubicacion = cabeza;
            while(ubicacion.siguiente != null){
                ubicacion = ubicacion.siguiente;
            }
            ubicacion.siguiente = nuevo;
            tamaño++;
        }
        //metodo insertar siempre ubicandose al final el nuevo y agregando valor a la referencia del tamaño
    }
    public void eliminarElemento (int elemento){
        if(cabeza == null){
            return;
        }
        //lista vacia
        if(cabeza.elemento == elemento){
            cabeza = cabeza.siguiente;
            tamaño--;
            return;
        }
        //lista con un solo elemento o eliminar el primero
        Nodo ubicacion = cabeza;
        while(ubicacion.siguiente != null && ubicacion.siguiente.elemento != elemento){
            ubicacion = ubicacion.siguiente;
        }
        if(ubicacion.siguiente != null){
            ubicacion.siguiente = ubicacion.siguiente.siguiente;
            tamaño--;
        }
        //Se elimina el dato ubicandolo con la referencia y aseguramos que no sea vacio para evitar NullPointerException
    }
    public String toString(){
        if(cabeza == null){
            return "La lista esta vacía.";
        }else{
            Nodo ubicacion = cabeza;
            String visual = Integer.toString(ubicacion.elemento);
            while(ubicacion.siguiente != null){
                visual += "->" + Integer.toString(ubicacion.siguiente.elemento);
                ubicacion = ubicacion.siguiente;
            }
            visual += "-> null";
            return visual;
        }
    }
}
