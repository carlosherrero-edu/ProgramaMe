package serie2.p462;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 1: La primera línea indica el número de casos de prueba
* URL del Problema:
* http://www.aceptaelreto.com/problem/statement.php?id=462
* Ejecución desde consola:
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO Envío 617867
 */

public class MundoLimpio {

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {

		// CASO 1: La primera entrada nos indica el número de casos que tenemos que
		// procesar

		int repeticiones;
		/* 
		 * Todas las variables relacionadas con el tiempo las tratamos como Long, pues por los datos de entrada
		 * sabemos que se pueden producir desbordamientos de tamaño si las tratamos como int
		 */
		long veces;  //veces que limpiamos las gafas
		String tiempo; //tiempo durante el que las gafas permanecen limpias tras cada limpieza
		long tiempoLimpio;  //tiempo total en segundos  que las gafas están limpias
		long segundosLimpio,minutosLimpio, horasLimpio, diasLimpio;
		
		// la primera entrada es el número de repeticiones
		repeticiones = lector.nextInt();
		// repeticiones = Integer.parseInt(lector.nextLine()); //si usamos nextLine()
		// para lectura

		for (int i = 0; i < repeticiones; i++) {

			// lectura de entradas
			 veces=lector.nextLong();
			 tiempo=lector.next();  //es de la forma hh:mm:ss
			
			// procesamiento
			 String[] partes= tiempo.split(":");  //el separador son ":"
			 long tHoras=Long.parseLong(partes[0]);
			 long tMinutos=Long.parseLong(partes[1]);
			 long tSegundos=Long.parseLong(partes[2]);
			 //calculo el tiempo total, en una variable de tipo long, para evitar desbordamientos
			 tiempoLimpio=(tSegundos+60*tMinutos+3600*tHoras)*veces;
			 
			 //de este tiempo hay que extraer ahora segundos, horas, minutos y días
			 diasLimpio=tiempoLimpio/86400;   //división entera--> da días
			 tiempoLimpio=tiempoLimpio%86400;
			 
			 horasLimpio=tiempoLimpio/3600; // división entera--> da las horas
			 tiempoLimpio=tiempoLimpio%3600;
			 
			 minutosLimpio= tiempoLimpio/60;  //división entera--> da los minutos
			 segundosLimpio=tiempoLimpio%60; //--> el resto sn los segundos
	
			// salida de resultados, en el formato que nos pida el enunciado
			System.out.format("%d %02d:%02d:%02d\n", 
					diasLimpio, horasLimpio, minutosLimpio,segundosLimpio);

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}//fin de la clase
