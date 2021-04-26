package controller;

import java.io.IOException;
import java.util.ArrayList;

import jdk.jshell.execution.Util;
import model.Matriz;
import model.entities.MatrizEnTripleta;
import model.entities.Polinomio;
import model.operations.Evaluation;
import model.operations.Replace;
import model.util.FileTo;
import model.util.StringToPolinomio;
import view.EvalPolinomioView;
import model.Matriz;

public class EvalPolinomioController {

    public static void index() {
        
        EvalPolinomioView.index(Matriz.matriz.toString(),4);


    }

       public static void evaluate(int row, int t) throws IOException {
        //Replace.replaceLetter();
        Polinomio temPolinomio = Matriz.replaceLetter(row);
        double result= Evaluation.evalPol(temPolinomio, t);
        EvalPolinomioView.result(result);

       }

}
