package serie1.p409;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 1: La primera línea indica el número de casos de prueba
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=409

* Ejecución desde consola:
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO 617347
 */

public class SeleccionandoCastellers {

	static final int DIFERENCIA_MAXIMA = 15;

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);
	
	//listas estáticas con las alturas y las sublistas de castellers por nivel
	static ArrayList<Integer> alturas= new ArrayList<>();
	static ArrayList<Integer> sublista= new ArrayList<>();
	
	
	static void extraerSublista(int porNivel) {
		//vaciamos la sublista
		sublista.clear();
		//extraemos los primeros elementos de la lista principal y los agregamos a la sublista
		for (int k=0; k<porNivel; k++) {
			sublista.add(alturas.remove(0));		
		}
	} //fin del método
	
	
	static void descartarElemento() {
		//descarta el primer elemento de la sublista e ingresa en ella un nuevo elemento de la lista principal
		sublista.remove(0); //este elemento se descarta
		sublista.add(alturas.remove(0));
	} //fin del método
	
	static boolean excedeDiferencia(int porNivel) {
		if ( sublista.get(porNivel-1)-sublista.get(0) > DIFERENCIA_MAXIMA) {
			return true;
		} else {
			return false;
		}
	}//fin del método

	public static void main(String[] args) {
		int pisos, castellers, porNivel;
		

		// CASO 1: La primera entrada nos indica el número de casos que tenemos que
		// procesar

		int repeticiones;

		// la primera entrada es el número de repeticiones
		repeticiones = lector.nextInt();
		// repeticiones = Integer.parseInt(lector.nextLine()); //si usamos nextLine()
		// para lectura

		for (int i = 0; i < repeticiones; i++) {

			// lectura de entradas. Empezamos por leer el número de castellers por nivel  y de castellers en total
			porNivel=lector.nextInt();
			castellers= lector.nextInt();
			//ahora leeremos la altura de todos los castellers y la guardamos en una lista
			alturas.clear();	
			for (int k=0; k<castellers; k++) {
				alturas.add(lector.nextInt());
			}
			
			// procesamiento
			//una vez obtenidas las alturas de todos los castellers, ordenamos la lista
			Collections.sort(alturas);
			pisos=0;
			
			//mientras haya suficientes castellers en la lista de alturas
			while (alturas.size()>= porNivel) {
				extraerSublista(porNivel);
				//ahora iremos descartando castellers mientras no agotemos la lista y la diferencia entre los extremos sea superior a la máxima permitida
				while (alturas.size()>0 && excedeDiferencia(porNivel)) {
					//descartamos el casteller de menor altura y tomamos el siguiente casteller de la lista
					descartarElemento();
				}//fin de bucle
				//si la sublista está en el rango permitido, agregamos un piso
				if (!excedeDiferencia(porNivel)) {
					pisos++;
				}
			} //fin del while
	
			// salida de resultados, en el formato que nos pida el enunciado
			System.out.println(pisos);

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}//fin de la clase
