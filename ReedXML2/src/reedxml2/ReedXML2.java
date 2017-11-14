package reedxml2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author sabdi
 */
public class ReedXML2 {

    public static void cargarXML() throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("prueba.xml");
        
        Document document = (Document)builder.build(xmlFile);
        
        // Se obtiene la raíz familia
        Element rootNode = document.getRootElement();
        
        // Se obtiene la lista de hijos de la raíz
        List list = rootNode.getChildren("hijo_de");
        String genero = "";
        // Se recorre la lista de hijos de 'familia'
        for (int i=0; i < list.size(); i++) {
            // Se obtiene el elemento hijo_de
            Element hijo_de = (Element)list.get(i);
            List hijo = hijo_de.getChildren();
            String A = hijo_de.getChildTextTrim("hijo");
            String B = hijo_de.getChildTextTrim("padre");
            for (int j=0; j < hijo.size(); j++) {
                Element h = (Element)hijo.get(j);
                genero = h.getAttributeValue("genero");
                break;
            }
            if (genero.equalsIgnoreCase("hombre")) {
                System.out.println(A+" es hijo de "+B);
            } else {
                System.out.println(A+" es hija de "+B);
            }
            
        }
    }

    public static void main(String[] args) throws JDOMException, IOException {
        cargarXML();
    }
    
}
