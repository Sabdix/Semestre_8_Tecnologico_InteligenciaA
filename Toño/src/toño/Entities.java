
package toño;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sabdi
 */
public class Entities {
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private Date fechaNacimiento;
    private SimpleDateFormat formatter;
    
    public Entities (String nombre, String apPaterno, String apMaterno, String fechaNacimiento) throws ParseException  {
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.fechaNacimiento = formatter.parse(fechaNacimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getFechaNacimiento() {
        return formatter.format(fechaNacimiento);
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String toString() {
        return this.getNombre() + " " + this.getApPaterno() + " " + this.getApMaterno() + " " + this.getFechaNacimiento();
    }
}
