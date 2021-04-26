package model.entities;

public class Termino {
    
    private int exp;
    private double coef;
    /**
     * @param exp
     * @param coef
     */
    public Termino(double coef,int exp) {
        this.exp = exp;
        this.coef = coef;
    }
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
    public double getCoef() {
        return coef; 
    }
    /**
     * @param coef the coef to set
     */
    public void setCoef(double coef) {
        this.coef = coef;
    }  
    
    

}