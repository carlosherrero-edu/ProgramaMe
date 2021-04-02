package doceuvas2020;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un número indeterminado de valores de entrada
* La condición de terminación es una última línea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 589: Igualando Copas
 * @author Asus
 * ME LO ACEPTÓ EN ESTA SEGUNDA VERSION: LA PRIMERA NO LE GUSTABA
 *
 */
public class IgualandoCopasV2 {
	


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
			int numCopas;
		
			long nivel, nivelMayor, completar;
			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  ( teclado.hasNext() && !terminar) {
				
				
				numCopas= teclado.nextInt() ; //el primer número es la cantidad de copas
				
				//la condición para terminar es que el número de copas sea 0
				if (numCopas != 0) {
					completar=0L ; // inicializamos completar
					nivelMayor=teclado.nextLong();//leemos el nivel de la primera copa
					
						for (int i=1; i<numCopas; i++) {
							//leemos el nivel de la siguiente copa
							nivel= teclado.nextLong();
							if (nivel <= nivelMayor) {
								//completamos el nivel de la copa hasta el nivel mayor
								completar += (nivelMayor-nivel);
								
							} else {
								//el nivel de la nueva copa es superior al de todas las anteriores
								//hay que completar todas las copas anteriores con la diferencia entre el "anterior" y el "nuevo" nivel mayor
								
								completar += (nivel-nivelMayor)*i;
								nivelMayor= nivel;    //y ahora actualizamos el nivel mayor
							}
						} //fin de la lectura de niveles
						//mostramos resultado
						System.out.println(completar);
					
					
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
