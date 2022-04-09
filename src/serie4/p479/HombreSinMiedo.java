package serie4.p479;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=479
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO Envío 623355
 *
 */

/**
 * Tipo enumerado con las 4 posibles direcciones de recorrido en la matriz
 * 
 * @author zeus
 *
 */
enum Direcciones {
	IZQUIERDA, DERECHA, ARRIBA, ABAJO
}

public class HombreSinMiedo {

	// Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector = new Scanner(System.in);

	/**
	 * Método para averiguar la distancia entre una posición de la habitación y la
	 * primera celda con 'X' avanzando en una de las 4 direcciones posibles, según
	 * el tipo Direcciones
	 * 
	 * @param habitacion matriz 2-D con los valores de cada celda de la habitación
	 * @param pos_x      fila en la que nos situamos inicialmente
	 * @param pos_y      columna en la que estamos situados inicialmente
	 * @param direccion  dirección de consulta desde (pos_x,pos_y), es un valor de
	 *                   Direcciones
	 * @return distancia en la dirección pedida desde la posición inicial hasta la
	 *         primera celda en que encontremos 'X' o bien -1 si llegamos al final
	 *         de la habitación sin haber encontrado ninguna 'X'
	 */
	static int calcularDistancia(char[][] habitacion, int pos_x, int pos_y, Direcciones direccion) {

		int distancia = -1;
		int x = pos_x;
		int y = pos_y;

		try {
			switch (direccion) {
			case IZQUIERDA:
				// recorrido en filas, hacia el comienzo
				do {
					y--;
				} while (habitacion[x][y] != 'X');
				// cuando salgamos del bucle, calculamos la distancia
				distancia = pos_y - y;
				break;

			case DERECHA:
				// recorrido en filas, hacia el final
				do {
					y++;
				} while (habitacion[x][y] != 'X');
				// cuando salgamos del bucle, calculamos la distancia
				distancia = y - pos_y;
				break;

			case ARRIBA:
				// recorrido en columnas, hacia arriba
				do {
					x--;
				} while (habitacion[x][y] != 'X');
				// cuando salgamos del bucle, calculamos la distancia
				distancia = pos_x - x;
				break;

			case ABAJO:
				// recorrido en columnas, hacia abajo
				do {
					x++;
				} while (habitacion[x][y] != 'X');
				// cuando salgamos del bucle, calculamos la distancia
				distancia = x - pos_x;
				break;

			} // fin del case

		} catch (IndexOutOfBoundsException e) {
			// si se produce la excepción, no hemos encontrado 'X' y nos hemos salido del
			// array
			// no hacemos nada, se devolverá -1

		}

		return distancia;
	} //fin del método
	

	public static void main(String[] args) {

		String leido; // última línea leído
		String[] trozos; // array de cadenas para guardar los trozos en que dividimos la línea
		int n_filas, n_col; // dimensiones de la habitación
		int n_queries; // número de consultas que vamos a procesar
		int pos_x, pos_y; // coordenadas de la posición donde nos encontramos al lanzar la consulta
		Direcciones direccion; // dirección de avance en la consulta, desde la posición inicial
		char[][] habitacion; // matriz 2D de caracteres con los valores de cada celda/posición de la
								// habitación

		// CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial,
		// que ignoraremos
		boolean terminar = false; // condición de terminación

		// leemos mientras haya más líneas y no se produzca la condición de terminación
		while (!terminar && lector.hasNext()) {
			leido = lector.nextLine();

			// hay que comprobar si llegamos a la condición de terminación
			if (!(leido.trim().equals("0 0"))) {
				// procesamiento
				// la primera línea contiene las dimensiones de la habitación
				trozos = leido.split("\\s+");
				n_filas = Integer.parseInt(trozos[0]);
				n_col = Integer.parseInt(trozos[1]);

				// ahora hemos de dimensionar y poblar la matriz con la descripción de la
				// habitación

				habitacion = new char[n_filas][n_col];
				// hemos de leer una línea por fila y trocearla
				for (int i = 0; i < n_filas; i++) {
					leido = lector.nextLine();
					for (int j = 0; j < n_col; j++) {
						habitacion[i][j] = leido.charAt(j);
					}

				} // fin del proceso de lectura
					// a continuación leemos el número de consultas que vamos a realizar
				n_queries = Integer.parseInt(lector.nextLine().trim());
				// y procesamos cada consulta;
				for (int k = 0; k < n_queries; k++) {
					leido = lector.nextLine();
					trozos = leido.split("\\s+");
					pos_x = Integer.parseInt(trozos[0]);
					pos_y = Integer.parseInt(trozos[1]);
					direccion = Direcciones.valueOf(trozos[2]);
					/*
					 * pos_x y pos_y los enviamos disminuidos en 1 pues los arrays comienzan en 0
					 */
					int distancia = calcularDistancia(habitacion, pos_x - 1, pos_y - 1, direccion);
					// mostramos la distancia desde la posición al primer 'X' encontrado
					System.out.println(distancia >= 0 ? distancia : "NINGUNO");

				}

				// salida de resultados, entre caso y caso
				System.out.println("---");
			} else {
				// activamos la condición de terminación
				terminar = true;
			}
		} // fin del while

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}// fin de la clase
