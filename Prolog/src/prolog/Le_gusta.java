package prolog;
/**
 *
 * @author sabdi
 */
public class Le_gusta {
    private String x;
    private String y;
    
    public Le_gusta() {}
    
    public Le_gusta(String x, String y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "Le_gusta("+x+","+y+")\r\n";
    }
}
