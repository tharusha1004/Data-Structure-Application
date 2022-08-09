/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Janith Disanayake
 */
public class LoginStudent {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public ResultSet loginToApp(String usname, String password) {

        try {

            con = DataBaseCon.getConnection();
            String query = "SELECT * FROM `user_acc` WHERE User_Name=? and Password=?";
            pst = con.prepareStatement(query);
            pst.setString(1, usname);
            pst.setString(2, password);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return rs;
    }

}
