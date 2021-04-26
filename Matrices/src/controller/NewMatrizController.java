package controller;

import model.Matriz;
import model.Polinomios;
import view.NewMatrizView;
import model.util.FileTo;
import model.util.StringToPolinomio;
import model.entities.*;

public class NewMatrizController {

    public static void index() {
        NewMatrizView.index();

    }

     /** 
           * @param rawPolinomio
           */

    public static void store(String readStringRow) {

        MatrizEnTripleta tempMatriz = new MatrizEnTripleta(FileTo.stringToRow(readStringRow));
        System.out.println(tempMatriz.toString());
        Matriz.matriz = tempMatriz;
      
      System.out.println(Matriz.matriz.toString());
      
         
     }
}


