package doceuvas;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un número indeterminado de valores de entrada
* La condición de terminación es una última línea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 371: Aburrimiento en las Sobremesas
 * @author Asus
 *
 */
public class ContandoEnLaArena {
	


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

		
	
			int lado, anterior, siguiente,  contador;
		
			boolean terminar=false;   //condición de terminación 
			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  ( teclado.hasNext() && !terminar) {
				
				
				lado = teclado.nextInt();    //número de cerillas en cada lado
		
				//la condición para terminar es que ambos números sean 0
				if (lado !=0) {
					/* tenemos que encontrar el término N de la sucesión formada por la regla
					A1= 3
					A(N)= A(N-1)+ 3*N
					*/
					contador=1;
					anterior=siguiente=3; //condición de inicializacion;
					while (lado>1 && contador< lado) {
						contador++;  
						anterior = siguiente;
						siguiente = anterior + 3*contador;
						
					}
					
							
					
					System.out.println( siguiente); //sigueinte contiene el número de cerillas necesarias
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
