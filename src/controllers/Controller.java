/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionListener;
import views.LibraryView;
import models.Model;

/**
 *
 * @author root
 */
public class Controller {

    Model model = new Model();
    LibraryView view = new LibraryView();

    public Controller(Model model, LibraryView view) {
        this.model = model;
        this.view = view;
        this.view.altasButton.addActionListener(new altasButtonListener());
        this.view.bajasButton.addActionListener(new bajasButtonListener());
        this.view.modificarButton.addActionListener(new modificarButtonListener());
        this.view.salirButton.addActionListener(new salirButtonListener());
    }

    public void start() {
        this.view.setVisible(true);
    }

    class altasButtonListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            model.executeQuery("INSERT INTO alumnos VALUES '" + view.registroTextField + "','" +
                    view.dniTextField + "','" + view.nameTextField + "','" + view.apellido1TextField +
                    "','" + view.apellido2TextField + "'" );
        }
    }
    
    class bajasButtonListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
            System.out.println("Hello, world");
        }
    }
    
    class modificarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
            System.out.println("Hello, world");
        }
    }
    
    class salirButtonListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
            System.exit(0);
        }
    }
}
