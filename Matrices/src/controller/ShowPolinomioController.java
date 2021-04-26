package controller;
import model.Matriz;
import model.Polinomios;

import view.ShowPolinomioView;

public class ShowPolinomioController {
    public static void index() {
        // view
        
        ShowPolinomioView.index();

    }

    
    /** 
     * @param select
     */
    public static void options(char select) {

        switch (select) {
        case '0':
            ShowPolinomioView.printPolinomios(Matriz.polinomio.getStringRepresentation());
            
            break;
        case '.':
            break;
        default:
            break;
        }
    }
}
