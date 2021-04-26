package controller;
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

            ShowPolinomioView.printPolinomios(Polinomios.polinomios.toString());
            
            break;
        case '.':
            break;
        default:
            int id = Character.getNumericValue(select);
            ShowPolinomioView.printPolinomios(Polinomios.polinomios.get(id-1).toString());
            break;
        }
    }
}
