/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.LibraryView;
import models.Queries;

/**
 *
 * @author root
 */
public class Controller {
    
    Queries queries = new Queries();
    LibraryView view = new LibraryView();
    
    public Controller(Queries queries, LibraryView view) {
        this.queries = queries;
        this.view = view;
    }
    
    public void start() {
        this.view.setVisible(true);
    } 
    
    private void altasButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        System.out.println("Hello, world");
    } 
    
}
