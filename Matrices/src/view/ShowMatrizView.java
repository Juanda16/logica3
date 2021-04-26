package view;

import java.util.Scanner;
import view.constants.ShowMatrizConstants;

public class ShowMatrizView {
    static Scanner read = new Scanner (System.in);
    
    public static void index() {
        System.out.print(ShowMatrizConstants.TITLE);
        char select;

        do {
            for (String option : ShowMatrizConstants.OPTIONS) {
                System.out.println(option);
            }
            System.out.print("choice: ");
            select = read.next().charAt(0);
            controller.ShowMatrizController.options(select);

        } while (select != '.');
    }
    
    /** 
     * @param polinomios
     */
    public static void printMatriz(String matriz) {
        
        System.out.println(ShowMatrizConstants.RESULT);
        System.out.println(matriz);

        char select;
        do {
            System.out.print(ShowMatrizConstants.OUT);
            select = read.next().charAt(0);
            read.nextLine();

        } while (select != '.');
    }
}
