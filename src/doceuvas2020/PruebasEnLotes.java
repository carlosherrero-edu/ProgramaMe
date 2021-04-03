package doceuvas2020;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero indeterminado de valores de entrada
* La condici�n de terminaci�n es una �ltima l�nea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 593: Pruebas en Lotes
 * @author Asus

 *
 */
public class PruebasEnLotes {
	
	/**
	 * Método para convertir un número decimal a su representación binaria
	 * @param numero entero largo que representa el número decimal
	 * @return cadena con su representación a binario
	 */
	
	static int calcularNumeroAnalisis (String muestra) {
		
	
		int mitad;
		
		//si no hay ningún 1 o positivo en la muestra
		if (muestra.indexOf('1')<0 ||muestra.length()<2 ) {
			//caso base: no hay más positivos en la muestra, o bien la muestra no puede dividirse más
			//terminamos el análisis y devolvemos 1
			return 1;
		}  else {
				//dividimos la muestra en 2 submitades
				mitad= muestra.length()/2 + muestra.length()%2;
				String izquierda= muestra.substring(0, mitad);
				String derecha = muestra.substring(mitad);
				//como hemos hecho un análisis, sumamos 1 a lo que nos devuelva el análisis de cada submitad
				return 1+calcularNumeroAnalisis(izquierda)+calcularNumeroAnalisis(derecha);
				
			}
			
		}
	
	
	

	
	public static void main(String[] args) {
		Scanner teclado=null;
		/* comentar las siguientes l�neas hasta el fin del bloque catch el juez en l�nea */
		File fichero;          
		try {
			
			String ruta = "C:/Users/Alumno/sample.in";
			 fichero = new File(ruta);
			 teclado = new Scanner(fichero);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1); // abandonamos la aplicaci�n si se producen erores
		}
			
		//teclado = new Scanner(System.in);   //descomentar esta l�nea en el Juez en L�nea
			boolean terminar=false;
		
			int muestras;  //número de muestras tomadas
			int analisis; //número de análisis que se deben realizar
			String resultado;   //cadena con el resultado de las muestras

			
			//leemos mientras haya  más líneas y no lleguemos a la condición de terminación
			while  ( teclado.hasNext() && !terminar) {
				
				
				muestras= teclado.nextInt() ; 
				
				//la condici�n para terminar es que el número de muestras sea 0
				if (muestras != 0) {
					//obtenemos la representación binaria del número
					resultado= teclado.next();
					analisis= calcularNumeroAnalisis(resultado);
					System.out.println(analisis);
					
					
					
				} else {
					//activamos la condici�n de terminaci�n
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
