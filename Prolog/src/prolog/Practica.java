package prolog;
/**
 *
 * @author sabdi
 */
public class Practica {
    private String x;
    private String y;
    
    public Practica(){}
    
    public Practica(String x, String y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "Practica("+x+","+y+")\r\n";
    }
}
