// Análisis (completar)
// Descripción del programa * Registrar puntajes:

 /* El programa debe permitir ingresar la cantidad de jugadores y la cantidad de rondas jugadas.
 * Despues se solicita el puntaje de cada jugador en cada ronda. 
 * El puntaje de cada ronda es un número entero entre 0 y 100.
 * 
 * Calcular estdísticas:
 * Para cada uno de los jugadores se debe calcular su puntaje total (la suma de sus puntajes en todas las rondas).
 * Identificar y mostrar el jugador con la puntuación total más alta. Si hay empate, mostrar a cualquiera de los ganadores.
 * Determinar el puntaje promedio de cada jugador en el torneo.
 * 
 * Mostrar resultados: 
 * Listar el puntaje total y promedio de cada jugador.
 * Mostrar el nombre del jugador con la mayor puntuación total.
// Entradas:  Entradas: Cantidad de jugadores (1-5)  (Int) Cantidad de rondas (1-10) (Int) Puntaje de ronda (1-100) (Double)
// Salidas:puntaje total (double),  jugador con la puntuación total más alta (double), puntaje promedio (double)
// Ejemplo:

 * # Ingrese la cantidad de jugadores a participar (máx. 10):
 * > 3
 * # Ingrese por favor la cantidad de rondas a jugar (máx. 5):
 * > 4
 * # Jugador 1 - Puntaje en ronda 0:
 * > 80
 * # Jugador 2 - Puntaje en ronda 0:
 * > 90
 * # Jugador 3 - Puntaje en ronda 0:
 * > 75
 * # Jugador 1 - Puntaje en ronda 1:
 * > 85
 * # Jugador 2 - Puntaje en ronda 1:
 * > 60
 * # Jugador 3 - Puntaje en ronda 1:
 * > 70
 * # Jugador 1 - Puntaje en ronda 2:
 * > 65
 * # Jugador 2 - Puntaje en ronda 2:
 * > 55
 * # Jugador 3 - Puntaje en ronda 2:
 * > 95
 * # Jugador 1 - Puntaje en ronda 3:
 * > 85
 * # Jugador 2 - Puntaje en ronda 3:
 * > 80
 * # Jugador 3 - Puntaje en ronda 3:
 * > 90
 * # Resultados del torneo:
 * # Jugador 1 - Puntaje Total: 315, Promedio: 78
 * # Jugador 2 - Puntaje Total: 285, Promedio: 71
 * # Jugador 3 - Puntaje Total: 330, Promedio: 82
 * # El jugador con la puntuación más alta es: Jugador 3
 * 
 */


package ui; // No olvidar especificar el paquete / carpeta de nuestro programa

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {
    Scanner escaner = new Scanner(System.in);
    int numJugadores, numRondas;
    int[][] puntajes;
    int[] sumaTotal;
    double[] promedio;

    public void run() {
        // Entrada de datos
        numJugadores = pedirEntero("Ingrese el número de jugadores (1-10):", 1, 10);
        numRondas = pedirEntero("Ingrese el número de rondas (1-5):", 1, 5);

        // Inicialización de estructuras
        puntajes = new int[numJugadores][numRondas];
        sumaTotal = new int[numJugadores];
        promedio = new double[numJugadores];

        // Ingresar puntajes con validación
        for (int i = 0; i < numJugadores; i++) {
            for (int j = 0; j < numRondas; j++) {
                puntajes[i][j] = pedirEntero("Ingrese el puntaje del jugador " + (i + 1) + " en la ronda " + (j + 1) + " (0-100):", 0, 100);
            }
            // Calcular suma total y promedio para cada jugador
            sumaTotal[i] = calcularSumaTotal(puntajes[i]);
            promedio[i] = calcularPromedio(puntajes[i]);
        }

        // Determinar el jugador con el mayor puntaje
        int jugadorGanador = puntuacionAlta(sumaTotal);

        // Mostrar resultados
        mostrarResultados();
        System.out.println(" El jugador con el mayor puntaje es el Jugador " + jugadorGanador + " con " + sumaTotal[jugadorGanador - 1] + " puntos.");
    }

    /**
     * Solicita un número entero dentro de un rango específico.
     */
    public int pedirEntero(String mensaje, int min, int max) {
        int valor;
        do {
            System.out.println(mensaje);
            valor = escaner.nextInt();
            if (valor < min || valor > max) {
                System.out.println("Valor inválido. Debe estar entre " + min + " y " + max + ". Inténtelo de nuevo.");
            }
        } while (valor < min || valor > max);
        return valor;
    }

    /**
     * Calcula la suma total de un arreglo de puntajes.
     */
    public int calcularSumaTotal(int[] numeros) {
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return suma;
    }

    /**
     * Calcula el promedio de un arreglo de puntajes.
     */
    public double calcularPromedio(int[] numeros) {
        if (numeros.length == 0) return 0;
        return (double) calcularSumaTotal(numeros) / numeros.length;
    }

    /**
     * Encuentra el jugador con el puntaje más alto.
     */
    public int puntuacionAlta(int[] jugadores) {
        int mayor = jugadores[0];
        int jugadorGanador = 1;
        for (int i = 1; i < jugadores.length; i++) {
            if (jugadores[i] > mayor) {
                mayor = jugadores[i];
                jugadorGanador = i + 1;
            }
        }
        return jugadorGanador;
    }

    /**
     * Muestra los puntajes y promedios de cada jugador.
     */
    public void mostrarResultados() {
        System.out.println("📊 Resultados del torneo:");
        for (int i = 0; i < numJugadores; i++) {
            System.out.println("Jugador " + (i + 1) + " - Puntaje Total: " + sumaTotal[i] + ", Promedio: " + promedio[i]);
        }
    }

    public static void main(String[] args) {
        AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
        mainApp.run();
    }
}