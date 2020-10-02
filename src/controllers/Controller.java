/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionListener;
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
    private ResultSet rs = null;
    private ResultSetMetaData md = null;

    public Controller() {
        this.view.setVisible(true);
        listeners();
    }
    
    public void listeners() {
        this.view.altasButton.addActionListener(new altasButtonListener());
        this.view.bajasButton.addActionListener(new bajasButtonListener());
        this.view.modificarButton.addActionListener(new modificarButtonListener());
        this.view.salirButton.addActionListener(new salirButtonListener());
    }
    
    public void cleanForm() {
        view.registroTextField.setText("");
    }
    
    class altasButtonListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            model.executeQuery("INSERT INTO alumnos (registro, dni, nombre, apellido1, apellido2) VALUES (" + view.registroTextField.getText() + ",'" +
                    view.dniTextField.getText() + "','" + view.nameTextField.getText() + "','" + view.apellido1TextField.getText() +
                    "','" + view.apellido2TextField.getText() + "')" 
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
            } catch(Exception e) {
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
    
    private void showData(int fila) {

            view.dniTextField.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 1)));
            view.registroTextField.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 0)));
            view.nameTextField.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 2)));
            view.apellido1TextField.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 3)));
            view.apellido2TextField.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 4)));

        }
}
