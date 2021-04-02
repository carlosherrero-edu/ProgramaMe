package plantillas.ej_caso1;

import java.io.File;
import java.util.Scanner;
import java.time.*;   //importamos las clases para trabajar con fechas
import static java.time.temporal.ChronoUnit.DAYS;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero determinado de valores de entrada
* La primera l�nea nos indica el n�mero de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 157: �Cu�ntos d�as faltan?
 * ESTA SOLUCI�N NO LA ADMITE EL JUEZ EN L�NEA DEBIDO A QUE NO TIENE CARGADAS LAS FUNCIONES DEL PAQUETE java.time
 * @author Asus
 *
 */

public class CuantosDiasFaltan2 {

	
	public static void main(String[] args) {
		Scanner teclado=null;
		/* comentar las siguientes l�neas hasta el fin del bloque catch el juez en l�nea */
		File fichero;          
		try {
			
			String ruta = "C:/Users/Asus/sample.in";
			 fichero = new File(ruta);
			 teclado = new Scanner(fichero);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1); // abandonamos la aplicaci�n si se producen erores
		}
			
			//teclado = new Scanner(System.in);   //descomentar esta l�nea en el Juez en L�nea
		
	
			int repeticiones, dia, mes;
			long intervalo;  //intervalo de d�as
			LocalDate diaInicio, diaFin;
		//la primera entrada es el n�mero de repeticiones
			repeticiones = teclado.nextInt();
			
			diaFin= LocalDate.of(2019,12,31); //diaFin guarda el 31 de diciembre de un a�o no bisiesto
			
			for (int i=0; i< repeticiones; i++) {
				dia =teclado.nextInt();
				mes = teclado.nextInt();
				//construimos la fecha del mismo a�o correspondiente al d�a pasado
				diaInicio = LocalDate.of(2019,mes,dia);
				//construimos el intervalo entre ambas fechas
				intervalo = DAYS.between (diaInicio,diaFin);
				//devolvemos el n�mero de d�as de ese per�odo
				System.out.println(intervalo);
				
			} //fin del for
			
	
	} //fin del main


}
