package model.entities;

import java.lang.Double;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import model.Matriz;

public class MatrizEnTripleta {

    protected Tripleta tripletas[];

    /**
     * 
     */
    public MatrizEnTripleta() {
        this.tripletas = new Tripleta[1];
        Tripleta tripletaConfig = new Tripleta(0, 0, (int) 0);
        tripletas[0] = tripletaConfig;
    }

    /**
     * @param tripletas
     */
    public MatrizEnTripleta(int row, int column) {
        this.tripletas = new Tripleta[1];
        Tripleta tripletaConfig = new Tripleta(row, column, (int) 0);
        tripletas[0] = tripletaConfig;
    }

    /**
     * @param row
     * @param column
     * @param data
     */
    public void setElement(int row, int column, double data) {
        int p = 0;
        Tripleta tripletaConfig = tripletas[0];
        int rows = tripletaConfig.getRow();
        int columns = tripletaConfig.getColumn();
        int elements = (int) tripletaConfig.getValue();
        int possition = elements + 1;
        boolean done = false;

        if (rows < row) {
            tripletaConfig.setRow(row + 1);
            // System.out.println("possition out of range");
        }

        if (columns < column) {
            tripletaConfig.setColumn(column + 1);
        }

        if (elements > 0) {
            for (int i = 1; i <= elements; i++) {

                if (tripletas[i].getRow() < row) {
                    possition = i + 1;
                } else if (tripletas[i].getRow() == row) {

                    if (tripletas[i].getColumn() < column) {
                        possition = i + 1;

                    } else if (tripletas[i].getColumn() == column) {
                        tripletas[i].setValue(data);
                        done = true;
                        break;

                    } else {
                        // possition = i;

                    }

                } else {
                    // possition = i;

                }

            }
        }
        if (!done) {
            Tripleta newElement = new Tripleta(row, column, data);
            Tripleta[] newTripletas = new Tripleta[elements + 2];
            tripletaConfig.setValue((int) (elements + 1));

            for (p = 0; p < possition; p++) {
                newTripletas[p] = tripletas[p];
            }

            newTripletas[p] = newElement;

            for (p = possition + 1; p <= tripletas.length; p++) {
                newTripletas[p] = tripletas[p - 1];

            }

            tripletas = newTripletas;
        }
    }

    /**
     * @param row
     * @return ArrayList<Double>
     */
    public ArrayList<Double> getRow(int columns) {
        ArrayList<Double> rowN = new ArrayList<Double>();

        for (int i = 1; i < columns; i++) {
            rowN.add(getValue(columns, i));
        }
        return rowN;
    }

    /**
     * @param column
     * @return ArrayList<Double>
     */
    public ArrayList<Double> getColumn(int rows) {

        ArrayList<Double> columnN = new ArrayList<Double>();
        for (int i = 1; i < rows; i++) {
            columnN.add(getValue(i, rows));
        }
        return columnN;
    }

    // /**
    // * @param column
    // * @return ArrayList<Double>
    // */
    // public ArrayList<Double> getColumn(int column,) {

    // ArrayList<Double> columnN = new ArrayList<Double>();
    // for (int i = 1; i < tripletas.length; i++) {
    // if (tripletas[i].getColumn() == column) {
    // columnN.add(tripletas[i].getValue());
    // }
    // }
    // return columnN;
    // }
    /**
     * @param column
     * @param row
     * @return ArrayList<Double>
     */
    public double getValue(int column, int row) {
        double value = 0;

        for (int i = 1; i < tripletas.length; i++) {
            if (tripletas[i].getRow() == row) {
                if (tripletas[i].getColumn() == column) {
                    value = tripletas[i].getValue();
                }
            }
        }
        return value;
    }

    public int getCelda(int column, int row) {
        int value = 0;

        for (int i = 1; i < tripletas.length; i++) {
            if (tripletas[i].getRow() == row) {
                if (tripletas[i].getColumn() == column) {
                    value = (int) tripletas[i].getValue();
                }
            }
        }
        return value;
    }

    public int getSize() {
        int maxRow = tripletas[0].getRow();
        int maxColumn = tripletas[0].getColumn();

        return Math.max(maxRow, maxColumn);
    }

    public boolean isSquare(){
        return tripletas[0].getRow()==tripletas[0].getColumn();
    }
    /**
     * @param list
     * @param startIndex
     * @param direction
     * @return int
     */
    public int findContrastChanges(ArrayList<Double> list, int startIndex, int direction) {
        // 1 = Right -→
        // 2 = Left ←-
        // 3 = Down ↓
        // 4 = Up ↑
        int position = 0;
        boolean leftOrDown = (direction == 2 || direction == 4);
        double mainConstrast = list.get(startIndex);

        if (leftOrDown) { // 2 = Left ←- // 4 = Up ↑
            Collections.reverse(list);
        }

        List<Double> sublist = list.subList(startIndex, list.size());
        if (mainConstrast == 0) {
            position = leftOrDown ? sublist.size() - (sublist.indexOf(1.0)) : (sublist.indexOf(1.0)) + startIndex;

        } else if (mainConstrast == 1) {
            position = leftOrDown ? sublist.size() - (sublist.indexOf(0.0)) : (sublist.indexOf(0.0)) + startIndex;

        } else {
        }

        return position;
    }

    /**
     * @param row
     * @param column
     * @return int[][]
     */
    public int[][] locate(int row, int column) {
        // 1 = Right -→
        // 2 = Left ←-
        // 3 = Down ↓
        // 4 = Up ↑
        int maxRow = tripletas[0].getRow();
        int maxColumn = tripletas[0].getColumn();
        int requestContrast = (int) getValue(column, row);
        ArrayList<Double> columnList = new ArrayList<Double>();
        ArrayList<Double> rowList = new ArrayList<Double>();
        // o -→ ←- ↓ ↑
        int[][] coordinates = { { 0, 0, 0, 0, 0 }, // x
                { 0, 0, 0, 0, 0 } };// y

        try {
            if (row <= maxRow && column <= maxColumn) {

                requestContrast = (int) getValue(row, column);
                columnList = getColumn(maxRow); // getting the whole column list
                rowList = getRow(maxColumn); // getting the whole row list
                coordinates[0][0] = requestContrast;
                for (int i = 1; i <= 4; i++) { // int i define the direction //1 = Right -→ //2 = Left ←- //3 = Down ↓
                                               // //4 = Up ↑
                    ArrayList<Double> list = (i == 1 || i == 3) ? rowList : columnList;

                    if (i == 1 || i == 2) {
                        coordinates[0][i] = row;
                        coordinates[1][i] = findContrastChanges(list, column, i);
                    } else if (i == 3 || i == 4) {
                        coordinates[1][i] = column;
                        coordinates[0][i] = findContrastChanges(list, row, i);

                    }
                }

            } else {
                System.out.println("out of bounds");
            }
        } catch (Exception error) {
            System.out.println("Catch exception: " + error);
        }
        return coordinates;
    }

    /**
     * @return Tripleta[]
     */
    /*
     * void addTripleta (int possition){ int i Tripleta newElement = new
     * Tripleta(row, column, data); Tripleta[] newTripletas = new Tripleta[elements
     * + 2]; tripletaConfig.setValue((int) (elements + 1));
     * 
     * for(i = 0; i<possition; i++){ newTripletas[i] = tripletas[i]; }
     * 
     * newTripletas[i] = newElement; tripletas = newTripletas; }
     */

    /**
     * Esta función permite crear una matriz en tripleta desde datos ingresados por
     * teclado y pantalla de texto.
     *
     * @return
     */
    // public static MatrizEnTripleta contruirMatrizEnTripletaDesdePantalla() {
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Cantidad de Filas ");
    // int m = sc.nextInt();
    // System.out.println("Cantidad de Columnas ");
    // int n = sc.nextInt();
    // MatrizEnTripleta matrizR = new MatrizEnTripleta(m, n);
    // int cantidadValores = 0;
    // for (int i = 1; i <= m; i++) {
    // for (int j = 1; j <= n; j++) {
    // Object v = pedirDatoxPantalla(i, j);
    // if (v != null) {
    // cantidadValores++;
    // Tripleta t = new Tripleta(i, j, v);
    // matrizR.setTripleta(cantidadValores, t);
    // }
    // }
    // }

    // Tripleta configuracion = new Tripleta(m, n, cantidadValores);
    // matrizR.setTripleta(0, configuracion);
    // return matrizR;
    // }

    // /**
    // * Para pedir datos por pantalla, ejemplos de matriz de numeros incluyendo
    // * los reales
    // *
    // * @param i
    // * @param j
    // * @return
    // */
    // private static Object pedirDatoxPantalla(int i, int j) {
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Ingrese el dato o numero de la fila:" + i + " columna: "
    // + j);
    // Double dato = Double.parseDouble(sc.nextLine());
    // if (dato == 0) {
    // return null;
    // }
    // return dato;
    // }

    public Tripleta[] getTripletas() {
        return tripletas;
    }

    /**
     * @return int
     */
    public int getCantidadValores() {
        return (int) tripletas[0].getValue();
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        // Obtengo la configuración de la matriz, fr y cr y la cantidadValores
        Tripleta configuracion = this.tripletas[0];
        int cantidadFilasMatriz = configuracion.getRow();
        int cantidadColumnasMatriz = configuracion.getColumn();
        int valoresDiferentesCero = (int) configuracion.getValue();

        int posicionArreglo = 1;

        // Recorrido por una matriz virtual m x n
        for (int filasVirtuales = 0; filasVirtuales < cantidadFilasMatriz; filasVirtuales++) {
            for (int columnasVirtuales = 0; columnasVirtuales < cantidadColumnasMatriz; columnasVirtuales++) {
                if (posicionArreglo <= valoresDiferentesCero) {
                    // Estoy en una posicion valida en el arreglo
                    Tripleta posibleTripletaMostrar = tripletas[posicionArreglo];
                    int filaCeldaMostrar = posibleTripletaMostrar.getRow();
                    int columnaCeldaMostrar = posibleTripletaMostrar.getColumn();
                    if (filasVirtuales == filaCeldaMostrar) {
                        if (columnasVirtuales == columnaCeldaMostrar) {
                            Object valorCeldaMostrar = posibleTripletaMostrar.getValue();
                            if (valorCeldaMostrar != null) {
                                cadena.append(" " + valorCeldaMostrar + " ");
                            } else {
                                cadena.append(" 0.0 ");
                            }
                            posicionArreglo++;
                        } else {
                            cadena.append(" 0.0 ");
                        }
                    } else {
                        cadena.append(" 0.0 ");
                    }
                } else {
                    cadena.append(" 0.0 ");
                }
            }
            cadena.append("\n");
        }

        return cadena.toString();
    }

}