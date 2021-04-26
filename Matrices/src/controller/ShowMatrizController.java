package controller;

import model.Matriz;
//import model.entities.MatrizEnTripleta;
import view.ShowMatrizView;

public class ShowMatrizController {
    public static void index() {
        // view
        
        ShowMatrizView.index();

    }

   /** 
     * @param select
     */
    public static void options(char select) {

        switch (select) {
        case '0':
            ShowMatrizView.printMatriz(Matriz.matriz.toString());
            
            break;
        case '.':
            break;
        default:
            break;
        }
    }
    
}
