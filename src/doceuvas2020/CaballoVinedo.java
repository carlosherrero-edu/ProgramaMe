package doceuvas2020;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un número indeterminado de valores de entrada
* La condición de terminación es una última línea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 590: A caballo por el viñedo
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
	
	
}//fin del método

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
			boolean terminar=false;
			int numRacimos, uvasObjetivo;
			int uvasLlevar, uvasTotal;
			int [] racimos;
			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  ( teclado.hasNext() && !terminar) {
				
				
				numRacimos= teclado.nextInt() ; //el primer número es la cantidad de racimos
				uvasObjetivo= teclado.nextInt() ; //el segundo número es la cantidad de uvas que como mínimo hemos de recolectar
				
				//la condición para terminar es que ambos números sean 0
				if (numRacimos != 0 && uvasObjetivo!=0) {
					//leemos el número de uvas de cada racimo
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
						int k=i;   //comenzamos a sumar en la posición i
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
								//hay una configuración donde llevo menos uvas
								uvasLlevar=uvasTotal;
								// si he alcanzado ya mi objeto , activo condicioón de terminación
								if( uvasTotal==uvasObjetivo) {
									// he llegado a la confifugraci´n mínimoa, no necesito seguir
									alcanzoObjetivo=true;
								}
							}
						} //fin de comprobaciones
						
						i++;  //aumentamos en 1 la posición donde empezamos la próxima vez
					}  //fin del recorrido de todos los racimos consecutivos
					//muestro el resutado, o imposible si no encontré configuración correcta
					System.out.println( uvasLlevar>0? uvasLlevar: "IMPOSIBLE");
					
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
