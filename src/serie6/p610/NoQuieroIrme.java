package serie6.p610;


import java.util.LinkedList;
import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 1: La primera línea indica el número de casos de prueba
* URL del Problema:
* 
* Ejecución desde consola:
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *https://www.aceptaelreto.com/problem/statement.php?id=610
 *Aceptado envío 627144
 */

public class NoQuieroIrme {

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);
	static final String SALIDA1="No quiero irme, Sr. Stark!";
	static final String SALIDA2="No quiero irme, Peter!";
	static final String SALIDA3="No hay abrazo";

	public static void main(String[] args) {

		// CASO 1: La primera entrada nos indica el número de casos que tenemos que
		// procesar

		int repeticiones; //casos de prueba
		int poblacion; //tamaño de la población y del círculo
		int stark; //posición del Sr Starck
		int peter;//posición en el círculo de Peter
		int salto; //salto que hace Muerte antes de eliminar al siguiente

		// la primera entrada es el número de repeticiones
		repeticiones = lector.nextInt();
		// repeticiones = Integer.parseInt(lector.nextLine()); //si usamos nextLine()
		// para lectura

		for (int i = 0; i < repeticiones; i++) {

			// lectura de entradas
			poblacion = lector.nextInt();
			stark = lector.nextInt();
			peter = lector.nextInt();
			salto = lector.nextInt();
			LinkedList<Character> circulo= new LinkedList<>();
			for (int k=0; k<poblacion; k++) {
				 circulo.add('X');
			}
	
			circulo.set(stark-1, 'S');
			circulo.set(peter-1, 'P');
			//ahora hay que ir "matando" elementos del círculo, desde el comeinzo, hasta haber eliminado a la mitad
			int indice=0;
			int eliminar;
			int tamanio_final=poblacion/2;
			while (circulo.size()>tamanio_final) {
				eliminar= (indice+salto)% (circulo.size());
				circulo.remove(eliminar);
				indice=eliminar%(circulo.size());			
			}
			
			

			// procesamiento

			// salida de resultados, en el formato que nos pida el enunciado
			if (circulo.contains('S') && !circulo.contains('P')) {
				System.out.println(SALIDA1);
			} else if (!circulo.contains('S') && circulo.contains('P')) {
				System.out.println(SALIDA2);
			} else {
				System.out.println(SALIDA3);
			}

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}//fin de la clase
