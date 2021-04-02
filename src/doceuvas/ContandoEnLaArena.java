package doceuvas;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero indeterminado de valores de entrada
* La condici�n de terminaci�n es una �ltima l�nea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 371: Aburrimiento en las Sobremesas
 * @author Asus
 *
 */
public class ContandoEnLaArena {
	


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

		
	
			int lado, anterior, siguiente,  contador;
		
			boolean terminar=false;   //condici�n de terminaci�n 
			
			//leemos mientras haya m�s l�neas y no se produzca la condici�n de terminaci�n
			while  ( teclado.hasNext() && !terminar) {
				
				
				lado = teclado.nextInt();    //n�mero de cerillas en cada lado
		
				//la condici�n para terminar es que ambos n�meros sean 0
				if (lado !=0) {
					/* tenemos que encontrar el t�rmino N de la sucesi�n formada por la regla
					A1= 3
					A(N)= A(N-1)+ 3*N
					*/
					contador=1;
					anterior=siguiente=3; //condici�n de inicializacion;
					while (lado>1 && contador< lado) {
						contador++;  
						anterior = siguiente;
						siguiente = anterior + 3*contador;
						
					}
					
							
					
					System.out.println( siguiente); //sigueinte contiene el n�mero de cerillas necesarias
				} else {
					//activamos la condici�n de terminaci�n
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
