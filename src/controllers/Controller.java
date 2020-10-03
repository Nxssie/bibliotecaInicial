/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import views.LibraryView;
import models.*;
import models.Model.VistaTabla;

/**
 *
 * @author root
 */
public class Controller {

    private Queries queries = new Queries();
    Model model = new Model();
    Model.VistaTabla vtabla = model.new VistaTabla(queries.showData("Select * from alumnos"));
    LibraryView view = new LibraryView();

    public Controller() {
        this.view.setVisible(true);
        this.view.getStudentsTable().setModel(vtabla);
        listeners();
    }

    public void listeners() {
        this.view.getAltasButton().addActionListener(new altasButtonListener());
        this.view.getBajasButton().addActionListener(new bajasButtonListener());
        this.view.getModificarButton().addActionListener(new modificarButtonListener());
        this.view.getSalirButton().addActionListener(new salirButtonListener());
        this.view.getActualizarButton().addActionListener(new actualizarButtonListener());

        this.view.getStudentsTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsTableMouseClicked(evt);
            }
        });
    }

    public void cleanForm() {
        view.getRegistroTextField().setText("");
        view.getDniTextField().setText("");
        view.getNameTextField().setText("");
        view.getApellido1TextField().setText("");
        view.getApellido2TextField().setText("");
    }

    public void refreshTable() {
        vtabla = model.new VistaTabla(queries.showData("SELECT * FROM alumnos"));
        view.getStudentsTable().setModel(vtabla);
    }

    class altasButtonListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
                model.executeQuery("INSERT INTO alumnos (registro, dni, nombre, apellido1, apellido2) VALUES (" + view.getRegistroTextField().getText() + ",'"
                        + view.getDniTextField().getText() + "','" + view.getNameTextField().getText() + "','" + view.getApellido1TextField().getText()
                        + "','" + view.getApellido2TextField().getText() + "')"
                );
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            cleanForm();
            refreshTable();
        }
    }

    class bajasButtonListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
                model.executeQuery("delete from alumnos where registro='" + view.getRegistroTextField().getText() + "'");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            cleanForm();
            refreshTable();
        }
    }

    class modificarButtonListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {

            try {
                model.executeQuery("update alumnos set dni='" + view.getDniTextField().getText() + "', nombre='" + view.getNameTextField().getText() + "', "
                        + "apellido1='" + view.getApellido1TextField().getText() + "', apellido2='" + view.getApellido2TextField().getText() + "' "
                        + "where registro='" + view.getRegistroTextField().getText() + "'");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            cleanForm();
            refreshTable();
        }
    }

    class salirButtonListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            System.exit(0);
        }
    }

    class actualizarButtonListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            refreshTable();
        }
    }

    public void studentsTableMouseClicked(java.awt.event.MouseEvent evt) {
        showData(view.getStudentsTable().getSelectedRow());
    }

    private void showData(int fila) {
        view.getRegistroTextField().setText(String.valueOf(view.getStudentsTable().getValueAt(fila, 0)));
        view.getDniTextField().setText(String.valueOf(view.getStudentsTable().getValueAt(fila, 1)));
        view.getNameTextField().setText(String.valueOf(view.getStudentsTable().getValueAt(fila, 2)));
        view.getApellido1TextField().setText(String.valueOf(view.getStudentsTable().getValueAt(fila, 3)));
        view.getApellido2TextField().setText(String.valueOf(view.getStudentsTable().getValueAt(fila, 4)));
    }
}
