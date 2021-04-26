package model.util;

import model.Matriz;
import model.entities.MatrizEnTripleta;
import java.io.*;

public class FileTo {

    public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";

    
    /** 
     * @param filePath
     * @return MatrizEnTripleta
     * @throws IOException
     */
    public static MatrizEnTripleta matrizTripleta(String filePath) throws IOException {
 
        BufferedReader br = null;

        try {
            int rowCounter = 0;
            int columnCounter = 0;
            MatrizEnTripleta matriz = new MatrizEnTripleta();
            br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            
             
            

            while (null != line) {

                String[] fields = line.split(SEPARATOR);
                columnCounter = 0;
                for (String field : fields) {

                    try {
                        double value = Double.parseDouble(field);
                        matriz.setElement(rowCounter, columnCounter, value);
                    } catch (Exception error) {
                        System.out.println(error);

                    }
                    columnCounter++;

                }
                rowCounter++;
                line = br.readLine();
            }
            // System.out.println(matriz.toString());
            return matriz;
        } catch (Exception e) {
            System.out.println(e);
            return null;

        } finally {
            if (null != br) {
                br.close();
            }
        }

    }

    

    public static MatrizEnTripleta stringToRow(String readStrinRow){
        String tempString = readStrinRow;
        MatrizEnTripleta matrizTemp = new MatrizEnTripleta();
        int columnCounter = 0;
        int rowCounter = 0;

        try {
            
            String[] lines = readStrinRow.split("\\r?\\n");
            for (int i = 0; i < lines.length; i++) {
                lines[i] = lines[i].replaceAll(" ", "");
                String[] rowParts = lines[i].split(SEPARATOR); 
            
                for (String field : rowParts) {

                    try {
                        double value = Double.parseDouble(field);
                        matrizTemp.setElement(rowCounter, columnCounter, value);
                    } catch (Exception error) {
                        System.out.println(error);

                    }
                    columnCounter++;
                }
                rowCounter++;
                columnCounter = 0;
            }
           rowCounter = 0; 
           return matrizTemp;
            
        } catch (Exception e) {
        System.out.println(e);
        return null;
      
        }
    }
    // private static String[] removeTrailingQuotes(String[] fields) {

    // String result[] = new String[fields.length];

    // for (int i = 0; i < result.length; i++) {
    // result[i] = fields[i].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$",
    // "");
    // }
    // return result;
    // }
}