package serie4.p477;


import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=477
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO envio 623
 *El ahorro de tiempo de usar ArrayList a LinkedList es imperceptible. Podía probar con Arrays estáticos...
 */
public class CapturaDoctorMuerte {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	public static void main(String[] args) {
	
	int vitalidad;
	int num_armas;
	int danioInocentes, danioVillanos;
	LinkedList<Arma> lista;
	Arma pistola;

	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				vitalidad=lector.nextInt();
				
				//hay que comprobar si llegamos a la condición de terminación
				if (!(vitalidad ==0)) {
					// procesamiento
					num_armas=lector.nextInt();
					lista=new LinkedList<>();
				
					for (int k=0; k<num_armas; k++) {
						//leemos el poder destructivo del arma
						danioInocentes=lector.nextInt();
						danioVillanos=lector.nextInt();
						/*
						 * //creamos una nueva instancia de Arma y la añadimos a la lista
						 * GEstionamos la lista como si fuese una cola, agregando al final con addLast()
						 * y eliminaremos después con pop()
						 */
						
						lista.addLast(new Arma(danioInocentes, danioVillanos, k+1));
					}
					
					//ordenamos ahora la lista según su orden natural
					/*
					 * Primero aparecen las armas que causen MENOR daño a inocentes
					 * Para igual daño a inocentes, primero elegirmos las que causen MAYOR daño a villanos
					 * En caso de igualdad de daños, las armas se eligen por el orden en que aparecienon
					 */
					Collections.sort(lista);
					
					//ahora elegimos armas hasta completar la vitalidad del villano, si es posible...
					int sumaDestruccion=0;
					String resultado="";  //cadena con las posiciones de las armas que vamos eligiendo
					do {
						//extraemos un arma de la lista
						pistola= lista.pop();
						sumaDestruccion+=pistola.getDanioVillanos();
						resultado+=String.format("%d ", pistola.getPosicion());					
					}while (sumaDestruccion<vitalidad && lista.size()>0); 
					
					//quitamos el espacio extra de resultado
					resultado=resultado.substring(0, resultado.length()-1);
						
					//salida de resultados, en el formato que nos pida el  enunciado
					if (sumaDestruccion>=vitalidad) {
						//en la lista hay armas con poder suficiente para destruir al villano
						System.out.println( resultado);
					} else {
						//hemos agotado la lista, pero no tenemos poder suficiente para destruirlo
						System.out.println( "MUERTE ESCAPA");
					}
					
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase

/**
 * Clase no pública para modelar cada arma por sus propuedades y poderlas ordenar
 * @author zeus
 *
 */
class Arma implements Comparable<Arma>{
	
	//la clase va a tener 3 propiedades 
	private int danioInocentes;
	private int danioVillanos;
	private int posicion;
	
	//constructor único
	public Arma(int danioInocentes, int danioVillanos, int posicion) {
		super();
		this.danioInocentes = danioInocentes;
		this.danioVillanos = danioVillanos;
		this.posicion = posicion;
	}
	
	//métodos getXxX
	
	public int getDanioInocentes() {
		return danioInocentes;
	}





	public int getDanioVillanos() {
		return danioVillanos;
	}


	public int getPosicion() {
		return posicion;
	}




	@Override
	public int compareTo(Arma otra) {
		if (this.getDanioInocentes()!= otra.getDanioInocentes()) {
			//si causan distinto daño a inocentes, se ordenan en sentido creciente por ese campo
			return Integer.valueOf(this.getDanioInocentes())
					.compareTo(Integer.valueOf(otra.getDanioInocentes()));
		} else {
			if (this.getDanioVillanos()!= otra.getDanioVillanos()) {
				// si causan distinto daño a villanos, se ordenan DECRECIENTEMENTE por este campo
				return (-1)*(Integer.valueOf(this.getDanioVillanos())
						.compareTo(Integer.valueOf(otra.getDanioVillanos())));
			} else {
				//en caso de igualdad, se ordenan por su posición en la lista
				return Integer.valueOf(this.getPosicion())
						.compareTo(Integer.valueOf(otra.getPosicion()));
			}
		}

	}
	
	
}
