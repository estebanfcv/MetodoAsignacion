package vista;

import java.awt.Insets;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;
import reglas.Procedimiento;
import util.Util;

/**
 *
 * @author estebanfcv
 */
public class Pantalla extends javax.swing.JFrame {

    private Procedimiento procedimiento;
    private boolean minimizacion;

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

        jLabel3 = new javax.swing.JLabel();
        group = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        botonCalcular = new javax.swing.JButton();
        panelOriginal = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultados = new javax.swing.JTextArea();
        botonProcedimiento = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSuma = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOriginal = new javax.swing.JTable();
        botonLimpiar = new javax.swing.JButton();
        radioMin = new javax.swing.JRadioButton();
        radioMax = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Método de asignación");
        setPreferredSize(new java.awt.Dimension(786, 630));
        setResizable(false);
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
        tablaResultados.setEnabled(false);
        jScrollPane2.setViewportView(tablaResultados);

        jLabel2.setText("0's seleccionados");

        jPanel1.setBackground(java.awt.Color.green);
        jPanel1.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jLabel4.setText("0's eliminados");

        jPanel2.setBackground(java.awt.Color.red);
        jPanel2.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        resultados.setColumns(20);
        resultados.setRows(5);
        jScrollPane3.setViewportView(resultados);

        botonProcedimiento.setText("Ver procedimiento");
        botonProcedimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProcedimientoActionPerformed(evt);
            }
        });

        jLabel5.setText("Total");

        javax.swing.GroupLayout panelOriginalLayout = new javax.swing.GroupLayout(panelOriginal);
        panelOriginal.setLayout(panelOriginalLayout);
        panelOriginalLayout.setHorizontalGroup(
            panelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOriginalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelOriginalLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(botonProcedimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSuma)
                        .addContainerGap())
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelOriginalLayout.setVerticalGroup(
            panelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOriginalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOriginalLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                    .addGroup(panelOriginalLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelOriginalLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4))
                    .addGroup(panelOriginalLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelOriginalLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonProcedimiento)
                            .addComponent(jLabel5)
                            .addComponent(txtSuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tablaOriginal.setModel(new javax.swing.table.DefaultTableModel(
            new Double [][] {
                {0.0}
            },
            new String [] {
                "A"
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

        group.add(radioMin);
        radioMin.setSelected(true);
        radioMin.setText("Minimización");
        radioMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMinActionPerformed(evt);
            }
        });

        group.add(radioMax);
        radioMax.setText("Maximización");
        radioMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMaxActionPerformed(evt);
            }
        });

        jLabel6.setText("Método:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(104, 104, 104)
                .addComponent(radioMin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(radioMax, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(botonCalcular)
                .addGap(69, 69, 69)
                .addComponent(botonLimpiar))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panelOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(radioMin)
                            .addComponent(radioMax)
                            .addComponent(jLabel1))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCalcular)
                    .addComponent(botonLimpiar))
                .addGap(6, 6, 6)
                .addComponent(panelOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        panelOriginal.setVisible(false);
        resultados.setEditable(false);
        txtSuma.setEditable(false);
        resultados.setMargin(new Insets(-5, 0, -5, 0));
        DefaultCaret caret = (DefaultCaret) resultados.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        minimizacion = true;
    }//GEN-LAST:event_formWindowOpened

    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed

        panelOriginal.setVisible(true);
        int nuevoNumero = (int) spinner.getValue();

        String[] columnas = new String[nuevoNumero];
        char c = 65;
        for (int j = 0; j < columnas.length; j++) {
            columnas[j] = "" + (c++);
        }

        Double[][] datos = new Double[nuevoNumero][nuevoNumero];
        for (int renglon = 0; renglon < datos.length; renglon++) {
            for (int columna = 0; columna < datos.length; columna++) {
                datos[renglon][columna] = (Double) tablaOriginal.getValueAt(renglon, columna);
            }
        }
        DefaultTableModel dtm = new DefaultTableModel(datos, columnas);
        tablaResultados.setModel(dtm);
        resultados.setText("");
        procedimiento = new Procedimiento(tablaOriginal, tablaResultados, resultados, txtSuma, minimizacion);

    }//GEN-LAST:event_botonCalcularActionPerformed

    private void spinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerStateChanged
        inicializarTabla();
    }//GEN-LAST:event_spinnerStateChanged

    private void tablaOriginalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablaOriginalPropertyChange
        int row = tablaOriginal.getSelectedRow();
        int colum = tablaOriginal.getSelectedColumn();
        if (row != -1 && colum != -1) {
            Object valor = tablaOriginal.getValueAt(row, colum);
            if (valor == null || valor.toString().trim().isEmpty() || !Util.isDouble(valor.toString())) {
                tablaOriginal.setValueAt(0.0, row, colum);
            } else {
                tablaOriginal.setValueAt(new Double(valor.toString()), row, colum);
            }
        }
    }//GEN-LAST:event_tablaOriginalPropertyChange

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        panelOriginal.setVisible(false);
        spinner.setEnabled(true);
        tablaOriginal.setEnabled(true);
        botonCalcular.setEnabled(true);
        resultados.setText("");
        txtSuma.setText("");
        inicializarTabla();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProcedimientoActionPerformed
        // TODO add your handling code here:
        PantallaProcedimiento pantallaProcedimiento = new PantallaProcedimiento();
        pantallaProcedimiento.setVisible(true);
        pantallaProcedimiento.getTxtProcedimiento().setText(procedimiento.getPasos());
    }//GEN-LAST:event_botonProcedimientoActionPerformed

    private void radioMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMinActionPerformed
        minimizacion = true;
    }//GEN-LAST:event_radioMinActionPerformed

    private void radioMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMaxActionPerformed
        minimizacion = false;
    }//GEN-LAST:event_radioMaxActionPerformed

    private void inicializarTabla() {
        int nuevoNumero = (int) spinner.getValue();

        String[] columnas = new String[nuevoNumero];
        char c = 65;
        for (int j = 0; j < columnas.length; j++) {
            columnas[j] = "" + (c++);
        }

        Double[][] datos = new Double[nuevoNumero][nuevoNumero];
        for (Double[] dato : datos) {
            for (int i = 0; i < datos.length; i++) {
                dato[i] = 0d;
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
    private javax.swing.JButton botonProcedimiento;
    private javax.swing.ButtonGroup group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelOriginal;
    private javax.swing.JRadioButton radioMax;
    private javax.swing.JRadioButton radioMin;
    private javax.swing.JTextArea resultados;
    private javax.swing.JSpinner spinner;
    private javax.swing.JTable tablaOriginal;
    private javax.swing.JTable tablaResultados;
    private javax.swing.JTextField txtSuma;
    // End of variables declaration//GEN-END:variables
}
