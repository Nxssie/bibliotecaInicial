/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.LibraryView;
import models.*;

/**
 *
 * @author Carlos Sanchez
 */
public class Controller implements ActionListener {

    private Queries queries = new Queries();
    Model model = new Model();
    Model.VistaTabla vtabla = model.new VistaTabla(queries.showData("Select * from alumnos"));
    LibraryView view = new LibraryView();

    public Controller() {
        this.view.setVisible(true);
        this.view.getStudentsTable().setModel(vtabla);
        listeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Altas":
                insert();
                break;
            case "Bajas":
                delete();
                break;
            case "Modificar":
                update();
                break;
            case "Actualizar":
                refreshTable();
                JOptionPane.showMessageDialog(null, "Tabla actualizada");
                break;
            case "Salir":
                System.exit(0);
                break;
        }
    }

    private void insert() {
        try {
            model.executeQuery("INSERT INTO alumnos (registro, dni, nombre, apellido1, apellido2) VALUES (" + view.getRegistroTextField().getText() + ",'"
                    + view.getDniTextField().getText() + "','" + view.getNameTextField().getText() + "','" + view.getApellido1TextField().getText()
                    + "','" + view.getApellido2TextField().getText() + "')"
            );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Registro Nº " + view.getRegistroTextField().getText() + " dado de alta.");
        cleanForm();
        refreshTable();
    }

    private void delete() {
        try {
            model.executeQuery("delete from alumnos where registro='" + view.getRegistroTextField().getText() + "'");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Registro Nº " + view.getRegistroTextField().getText() + " dado de baja.");
        cleanForm();
        refreshTable();
    }

    private void update() {
        try {
            model.executeQuery("update alumnos set dni='" + view.getDniTextField().getText() + "', nombre='" + view.getNameTextField().getText() + "', "
                    + "apellido1='" + view.getApellido1TextField().getText() + "', apellido2='" + view.getApellido2TextField().getText() + "' "
                    + "where registro='" + view.getRegistroTextField().getText() + "'");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "Registro Nº " + view.getRegistroTextField().getText() + " modificado.");
        cleanForm();
        refreshTable();
    }

    public void listeners() {
        this.view.getAltasButton().addActionListener(this);
        this.view.getBajasButton().addActionListener(this);
        this.view.getModificarButton().addActionListener(this);
        this.view.getSalirButton().addActionListener(this);
        this.view.getActualizarButton().addActionListener(this);

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
