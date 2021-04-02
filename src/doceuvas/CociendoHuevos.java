package doceuvas;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero indeterminado de valores de entrada
* La condici�n de terminaci�n es una �ltima l�nea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 368:Cociendo huevos
 * @author Asus
 *
 */
public class CociendoHuevos {
	
	static final int TIEMPO_COCCION=10;  // tiempo de cocci�n de una olla con N nuevos

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

		
	
			int numHuevos, capacidadOlla, tiempo;
			boolean terminar=false;   //condici�n de terminaci�n 
			
			//leemos mientras haya m�s l�neas y no se produzca la condici�n de terminaci�n
			while  ( teclado.hasNext() && !terminar) {
				
				
				numHuevos = teclado.nextInt();    //el primer n�mero es la cantidad de huevos
				capacidadOlla = teclado.nextInt();   //el siguiente es la capcidad de la olla
				//la condici�n para terminar es que ambos n�meros sean 0
				if (numHuevos !=0 || capacidadOlla!=0) {
					tiempo= (numHuevos%capacidadOlla ==0)? (numHuevos/capacidadOlla)*TIEMPO_COCCION : 
						(numHuevos/capacidadOlla +1 )*TIEMPO_COCCION ;
					System.out.println( tiempo);
				} else {
					//activamos la condici�n de terminaci�n
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
