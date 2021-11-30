import java.util.Scanner;

public class Multiplication {
    int n;
    int m;
    boolean condition = true;

    public Multiplication() {
        this.multiplication();
    }

    private void multiplication() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Este programa escribirá las tablas de multiplicar con base a 2 numeros.\n" +
                "El primero define el rango de las tablas. Iniciando en 1 y finalizando en el número indicado.\n" +
                "El segundo define que tanto de cada tabla se mostrara. Iniciando en 1 y finalizando en el número indicado\n");
        while (condition) {
            System.out.println("\nInserte el primer número");
            try {
                n = Integer.parseInt(sc.next());
                System.out.println("Inserte el segundo número");
                m = Integer.parseInt(sc.next());
                if(n>0 && m >0){
                    for (int i = 1; i <= n; i++){
                        tabla(i,m);
                    }
                    condition = false;
                }else{
                    System.out.println("Inserte un numero mayor a cero. Por favor intente nuevamente\n");
                }
            } catch (NumberFormatException e ){
                System.out.println("Inserte un numero valido. Por favor intente nuevamente\n");
            }
        }
    }

    private void tabla(int multiplicando, int maxMultiplicador ){
        System.out.println("\nInicio tabla del "+ multiplicando + " ---------------------");
        for (int i = 1; i <= maxMultiplicador; i++){
            System.out.println(multiplicando + " x "+ i + " = "+ multiplicando*i);
        }
    }
}
