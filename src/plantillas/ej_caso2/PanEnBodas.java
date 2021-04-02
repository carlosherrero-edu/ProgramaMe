package plantillas.ej_caso2;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero indeterminado de valores de entrada
* La condici�n de terminaci�n es una �ltima l�nea con algo especial (en este caso, un 0 en el primer campo)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 172: EL PAN EN LAS BODAS
 * @author Asus
 *
 */
public class PanEnBodas {

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
			int numComensales;
			String disposicionMesa;
			boolean terminar=false;   //condici�n de terminaci�n 
			
			//leemos mientras haya m�s l�neas y no se produzca la condici�n de terminaci�n
			while  ( teclado.hasNext() && !terminar) {
				
				
				numComensales = teclado.nextInt(); //leemos el n�mero
				
				//la condici�n para terminar es que nos pasen un valor 0
				if (numComensales>0 ) {
					//leemos la cadena con la disposici�n de los comensales en la mesa
					//usamos la funci�n "trim" para eliminar posibles espacios y convertimos todo a may�sculas 
					disposicionMesa= teclado.next().trim().toUpperCase();
					//iniciamos contadores del n�mero de comensajes que toman el pan de uno u otro lado
					int tomaDerecha=0, tomaIzquierda=0;
					//recorremos la cadena y vemos cu�ntos comensales toman el pan de uno u otro lado
					for (int i=0; i<numComensales; i++) {
						if (disposicionMesa.charAt(i)=='D') {
							tomaDerecha++;
						} else if (disposicionMesa.charAt(i)=='I') {
							tomaIzquierda++;
						}
						
					} //fin del recorrido de la cadena
					//imprimimos el resultado dependiendo de la variable todasPares

					if (tomaDerecha ==0 || tomaIzquierda==0) {
						//si todos los comensales tomaron el pan del mismo lado, o ninguno ha tomado a�n pan...
						System.out.println("TODOS COMEN");
					} else {
						System.out.println("ALGUNO NO COME");
						
					}
					
				} else {
					//activamos la condici�n de terminaci�n
					terminar =true;
				}
			}
		

		teclado.close(); //cerramos la conexi�n con el teclado
	}

}
