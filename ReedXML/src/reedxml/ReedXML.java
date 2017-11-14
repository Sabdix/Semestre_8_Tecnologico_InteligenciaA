package reedxml;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author sabdi
 */
public class ReedXML {

    public static void cargarXml() throws JDOMException, IOException {
        // Se crea un SAXBulder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("prueba.xml");
        
        // Se crea el documento a través del archivo
        Document document = (Document)builder.build(xmlFile);
        
        // Se obtiene la raíz 'tables'
        Element rootNode = document.getRootElement();
        
        // Se obtiene la lista de hijos de la raíz 'tables'
        List list = rootNode.getChildren("tabla");
        
        // Se recorre la lista de hijos de 'tables'
        for (int i=0; i < list.size(); i++) {
            // Se obtiene el elemento 'tabla'
            Element tabla = (Element)list.get(i);
            
            // Se obtiene el atributo 'nombre' que está en el tag 'tabla'
            String nombreTabla = tabla.getAttributeValue("nombre");
            System.out.println("Tabla: " + nombreTabla);
            
            // Se obtiene la lista de hijos de tag 'tabla'
            List lista_campos = tabla.getChildren();
            System.out.println("\tNombre\t\tTipo\t\tValor");
            
            // se recorre la lista de campos
            for (int j=0; j < lista_campos.size(); j++) {
                // Se obtiene el elemento 'campo'
                Element campo = (Element)lista_campos.get(j);
                
                // Se obtienen los valores que están entre tags '<campo></campo>'
                // Se obtiene el valor que está entre el tag '<nombre></nombre>'
                String nombre = campo.getChildTextTrim("nombre");
                
                // Se obtiene el valor que está entre los tags '<tipo></tipo>'
                String tipo = campo.getChildTextTrim("tipo");
                
                // Se obtiene el valor que está entre los tags '<valor></valor>'
                String valor = campo.getChildTextTrim("valor");
                
                System.out.println("\t"+nombre+"\t\t"+tipo+"\t\t"+valor);
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            cargarXml();
        } catch (JDOMException ex) {
            Logger.getLogger(ReedXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReedXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
