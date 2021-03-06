/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Carlos Sanchez
 */
public class Model {

    DBConnection connect = new DBConnection();

    public Model() {
    }

    public int executeQuery(String sql) {
        int i = 0;
        try {
            Statement stmt = connect.getConnection().createStatement();
            i = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return i;
    }

    public class VistaTabla extends AbstractTableModel {
        
        ResultSet rs;
        ResultSetMetaData md;
        int numColumnas;
        int numFilas;

        public VistaTabla(ResultSet rs) {
            this.rs = rs;
            try {
                md = rs.getMetaData();
                this.rs.last();
                numFilas = this.rs.getRow();
                numColumnas = md.getColumnCount();

            } catch (SQLException ex) {
            }
        }

        @Override
        public int getRowCount() {
            return numFilas;

        }

        @Override
        public int getColumnCount() {
            return numColumnas;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            try {
                rs.absolute(rowIndex + 1);
                Object o = rs.getObject(columnIndex + 1);
                return o;
            } catch (SQLException ex) {
                return ex.toString();
            }

        }

    }
    
}
