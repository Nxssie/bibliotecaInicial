/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import views.LibraryView;
import models.*;

/**
 *
 * @author root
 */
public class Controller {

    Model model = new Model();
    LibraryView view = new LibraryView();
    VistaTabla vtabla = new Model.VistaTabla(rs);

    public Controller() {
        this.view.setVisible(true);
        this.view.studentsTable.setModel(vtabla);
        listeners();
    }

    public void listeners() {
        this.view.altasButton.addActionListener(new altasButtonListener());
        this.view.bajasButton.addActionListener(new bajasButtonListener());
        this.view.modificarButton.addActionListener(new modificarButtonListener());
        this.view.salirButton.addActionListener(new salirButtonListener());
        
        this.view.studentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsTableMouseClicked(evt);
            }
        });
    }

    public void cleanForm() {
        view.registroTextField.setText("");
    }

    class altasButtonListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            model.executeQuery("INSERT INTO alumnos (registro, dni, nombre, apellido1, apellido2) VALUES (" + view.registroTextField.getText() + ",'"
                    + view.dniTextField.getText() + "','" + view.nameTextField.getText() + "','" + view.apellido1TextField.getText()
                    + "','" + view.apellido2TextField.getText() + "')"
            );
        }
    }

    class bajasButtonListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            model.executeQuery("delete from alumnos where registro='" + view.registroTextField.getText() + "'");
        }
    }

    class modificarButtonListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {

            try {
                model.executeQuery("update alumnos set dni='" + view.dniTextField.getText() + "', nombre='" + view.nameTextField.getText() + "', "
                        + "apellido1='" + view.apellido1TextField.getText() + "', apellido2='" + view.apellido2TextField.getText() + "' "
                        + "where registro='" + view.registroTextField.getText() + "'");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            cleanForm();
        }
    }

    class salirButtonListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            System.exit(0);
        }
    }

    public void studentsTableMouseClicked(java.awt.event.MouseEvent evt) {
        showData(view.studentsTable.getSelectedRow());
    }


private void showData(int fila) {
        view.registroTextField.setText(String.valueOf(view.studentsTable.getValueAt(fila, 0)));
        view.dniTextField.setText(String.valueOf(view.studentsTable.getValueAt(fila, 1)));
        view.nameTextField.setText(String.valueOf(view.studentsTable.getValueAt(fila, 2)));
        view.apellido1TextField.setText(String.valueOf(view.studentsTable.getValueAt(fila, 3)));
        view.apellido2TextField.setText(String.valueOf(view.studentsTable.getValueAt(fila, 4)));
    }
}
