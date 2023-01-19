import java.util.Scanner;

public class PigElCerdo {

    public static int tirarDado() {
        int resultado = (int) (Math.random()*6+1);

        return resultado;
    }

    public static int[] turno(int array[], int posicion, String texto) {
        
        int datos[] = {0, 0}; 
        //Primera posicion-->[0] es la posicion del array y la segunda posicion-->[1] es la suma de los puntos
        int contPos = 0;

        for (int i = 0; i < 3; i++) {
            array[posicion] = tirarDado();
            if(array[posicion] == 1) {
                System.out.println("En la tirada numero " + (i + 1) + ", del " + texto + " ha salido un " + array[posicion] + " asi que no hay mas tiradas y gana 0 puntos");
                contPos++;
                datos[0] = contPos;
                datos[1] = 0;
                i = 3;
            } else {                   
                System.out.println("En la tirada numero " + (i + 1) + ", del " + texto + " ha salido un " + array[posicion]);
                datos[1] = datos[1] + array[posicion];
                posicion ++;
                contPos++;
            }
        }
        datos[0] = contPos;

        return datos;
    }

    public static void mostrarTiradas(int array[], int ultReg) {
        for (int i = 0; i < ultReg; i++) {
            System.out.print(array[i] + ", ");
        }

    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        final int PUNTUACION_FINAL = 100;
        int tusPuntos = 0;
        int iaPuntos = 0;

        int tiradasJugador[] = new int[100];
        int tiradasIa[] = new int[100];
        
        int resultado[] = new int[2];
        int contPosJug = 0;
        int contPosIa = 0;

        String texto = "";

        int turno = 2;

        do {
            if((turno%2) == 0) {
                System.out.println();
                System.out.println();
                texto = "Jugador 1";
                resultado = turno(tiradasJugador, contPosJug, texto);
                tusPuntos = tusPuntos + resultado[1];
                contPosJug = contPosJug + resultado[0];
            } else {
                System.out.println();
                System.out.println();
                texto = "Jugador 2";
                resultado = turno(tiradasIa, contPosIa, texto);
                iaPuntos = iaPuntos + resultado[1];
                contPosIa = contPosIa + resultado[0];
            }

            turno++;

            System.out.println("|- - - -PUNTUACIONES- - - - -");
            System.out.println("|      Jugador 1: " + tusPuntos);
            System.out.println("|----------------------------");
            System.out.println("|      Jugador 2: " + iaPuntos);


            System.out.println();
            System.out.println("_____________________________________________");

            System.out.println("PULSA ~ENTER~ PARA PASAR AL SIGUIENTE JUGADOR");
            System.out.println("_____________________________________________");
            sc.nextLine();
            
        } while (tusPuntos < PUNTUACION_FINAL && iaPuntos < PUNTUACION_FINAL);

        if(tusPuntos > PUNTUACION_FINAL) {
            System.out.println();            
            System.out.println();
            System.out.println("_____________________________________________");
            System.out.println("ENHORABUENA HAS GANADO");
            System.out.println("_____________________________________________");
        } else {
            System.out.println();
            System.out.println();
            System.out.println("_____________________________________________");
            System.out.println("VAYA HAS PERDIDO");
            System.out.println("_____________________________________________");
        }

        System.out.println();
        System.out.println();
        System.out.println("Estas han sido tus tiradas en el juego:");
        mostrarTiradas(tiradasJugador, contPosJug);

        System.out.println();
        System.out.println();
        System.out.println("Estas han sido las tiradas de la maquina en el juego:");
        mostrarTiradas(tiradasIa, contPosIa);

        sc.close();
    }
}
