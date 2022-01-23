import java.io.IOException;

import model.entities.MatrizEnTripleta;
import model.entities.NodoDoble;
import model.entities.Tripleta;
import model.util.FileTo;

public class Main {

    /**
     * @param args
     * @throws IOException
     */
    public void main(String[] args) throws IOException {
        MatrizEnTripleta matrizEnTripleta = new MatrizEnTripleta(); // Aqui irian las matrices reales
        MatrizEnListaLigadaForma2 matrizForma2 = new MatrizEnListaLigadaForma2();

        if (compare(matrizEnTripleta, matrizForma2)) {
            System.out.println("Las Matrices son iguales");
        } else {
            System.out.println("Las Matrices NO son iguales");
        }
    }

    boolean compare(MatrizEnTripleta matrizEnTripleta, MatrizEnListaLigadaForma2 matrizForma2) {

        final int iterations = matrizEnTripleta.getTripletas().length;
        final int matrizTripletaSize = matrizEnTripleta.getSize();
        final int matrizForma2Size = matrizForma2.getSize();

        final boolean areEqual = matrizTripletaSize == matrizForma2Size;
        final boolean areNull = matrizEnTripleta == null || matrizForma2 == null;

        NodoDoble nodoCabeza = matrizForma2.nodoConfiguracion.getLigaF();
        NodoDoble nodoRecorrido = nodoCabeza.getLigaF();

        if (areNull)
            return false;

        if (!matrizEnTripleta.isSquare() || !matrizForma2.isSquare()) {
            return false;
        }

        if (!areEqual) {
            return false;
        }

        for (int i = 1; i <= iterations; i++) {

            if (nodoRecorrido == null || nodoRecorrido != nodoCabeza) {
                return false;
            }

            Tripleta tripletaRecorridoMatrizForma2 = nodoRecorrido.getTripleta();
            Tripleta tripletaRecorridoMatrizTripleta = matrizEnTripleta.getTripletas()[i];

            // Esto se puede ya que al recorrer la matriz forma 2 por las filas siempre
            // obtengo
            // la tripleta siguiente al igual que en el arreglo de tripletas de la matriz
            // por tripletas
            if (!tripletaRecorridoMatrizTripleta.equals(tripletaRecorridoMatrizForma2))
                return false; // usando el operador == de [Tripleta]

            nodoRecorrido = nodoRecorrido.getLigaF();

        }
        return true;

    }

}
