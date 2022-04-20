package serie5.p521;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Esqueleto de programa para resolver supuestos del concurso AceptaElReto Tipo
 * 2: Procesamos todas las entradas hasta encontrar una condición especial URL
 * del Problema: https://www.aceptaelreto.com/problem/statement.php?id=521
 * Ejecución desde consola(bin): >>> java paquete.Clase <ruta/sample.in >
 * ruta/sample.res >>> diff sample.out sample.res // para comprobar las
 * diferencias
 */
public class PodemosEmpezar {

	// Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector = new Scanner(System.in);

	static final String TERMINAR = "0 0 0";

	public static void main(String[] args) {

		String linea;
		String[] fragmentos;
		int viviendas;
		int asistentes, quorum;
		HashSet<String> controlAsistentes;

		// CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial,
		// que ignoraremos
		boolean terminar = false; // condición de terminación

		// leemos mientras haya más líneas y no se produzca la condición de terminación
		while (!terminar && lector.hasNext()) {
			linea = lector.nextLine().trim();

			// hay que comprobar si llegamos a la condición de terminación
			if (!(linea.equals(TERMINAR))) {
				// procesamiento
				fragmentos = linea.split("\\s+");
				viviendas = Integer.parseInt(fragmentos[0]) * Integer.parseInt(fragmentos[1]);
				asistentes = Integer.parseInt(fragmentos[2]);
				controlAsistentes = new HashSet<>();
				linea = lector.nextLine().trim();
				fragmentos = linea.split("\\s+");

				for (int i = 0; i < asistentes; i++) {
					String vivienda = fragmentos[2 * i] + fragmentos[2 * i + 1];
					controlAsistentes.add(vivienda);

				}
				quorum = (viviendas % 2 == 0) ? (viviendas / 2) : (viviendas / 2 + 1);

				// salida de resultados, en el formato que nos pida el enunciado
				System.out.println(controlAsistentes.size() >= quorum ? "EMPEZAMOS" : "ESPERAMOS");
			} else {
				// activamos la condición de terminación
				terminar = true;
			}
		} // fin del while

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}// fin de la clase
