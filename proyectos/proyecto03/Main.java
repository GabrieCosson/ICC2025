import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Main extends Thread {
    private static final int TOTAL_CARTAS = 96;
    private static final int CARTAS_EN_JUEGO = 30;
     private static final int CARTAS_POR_JUGADOR = 1;
    private static final int MAX_JUGADORES = 5;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(12345);
        // Crear el mazo de cartas
        Carta[] mazo = new Carta[TOTAL_CARTAS];
        int index = 0;
        for (int sueter = 0; sueter < 2; sueter++) {
            for (int lentes = 0; lentes < 2; lentes++) {
                for (int sombrero = 0; sombrero < 2; sombrero++) {
                    for (int guantes = 0; guantes < 2; guantes++) {
                        for (int bufanda = 0; bufanda < 2; bufanda++) {
                            for (int copia = 0; copia < 3; copia++) {
                                mazo[index++] = new Carta(sueter, lentes, sombrero, guantes, bufanda);
                            }
                        }
                    }
                }
            }
        }
        // Barajar las cartas
        for (int i = 0; i < mazo.length; i++) {
            int r = i + random.nextInt(mazo.length - i);
            Carta temp = mazo[r];
            mazo[r] = mazo[i];
            mazo[i] = temp;
        }
        int numIA = 3;//no cambiar a valores mayores a 5
        int totalJugadores = numIA + 1;
        Jugador[] jugadores = new Jugador[totalJugadores];
        // Datos del jugador
        System.out.print("Ingresa tu nombre: ");
        String nombreHumano = scanner.nextLine();
        jugadores[0] = new Jugador(nombreHumano, true);
        // Datos del jugador Ia de manera iterativa
        for (int i = 1; i < totalJugadores; i++) {
            jugadores[i] = new Jugador("IA-" + i, false);
        }
        // hilo
        for (int i = 1; i < totalJugadores; i++) {
            jugadores[i].start();
        }
        // Preparar juego
        Carta[] cartasEnJuego = new Carta[CARTAS_EN_JUEGO];
        System.arraycopy(mazo, 0, cartasEnJuego, 0, CARTAS_EN_JUEGO);
        int siguienteCarta = CARTAS_EN_JUEGO;
        // Repartir cartas iniciales
        for (Jugador jugador : jugadores) {
            Carta cartaInicial = mazo[siguienteCarta++];
            jugador.nuevaRonda(cartaInicial);
            System.out.println(jugador.getNombre() + " recibe carta inicial: " + cartaInicial);
        }
        // Jugar rondas
       boolean juegoTerminado = false;
        while (!juegoTerminado) {
            System.out.println("\nNueva Ronda");
            mostrarCartasEnJuego(cartasEnJuego);
            for (Jugador jugador : jugadores) {
                System.out.println("\nTurno de " + jugador.getNombre());
                System.out.println("Tu última carta: " + jugador.getElecciones().obtenerUltima().elemento);
                if (jugador.esHumano()) {
                    // Turno del jugador humano
                    manejarTurnoHumano(jugador, cartasEnJuego, scanner);
                } else {
                    // Turno de la IA
                    jugador.iniciarTurno(cartasEnJuego);
                    // Esperar a que la IA complete su turno
                    synchronized (jugador.lock) {
                        while (jugador.isTurnoActivo()) {
                            try {
                                jugador.lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            // Verificar si hay suficientes cartas para otra ronda
            if (siguienteCarta + totalJugadores > mazo.length) {
                juegoTerminado = true;
                System.out.println("\nÚLTIMA RONDA");
            }
            // Reemplazar cartas tomadas
            reemplazarCartas(cartasEnJuego, mazo, siguienteCarta);
            siguienteCarta += contarNulls(cartasEnJuego);
        }
        terminarJuego(jugadores);
    }
    private static void manejarTurnoHumano(Jugador jugador, Carta[] cartasEnJuego, Scanner scanner) {
        System.out.println("1. Tomar una carta");
        System.out.println("2. Terminar ronda");
        System.out.print("Elige una opción: ");
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            System.out.print("Elige el índice de la carta (0-" + (cartasEnJuego.length-1) + "): ");
            int indiceCarta = scanner.nextInt();
            
            if (indiceCarta >= 0 && indiceCarta < cartasEnJuego.length && cartasEnJuego[indiceCarta] != null) {
                if (jugador.agregarCarta(cartasEnJuego[indiceCarta])) {
                    cartasEnJuego[indiceCarta] = null;
                    System.out.println("Carta añadida a tu secuencia.");
                } else {
                    System.out.println("No puedes tomar esa carta, no cumple las reglas.");
                }
            } else {
                System.out.println("Índice inválido o carta ya tomada.");
            }
        } else {
            if (!jugador.puedeContinuar(cartasEnJuego)) {
                System.out.println("Has terminado tu turno correctamente.");
                jugador.terminarRonda();
            } else {
                System.out.println("¡Error! Aún hay cartas que puedes tomar.");
            }
        }
    }
    private static void terminarJuego(Jugador[] jugadores) {
        System.out.println("\n=== FIN DEL JUEGO ===");
        mostrarPuntuaciones(jugadores);
        // Detener hilos de jugadores IA
        for (Jugador jugador : jugadores) {
            if (!jugador.esHumano()) {
                jugador.terminarRonda();
                synchronized (jugador.lock) {
                    jugador.lock.notifyAll();
                }
            }
        }
    }
    private static void mostrarCartasEnJuego(Carta[] cartas) {
        System.out.println("\nCartas disponibles:");
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != null) {
                System.out.println(i + ": " + cartas[i]);
            }
        }
    }
    
    private static void reemplazarCartas(Carta[] cartasEnJuego, Carta[] mazo, int siguienteCarta) {
        for (int i = 0; i < cartasEnJuego.length; i++) {
            if (cartasEnJuego[i] == null && siguienteCarta < mazo.length) {
                cartasEnJuego[i] = mazo[siguienteCarta++];
            }
        }
    }
    
    private static int contarNulls(Carta[] cartas) {
        int count = 0;
        for (Carta c : cartas) {
            if (c == null) count++;
        }
        return count;
    }
    
    private static void mostrarPuntuaciones(Jugador[] jugadores) {
        int maxPuntos = 0;
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + ": " + jugador.getPuntos() + " puntos");
            if (jugador.getPuntos() > maxPuntos) {
                maxPuntos = jugador.getPuntos();
            }
        }
        // Determinar ganador(es)
        System.out.print("\nGanador(es): ");
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntos() == maxPuntos) {
                System.out.print(jugador.getNombre() + " ");
            }
        }
        System.out.println("con " + maxPuntos + " puntos!");

    }
}