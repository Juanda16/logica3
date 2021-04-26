import java.io.IOException;

import model.Matriz;
// import controller.EvalPolinomioController;
// import model.entities.MatrizEnTripleta;
// import model.util.FileTo;
import view.Index;

public class Main {
        
    Matriz matriz = new Matriz();   
    /** 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Index.mainScreen();
        
        // matriz = FileTo.matriz("libro1.csv");
        
        // System.out.println(matriz.toString());
         //   EvalPoliniomioController.evaluate();

        
    }
}
