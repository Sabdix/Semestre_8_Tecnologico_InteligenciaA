/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adddata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sabdi
 */
public class Interfaz extends javax.swing.JFrame {
    
    private ArrayList<Entidad> entities;
    private FileReader fr;
    private BufferedReader bf;
    private String sCadena, texto;
    private DefaultTableModel model;
    private File fichero;
    private FileWriter bw;

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        entities = new ArrayList<>();
        iniciarTabla();
        
    }
    
    private void iniciarTabla() {
        model = (DefaultTableModel) jtTabla.getModel();
        model.setNumRows(0);
        texto = "";
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        btAdd = new javax.swing.JButton();
        btLoad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre(s)", "Apellido Paterno", "Apellido Materno", "Fecha de Nacimiento"
            }
        ));
        jScrollPane1.setViewportView(jtTabla);

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btLoad.setText("Load");
        btLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btLoad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAdd)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd)
                    .addComponent(btLoad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // Al dar click en el botón se crea la interfaz del formulario y se le envía el objeto Interfaz
        VentanaLog1 v = new VentanaLog1(this);
        v.setVisible(true);        
    }//GEN-LAST:event_btAddActionPerformed

    public void setEntidad(Entidad obj) throws IOException {
        // Se verifica que el arreglo entities sea mayor que 0 
        if (entities.size() > 0) {
            entities.add(obj);
            texto = "";
            try {
                bw = new FileWriter(fichero.getPath());
                for(int i=0; i<entities.size(); i++) {
                    texto += entities.get(i).toString() + "\n";            
                }
                bw.write(texto);
                bw.close();
                addTabla();
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Si no es mayor que 0, entonces al momento de guargar una entidad pregunta la ubicación del archivo
            entities.add(obj);
            texto = "";
            JFileChooser fc = new JFileChooser();
            if(fc.showSaveDialog(null) == fc.APPROVE_OPTION){ 
                fichero = new File(fc.getSelectedFile().getAbsolutePath()+".txt"); 
                bw = new FileWriter(fichero.getPath());
                for(int i=0; i<entities.size(); i++) {
                    texto += entities.get(i).toString() + "\n";            
                }
                bw.write(texto);
                bw.close();
                addTabla();
            }
        }
    }
    
    private void btLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoadActionPerformed
        // Aquí se selecciona el archivo que se desea cargar
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        fc.setFileFilter(filtro);
        int seleccion = fc.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            fichero = fc.getSelectedFile();
            try {
                leerArchivo(fichero);
                addTabla();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btLoadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    
    private void leerArchivo(File fichero) throws FileNotFoundException, IOException {
        // Aquí se lee el archivo para posterirmente los elementos convertirlos en entidades y agregarlos al arreglo
        fr = new FileReader(fichero);
        bf = new BufferedReader(fr);
        entities.clear();
        String sCadena2[];
        while ((sCadena = bf.readLine()) != null) {
            sCadena2 = sCadena.split(" ");
            try {
                entities.add(new Entidad(sCadena2[0], sCadena2[1], sCadena2[2], sCadena2[3]));
            } catch (ParseException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void addTabla() {
        // Aquí se borra el contenido de la tabla y se agregan todos los elementos de entities
        // Se puede deciir que es un refresco de la tabla
        while(model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (int i=0; i<entities.size(); i++) {
            model.addRow(new Object[] {entities.get(i).getNombre(), entities.get(i).getApPaterno(), 
            entities.get(i).getApMaterno(), entities.get(i).getFechaNacimiento()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btLoad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables
}
