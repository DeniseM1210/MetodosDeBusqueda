import java.util.Arrays;
import java.util.Scanner;

class MetodosBusqueda {
	String[] arreglo;
	int tamaño;
	int contador;
	
	public MetodosBusqueda(int tam) {
		tamaño = tam;
		arreglo = new String[tam];
		Arrays.fill(arreglo, "-1");
	}
	
	public void MetodosBusqueda(String[] cadArreglo, String[] arreglo) {
		for(int i = 0; i < cadArreglo.length; i++) {
			String elemento = cadArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento) % 7;
			System.out.println("Indice: " + indiceArreglo + " para " + elemento);
			while(arreglo[indiceArreglo] != "-1") {
				indiceArreglo++;
				System.out.println("Colision en el indice: " + (indiceArreglo - 1) + " cambiado por: " + indiceArreglo);
				indiceArreglo %= tamaño;
			}
			arreglo[indiceArreglo] = elemento;
		}
	}
	
	public void mostrar() {
		int incremento = 0;
		int j;
		for(int i = 0; i < 1; i++) {
			incremento += 8;
			for(j = 0; j < 100; j++) {
			}
			System.out.println("");
			System.out.println("---------------------------------");
			for(j = incremento - 8; j < incremento; j++) {
				System.out.format(" | %3s" + " ", j);
			}
			System.out.println(" | ");
			for(j = incremento - 8; j < incremento; j++) {
				if(arreglo[j].equals(" - 1 ")) {
					System.out.println(" | ");
				}else {
					System.out.println(String.format(" | %3s " + " ", arreglo[j]));
				}
			}
			System.out.println();
			System.out.println("------------------------------");
			for(j = 0; j < 100; j++) {
			}
			System.out.println();
		}
	}
	
	public String buscarClave(String elemento) {
		int indiceArreglo = Integer.parseInt(elemento) % 7;
		int contador = 0;
		
		while(arreglo[indiceArreglo] != "-1") {
			if(arreglo[indiceArreglo] == elemento) {
				System.out.println("Elemento: " + elemento + " se encontro en el indice: " + indiceArreglo);
				return arreglo[indiceArreglo];
			}
			indiceArreglo++;
			indiceArreglo %= tamaño;
			contador++;
			if(contador > 7) {
				System.out.println("error");
				break;
			}
		}
		return null;
		
	}

	public static int busquedaBin(int[] matriz, int valorBuscado) {
		if (matriz.length == 0) {
			return -1;
		}

		int mitad, inferior = 0;
		int superior = matriz.length-1;

		do {
			mitad = (inferior + superior) / 2;
			if (valorBuscado > matriz[mitad]) {
				inferior = mitad + 1;
			} else {
				superior = mitad-1;
			}
		} while (matriz[mitad] != valorBuscado && inferior <= superior);

		if (matriz[mitad] == valorBuscado) {
			return mitad;
		} else {
			return -1;
		}

	}
	
	

}

public class PruebaMetodosBusqueda {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	    int[] matriz= {1,4,6,8,19,23,56,78,98,100,102};
	    System.out.println("Ingrese el valor buscado");
	    int buscado = entrada.nextInt();
	    System.out.println("Vector: " + Arrays.toString(matriz));
	    MetodosBusqueda.busquedaBin(matriz, buscado);
	    
	    System.out.println("----------------------------");
	    
	    MetodosBusqueda mb = new MetodosBusqueda(8);
	    String[] elementos = {"25", "14", "96", "300", "1", "12", "8", "7"};
	    mb.MetodosBusqueda(elementos, mb.arreglo);
	    mb.mostrar();
	    
	    String buscarElemento = mb.buscarClave("500");
	    if(buscarElemento == null) {
	    	System.out.println("\n Elemento no encontrado");
	    }

	}

}
