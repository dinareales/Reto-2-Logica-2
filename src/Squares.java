import java.util.Scanner;

public class Squares  {
    int n = 0;
    boolean condition = true;

    public Squares() {
        this.squares();
    }

    private void squares(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Este programa escribirá el cuadrado de cada numero hasta el indicado por el usuario\n"+
                "Este procedimiento lo hara por medio de suma de numeros impares");
        while (condition) {
            System.out.println("\nInserte el número maximo para el calculo");
            try {
                n = Integer.parseInt(sc.next());
                if(n>0){
                    cuadrados(n);
                    condition = false;
                }else{
                    System.out.println("Inserte un numero mayor a cero. Por favor intente nuevamente\n");
                }
            } catch (NumberFormatException e ){
                System.out.println("Inserte un numero valido. Por favor intente nuevamente\n");
            }
        }
    }

    private void cuadrados(int base){
        int sumatoria = 0;
        int numUsado = 1;
        System.out.println("\nNúmeros usados para la base: " + base + "----------------------");

        if ( base != 1){
            for (int i = 0; i < base; i++){
                System.out.println(numUsado);
                sumatoria += numUsado;
                numUsado+=2;
            }
            System.out.println("El cuadrado de la base "+ base +" es " +sumatoria);
        }else{
            System.out.println(1);
            System.out.println("El cuadrado de la base 1 es 1");
        };
    }
}
