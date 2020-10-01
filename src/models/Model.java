/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import models.DBConnection;
import models.Queries;
/**
 *
 * @author root
 */
public class Model {
    
    private Connection conn = null;
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
}
