package model;

import java.io.IOException;
import java.util.ArrayList;
import model.util.StringToPolinomio;
import model.entities.MatrizEnTripleta;
import model.entities.Polinomio;

public class Matriz {

    public static MatrizEnTripleta matriz = new MatrizEnTripleta();
    public static Polinomio polinomio = new Polinomio();

    /**
     * 
     */
    
    public Matriz() {
        matriz = new MatrizEnTripleta();
        polinomio = new Polinomio();
    }

    
    /** 
     * @param evalRow
     * @return Polinomio
     * @throws IOException
     */
    public static Polinomio replaceLetter(int evalRow) throws IOException {
        ArrayList<Double> currentRow = new ArrayList<Double>();
        char character = 'A';
        int ascii = (int) character;
        String rawPolinomio = "";
        System.out.println(ascii);

        // matriz = FileTo.matrizTripleta("libro1.csv");
        // String literalPolinomio = "At^3+Bt^2+Ct^1";
        String literalPolinomio = polinomio.getStringRepresentation().replaceAll(" ", "");
        // int rowSize = matriz.getRowSize();
        // for (int j = 0; j < rowSize; j++){}
        currentRow = matriz.getRow(evalRow);// for segun las filas de la matriz
        System.out.println(literalPolinomio);
        String parts[] = literalPolinomio.split("(?=\\+)|(?=-)");
        char coef = 'A';
        for (int i = 0; i < parts.length; i++) {
            // System.out.println(coef);
            String tempString = "" + coef;
            // System.out.println(tempString);
            if (i <= currentRow.size()) {
                String termino = parts[i].replaceAll(tempString, Double.toString(currentRow.get(i)));
                //System.out.println(termino);
                rawPolinomio = rawPolinomio + termino;
            }
            coef++;
        }
        //System.out.println(rawPolinomio);
        System.out.println(StringToPolinomio.stringToPolinomio(rawPolinomio).toString());
        polinomio = StringToPolinomio.stringToPolinomio(rawPolinomio);
        return polinomio;
    

    }

    /**
     * 
     */
    
}
