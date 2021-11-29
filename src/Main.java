import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int n = 0;
        int m = 0;
        Scanner lectura = new Scanner(System.in);

        System.out.print("Este programa escribirá las tablas de multiplicar con base a 2 numeros.\n" +
                        "El primero define el rango de las tablas. Iniciando en 1 y finalizando en el número indicado.\n" +
                        "El segundo define que tanto de cada tabla se mostrara. Iniciando en 1 y finalizando en el número indicado\n");
        System.out.println("\nInserte el primer número");
        n = lectura.nextInt();
        System.out.println("Inserte el segundo número");
        m = lectura.nextInt();
        for (int i = 1; i <= n; i++){
            tabla(i,m);
        };
    }

    public static void tabla(int multiplicando, int maxMultiplicador ){
        System.out.println("\nInicio tabla del "+ multiplicando + " ---------------------");
        for (int i = 1; i <= maxMultiplicador; i++){
            System.out.println(multiplicando + " x "+ i + " = "+ multiplicando*i);
        };
    };
}
