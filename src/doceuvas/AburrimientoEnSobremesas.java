package doceuvas;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un número indeterminado de valores de entrada
* La condición de terminación es una última línea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 369: Contando en la Arena
 * @author Asus
 *
 */
public class AburrimientoEnSobremesas {
	
	static final String BASE="1";

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

		
	
			int entrada;
			String salida;
			boolean terminar=false;   //condición de terminación 
			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  ( teclado.hasNext() && !terminar) {
				
				
				entrada = teclado.nextInt();    //número a escribir en base 1
		
				//la condición para terminar es que ambos números sean 0
				if (entrada !=0) {
					//reiniciamos salida
					salida="";
					for (int i=1; i<=entrada; i++) {
						salida +=BASE;
					}
					System.out.println( salida);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
