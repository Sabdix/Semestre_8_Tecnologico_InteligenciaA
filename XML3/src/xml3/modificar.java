/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author sabdi
 */
public class modificar {

    public static void modificar() throws JDOMException, IOException {
        // Creamos el SAXBuilder para parsear el archivo
        // Hacemos referencia al archivo xml a hacer cambios
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("nombres.xml");

        // Se crea el documento a través del archivo
        Document document = (Document) builder.build(xmlFile);

        // Se obtiene la raíz del archivo xml
        Element rootNode = document.getRootElement();

        List list = rootNode.getChildren("persona");
        String id = JOptionPane.showInputDialog(null, "Da el Id del nodo que quieres modificar");

        for (int i = 0; i < list.size(); i++) {
            Element persona = (Element) list.get(i);
            if (persona.getAttributeValue("id").equalsIgnoreCase(id)) {
                String nombre = JOptionPane.showInputDialog(null, "Dame el nombre");
                String apellido1 = JOptionPane.showInputDialog(null, "Dame el apellido paterno");
                String apellido2 = JOptionPane.showInputDialog(null, "Dame el apellido materno");
                
                // Agregamos el nombre
                Element nuevoNombre = new Element("nombre");
                nuevoNombre.setText(nombre);
                persona.setContent(nuevoNombre);

                // Agregamos los apelidos
                Element nuevoApellido1 = new Element("apellido1");
                nuevoApellido1.setText(apellido1);
                persona.addContent(nuevoApellido1);

                Element nuevoApellido2 = new Element("apellido2");
                nuevoApellido2.setText(apellido2);
                persona.addContent(nuevoApellido2);

            }
        }
        // new XMLOutputter().output(doc, System.out);
        XMLOutputter xmlOutput = new XMLOutputter();

        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(document, new FileWriter("nombres.xml"));

        System.out.println("File Saved!");
    }
    
    public static void eliminar() throws JDOMException, IOException {
        // Creamos el SAXBuilder para parsear el archivo
        // Hacemos referencia al archivo xml a hacer cambios
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("nombres.xml");

        // Se crea el documento a través del archivo
        Document document = (Document) builder.build(xmlFile);

        // Se obtiene la raíz del archivo xml
        Element rootNode = document.getRootElement();

        List list = rootNode.getChildren("persona");
        String id = JOptionPane.showInputDialog(null, "Da el Id del nodo que quieres eliminar");

        for (int i = 0; i < list.size(); i++) {
            Element persona = (Element) list.get(i);
            if (persona.getAttributeValue("id").equalsIgnoreCase(id)) {
                rootNode.removeContent(i*2+1);
            }
        }
        // new XMLOutputter().output(doc, System.out);
        XMLOutputter xmlOutput = new XMLOutputter();

        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(document, new FileWriter("nombres.xml"));

        System.out.println("File Saved!");
    }
}
