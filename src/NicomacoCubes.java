import java.util.Scanner;

public class NicomacoCubes {
    int numberImpar = -1;
    int numberCubes = 0;
    boolean exit = true;

    public NicomacoCubes() {
        this.nicomacoCubes();
    }

    private void nicomacoCubes() {
        Scanner sc = new Scanner(System.in);

        while (exit) {
            try {
                System.out.println("Digite cuantos cubos desea obtener: ");
                numberCubes = Integer.parseInt(sc.nextLine());
                if(numberCubes>0){
                    for (int i = 1; i <= numberCubes; i++) {
                        numberImpar += 2;
                        int suma = numberImpar;
                        for (int j = 2; j <= i; j++) {
                            numberImpar += 2;
                            suma += numberImpar;
                        }
                        System.out.println(i +"^3==: "+ suma);
                    }
                    exit = false;
                }else{
                    System.out.println("Inserte un numero mayor a cero. Por favor intente nuevamente\n");
                }
            } catch (NumberFormatException e ){
            System.out.println("Inserte un numero valido. Por favor intente nuevamente\n");
            }
        }
    }
}
