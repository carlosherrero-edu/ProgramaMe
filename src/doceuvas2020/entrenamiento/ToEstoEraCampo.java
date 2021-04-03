package doceuvas2020.entrenamiento;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero indeterminado de valores de entrada
* La condici�n de terminaci�n es una �ltima l�nea con algo especial (en este caso, un n�mero negativo)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 538:ToEstoERaCampo
 * @author Asus
 *
 */
public class ToEstoEraCampo {

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

		
	
			int edadAbuelo, edadIglesia;
			boolean terminar=false;   //condici�n de terminaci�n 
			
			//leemos mientras haya m�s l�neas y no se produzca la condici�n de terminaci�n
			while  ( teclado.hasNext() && !terminar) {
				
				
				edadAbuelo = teclado.nextInt();    //el primer n�mero es la edad del abuelo
				edadIglesia = teclado.nextInt();   //el siguiente es la edad de la Iglesia
				//la condici�n para terminar es que ambos n�meros sean 0
				if (edadAbuelo !=0 || edadIglesia!=0) {
					System.out.println( (edadAbuelo-edadIglesia >=0)? "CUERDO": "SENIL");
				} else {
					//activamos la condici�n de terminaci�n
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
