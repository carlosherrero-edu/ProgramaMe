package serie6.p612;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Scanner;

/**
 * Esqueleto de programa para resolver supuestos del concurso AceptaElReto Tipo
 * 3: Leemos casos de prueba mientras no existan más entradas URL del Problema:
 * 
 * Ejecución desde consola (bin): >>> java paquete.Clase <ruta/sample.in >
 * ruta/sample.res >>> diff sample.out sample.res // para comprobar las
 * diferencias
 * https://www.aceptaelreto.com/problem/submission.php?id=627234
 * ACEPTADO envío 627234
 */
public class PuntoEnCirculos {

	// Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector = new Scanner(System.in);

	static double calcularPotencia(int centroX, int centroY, int posX, int posY, int radio) {

		return Math.pow(centroX - posX, 2) + Math.pow(centroY - posY, 2) - Math.pow(radio, 2);
	}

	public static void main(String[] args) {
		// CASO 3: Hemos de procesar todas las entradas hasta llegar al fin del flujo de
		// entrada
		int radio;
		int posX, posY;
		int centroX, centroY;
		int num_circulos;
		String linea;


				try (BufferedReader lector = new BufferedReader(new InputStreamReader(System.in))){
					while (lector.ready()) {

						// leemos mientras tengamos algo que leer en el flujo de entrada
						linea = lector.readLine();
						//separamos y leems los valores numéricos en la línea
						String[] valores=linea.split("\\s+");
						radio=Integer.parseInt(valores[0]);
						posX=Integer.parseInt(valores[1]);
						posY=Integer.parseInt(valores[2]);
						num_circulos=0;
						centroX=0; centroY=0;
						while (radio>=1) {
							if (calcularPotencia(centroX,centroY,posX,posY,radio)<=0) {
								//el punto está dentro de un círculo
								num_circulos++;
							}
					
								//ahora hay que construir los 4 círculos posibles
								// commo todos tienen igual radio, genero los puntos que serán su centro
								ArrayList<Punto> puntosF= new ArrayList<>();
								puntosF.add(new Punto(centroX-radio, centroY));
								puntosF.add(new Punto(centroX+radio, centroY));
								puntosF.add(new Punto(centroX, centroY-radio));
								puntosF.add(new Punto(centroX, centroY+radio));
								//determinamos el punto que está más cercano a posX, posY
								double distanciaMin=Double.MAX_VALUE;
								int posMin=-1;
								for (int k=0; k<4; k++) {
									Punto p=puntosF.get(k);
									if (Math.pow(p.getX()-posX, 2)+Math.pow(p.getY()-posY, 2) < distanciaMin) {
										distanciaMin= Math.pow(p.getX()-posX, 2)+Math.pow(p.getY()-posY, 2);
										posMin=k;
									}
								} //al final, posMin señala al centro del círculo más cercano al punto
								radio=radio/2;
								centroX=puntosF.get(posMin).getX();
								centroY=puntosF.get(posMin).getY();
								//hacemos la siguiente llamada iterativa
							
						} //fin del bucle while
										
										
						
						System.out.println(num_circulos);
						

					} // fin del bucle while en el que leemos entradas

	}catch(IOException e)
	{
		// no hacemos nada
	}

} // fin del main

}

/**
 * Clase para guardar un punto del plano con coordenadas enteras
 * @author zeus
 *
 */
class Punto {

	int posX;
	int posY;

	Punto(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	int getX() {
		return this.posX;
	}

	int getY() {
		return this.posY;

	}
} // fin de la clase Punto
