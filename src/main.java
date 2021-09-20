import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import arbol.binario.listaligada.normal.ArbolBinarioListaLigada;
import arbol.binario.listaligada.normal.NodoBinarioGenerico;
import models.DnaTest;
import java.io.IOException;
import util.FileTo;

public class main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // String inorden = "gehicbfdajklnmop";
        // String preorden = "abceghidflkjmnop";

        ArbolAVL<DnaTest> record = new ArbolAVL<DnaTest>();
        record = FileTo.recordTree("src/muestras.csv");
        String inorden = "gehicrbfdajklnmop";

        String preorden = "abceghirdflkjmnop";

        Character[] inordenCH = convertirChar2Character(inorden);
        Character[] preordenCH = convertirChar2Character(preorden);

        ArbolBinarioListaLigada abll = new ArbolBinarioListaLigada();
        NodoBinarioGenerico raiz = abll.construyeArbolCadenaPREyIN(preordenCH, inordenCH);

        abll.setRaiz(raiz);
        ArbolBinarioListaLigada.inorden(raiz);
    }

    private static Character[] convertirChar2Character(String cadena) {
        Character[] nuevoCH = new Character[cadena.length()];
        for (int i = 0; i < cadena.length(); i++) {
            Character c = cadena.charAt(i);
            nuevoCH[i] = c;
        }
        return nuevoCH;
    }

}
