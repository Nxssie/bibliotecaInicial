/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Carlos Sanchez
 */
public class LibraryView extends javax.swing.JFrame {

    /**
     * Creates new form libraryView
     */
    public LibraryView() {
        String[] columnNames = {"Registro",
                            "DNI",
                            "Nombre",
                            "1er Apellido",
                            "2º Apellido"};
        studentsTable = new javax.swing.JTable();
        initComponents();
        this.setSize(700, 475);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        apellido2TextField = new javax.swing.JTextField();
        apellido1TextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        dniTextField = new javax.swing.JTextField();
        registroTextField = new javax.swing.JTextField();
        salirButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        altasButton = new javax.swing.JButton();
        bajasButton = new javax.swing.JButton();
        modificarButton = new javax.swing.JButton();
        actualizarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Registro");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setText("DNI");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel4.setText("Apellido 1");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel5.setText("Apellido 2");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));
        getContentPane().add(apellido2TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 140, -1));
        getContentPane().add(apellido1TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 140, -1));
        getContentPane().add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 140, -1));
        getContentPane().add(dniTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 140, -1));
        getContentPane().add(registroTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 140, -1));

        salirButton.setText("Salir");
        getContentPane().add(salirButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));

        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(studentsTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, 274));

        altasButton.setText("Altas");
        getContentPane().add(altasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        bajasButton.setText("Bajas");
        getContentPane().add(bajasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));

        modificarButton.setText("Modificar");
        getContentPane().add(modificarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, -1, -1));

        actualizarButton.setText("Actualizar");
        getContentPane().add(actualizarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    /**
     * @param args the command line arguments
     */

    public JTable getStudentsTable() {
        return studentsTable;
    }
    
    public JButton getActualizarButton() {
        return actualizarButton;
    }

    public JButton getAltasButton() {
        return altasButton;
    }

    public JButton getBajasButton() {
        return bajasButton;
    }

    public JButton getModificarButton() {
        return modificarButton;
    }

    public JButton getSalirButton() {
        return salirButton;
    }

    public JTextField getApellido1TextField() {
        return apellido1TextField;
    }

    public JTextField getApellido2TextField() {
        return apellido2TextField;
    }

    public JTextField getDniTextField() {
        return dniTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getRegistroTextField() {
        return registroTextField;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarButton;
    private javax.swing.JButton altasButton;
    private javax.swing.JTextField apellido1TextField;
    private javax.swing.JTextField apellido2TextField;
    private javax.swing.JButton bajasButton;
    private javax.swing.JTextField dniTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarButton;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField registroTextField;
    private javax.swing.JButton salirButton;
    private javax.swing.JTable studentsTable;
    // End of variables declaration//GEN-END:variables
}
