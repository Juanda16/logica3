package controller;

import java.io.IOException;
import model.Matriz;
import model.entities.Polinomio;
import model.operations.Evaluation;
import view.EvalPolinomioView;

public class EvalPolinomioController {

    public static void index() {

        EvalPolinomioView.index(Matriz.matriz.toString(), Matriz.matriz.getRowSize());

    }

    public static void evaluate(int row, int t) throws IOException {
        // Replace.replaceLetter();
        Polinomio temPolinomio = new Polinomio();
        if (Matriz.polinomio != null) {
            temPolinomio = Matriz.replaceLetter(row);
        }
        double result = Evaluation.evalPol(temPolinomio, t);
        EvalPolinomioView.result(result);

    }

}
