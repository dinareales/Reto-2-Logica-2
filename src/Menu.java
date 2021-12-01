import java.util.Scanner;

public class Menu {
    boolean exit = false;
    int option;

    public Menu() {
        this.menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        while (!exit) {
            System.out.print("Menu Basico \n 1. Construir las tablas de multiplicar de los números de 1 a N, 1 \n " +
                    "2. Calcular el cuadrado de un numero por suma de números impares \n " +
                    "3. Calcule los cubos de los primeros N números enteros. \n " +
                    "4. Opcion 4\n " +
                    "5. Salir \n");
            System.out.print("Ingrese una opcion: ");
            try {
                option = Integer.parseInt(sc.next());
                switch (option) {
                    case 1:
                        new Multiplication();
                        break;
                    case 2:
                        new Squares();
                        break;
                    case 3:
                        new NicomacoCubes();
                        break;
                    case 4:
                        System.out.print("Bienvenido estas en la Opcion 4! \n");
                        break;
                    case 5:
                        System.out.print("Hasta luego!");
                        exit = true;
                        break;
                    default:
                        System.out.print("Opcion no valida!\n\n");
                }
            } catch (NumberFormatException ex ){
                System.out.println("Inserte un numero valido. Por favor intente nuevamente\n\n");
            }
        }
    }
}


