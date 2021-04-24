package controller;

import view.constants.NewMatriz;

//import view.constants;

public class MainController {


    
    /** 
     * @param select
     */
    public static void index(char select) {
        switch (select) {
        case '1':NewPolinomioController.index();                    
            break;
        case '2':ShowPolinomioController.index();
            break;
        case '3':NewMatrizController.index();
            break;
        case '4':ShowMatrizController.index();
            break;
        case '5':EvalPoliniomioController.index();
            break;
        case '.':
            break;
        default:
            System.out.println("error");

        }

    }

}