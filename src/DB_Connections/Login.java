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
public class Login {
    public boolean isLogin(Statement st, String username, String pass)
    {
        boolean flag = false;
        try
        {
            
            String query = "select * from registration_info where username='"+username+"' and password='"+pass+"'";
            ResultSet rs = st.executeQuery(query);
                if(rs.next())
                    flag=true;
        }
        catch(Exception ex)
        {
            System.out.println("Exception in login is "+ex);
        }
        return flag;
    }
}