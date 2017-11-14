
package generadordesentencias;

import java.util.Scanner;

/**
 *
 * @author sabdi
 */
public class GeneradorDeSentencias {
    
    private static String sujetos[];
    private static String verbos[];
    private static String complementos[];
    private static int probabilidades [][];

    public static void main(String[] args) {
        // Creamos el teclado que escribirá en la consola
        Scanner teclado = new Scanner(System.in);
        
        // Inicializamos los sujetos
        sujetos = new String[10];
        sujetos[0] = "Alejandra";
        sujetos[1] = "Baltazar";
        sujetos[2] = "Mariano";
        sujetos[3] = "Victor";
        sujetos[4] = "Alondra";
        sujetos[5] = "Toño";
        sujetos[6] = "Rodrigo";
        sujetos[7] = "Sabdi";
        sujetos[8] = "Iván";
        sujetos[9] = "Alejandro";
        
        // Inicializamos los verbos
        verbos = new String[10];
        verbos[0] = "Besa";
        verbos[1] = "trabaja";
        verbos[2] = "lee";
        verbos[3] = "piensa";
        verbos[4] = "golpea";
        verbos[5] = "molesta";
        verbos[6] = "rie";
        verbos[7] = "cuenta";
        verbos[8] = "escucha";
        verbos[9] = "imparte";
        
        //Inicializamos los complementos
        complementos = new String[10];
        complementos[0] = "a Sabdi con ternura";
        complementos[1] = "en el trabajo de ingeniería del conocimiento";
        complementos[2] = "un cómic de DeadPool";
        complementos[3] = "en la chava que le gusta";
        complementos[4] = "a Rodrigo por el simple hecho de ser rosado";
        complementos[5] = "a Sabdi para que le explique el trabajo";
        complementos[6] = "de cualquier cosa que diga Sabdi o Baltazar";
        complementos[7] = "un chiste para que el Rodrigo se ria";
        complementos[8] = "a una mujer que le dice que no";
        complementos[9] = "clases como nadie";
        
        //Inicializamos las probabilidades
        probabilidades = new int[10][10];
        probabilidades[0][0] = 9;
        probabilidades[0][1] = 5;
        probabilidades[0][2] = 8;
        probabilidades[0][3] = 1;
        probabilidades[0][4] = 9;
        probabilidades[0][5] = 7;
        probabilidades[0][6] = 2;
        probabilidades[0][7] = 4;
        probabilidades[0][8] = 9;
        probabilidades[0][9] = 1;
        
        probabilidades[1][0] = 6;
        probabilidades[1][1] = 6;
        probabilidades[1][2] = 7;
        probabilidades[1][3] = 7;
        probabilidades[1][4] = 6;
        probabilidades[1][5] = 6;
        probabilidades[1][6] = 6;
        probabilidades[1][7] = 6;
        probabilidades[1][8] = 6;
        probabilidades[1][9] = 5;
        
        probabilidades[2][0] = 9;
        probabilidades[2][1] = 5;
        probabilidades[2][2] = 9;
        probabilidades[2][3] = 5;
        probabilidades[2][4] = 6;
        probabilidades[2][5] = 5;
        probabilidades[2][6] = 8;
        probabilidades[2][7] = 7;
        probabilidades[2][8] = 6;
        probabilidades[2][9] = 1;
        
        probabilidades[3][0] = 1;
        probabilidades[3][1] = 9;
        probabilidades[3][2] = 6;
        probabilidades[3][3] = 9;
        probabilidades[3][4] = 2;
        probabilidades[3][5] = 2;
        probabilidades[3][6] = 6;
        probabilidades[3][7] = 8;
        probabilidades[3][8] = 5;
        probabilidades[3][9] = 1;
        
        probabilidades[4][0] = 9;
        probabilidades[4][1] = 1;
        probabilidades[4][2] = 6;
        probabilidades[4][3] = 1;
        probabilidades[4][4] = 9;
        probabilidades[4][5] = 9;
        probabilidades[4][6] = 4;
        probabilidades[4][7] = 1;
        probabilidades[4][8] = 7;
        probabilidades[4][9] = 1;
        
        probabilidades[5][0] = 9;
        probabilidades[5][1] = 6;
        probabilidades[5][2] = 3;
        probabilidades[5][3] = 3;
        probabilidades[5][4] = 8;
        probabilidades[5][5] = 8;
        probabilidades[5][6] = 6;
        probabilidades[5][7] = 2;
        probabilidades[5][8] = 8;
        probabilidades[5][9] = 1;
        
        probabilidades[6][0] = 1;
        probabilidades[6][1] = 9;
        probabilidades[6][2] = 3;
        probabilidades[6][3] = 4;
        probabilidades[6][4] = 4;
        probabilidades[6][5] = 4;
        probabilidades[6][6] = 9;
        probabilidades[6][7] = 3;
        probabilidades[6][8] = 3;
        probabilidades[6][9] = 1;
        
        probabilidades[7][0] = 1;
        probabilidades[7][1] = 2;
        probabilidades[7][2] = 6;
        probabilidades[7][3] = 5;
        probabilidades[7][4] = 6;
        probabilidades[7][5] = 6;
        probabilidades[7][6] = 6;
        probabilidades[7][7] = 9;
        probabilidades[7][8] = 6;
        probabilidades[7][9] = 1;
        
        probabilidades[8][0] = 9;
        probabilidades[8][1] = 6;
        probabilidades[8][2] = 6;
        probabilidades[8][3] = 2;
        probabilidades[8][4] = 8;
        probabilidades[8][5] = 8;
        probabilidades[8][6] = 8;
        probabilidades[8][7] = 8;
        probabilidades[8][8] = 9;
        probabilidades[8][9] = 6;
        
        probabilidades[9][0] = 5;
        probabilidades[9][1] = 9;
        probabilidades[9][2] = 5;
        probabilidades[9][3] = 4;
        probabilidades[9][4] = 5;
        probabilidades[9][5] = 5;
        probabilidades[9][6] = 7;
        probabilidades[9][7] = 7;
        probabilidades[9][8] = 5;
        probabilidades[9][9] = 9;
        
        //Hacemos el Random
        String sentencia2, sentencia = "";
        int verbo, predicado;
        sentencia2 = sujetos[(int)(Math.random()*9)];
        do {
            verbo = (int)(Math.random()*9);
            predicado = (int)(Math.random()*9);   
            sentencia = " " + verbos[verbo] + " " + complementos[predicado] + " Tiene una probabilidad de ";
            System.out.println(sentencia2 + sentencia + probabilidades [verbo][predicado] + "0%\n");
        } while (probabilidades [verbo][predicado] <= 5);
    }
    
}
