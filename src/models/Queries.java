/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
//import FrmPrincipal.*;
import models.DBConnection.*;

/**
 *
 * @author Carlos Sanchez
 */
public class Queries {

    private Connection conn = null;
    private static ResultSet rs = null;
    //private VistaTabla vtabla = null;

    DBConnection connect = new DBConnection();
    
    public ResultSet showData(String sql) {

        try {
            Statement stmt = connect.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return rs;
    }

    /*public int executeUpdateQuery(String sql) {
        int i;
        try {
            Statement stmt = connect.getConnection().createStatement();
            JOptionPane.showMessageDialog(null, sql);
            i = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            i = 0;
        }
        return i;
    }*/

}
