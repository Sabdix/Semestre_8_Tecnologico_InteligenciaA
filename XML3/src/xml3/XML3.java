
package xml3;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author sabdi
 */
public class XML3 {
    
    public static void crear() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("arbol");
            doc.appendChild(rootElement);

            // persona
            Element empleado = doc.createElement("persona");
            rootElement.appendChild(empleado);

            // atributo del elemento empleado
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            empleado.setAttributeNode(attr);

            // nombre
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode("Sabdi"));
            empleado.appendChild(nombre);

            // apellidos
            Element apellidos = doc.createElement("apellido1");
            apellidos.appendChild(doc.createTextNode("Pantoja"));
            empleado.appendChild(apellidos);

            // seccion
            Element seccion = doc.createElement("apellido2");
            seccion.appendChild(doc.createTextNode("Orozco"));
            empleado.appendChild(seccion);

            TransformerFactory transformerFac = TransformerFactory.newInstance();
            Transformer transformer = transformerFac.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("nombres.xml"));

            transformer.transform(source, result);
            System.out.println("File saved");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    
    }

    public static void main(String[] args) {
         //crear();
        try {
            switch(JOptionPane.showInputDialog("1.- Agregar, 2.- Modificar, 3.- Eliminar ")) {
                case "1":
                    agregar.agregar();
                    break;
                case "2":
                    modificar.modificar();
                    break;
                case "3":
                    modificar.eliminar();
                    break;
            }
        } catch (JDOMException ex) {
            Logger.getLogger(XML3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XML3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
