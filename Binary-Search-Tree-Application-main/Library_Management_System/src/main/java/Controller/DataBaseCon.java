/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.*;

/**
 *
 * @author Janith Disanayake
 */
public class DataBaseCon {

    /**
     *
     * @return @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/lms_pdsa", "root", "");
        return con;
    }

}
