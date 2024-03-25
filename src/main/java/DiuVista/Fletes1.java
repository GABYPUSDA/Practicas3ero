
package DiuVista;

import DIU.Fletes;
import DIU.Main;
import DiuControlador.ControladorFlete;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author DELL
 */
public class Fletes1 extends javax.swing.JFrame {
// DefaultTableModel modelo = new DefaultTableModel();
    /**
     * Creates new form Fletes1
     */
    ArrayList<Fletes> fletes = new ArrayList<>();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Fletes1() {
        initComponents();
        setModelo();
        cargarTabla();

    }
    public void setModelo(){
        String [] cabecera = {"id","LugarRecogida","Destino", "FechaHora","Descripcion", "Tarifa", "Estado"};
        modelo.setColumnIdentifiers(cabecera);
        tbFletes.setModel(modelo);
    }

    private void setDatos() {
        Object[] filas = new Object[modelo.getColumnCount()];
        int contador = 1;
        for (Fletes datos : fletes ) {
            filas[0] = contador;
            filas[1] = datos.getLugarRecogida();
            filas[2] = datos.getDestino();
            filas[3] = datos.getFechaHora();
            filas[4] = datos.getDescripcionflete();
            filas[5] = datos.getTarifa();
            filas[6] = datos.getEstado();
            contador++;
            modelo.addRow(filas);
        }
        tbFletes.setModel(modelo);
    }
    
    public void cargarTabla() {

        ControladorFlete ec = new ControladorFlete();
        ArrayList<Object[]> lista = ec.obtenerFlete();
        for (Object[] Filas : lista) {
            modelo.addRow(Filas);

        }
        tbFletes.setModel(modelo);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnSeleccionarFlete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFletes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnSeleccionarFlete.setText("Elejir un flete");
        BtnSeleccionarFlete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeleccionarFleteActionPerformed(evt);
            }
        });

        tbFletes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbFletes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnSeleccionarFlete)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(BtnSeleccionarFlete)))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSeleccionarFleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeleccionarFleteActionPerformed
        
        int elejirFlete = tbFletes.getSelectedRow();
        
    }//GEN-LAST:event_BtnSeleccionarFleteActionPerformed

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
            java.util.logging.Logger.getLogger(Fletes1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fletes1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fletes1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fletes1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fletes1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSeleccionarFlete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFletes;
    // End of variables declaration//GEN-END:variables
}
