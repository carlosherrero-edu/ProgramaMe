package serie5.p524;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* 
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *
 *WRONG ANSWER
 */

class Producto{
	
	Integer precioCompe;
	Integer precioTencia;
	//constructor
	
	Producto( int precioCompe, int precioTencia) {
		super();
	
		this.precioCompe = precioCompe;
		this.precioTencia = precioTencia;
	}
	
	
}


public class Competencia {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	
	//método para elegir los primeros productos del catálogo ordenados por Compe
	
	static int calcularMenoresCompe(LinkedList<Producto> catalogo, int minCompe) {
		int suma=0;
		//primero ordenamos la colección por los precios más bajos en la tienda de Compe
		Collections.sort(catalogo, new Comparator<Producto>() {
			public int compare(Producto prod1, Producto prod2) {
				if (!prod1.precioCompe.equals(prod2.precioCompe)) {
					return prod1.precioCompe.compareTo(prod2.precioCompe);
				} else {
					//en caso de igualdad, devolvemos el producto más caro en la tienda de Tencia para que salga el primero de la lista
					return (-1)*prod1.precioTencia.compareTo(prod2.precioTencia);
				}
			}
			
		}//fin clase anónima
		);
		
		//buscamos en esa lista los productos indicados en minCompe, tomamos el precio de Compe y lo descartamos de la lista
		for (int i=0; i<minCompe; i++) {
			suma+=catalogo.pop().precioCompe;
			
		}
		return suma;
		
	} //fin del método
	
	
	
	//método para elegir los primeros productos del catálogo ordenados por Tencia
	
		static int calcularMenoresTencia(LinkedList<Producto> catalogo, int minTencia) {
			int suma=0;
			Collections.sort(catalogo, new Comparator<Producto>() {
				public int compare(Producto prod1, Producto prod2) {
					if (!prod1.precioTencia.equals(prod2.precioTencia)) {
						return prod1.precioTencia.compareTo(prod2.precioTencia);
					} else {
						//en caso de igualdad, hacemos que salga primero de la lista el producto más caro en la tienda de Compe
						return (-1)*prod1.precioCompe.compareTo(prod2.precioCompe);
					}
				}
				
			}//fin clase anónima
			);
			
			//buscamos en esa lista los productos indicados en minTencia tomamos el precio de Tencia y lo descartamos de la lista
			for (int i=0; i<minTencia; i++) {
				suma+=catalogo.pop().precioTencia;
				
			}
			return suma;
			
		} //fin del método
		
		
		
		//método para elegir el resto de productos por el importe más bajo
		static int elegirPrecioMenor(LinkedList<Producto> catalogo) {
			int suma=0;
			//para los productos que quedan al final, tomanos el menor precio de los dos
			for (Producto prod: catalogo) {
				
				if (prod.precioCompe<=prod.precioTencia) {
					suma+=prod.precioCompe;
				} else {
					suma+=prod.precioTencia;
				}
				
			}
			return suma;
		}//fin del método
	

	public static void main(String[] args) {
	
	String linea;
	String[] preciosCompe;
	String[] preciosTencia;
	int numCompras; //número de compras que tenemos que realizar
	int minCompe, minTencia;  //compras que al menos hay que realizar en las tiendas de Compe y de Tencia
	LinkedList<Producto> catalogo=new LinkedList<>();
	int importeTotal1, importeTotal2;
	
	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				numCompras= Integer.parseInt(lector.nextLine());
				
				//hay que comprobar si llegamos a la condición de terminación
				if (!(numCompras ==0)) {
					//número de compras mínimas en cada tienda
					linea=lector.nextLine();
					minCompe= Integer.parseInt(linea.split("\\s+")[0]);
					minTencia= Integer.parseInt(linea.split("\\s+")[1]);
					//precios de los artículos en cada tienda
					preciosCompe= lector.nextLine().split("\\s+");
					preciosTencia= lector.nextLine().split("\\s+");
					
					
					//decidimos por el primer criterio, eligiendo primero en Compe
					catalogo.clear();
					for (int k=0; k<numCompras; k++) {
						catalogo.add(new Producto( Integer.parseInt(preciosCompe[k]), 
													Integer.parseInt(preciosTencia[k])));
					}
					
					//iniciamos importe total
					importeTotal1=0;
					importeTotal1+=calcularMenoresCompe(catalogo,minCompe);
					importeTotal1+=calcularMenoresTencia(catalogo,minTencia);
					importeTotal1+=elegirPrecioMenor(catalogo);
					
					
					// ahora vemos el segundo criterio
					
					
					//decidimos por el primer criterio, eligiendo primero en Compe
					catalogo.clear();
					for (int k=0; k<numCompras; k++) {
						catalogo.add(new Producto( Integer.parseInt(preciosCompe[k]), 
													Integer.parseInt(preciosTencia[k])));
					}
					
					//iniciamos importe total
					importeTotal2=0;
					importeTotal2+=calcularMenoresTencia(catalogo,minTencia);
					importeTotal2+=calcularMenoresCompe(catalogo,minCompe);
					importeTotal2+=elegirPrecioMenor(catalogo);
					
					
					//salida de resultados, en el formato que nos pida el  enunciado
					System.out.println( (importeTotal1<importeTotal2)? importeTotal1: importeTotal2);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase
