package vista;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import reglas.Procedimiento;
import util.Util;

/**
 *
 * @author estebanfcv
 */
public class Pantalla extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla
     */
    public Pantalla() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        spinner = new JSpinner(new SpinnerNumberModel(2, 2, 10, 1));
        botonCalcular = new javax.swing.JButton();
        panelOriginal = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOriginal = new javax.swing.JTable();
        botonLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Seleccione el número de renglón/columna");

        spinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerStateChanged(evt);
            }
        });

        botonCalcular.setText("Calcular");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaResultados);

        javax.swing.GroupLayout panelOriginalLayout = new javax.swing.GroupLayout(panelOriginal);
        panelOriginal.setLayout(panelOriginalLayout);
        panelOriginalLayout.setHorizontalGroup(
            panelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOriginalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panelOriginalLayout.setVerticalGroup(
            panelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOriginalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );

        tablaOriginal.setModel(new javax.swing.table.DefaultTableModel(
            new Integer [][] {
                {0, 0},
                {0, 0}
            },
            new String [] {
                "A", "B"
            }
        ));
        tablaOriginal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablaOriginalPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tablaOriginal);

        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(botonCalcular)
                .addGap(69, 69, 69)
                .addComponent(botonLimpiar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCalcular)
                    .addComponent(botonLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        panelOriginal.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
        if (!validarDatos()) {
            JOptionPane.showMessageDialog(rootPane, "Fvor de ingresar solamente valores númericos mayores a 0", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        panelOriginal.setVisible(true);
        int nuevoNumero = (int) spinner.getValue();

        String[] columnas = new String[nuevoNumero];
        char c = 65;
        for (int j = 0; j < columnas.length; j++) {
            columnas[j] = "" + (c++);
        }

        Integer[][] datos = new Integer[nuevoNumero][nuevoNumero];
        for (int renglon = 0; renglon < datos.length; renglon++) {
            for (int columna = 0; columna < datos.length; columna++) {
                datos[renglon][columna] = (Integer) tablaOriginal.getValueAt(renglon, columna);
            }
        }
        DefaultTableModel dtm = new DefaultTableModel(datos, columnas);
        tablaResultados.setModel(dtm);
        spinner.setEnabled(false);
        tablaOriginal.setEnabled(false);
        botonCalcular.setEnabled(false);
        
        Procedimiento procedimiento = new Procedimiento(tablaOriginal,tablaResultados);
        
    }//GEN-LAST:event_botonCalcularActionPerformed

    private void spinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerStateChanged
        inicializarTabla();
    }//GEN-LAST:event_spinnerStateChanged

    private void tablaOriginalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablaOriginalPropertyChange
        int row = tablaOriginal.getSelectedRow();
        int colum = tablaOriginal.getSelectedColumn();
        if (row != -1 && colum != -1) {
            Object valor = tablaOriginal.getValueAt(row, colum);
            if (valor == null || valor.toString().trim().isEmpty() || !Util.isNumero(valor.toString())) {
                System.out.println("el valor es::::::: " + valor);
                tablaOriginal.setValueAt(0, row, colum);
            } else {
                tablaOriginal.setValueAt(new Integer(valor.toString()), row, colum);
            }
        }
    }//GEN-LAST:event_tablaOriginalPropertyChange

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        panelOriginal.setVisible(false);
        spinner.setEnabled(true);
        tablaOriginal.setEnabled(true);
        botonCalcular.setEnabled(true);
        inicializarTabla();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private boolean validarDatos() {
        for (int renglon = 0; renglon < tablaOriginal.getRowCount(); renglon++) {
            for (int columna = 0; columna < tablaOriginal.getColumnCount(); columna++) {
                Integer valor = tablaOriginal.getValueAt(renglon, columna) == null ? 0 : (Integer) tablaOriginal.getValueAt(renglon, columna);
                if (valor == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void inicializarTabla() {
        int nuevoNumero = (int) spinner.getValue();

        String[] columnas = new String[nuevoNumero];
        char c = 65;
        for (int j = 0; j < columnas.length; j++) {
            columnas[j] = "" + (c++);
        }

        Integer[][] datos = new Integer[nuevoNumero][nuevoNumero];
        for (Integer[] dato : datos) {
            for (int i = 0; i < datos.length; i++) {
                dato[i] = 0;
            }
        }
        DefaultTableModel dtm = new DefaultTableModel(datos, columnas);
        tablaOriginal.setModel(dtm);
    }

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
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelOriginal;
    private javax.swing.JSpinner spinner;
    private javax.swing.JTable tablaOriginal;
    private javax.swing.JTable tablaResultados;
    // End of variables declaration//GEN-END:variables
}
