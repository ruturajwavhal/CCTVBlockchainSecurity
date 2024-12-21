/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connections;
import java.sql.*;
/**
 *
 * @author 4756
 */
public class DB_Driver {
    public Statement getConnection()
    {
        Statement st = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cctv_video_securing","root","root");
            st=con.createStatement();
        }
        catch(Exception ex)
        {
            System.out.println("Exception in DB_Driver is "+ex);
        }
        return st;
    }
    public Statement getTerminalKeyConnection()
    {
        Statement st = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/terminal_key","root","root");
            st=con.createStatement();
        }
        catch(Exception ex)
        {
            System.out.println("Exception in DB_Driver is "+ex);
        }
        return st;
    }
}
