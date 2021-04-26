package model.operations;

import java.io.IOException;
import java.util.ArrayList;
import model.entities.MatrizEnTripleta;
import model.util.FileTo;
import model.util.StringToPolinomio;

public class Replace {
     // public static void evaluate(Polinomio polinomio) {
        public static void replaceLetter() throws IOException {
            ArrayList<Double> currentRow = new ArrayList<Double>();
            char character = 'A';
            int ascii = (int) character;
            String rawPolinomio="";
            System.out.println(ascii);
            MatrizEnTripleta matriz = new MatrizEnTripleta();
            matriz = FileTo.matrizTripleta("libro1.csv");
            String literalPolinomio = "At^3+Bt^2+Ct^1";
            literalPolinomio = literalPolinomio.replaceAll(" ", "");
            currentRow = matriz.getRow(1);//for segun  las filas de la matriz
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
