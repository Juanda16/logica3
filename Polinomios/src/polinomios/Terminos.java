/**
 *
 * @author JD
 */
public class Terminos {
    private int exp;
    private int coef;
    

    /**
     * @return the exp
     */
    public int getExp() {
        return exp;
    }
    /**
     * @param exp the exp to set
     */
    public void setExp(int exp) {
        this.exp = exp;
    }
    /**
     * @return the coef
     */
    public int getCoef() {
        return coef;
    }
    /**
     * @param coef the coef to set
     */
    public void setCoef(int coef) {
        this.coef = coef;
    }
    /**
     * @param exp
     * @param coef
     */
    public Terminos(int exp, int coef) {
        this.exp = exp;
        this.coef = coef;
    }
    
    
}