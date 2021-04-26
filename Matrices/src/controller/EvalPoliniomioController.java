package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.Matriz;
import model.entities.MatrizEnTripleta;
import model.entities.Polinomio;
import model.util.FileTo;
import model.util.StringToPolinomio;
import model.Matriz;

public class EvalPoliniomioController {

    public static void index() {

    }

    // public static void evaluate(Polinomio polinomio) {
    public static void evaluate() throws IOException {
        ArrayList<Double> currentRow = new ArrayList<Double>();
        char character = 'A';
        int ascii = (int) character;
        String rawPolinomio="";
        System.out.println(ascii);
        MatrizEnTripleta matriz = new MatrizEnTripleta();
        matriz = FileTo.matrizTripleta("libro1.csv");
        String literalPolinomio = "At^3+Bt^2+Ct^1";
        literalPolinomio = literalPolinomio.replaceAll(" ", "");
        currentRow = matriz.getRow(1);
        System.out.println(literalPolinomio);
        String parts[] = literalPolinomio.split("(?=\\+)|(?=-)");
        char coef = 'A';
        for (int i = 0; i < parts.length; i++) {
            //System.out.println(coef);
            String tempString = "" + coef;
            //System.out.println(tempString);
            if (i <= currentRow.size()) {
                String termino = parts[i].replaceAll(tempString, Double.toString(currentRow.get(i)));
                System.out.println(termino);
                rawPolinomio = rawPolinomio + termino;
            }
            coef++;
        }
        System.out.println(rawPolinomio);
        System.out.println(StringToPolinomio.stringToPolinomio(rawPolinomio).toString());
    }
}
