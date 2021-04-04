package doceuvas2020;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero indeterminado de valores de entrada
* La condici�n de terminaci�n es una �ltima l�nea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 588: Velas Binarias
 * @author Asus

 *
 */
public class VelasBinarias {
	
	/**
	 * Método para convertir un número decimal a su representación binaria
	 * @param numero entero largo que representa el número decimal
	 * @return cadena con su representación a binario
	 * NOTA: Puede evitarse el uso de este método llamando al método estático Long.toBinaryString()
	 */
	static String pasarABinario (long numero) {
		
		String salida="";   //cadena donde convertimos el número a binario
		String resto;
		
		while (   Math.floor(numero/2)>=2) {
			resto = Long.toString(numero%2);
			salida= resto.concat(salida);
			numero = numero/2;  //división entera				
		}
		//concatenamos los últimos valores del resto y del cociente al resultado
		resto = Long.toString(numero%2);
		salida= resto.concat(salida);
		salida= Long.toString(numero/2).concat(salida);
		
		
		return salida;
	}
	
	
	/**
	 * Método que transforma una cadena en su cadena invertida
	 * @param cadena cadena de entrada
	 * @return cadena invertida- leída de derecha a izquierda
	 */
	static String invertirCadena (String cadena) {
		
		String salida="";
		for (int i=cadena.length()-1; i>=0; i--) {
			salida = salida.concat(Character.toString(cadena.charAt(i)));
		}
		return salida;
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
		
			long numero;  //numero que debemos convertir a binario; entero largo por la condición <= 2^63
			String binario;   //cadena con el número convertido a binario
			String subcadena, subcadenaInversa;
			int primero, ultimo;
			
			//leemos mientras haya  más líneas y no lleguemos a la condición de terminación
			while  ( teclado.hasNext() && !terminar) {
				
				
				numero= teclado.nextLong() ; 
				
				//la condici�n para terminar es que el número leído sea 0
				if (numero != 0) {
					//obtenemos la representación binaria del número, con el método estático Long.toBinaryString
					binario= Long.toBinaryString(numero);
					
					//la siguiente orden la descomentaríamos si quisiéramos utilizar nuestro método
					//binario= pasarABinario(numero);
					
					
					/* Tomaremos ahora la subcadena que está comprendida entre el primer
					 * y el último dígito 1 de la cadena
					 */
					primero = binario.indexOf('1');
					ultimo= binario.lastIndexOf('1');
					subcadena= binario.substring(primero, ultimo+1);
					//obtenemos el inverso de la subcadena para comprobar si son iguales
					subcadenaInversa = invertirCadena(subcadena);
					
					if (subcadena.equals(subcadenaInversa)) {
						//la tarta se puede leer igual desde ambos lados
						System.out.println("SI");
					} else {
						//la tarta no se ve igual desde ambos lados
						System.out.println("NO");
					}
					
				} else {
					//activamos la condici�n de terminaci�n
					terminar =true;
				}
			}
		
		teclado.close();
	} //fin del main

}
