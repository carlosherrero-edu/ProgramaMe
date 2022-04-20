package serie5.p522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esqueleto de programa para resolver supuestos del concurso AceptaElReto Tipo
 * 3: Leemos casos de prueba mientras no existan más entradas URL del Problema:
 * 
 * Ejecución desde consola (bin): >>> java paquete.Clase <ruta/sample.in >
 * ruta/sample.res >>> diff sample.out sample.res // para comprobar las
 * diferencias
 * ACEPTADO ENVIO 624601
 */
public class DesconfianzaAsale {

	// Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

	static String transformarDigrafos(String palabra) {
		/*
		 * Para que ch vaya ordenado después de cualquier otro carácter o pareja de caracteres c?
		 * sustituyo "ch" por "c{", pues "{" es justo el siguiente carácter Ascii tras la "z"
		 * por la misma razón, sustituyo "ll" por "l{"
		 */
		return palabra.replaceAll("ch", "c{").replaceAll("ll", "l{");
	}

	public static void main(String[] args) {
		String palabra1, palabra2;
		String palabraT1 = "", palabraT2 = "";
		String linea;

		// CASO 3: Hemos de procesar todas las entradas hasta llegar al fin del flujo de
		// entrada

		try {
			while (lector.ready()) {

				// leemos mientras tengamos algo que leer en el flujo de entrada
				linea = lector.readLine();
				palabra1 = linea.split("\\s")[0];
				palabra2 = linea.split("\\s")[1];

				// procesamiento
				palabraT1 = transformarDigrafos(palabra1);
				palabraT2 = transformarDigrafos(palabra2);

				// salida de resultados, en el formato que nos pida el enunciado
				if (palabraT1.compareTo(palabraT2) <= 0) {
					System.out.println(palabra1);
				} else {
					System.out.println(palabra2);
				}

			} // fin del bucle while en el que leemos entradas

		} catch (IOException e) {
			try {
				lector.close();
			} catch (IOException e1) {
				//
			}
		}

	} // fin del main

}
