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
                    "4. Determinar cuantos billetes necesita de cada precio para formar un valor especifico\n " +
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
                        new Teller();
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


