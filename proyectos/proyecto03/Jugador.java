import java.util.concurrent.TimeUnit;
public class Jugador extends Thread {
    private String nombre;
    private ListaLigada elecciones;
    private ListaLigada puntosAcumulados;
    private boolean esHumano;
    private Carta[] cartasDisponibles;
    private boolean turnoActivo;
    private boolean rondaTerminada;
    public final Object lock = new Object();
    public Jugador(String nombre, boolean esHumano) {
        this.nombre = nombre;
        this.elecciones = new ListaLigada();
        this.puntosAcumulados = new ListaLigada();
        this.esHumano = esHumano;
        this.turnoActivo = false;
        this.rondaTerminada = false;
    }
    public void nuevaRonda(Carta cartaVisible) {
        this.elecciones = new ListaLigada();
        this.elecciones.agregarCarta(cartaVisible);
    }
    public boolean agregarCarta(Carta carta) {
        Carta ultima = elecciones.obtenerUltima().elemento;
        if (ultima.diferenciasCon(carta) <= 1) {
            elecciones.agregarCarta(carta);
            return true;
        }
        return false;
    }
    public boolean puedeContinuar(Carta[] cartasDisponibles) {
        if (elecciones.estaVacia()) return false;
        Carta ultima = elecciones.obtenerUltima().elemento;
        for (Carta c : cartasDisponibles) {
            if (c != null && ultima.diferenciasCon(c) <= 1) {
                return true;
            }
        }
        return false;
    }
    public void setCartasDisponibles(Carta[] cartas) {
        this.cartasDisponibles = cartas;
    }
    public void setTurnoActivo(boolean activo) {
        this.turnoActivo = activo;
    }
    public boolean isTurnoActivo() {
        return turnoActivo;
    }
    public void terminarRonda() {
        this.rondaTerminada = true;
    }
    @Override
    public void run() {
        while (!rondaTerminada) {
            synchronized (lock) {
                if (turnoActivo && !esHumano) {
                    // jugador IA 
                    Carta ultima = elecciones.obtenerUltima().elemento;
                    Carta seleccionada = null;
                    // Buscar una carta
                    for (Carta c : cartasDisponibles) {
                        if (c != null && ultima.diferenciasCon(c) <= 1) {
                            seleccionada = c;
                            break;
                        }
                    }
                    if (seleccionada != null) {
                        agregarCarta(seleccionada);
                        System.out.println(nombre + " ha tomado la carta: " + seleccionada);
                    } else {
                        System.out.println(nombre + " no puede continuar su secuencia.");
                        terminarRonda();
                    }
                    turnoActivo = false;
                    lock.notifyAll(); // Notificar que el turno ha terminado
                }
                try {
                    if (!turnoActivo && !rondaTerminada) {
                        lock.wait(); // Esperar hasta que sea su turno
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void iniciarTurno(Carta[] cartas) {
        synchronized (lock) {
            this.cartasDisponibles = cartas;
            this.turnoActivo = true;
            lock.notifyAll();
        }
    }
    public String getNombre() { return nombre; }
    public ListaLigada getElecciones() { return elecciones; }
    public int getPuntos() { return puntosAcumulados.tamaño(); }
    public boolean esHumano() { return esHumano; }
}