package prolog;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author sabdi
 */
public class Procesa {

    private final ArrayList<Hijo_de> lstHijo;
    private final ArrayList<Le_gusta> lstGusta;
    private final ArrayList<Practica> lstPractica;
    private final ArrayList<String> saludo = new ArrayList<>();
    private final ArrayList<String> despedida = new ArrayList<>();
    private Date fecha;

    public Procesa(ArrayList<Hijo_de> lstHijo, ArrayList<Le_gusta> lstGusta, ArrayList<Practica> lstPractica) {
        this.lstHijo = lstHijo;
        this.lstGusta = lstGusta;
        this.lstPractica = lstPractica;

        // Inicializar Saludo
        saludo.add("Hola!!");
        saludo.add("Que hay!!");
        saludo.add("Que onda");
        saludo.add("Whats up nigga!");
        saludo.add("Hola, como estas?");

        // Inicializar Despedida
        despedida.add("Adios");
        despedida.add("Adios, regresa pronto");
        despedida.add("Byes");
        despedida.add("Hasta luego");
        despedida.add("Delete Flash");

        fecha = new Date();
    }

    public ArrayList<Hijo_de> getLstHijo() {
        return lstHijo;
    }

    public ArrayList<Le_gusta> getLstGusta() {
        return lstGusta;
    }

    public ArrayList<Practica> getLstPractica() {
        return lstPractica;
    }

    public String ProcesarCadena(String cadena) {
        String respuesta = fecha.toString() +" \"No entiendo tu pregunta\" ";

        if (cadena.toUpperCase().contains("HOLA")) {
            return fecha.toString() + " \"" + randomSaludo() + "\"";
        }
        if (cadena.toUpperCase().contains("AYUDA") || cadena.toUpperCase().contains("?")) {
            return fecha.toString() + "\n \"" + ayuda() + "\"";
        }
        if (cadena.toUpperCase().contains("ADIOS")) {
            return fecha.toString() + " \"" + randomAdios() + "\"";
        }
        if (cadena.toUpperCase().contains("DIME LOS PADRES DE ")) {
            cadena = cadena.toUpperCase().replace("DIME LOS PADRES DE ", "");
            return fecha.toString() + " \"" + papasDe(cadena) + "\"";
        }
        if (cadena.toUpperCase().contains(" ES HERMANO DE ")) {
            return fecha.toString() + " \"" + sonHermanos(cadena.split(" ")) + "\"";
        }
        if (cadena.toUpperCase().contains("DIME LOS HERMANOS DE ")) {
            cadena = cadena.toUpperCase().replace("DIME LOS HERMANOS DE ", "");
            return fecha.toString() + " \"" + getHermanos(cadena) + "\"";
        }
        if (cadena.toUpperCase().contains("DIME LOS ABUELOS DE ")) {
            cadena = cadena.toUpperCase().replace("DIME LOS ABUELOS DE ", "");
            return fecha.toString() + " \"" + getAbuelos(cadena) + "\"";
        }
        if (cadena.toUpperCase().contains("DIME LOS SOBRINOS DE ")) {
            cadena = cadena.toUpperCase().replace("DIME LOS SOBRINOS DE ", "");
            return fecha.toString() + " \"" + getSobrinos(cadena) + "\"";
        }
        if (cadena.toUpperCase().contains("DIME CUANTOS TIOS TIENE ")) {
            cadena = cadena.toUpperCase().replace("DIME CUANTOS TIOS TIENE ", "");
            return fecha.toString() + " \"" + cadena + " tiene " + getTiosN(cadena) + " tios\"";
        }
        if (cadena.toUpperCase().contains("DIME CUANTOS PRIMOS TIENE ")) {
            cadena = cadena.toUpperCase().replace("DIME CUANTOS PRIMOS TIENE ", "");
            return fecha.toString() + " \"" + cadena +" tiene " + getPrimos(cadena) + " primos\" ";
        }
        if (cadena.toUpperCase().contains(" ES PRIMO DE ")) {
            return fecha.toString() + " \"" + sonPrimos(cadena.split(" ")) + " \" ";
        }
        if (cadena.toUpperCase().contains(" ES ABUELO DE ")) {
            return fecha.toString() + " \"" + esAbuelo(cadena.split(" ")) + " \" ";
        }
        if (cadena.toUpperCase().contains(" ES BISABUELO DE ")) {
            return fecha.toString() + " \"" + esBisAbuelo(cadena.split(" ")) + " \" ";
        }

        return respuesta;
    }
    
    private String ayuda() {
        String respuesta = "Hola \n"
                + "Adios \n"
                + "Ayuda \n"
                + "Dime los padres de * \n"
                + "* es hermano de * \n"
                + "Dime los hermanos de \n"
                + "Dime los abuelos de * \n"
                + "Dime los sobrinos de \n"
                + "Dime cuantos tios tiene * \n"
                + "Dime cuantos primos tiene \n"
                + "* es primo de * \n"
                + "* es abuelo de * \n"
                + "* es bisabuelo de *";
        return respuesta;
    }

    private String randomSaludo() {
        return saludo.get((int) (Math.random() * saludo.size()));
    }

    private String randomAdios() {
        return despedida.get((int) (Math.random() * despedida.size()));
    }

    private String papasDe(String cadena) {
        // Verificamos los papás de cadena
        String cadenaR = "";
        for (Hijo_de hijo : lstHijo) {
            if (hijo.getX().equalsIgnoreCase(cadena)) {
                cadenaR += hijo.getY() + ", ";
            }
        }
        return cadenaR;
    }

    private String sonHermanos(String[] cadena) {
        // Obtenemos los papás de los hijos
        String papa1 = buscar(cadena[0]);
        String papa2 = buscar(cadena[cadena.length - 1]);
        
        // Verificamos si son iguales
        if (papa1.equalsIgnoreCase(papa2) && papa1.compareToIgnoreCase("") != 0) {
            // Si los son, son hermanos
            return "Si son hermanos";
        }
        // Si no lo son, Preguntamos si realmente son hermanos

        String opcion = JOptionPane.showInputDialog("No tengo conocimiento de ello, ¿Su sentencia es verdadera?");

        if (opcion.compareToIgnoreCase("si") == 0) {
            if (papa1.compareToIgnoreCase("") == 0 && papa2.compareToIgnoreCase("") == 0) {
                String papi = JOptionPane.showInputDialog("¿Quien es el papá de ambos?");
                lstHijo.add(new Hijo_de(cadena[0], papi));
                lstHijo.add(new Hijo_de(cadena[cadena.length-1], papi));
                return fecha.toString() + " \"Conocimiento agregado con éxito\" ";
            } else if (papa1.compareToIgnoreCase("") == 0) {
                lstHijo.add(new Hijo_de(cadena[0], papa2));
                return fecha.toString() + " \"Hijo agregado con éxito\" ";
            } else if (papa2.compareToIgnoreCase("") == 0) {
                lstHijo.add(new Hijo_de(cadena[cadena.length-1], papa1));
                return fecha.toString() + " \"Hijo agregado con éxito\" ";
            }
        }
        return "No se agrego conocimiento";
    }

    private String sonHermanos2(String[] cadena) {
        // Obtenemos los papás de los hijos
        String papa1 = buscar(cadena[0]);
        String papa2 = buscar(cadena[cadena.length - 1]);
        
        // Verificamos si son iguales
        if (papa1.equalsIgnoreCase(papa2) && papa1.compareToIgnoreCase("") != 0) {
            // Si los son, son hermanos
            return "Si son hermanos";
        }
        return "No se agrego conocimiento";
    }
    
    private String buscar(String H) {
        // Buscamos al papa de H
        for (Hijo_de hijo : lstHijo) {
            if (hijo.getX().equalsIgnoreCase(H.trim())) {
                return hijo.getY();
            }
        }
        return "";
    }

    private String getHermanos(String H) {
        String cadenaR = "";
        // Obtenemos a los papas de H
        String papasDe = papasDe(H);
        // Buscamos a los papas de la lista
        for (Hijo_de hijo : lstHijo) {
            // Si los papas de H son los mismos que los de la persona (hijo) y
            // además H es diferente del hijo de la persona (hijo), se agregan a CadenaR
            if (papasDe.contains(hijo.getY()) && !hijo.getX().equalsIgnoreCase(H)) {
                cadenaR += hijo.getX() + ", ";
            }
        }
        // Si la cadena quedó vacía, significa que no encontró hermanos
        if (cadenaR.equalsIgnoreCase("")) {
            return "No encontre hermanos de " + H;
        }
        return cadenaR;
    }

    private String getAbuelos(String H) {
        // Obtenemos los papás de H
        String papasDe = papasDe(H);
        //Obtenemos los papás de de los papas de H
        String papasDePapas1 = papasDe(papasDe.split(",")[0]);
        String papasDePapas2 = papasDe(papasDe.split(",")[1]);
        //Retornamos los papás de los papás de H
        return papasDePapas1 + papasDePapas2;
    }
    
    private String getSobrinos(String T) {
        String resultado = "";
        String hermanosDeT = getHermanos(T);
        String []hermanosdeT = hermanosDeT.split(", ");
        
        for (int i=0; i < hermanosdeT.length; i++) {
            resultado += getHijos(hermanosdeT[i]) + ", ";
        }
        return resultado;
    }
    
    private String getHijos(String P) {
        // Buscamos al hijo del papa
        String hijos = "";
        for (Hijo_de papa : lstHijo) {
            if (papa.getY().equalsIgnoreCase(P.trim())) {
                hijos += papa.getX() + ", ";
            }
        }
        return hijos;
    }
    
    private String getTios(String H) {
        // Obtenemos el papa de H
        String papa = buscar(H);
        // Retornamos los hermanos de papa
        return getHermanos(papa.trim());
    }
    
    private int getTiosN(String H) {
        // Obtenemos el papa de H
        String papa = buscar(H);
        // Retornamos los hermanos de papa
        return getHermanos(papa).split(", ").length;
    }
    
    private String getPrimos(String H) {
        //Retornamos el tio de H
        String resultado = "";
        String tios = getTios(H);
        String tio[] = tios.split(", ");
        
        //Revisar hijos de los tios
        for (int i=0; i<tio.length; i++) {
            resultado += getHijos(tio[i]);
        }
        return resultado.split(", ").length + "";
    }
    
    private String sonPrimos(String[] cadena) {
        String papa1 = buscar(cadena[0]);
        String papa2 = buscar(cadena[cadena.length - 1]);
        String papas[] = {papa1, papa2};
        String respuesta = sonHermanos2(papas);
        if (respuesta.contains("Si") && !papa1.equalsIgnoreCase(papa2)) {
            return "Si son primos";
        } 
        
        if (JOptionPane.showInputDialog("\"No tengo conocimiento de ello, ¿Su sentencia es verdadera?\"").compareToIgnoreCase("si") == 0) {
            if (papa1.equalsIgnoreCase("") && papa2.equalsIgnoreCase("")) {
                String Papa1 = JOptionPane.showInputDialog("¿Quien es el papá de "+ cadena[0] + "?");
                String Papa2 = JOptionPane.showInputDialog("¿Quien es el papá de "+ cadena[cadena.length - 1] + "?");
                String PapaM = JOptionPane.showInputDialog("¿Quien es el papá de" + Papa1 + " y " + Papa2 + "?");
                lstHijo.add(new Hijo_de(cadena[0], Papa1));
                lstHijo.add(new Hijo_de(cadena[cadena.length-1], Papa2));
                lstHijo.add(new Hijo_de(Papa1, PapaM));
                lstHijo.add(new Hijo_de(Papa2, PapaM));
                return "Conocimiento agregado con éxito";
            } else if (papa1.equalsIgnoreCase("") && !buscar(papa2).equalsIgnoreCase("")) {
                String pap1 = JOptionPane.showInputDialog("¿Quien es el papá de "+ cadena[0] + "?");
                if (!existe(pap1)) {
                    lstHijo.add(new Hijo_de(pap1, buscar(papa2)));
                }
                lstHijo.add(new Hijo_de(cadena[0], pap1));
                return "Conocimiento agregado con éxito"; 
            } else if (papa2.equalsIgnoreCase("") && !buscar(papa1).equalsIgnoreCase("")) {
                String pap2 = JOptionPane.showInputDialog("¿Quien es el papá de "+ cadena[cadena.length-1] + "?");
                if (!existe(pap2)) {
                    lstHijo.add(new Hijo_de(pap2, buscar(papa1)));
                }
                lstHijo.add(new Hijo_de(cadena[cadena.length-1], pap2));
                return "Conocimiento agregado con éxito";
            } else if (papa1.equalsIgnoreCase("") && !buscar(papa2).equalsIgnoreCase("")) {
                String pa = JOptionPane.showInputDialog("¿Quien es el papá de " + cadena[0] + "?");
                lstHijo.add(new Hijo_de(cadena[0], pa));
                lstHijo.add(new Hijo_de(pa, buscar(papa2)));
                return "Conocimiento agregado con éxito";
            } else if (papa2.equalsIgnoreCase("") && !buscar(papa1).equalsIgnoreCase("")) {
                String pa = JOptionPane.showInputDialog("¿Quien es el papá de " + cadena[cadena.length-1] + "?");
                lstHijo.add(new Hijo_de(cadena[cadena.length-1], pa));
                lstHijo.add(new Hijo_de(pa, buscar(papa1)));
                return "Conocimiento agregado con éxito";
            } else if (buscar(papa1).equalsIgnoreCase("") && buscar(papa2).equalsIgnoreCase("")) {
                String papaMayor = JOptionPane.showInputDialog("¿Quien es el papá de los padres de ambos?");
                lstHijo.add(new Hijo_de(papa1, papaMayor));
                lstHijo.add(new Hijo_de(papa2, papaMayor));
                return "Conocimiento agregado con éxito";
            } else if(buscar(papa1).equalsIgnoreCase("") && !buscar(papa2).equalsIgnoreCase("")) {
                lstHijo.add(new Hijo_de(papa1, buscar(papa2)));
                return "Conocimiento agregado con éxito";
            } else if (buscar(papa2).equalsIgnoreCase("") && !buscar(papa1).equalsIgnoreCase("")) {
                lstHijo.add(new Hijo_de(papa2, buscar(papa1)));
                return "Conocimiento agregado con éxito";
            }
        }
        return "No se agrego conocimiento";
    }
    
    private boolean existe(String papa) {
        for (Hijo_de p : lstHijo) {
            if (p.getX().equalsIgnoreCase(papa)) {
                return true;
            }
        }
        return false;
    }
    
    private String esAbuelo(String[] cadena) {
        String papa = buscar(cadena[cadena.length-1]);
        String abuelo = buscar(papa);
        
        if (abuelo.equalsIgnoreCase(cadena[0])) {
            return "Si es su abuelo";
        }
        
        if (JOptionPane.showInputDialog("\"No tengo conocimiento de ello, ¿Su sentencia es verdadera?\"").compareToIgnoreCase("si") == 0) {
            if (papa.equalsIgnoreCase("")) {
                String pa = JOptionPane.showInputDialog("¿Quien es el papá de " + cadena[cadena.length-1]);
                lstHijo.add(new Hijo_de(cadena[cadena.length-1], pa));
                lstHijo.add(new Hijo_de(pa, cadena[0]));
                return "Conocimiento agregado con éxito";
            } else if (abuelo.equalsIgnoreCase("")) {
                lstHijo.add(new Hijo_de(papa, cadena[0]));
                return "Conocimiento agregado con éxtio";
            }
        }
        return "No se agrego conocimiento";
    }
    
    private String esAbuelo2(String[] cadena) {
        String papa = buscar(cadena[cadena.length-1]);
        String abuelo = buscar(papa);
        
        if (abuelo.equalsIgnoreCase(cadena[0])) {
            return "Si es su abuelo";
        }
        
        return "No se agrego conocimiento";
    }
    
    private String esBisAbuelo(String[] cadena) {
        String papa = buscar(cadena[cadena.length-1]);
        String abuelo = buscar(papa);
        String bisAbuelo = buscar(abuelo);
        
        if (bisAbuelo.equalsIgnoreCase(cadena[0])) {
            return "Si es su bisabuelo";
        }
        
        if (JOptionPane.showInputDialog("\"No tengo conocimiento de ello, ¿Su sentencia es verdadera?\"").compareToIgnoreCase("si") == 0) {
            if (papa.equalsIgnoreCase("")) {
                String pap = JOptionPane.showInputDialog("¿Quien es el papá de " + cadena[cadena.length-1] + "?");
                String abue = JOptionPane.showInputDialog("¿Quien es el papá de " + pap + "?");
                lstHijo.add(new Hijo_de(cadena[cadena.length-1], pap));
                lstHijo.add(new Hijo_de(pap, abue));
                lstHijo.add(new Hijo_de(abue, cadena[0]));
                return "Conocimiento agregado con éxito";
            } else if (abuelo.equalsIgnoreCase("")) {
                String abue = JOptionPane.showInputDialog("¿Quien es el papá de " + papa + "?");
                lstHijo.add(new Hijo_de(papa, abue));
                lstHijo.add(new Hijo_de(abue, cadena[0]));
                return "Conocimiento agregado con éxito";
            } else if (bisAbuelo.equalsIgnoreCase("")) {
                lstHijo.add(new Hijo_de(abuelo, cadena[0]));
                return "Conocimiento agregado con éxito";
            }
        }
        return "No se Agrego conocimiento";
    }
}
