package doceuvas2020.entrenamiento;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero indeterminado de valores de entrada
* La condici�n de terminaci�n es una �ltima l�nea con algo especial (en este caso, 2 d�gitos 0)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 520: �D�nde est� la bolita?
 * @author Asus
 *
 */
/**
 * @author Asus
 *
 */
public class DondeEstaLaBolita {
	
	static final int BOLITA = 1; //constante que representa la existencia de una bolita

	
	/**
	 * M�todo que inicia el array que representa los cubiletes.
	 * La posici�n donde se guarde inicialmente la bolita se inicia con el valor indicado por la constante BOLITA, el resto se inician a 0
	 * @param cubiletes - referencia a un array con valores enteros
	 * @param posicionBolita - entero con la posici�n inicial donde se encuentra la bolita
	 */
	static void  iniciarCubiletes (int [] cubiletes, int posicionBolita) {
		
		// el cubilete que contenga la bolita guardar� un 1, el resto un 0
		for (int i=0; i< cubiletes.length; i++) {
			 cubiletes[i] = (posicionBolita == (i+1)) ?BOLITA:0;
		}	
		
	}
	
	
	/**
	 * M�todo est�tico para intercambiar los contenidos en las celdas o posicones de un array de enteros
	 * @param cubiletes - referencia a un array con valores enteros
	 * @param pos1 - �ndice de la primera posici�n del array 
	 * @param pos2 - - �ndice de la segunda posici�n del array , cuyo contenido queremos intercambiar con la anterior
	 */
	static void intercambiar (int[] cubiletes, int pos1, int pos2) {
		//hay que usar una variable pivote para el intercambio de los contenidos en ambas posiciones
		int contenido;
		contenido = cubiletes[pos1];
		cubiletes[pos1]= cubiletes [pos2];
		cubiletes[pos2] = contenido;
	}
	
	/**
	 * M�todo est�tico para indicar la posici�n de un array en la que tenemos guardado un elemento clave, la constante BOLITA
	 * @param cubiletes -referencia a un array con valores enteros
	 * @return primera  posici�n del array donde se encuentra almacenada la constante BOLITA
	 */
	static int buscarBola (int[] cubiletes) {
		int posicion=0;
		while (cubiletes[posicion] != BOLITA && posicion < cubiletes.length) {
			posicion++;
		}
		return posicion;
	}

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

		
	
			int numeroCubiletes, posicionInicial, posicion1, posicion2;
			boolean terminar=false;   //condici�n de terminaci�n 
			boolean hayIntercambio; 
			
			//leemos mientras haya m�s l�neas y no se produzca la condici�n de terminaci�n
			while  ( teclado.hasNext() && !terminar) {
				
				
				numeroCubiletes = teclado.nextInt();    //el primer valor es el n�mero de cubiletes
				posicionInicial = teclado.nextInt();   //el siguiente es el cubilete que tendr� la bolita
				//la condici�n para terminar es que ambos n�meros sean 0
				if (numeroCubiletes !=0 || posicionInicial !=0) {
					//creamos un array donde cada elemento representa un cubilete
					
					int [] cubiletes = new int [numeroCubiletes];
					//TENER EN CUENTA QUE EL ARRAY EMPIEZA EN 0, PERO TODAS LAS POSICIONES QUE NOS DAN EMPIEZAN EN 1
					iniciarCubiletes (cubiletes, posicionInicial);  //llamamos al m�todo para iniciar el arreglo de cubiletes
					
					hayIntercambio=true;
					do {
						//bucle que recorremos mientras se sigan intercambiando cubiletes
						//vamos leyendo los cubiletes que se intercambian
						posicion1 = teclado.nextInt();
						posicion2 = teclado.nextInt();
						if (posicion1>0 || posicion2>0) {
							//intercambiamos los cubiletes en sus posiciones
							intercambiar (cubiletes, posicion1-1, posicion2-1);
							
						} else {
							//finaliza el intercambio de cubiletes
							hayIntercambio =false;
						}
					} while (hayIntercambio);
					
					//una vez finalizado el intercambio, hemos de devolver d�nde tenemos la bola
					System.out.println(buscarBola(cubiletes)+1);
						
				} else {
					//activamos la condici�n de terminaci�n
					terminar =true;
				}
			}  //fin del bucle while de lectura de valores
		
		teclado.close();
	} //fin del main

}
