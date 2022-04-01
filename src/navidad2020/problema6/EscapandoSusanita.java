package navidad2020.problema6;

import java.util.Scanner;

/**
 * Esqueleto de programa para resolver supuestos del concurso AceptaElReto
 * Tipo1: La primera línea indica el número de casos de prueba URL del Problema:
 * https://www.aceptaelreto.com/problem/statement.php?id=581 URL del Juez en
 * Línea https://www.aceptaelreto.com/problem/send.php?id=581 Ejecución desde
 * consola: >>> java paquete.Clase <ruta/sample.in > ruta/sample.res >>> diff
 * sample.out sample.res // para comprobar las diferencias Aceptado por Juez en
 * Línea: Envío 617108
 */

public class EscapandoSusanita {

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);

	/**
	 * Método que genera la sub-lista con los índices de los amigos que aún no han
	 * conseguido escapar
	 * 
	 * @param amigos      lista original de amigos. Es booleana, indicando para cada
	 *                    amigo si ha podido escapar -true- o no -false-
	 * @param noEscapados número de amigos en la lista que no han escapado (con
	 *                    valor false)
	 * @param comienzo    posición del primer amigo que no ha escapado, y donde
	 *                    empezamos a generar la sublista
	 * @return lista de enteros con los índices de los amigos que aún no han
	 *         escapado en la lista original, empezando en 'comienzo'
	 */
	static int[] crearListaNoEscapados(boolean[] amigos, int noEscapados, int comienzo) {
		// generamos la sublista con las posiciones de aamigos no escapados, que tendrá
		// 'noEscapados' elementos
		int[] listaNoEscapados = new int[noEscapados];

		int contador = 0; // contador con el número de amigos no escapados encontrados
		/*
		 * //el primer elemento no escapado está en la posición "comienzo". Por
		 * ello,empezamos el recorrido de la lista en esa posición empleamos una
		 * variable auxiliar índice
		 */
		int indice = comienzo;
		// repetimos hasta que encontremos a todos los amigos que aún no han espacado
		while (contador < noEscapados) {
			// guardamos la posición EN EL CÍRCULO ORIGINAL del amigo no espacado
			listaNoEscapados[contador] = indice;
			// buscamos con un bucle do-while la posición del siguiente amigo no escapado
			// del circulo original
			do {
				// hay que ir sumando 1 al índice, pero "módulo" la longitud del círculo
				// original
				indice = (indice + 1) % amigos.length;
			} while (amigos[indice]);
			// una vez encontrado el siguiente elemento no escapado, incrementamos el
			// contador
			contador++;

		}
		// devolvemos la sublista generada

		return listaNoEscapados;
	}

	public static void main(String[] args) {

		// CASO 1: La primera entrada nos indica el número de casos que tenemos que
		// procesar

		int repeticiones;
		int numAmigos; // número de amigos que se reúnen con Susanita
		int desplazamiento; // desplazamiento por el círculo de amigos
		int noEscapados; // número de amigos que no han conseguido escapar de Susanita
		int comienzo; // posición en el círculo de amigos por la que empezamos a contar
		int destino; // posición en la que nos situamos en cada desplazamiento circular, que señala
						// el siguente amigo que escapará

		// la primera entrada es el número de repeticiones
		repeticiones = lector.nextInt();

		for (int i = 0; i < repeticiones; i++) {

			// lectura del número de amigos y del desplazamineto
			numAmigos = lector.nextInt();
			desplazamiento = lector.nextInt();

			/*
			 * definimos un array booleano para controlar los amigos que escapan de Susanita
			 * A los amigos que consigan escapar les establecemos a 'true' en el array. Al
			 * crear el array, todos están a 'false' (ninguno ha escapado aún de las garras
			 * de Susanita...)
			 */

			boolean[] amigos = new boolean[numAmigos];
			// inicialmente ningún amigo ha podido escapar
			noEscapados = numAmigos;
			// ... y empezamos a recorrer la lista en el primer amigo, de indice 0
			comienzo = 0;

			// vamos a ir recorriendo este array hasta que sólo quede un amigo sin haber
			// escapado
			while (noEscapados > 1) {
				/*
				 * creamos la sublista de amigos "no escapados" Esta sublista contiene las
				 * posiciones de los amigos que aún no han escapado, empezando por 'comienzo'
				 */
				int[] listaNoEscapados = crearListaNoEscapados(amigos, noEscapados, comienzo);

				/*
				 * nos desplazamos en esa sublista de forma circular las posiciones indicadas
				 * por "desplazamiento" restamos 1 ya que la propia posición desplazamiento está
				 * incluida al contar y utilizamos aritmética modular, módulo "noEscapados"
				 */
				int indice = (desplazamiento - 1) % noEscapados;
				// el elemento de listaNoEscapados que ocupa esa posición es el siguiente que
				// "escapa de Susanita
				destino = listaNoEscapados[indice];
				amigos[destino] = true;
				// ahora tenemos que elegir el siguiente amigo no escapado en la lista completa,
				// en sentido circular

				do {
					destino = (destino + 1) % numAmigos;
				} while (amigos[destino]);

				// el índice donde terminemos será el comienzo del siguiente ciclo
				comienzo = destino;
				// y ya queda un amigo no escapado menos
				noEscapados--;

			}

			/*
			 * Para dar el resultado, hemos de aumentar comienzo en 1, ya que nuestros
			 * índices empiezan en 0
			 */

			System.out.println(comienzo + 1);

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}// fin de la clase
