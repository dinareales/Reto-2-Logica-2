import java.util.Scanner;

public class Teller{

    int retiro = 0;
    int[] billetes = new int[]{100000,50000,20000,10000,5000,2000,1000};
    int[] monedas =  new int[]{500,200,100,50};
    boolean condition = true;

    public Teller(){ this.teller(); }

    private void teller(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Este programa simulará en funcionamiento de un cajero, y entregara como resultado la cantidad de billetes y monedas\n"+
                "de cada denominación necesarios para realizar un retiro especifico. ");
        while (condition) {
            System.out.println("\nInserte el valor a retirar");
            try {
                retiro = Integer.parseInt(sc.next());
                if(retiro>0){
                  if(retiro%50 == 0){
                      cajero();
                      System.out.println("El retiro se entrego con la siguiente  cantidad de billestes y monedas\n"
                              +"$100.000: "+billetes[0] +" $50.000: " + billetes[1] + " $20.000: "+ billetes[2]+ "\n"
                              +"$10.000 : "+billetes[3] +" $5.000 : " + billetes[4] + " $2.000: "+ billetes[5]+ "\n"
                              +"$1.000  : "+billetes[6] +" $500   : " + monedas[0] + " $200: "+ monedas[1]+ "\n"
                              +"$100    : "+monedas[2] +" $50    : " + monedas[3]);
                      condition = false;
                  }else {
                      System.out.println("No hay forma de entregarle esa cantidad con nuestra moneda\n"
                      +"Inserte un valor que pueda expresarse en terminos de la moneda mas pequeña ( 50 )");
                  }
                }else{
                    System.out.println("Inserte un numero mayor a cero. Por favor intente nuevamente\n");
                }
            } catch (NumberFormatException e ){
                System.out.println("Inserte un numero valido. Por favor intente nuevamente\n");
            }
        }

    }

    /* Para entender la funcion de cajero es importante tener en cuenta que su estructura se repite tanto para billetes como para
    monedas. En ese sentido, se explicara solo en de billetes.

        Retiro: Guarda el total de lo que el usuario dispone a retirar. Ademas, esta cambia en cada ciclo, pues le restamos el valor
        de los billetes y monedas usados hasta que este retiro quede en 0. Lo que signica que se descompuso correctamente el retiro
        en billetes y monedas.

        Residuo: Guarda temporalmente el valor de la resta de de los billetes y monedas para que ne genere conflictos en la asignacion
        del numero de billetes o monedas usados de cada tipo.

        billetes[], monedas[]: Inicialmente guardan el valor del dinero usado en el sistema de referencia. Dado que se conoce el
        sistema y que posicion va a ocupar cada moneda o billete, estos seran modificados para guardar en cada posicion el numero
        usado de cada tipo que le corresponde al retiro.

                (POR CAMBIOS REALIZADOS DESPUES DE REALIZAR ESTOS COMENTARIOS, EL CICLO INICIA EVALUANDO SI
                PRIMERO DEBE ENTREGAR MONEDAS, PERO LA MECANICA SIGUE EL HILO DE LA SIGUIENTE EXPLICACION )


    El ciclo inicia con una validacion que permite identificar si es posible entregar billetes de ese valor. Si no, ira directamente
    al siguinte billete.
    *
            if( !(billetes[i] > retiro)){
                ---Codigo siguiente---
            }else{
                billetes[i]= 0;
            }

    Luego evalua si es necesario utilizar mas billetes de otro tipo, si es asi, asignara los billetes de tipo actual y pasara
    al siguente. De no ser el caso, asignara los billetes necesarios del tipo actual y le asignara 0 a los billetes y monedas
    que no se utilizaron finalizando el ciclo.

        if (retiro%billetes[i] != 0) {
                    residuo = retiro%billetes[i];
                    billetes[i]= retiro/billetes[i];
                    retiro = residuo;
                    ---Codigo siguiente---
                }else{
                    billetes[i]= retiro/billetes[i];
                    for (int j = i+1; j < billetes.length; j++) {
                        billetes[j]= 0;
                    }
                    for (int j = 0; j < monedas.length; j++) {
                        monedas[j] = 0;
                    }
                    break;
                }
    Para finalizar con los billetes e iniciar con las monedas, se realiza una evaluación, para este punto sabemos que el residuo
    no puede ser 0, pues habria ingresado con las validaciones anterirores. Ademas, sabemos que las monedas seran utilizadas
    cuando aun tengamos residuo y ademas no podamos exprezarlos con el menor de los billetes (1000). Lo que concluye con :

             if ((1000 > retiro)){
                --- Duplicacion de mecanica  de billetes en monedas ---
             }

     */

    private void cajero(){
        int residuo =  0;

        if (1000 > retiro){
            for (int i = 0; i < billetes.length; i++) {
                billetes[i]= 0;
            }
            for (int j = 0; j < monedas.length; j++) {
                if( !(monedas[j]>retiro)){
                    if (retiro%monedas[j] != 0){
                        residuo = retiro%monedas[j];
                        monedas[j] = retiro/monedas[j];
                        retiro = residuo;
                    }else{
                        monedas[j]= retiro/monedas[j];
                        for (int k = j+1; k < monedas.length; k++) {
                            monedas[k] = 0;
                        }
                        break;
                    }
                }else {
                    monedas[j]= 0;
                }
            }
        }else{
            for (int i = 0; i < billetes.length; i++) {
                if( !(billetes[i] > retiro)){
                    if (retiro%billetes[i] != 0) {
                        residuo = retiro%billetes[i];
                        billetes[i]= retiro/billetes[i];
                        retiro = residuo;
                        if ((1000 > retiro)){
                            for (int j = 0; j < monedas.length; j++) {
                                if( !(monedas[j]>retiro)){
                                    if (retiro%monedas[j] != 0){
                                        residuo = retiro%monedas[j];
                                        monedas[j] = retiro/monedas[j];
                                        retiro = residuo;
                                    }else{
                                        monedas[j]= retiro/monedas[j];
                                        for (int k = j+1; k < monedas.length; k++) {
                                            monedas[k] = 0;
                                        }
                                        break;
                                    }
                                }else {
                                    monedas[j]= 0;
                                }
                            }
                        }
                    }else{
                        billetes[i]= retiro/billetes[i];
                        for (int j = i+1; j < billetes.length; j++) {
                            billetes[j]= 0;
                        }
                        for (int j = 0; j < monedas.length; j++) {
                            monedas[j] = 0;
                        }
                        break;
                    }
                }else{
                    billetes[i]= 0;
                }
            }
        }
    }
}
