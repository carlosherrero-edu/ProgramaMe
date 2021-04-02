package doceuvas;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un número indeterminado de valores de entrada
* La condición de terminación es una última línea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 368:Cociendo huevos
 * @author Asus
 *
 */
public class CociendoHuevos {
	
	static final int TIEMPO_COCCION=10;  // tiempo de cocción de una olla con N nuevos

	public static void main(String[] args) {
		Scanner teclado=null;
		/* comentar las siguientes líneas hasta el fin del bloque catch el juez en línea */
		File fichero;          
		try {
			
			String ruta = "C:/Users/Asus/sample.in";
			 fichero = new File(ruta);
			 teclado = new Scanner(fichero);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1); // abandonamos la aplicación si se producen erores
		}
			
		//teclado = new Scanner(System.in);   //descomentar esta línea en el Juez en Línea

		
	
			int numHuevos, capacidadOlla, tiempo;
			boolean terminar=false;   //condición de terminación 
			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  ( teclado.hasNext() && !terminar) {
				
				
				numHuevos = teclado.nextInt();    //el primer número es la cantidad de huevos
				capacidadOlla = teclado.nextInt();   //el siguiente es la capcidad de la olla
				//la condición para terminar es que ambos números sean 0
				if (numHuevos !=0 || capacidadOlla!=0) {
					tiempo= (numHuevos%capacidadOlla ==0)? (numHuevos/capacidadOlla)*TIEMPO_COCCION : 
						(numHuevos/capacidadOlla +1 )*TIEMPO_COCCION ;
					System.out.println( tiempo);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
