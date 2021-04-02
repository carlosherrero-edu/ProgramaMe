package doceuvas2020;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero indeterminado de valores de entrada
* La condici�n de terminaci�n es una �ltima l�nea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 589: Igualando Copas
 * @author Asus
 * ME LO ACEPT� EN ESTA SEGUNDA VERSION: LA PRIMERA NO LE GUSTABA
 *
 */
public class IgualandoCopasV2 {
	


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
			int numCopas;
		
			long nivel, nivelMayor, completar;
			
			//leemos mientras haya m�s l�neas y no se produzca la condici�n de terminaci�n
			while  ( teclado.hasNext() && !terminar) {
				
				
				numCopas= teclado.nextInt() ; //el primer n�mero es la cantidad de copas
				
				//la condici�n para terminar es que el n�mero de copas sea 0
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
					//activamos la condici�n de terminaci�n
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
