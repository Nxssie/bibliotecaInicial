/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos Sanchez
 */
public class Queries {

    private static ResultSet rs = null;

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
}
