import java.util.Arrays;

/*Examples:
52x^2 + 25x^1 + 65  ok
52x^2 + 25x^1 - 65  ok
52x^2-25x^1-65      java.lang.NumberFormatException: For input string: "2-25"
34x^4-345x^3 +12x^2+ 123x + 0  java.lang.NumberFormatException: For input string: "4-345"
25x2 + 10x + 20 ok

*/

public class StringToPolinomio2 {
    int[] polinomio;

    public StringToPolinomio2(String rawPolinomio) {

        try {
            rawPolinomio =rawPolinomio.replaceAll(" ", "");
            System.out.println(rawPolinomio);
            String parts[] = rawPolinomio.split("(?=\\+)|(?=-)"); 
            
            polinomio = new int[parts.length];
            int coef=0;
            int exp=0;
            String termino[]= {"0","0","0"};
            for (int i = 0; i < parts.length; i++) { 
                termino = parts[i].split("(?=\\+)|(?=-)|x\\^");
                if (termino.length==1) {
                    coef = Integer.parseInt(termino[0]);
                    exp=0;
                    System.out.println(parts[i]);
                    
                }else{
                System.out.println(parts[i]);
                coef = Integer.parseInt(termino[0]);
                exp = Integer.parseInt(termino[1]); 
                }
                /* *Verifico que la cadena contenga el sigono + o - */
                /*if ((termino[0].equals("+"))|(termino[0].equals("-"))) {
                    termino[0]= termino[0]+termino[1];
                    termino[1]= termino[2];
                }
                */
               
                Terminos termino1 = new Terminos(exp, coef);
                System.out.println(termino1.getCoef());
                System.out.println(termino1.getExp());
            }

                

        }catch (Exception error) {
            System.out.println(error);
            }
            
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "StringToPolinomio2 [polinomio=" + Arrays.toString(polinomio) + "]";
    }

        
    }

