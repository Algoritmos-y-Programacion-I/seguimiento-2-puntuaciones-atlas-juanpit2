// Análisis (completar)
// Descripción del programa (Registrar puntaje):El programa debe permitir registrar los puntajes, cantidad de jugadores y rondas a juagar
// Entradas: cantidad de jugadores (int),cantidad de rondas a jugar (int), puntaje(double)
// Salidas:puntaje total (double),  jugador con la puntuación total más alta (double), puntaje promedio (double)
// Ejemplo:


package ui; // No olvidar especificar el paquete / carpeta de nuestro programa

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {

	// Declaración del Escaner que nos ayudará en todo el programa
	private Scanner escaner;

	// Declaración de nuestras constantes a utilizar


	private AtlasPuntuaciones() {
		escaner = new Scanner(System.in);
	}
	
	
	public void run()
	{
		// Declaracion de todas las variables a usar en el programa
	 // Declaracion de todas las variables a usar en el programa
        int numjugadores, numrondas;
		int cantidad = 3;

        System.out.println("Ingrese el numero de jugadores.");
        numjugadores = escaner.nextInt();
        int[] puntaje = new int[numjugadores];
		int[] totalpuntaje= new int [cantidad];

        System.out.println("Ingrese el numero de rondas.");
        numrondas = escaner.nextInt();

        for(int i=0; i<numjugadores; i++){
            for(int j=0; j<numrondas; j++){
                System.out.println("Ingrese el puntaje del jugador " + (i+1) + " en la ronda "+ (j+1));
                puntaje[i] = escaner.nextInt();
				
        	}
        
			System.out.println("Resultados del torneo");
			double sumapuntaje;
			int suma=0;
			for(int k = 0; k < puntaje.length-1; k++) {
				sumapuntaje = puntaje[k] + puntaje[k];
				double promedio= sumapuntaje/numrondas;
			
				System.out.println("Jugador 1 - Puntaje Total: "+ sumapuntaje+ ", Promedio" + promedio);
				
				
			}
 
        }
		

		

		 }
     

	

	public static void main(String[] args) {
		AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
		mainApp.run();
	}

	/**
	 * Descripción: El método calcularSumaTotal permite ...
	 * @param int[] numeros
	 * @return 
	 */
    public int calcularSumaTotal(int[] numeros) {
        return 0;
    }

	/**
	 * Descripción: El método calcularPromedio permite ...
	 * @param int[] numeros
	 * @return 
	 */
    public double calcularPromedio(int[] numeros) {
         return 0;
    }

	/**
	 * Descripción: El método encontrarMayor permite ...
	 * @param double[] numeros
	 * @return 
	 */
   public static int puntuacionAlta(int[] jugadores) {
        int mayor = 0;
        int jugadorGanador = 1; 
        for(int i = 0; i < jugadores.length; i++) {
            if(jugadores[i] > mayor) {
                mayor = jugadores[i];
                jugadorGanador = i + 1; 
            }
        }
        return jugadorGanador;
    }

	

	
}