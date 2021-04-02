package plantillas.ej_caso1;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero indeterminado de valores de entrada
* La condici�n de terminaci�n es una �ltima l�nea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 369: Contando en la Arena
 * @author Asus
 *
 */
public class AburrimientoEnSobremesas {
	
	static final String BASE="1";

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

		
	
			int entrada;
			String salida;
			boolean terminar=false;   //condici�n de terminaci�n 
			
			//leemos mientras haya m�s l�neas y no se produzca la condici�n de terminaci�n
			while  ( teclado.hasNext() && !terminar) {
				
				
				entrada = teclado.nextInt();    //n�mero a escribir en base 1
		
				//la condici�n para terminar es que ambos n�meros sean 0
				if (entrada !=0) {
					//reiniciamos salida
					salida="";
					for (int i=1; i<=entrada; i++) {
						salida +=BASE;
					}
					System.out.println( salida);
				} else {
					//activamos la condici�n de terminaci�n
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
