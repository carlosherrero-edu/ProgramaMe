package doceuvas2020;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un número determinado de valores de entrada
* La primera línea nos indica el número de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entada con casos de prueba
 * corresponde al problema 585: REto del REloj Programable
 * @author Asus
 *
 */

public class RelojProgramable {
	
	static final double GRADOS_HORA=30.0;  //GRADOS QUE avanza la aguja horaria por  cada hora
	static final double GRADOS_MINUTO=0.5; //GRADOS QUE avanza la aguja horaria por cada minuto
	
	
	static double calculaMinutos (double grados) {
		
		return (grados /6.0);
	}
	
	public static void main(String[] args) {
		Scanner teclado=null;
		/* comentar las siguientes líneas hasta el fin del bloque catch el juez en línea */
		File fichero;          
		try {
			
			String ruta = "C:/Users/Alumno/sample.in";
			 fichero = new File(ruta);
			 teclado = new Scanner(fichero);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1); // abandonamos la aplicación si se producen erores
		}
		
		
			
			//teclado = new Scanner(System.in);   //descomentar esta línea en el Juez en Línea
		
		
			int repeticiones;
			
			String cad1, cad2;
	
			double angulo1, angulo2, ang_horas=0, ang_minutos=0;

		//la primera entrada es el número de repeticiones
			repeticiones = teclado.nextInt();
			
			
			
			for (int i=0; i< repeticiones; i++) {
				//leemos los angulos que forman las 2 manillas
				cad1= teclado.next().trim();
				cad2= teclado.next().trim();
			
				//trasnformamos a double
				angulo1= Double.parseDouble(cad1);
				angulo2= Double.parseDouble(cad2);
				
				boolean horaDetectada= false;
				
				int hora=0;   //empezamos por suponer que la primera hora es 0
				
				while (!horaDetectada && hora <=11) {
					if( (hora*GRADOS_HORA + calculaMinutos(angulo1)*GRADOS_MINUTO) == angulo2) {
						
						horaDetectada=true;
						ang_horas= angulo2;
						ang_minutos= angulo1;
					} else if ((hora*GRADOS_HORA + calculaMinutos(angulo2)*GRADOS_MINUTO)== angulo1) {
						horaDetectada=true;
						ang_horas= angulo1;
						ang_minutos= angulo2;
					} else {
						//probamos con la siguiente hora posible
						hora++;
					}
								
				}
				
				if (!horaDetectada) {
					//la hora introducida no es correcta
					System.out.println("ERROR");
				} else {
				
					int minuto=(int)calculaMinutos(ang_minutos);
					System.out.format("%02d:%02d\n", hora, minuto);
				}
				
			} //fin del for exterior
			
	
	} //fin del main


}
