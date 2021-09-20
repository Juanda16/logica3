package util;

import java.io.*;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import models.DnaTest;

public class FileTo {

    public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";

    /**
     * @param filePath
     * @return MatrizEnTripleta
     * @throws IOException
     */
    public static ArbolAVL<DnaTest> recordTree(String filePath) throws IOException {

        BufferedReader br = null;

        try {

            ArbolAVL<DnaTest> record = new ArbolAVL<DnaTest>();
            br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();

            while (null != line) {

                String[] fields = line.split(SEPARATOR);

                try {
                    DnaTest tempTest = new DnaTest();
                    tempTest.setUserId(Integer.parseInt(fields[0]));
                    tempTest.setName(fields[1]);
                    tempTest.setGen1(fields[2]);
                    tempTest.setGen2(fields[3]);
                    tempTest.setGen3(fields[4]);
                    tempTest.setGen4(fields[5]);
                    tempTest.setFatherId(Integer.parseInt(fields[6]));

                    record.insertarDato(tempTest);

                } catch (Exception error) {
                    System.out.println(error);

                }

                line = br.readLine();
            }
            System.out.println(record.toString());
            return record;
        } catch (Exception e) {
            System.out.println(e);
            return null;

        } finally {
            if (null != br) {
                br.close();
            }
        }

    }

}