import java.util.Arrays;
import java.util.Scanner;

class MetodosBusqueda {
	

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

	}

}
