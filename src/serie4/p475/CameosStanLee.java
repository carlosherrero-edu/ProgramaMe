package serie4.p475;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 1: La primera línea indica el número de casos de prueba
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=475
* Ejecución desde consola:
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO Envío 623242
 */

public class CameosStanLee {

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);
	static final String BUSCADA="stanlee";
	

	public static void main(String[] args) {

		// CASO 1: La primera entrada nos indica el número de casos que tenemos que
		// procesar

		int repeticiones;
		String cadenaLeida;
		int aparicionesStan;
		int posicion;

		// la primera entrada es el número de repeticiones
		repeticiones = Integer.parseInt(lector.nextLine());
		// repeticiones = Integer.parseInt(lector.nextLine()); //si usamos nextLine()
		// para lectura

		for (int i = 0; i < repeticiones; i++) {

			// lectura de entradas
			cadenaLeida=lector.nextLine();

			// procesamiento
			//transformamos la cadena leída, pasando a mayúsculas y eliminando espacios o signos de puntuación
			cadenaLeida=cadenaLeida.replaceAll("\\W+", "").toLowerCase();
			//iniciamos el número de repeticiones de Stan Lee
			aparicionesStan=0;
			int indice=0;
			boolean salir=false;
			while (!salir) {
				//este bucle for va buscando dónde se encuentra cada uno de los caracteres en la cadena 'stanlee'
				for (int k=0; k<BUSCADA.length(); k++) {
					posicion=cadenaLeida.indexOf(BUSCADA.charAt(k), indice);
					if (posicion <0) {
						//ya no puede haber más ocurrencias de Stanley Lee, nos salimos del bucle for
						salir=true;
						break;
					} else {
						//actualizamos indice para empezar a buscar el siguiente carácter de 'stanlee' a partir de la siguiente posición
						indice=posicion+1;
					}
				}//fin del bucle for
				//si llegamos aquí y no hemos salido del bucle, hemos encontrado una repetición completa de 'stanlee'
				if (!salir)
					aparicionesStan++;
			}//fin del bucle while

			// salida de resultados, en el formato que nos pida el enunciado
			System.out.println(aparicionesStan);

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}//fin de la clase
