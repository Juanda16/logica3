package model.entities;

public class Tripleta {
    int row = 0, column = 0;
    double value;

    /**
     * @param row
     * @param column
     * @param value
     */
    public Tripleta(int row, int column, double value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    
    /** 
     * @return Tripleta
     */
    // public static Tripleta ingresarTripletaPorPantalla() {
    //     Scanner sc;
    //     sc = new Scanner(System.in);

    //     System.out.println("Ingrese la tripleta separada por (coma ,) [ Ejemplo: 2,3,5] :");
    //     String datos[] = sc.next().split(",");
    //     Tripleta t = null;
    //     int f = Integer.valueOf(datos[0]);
    //     int c = Integer.valueOf(datos[1]);
    //     int v = Integer.valueOf(datos[2]);
    //     if (!(f == 0 || c == 0 || v == 0)) {
    //         t = new Tripleta(f, c, v);
    //     }
    //     sc.close();
    //     return t;
    // }

    
    /** 
     * @return Tripleta
     */
    public Tripleta clonar() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tripleta other = (Tripleta) obj;
        if (column != other.column)
            return false;
        if (row != other.row)
            return false;
        if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
            return false;
        return true;
    }

    
    
}
