package doceuvas2020;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero indeterminado de valores de entrada
* La condici�n de terminaci�n es una �ltima l�nea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 590: A caballo por el vi�edo
 * @author Asus
 *
 */
public class CaballoVinedo {
	
	static long dimeMayor (long[] lista) {	
		long mayor= lista[0]; //lo inicializo con el primero
				
					
					for ( long elemento : lista) {  //recorro la lista
						 if (mayor <  elemento) {
				                mayor = elemento;
				            }
						
					}		
	
	return mayor;
	
	
}//fin del m�todo

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
			int numRacimos, uvasObjetivo;
			int uvasLlevar, uvasTotal;
			int [] racimos;
			
			//leemos mientras haya m�s l�neas y no se produzca la condici�n de terminaci�n
			while  ( teclado.hasNext() && !terminar) {
				
				
				numRacimos= teclado.nextInt() ; //el primer n�mero es la cantidad de racimos
				uvasObjetivo= teclado.nextInt() ; //el segundo n�mero es la cantidad de uvas que como m�nimo hemos de recolectar
				
				//la condici�n para terminar es que ambos n�meros sean 0
				if (numRacimos != 0 && uvasObjetivo!=0) {
					//leemos el n�mero de uvas de cada racimo
					racimos = new int[numRacimos];
					//leemos los niveles del teclado
					for (int i=0; i<numRacimos; i++) {
						racimos[i]= teclado.nextInt();
					}
					
					uvasLlevar=0;
					
					boolean alcanzoObjetivo=false;
					int i=0;
					
					//hacemos todos los recorridos posibles de racimos consecutivos
					while (!alcanzoObjetivo && i<numRacimos) {
						uvasTotal=0;
						int k=i;   //comenzamos a sumar en la posici�n i
						while (uvasTotal<uvasObjetivo && k<numRacimos) {
							//sumo uvas de los racimos consecutivos hasta que alcance la cantidad objetivo
							uvasTotal += racimos[k];
							k++;
						}
						
						if (uvasTotal >= uvasObjetivo) {
							// he podido completar el objetivo
							if (uvasLlevar==0) {
								//para la primera vez que completo el objetovo
								uvasLlevar= uvasTotal;
							} else if (uvasTotal <= uvasLlevar) {
								//hay una configuraci�n donde llevo menos uvas
								uvasLlevar=uvasTotal;
								// si he alcanzado ya mi objeto , activo condicio�n de terminaci�n
								if( uvasTotal==uvasObjetivo) {
									// he llegado a la confifugraci�n m�nimoa, no necesito seguir
									alcanzoObjetivo=true;
								}
							}
						} //fin de comprobaciones
						
						i++;  //aumentamos en 1 la posici�n donde empezamos la pr�xima vez
					}  //fin del recorrido de todos los racimos consecutivos
					//muestro el resutado, o imposible si no encontr� configuraci�n correcta
					System.out.println( uvasLlevar>0? uvasLlevar: "IMPOSIBLE");
					
				} else {
					//activamos la condici�n de terminaci�n
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
