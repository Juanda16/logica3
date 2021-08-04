import java.io.IOException;
import model.entities.MatrizEnTripleta;
import model.util.FileTo;


public class Main {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
       
        MatrizEnTripleta matriz;
        int row = 3, column=3;
        matriz = FileTo.matrizTripleta("libro1.csv"); // Matriz obtenida de archivo para simulación
        int[][] coordinates = matriz.locate(3, 3); // Método principal requerida , ingresa f y c
        System.out.println(matriz.toString());
        System.out.println("Resultado");
        System.out.println("Coordenadas a analizar: " + row +" , " + column + "\n"  
        + "Contraste de la posición: " + coordinates[0][0]  + "\n"        
        + "Cruz derecha: "   + coordinates[0][1] +" , " + coordinates[1][1] + "\n"
        + "Cruz izquierda: " + coordinates[0][2] +" , " + coordinates[1][2] + "\n"
        + "Cruz abajo: "     + coordinates[0][3] +" , " + coordinates[1][3] + "\n"
        + "Cruz arriba: "    + coordinates[0][4] +" , " + coordinates[1][4] + "\n");
        
        // 1 = Right -→
        // 2 = Left ←-         
        // 3 = Down ↓
        // 4 = Up ↑

    }
}
