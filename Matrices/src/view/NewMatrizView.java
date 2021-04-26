package view;

import java.util.Scanner;

import controller.MainController;
import controller.NewMatrizController;
import model.Matriz;
import model.Polinomios;
import model.entities.Polinomio;
import view.constants.NewMatrizConstants;

public class NewMatrizView {
    //crea la vista de ingreso de la nueva matriz (copy of newpolinomio view)
    
    static Scanner read = new Scanner (System.in);

    /**
     * Formulario para la creacion de matrices
     */
    public static void index() {
       
        System.out.println(NewMatrizConstants.TITLE );        
               
        char response;
        String readStringRow = ""; 
        
        do {
            System.out.println(NewMatrizConstants.SUBTITLE + Matriz.polinomio.getSizePolLetter());
            System.out.println(NewMatrizConstants.NOTES);
            readStringRow = readStringRow + read.nextLine() + "\n";            
            System.out.println("Fila: "+ readStringRow +" ");
            do {
                System.out.print(NewMatrizConstants.QUESTION);
                response = read.next().charAt(0);
                read.nextLine();
            } while (response != 'y' && response != 'n');
           
        } while (response == 'y');
        NewMatrizController.store(readStringRow);
        System.out.println(NewMatrizConstants.READY);
        
    }
}
    


