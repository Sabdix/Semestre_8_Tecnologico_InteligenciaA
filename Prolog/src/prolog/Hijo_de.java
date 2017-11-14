package prolog;
/**
 *
 * @author sabdi
 */
public class Hijo_de {
    private String x;
    private String y;

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }
    
    public Hijo_de() {}
    
    public Hijo_de(String x, String y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "Hijo_de("+x+","+y+")\r\n";
    }
}
