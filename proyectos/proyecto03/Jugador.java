public class Jugador{
    private String nombre;
    private ListaLigada elecciones;
    private ListaLigada puntosAcumulados;
    private boolean modoDeJugador;
    public Jugador(String nombre, boolean modoDeJugador){
        this.nombre = nombre;
        this.elecciones = new ListaLigada();
        this.puntosAcumulados = new ListaLigada();
        this.modoDeJugador = modoDeJugador;
    }
    public void nuevaRonda(Carta primerCarta){
        this.elecciones = new ListaLigada();
        this.elecciones.agregarCarta(primerCarta);
    }
}