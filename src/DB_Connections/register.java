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
public class register {
    public boolean isRegister(Statement st, String name, String mob, String email, String username, String pass )
    {
        boolean flag = false;
        try
        {
            String query="insert into registration_info values('"+name+"','"+mob+"','"+email+"','"+username+"','"+pass+"')";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
        }
        catch(Exception ex)
        {
            System.out.println("Exception in register is "+ex);
        }
        return flag;
    }
}
