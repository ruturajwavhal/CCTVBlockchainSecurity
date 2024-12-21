/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connections;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 4756
 */
public class UpdateAdminPassword {
    public boolean isUpdatePassword( String password)
    {
        boolean flag = false;
        try
        {
             Statement st=new DB_Driver().getConnection();
            String query = "update admin_info set password='"+password+"' where username='admin'";
            int x = st.executeUpdate(query);
            
           if(x>0)
           {
               flag = true;
           }
        }
        catch(Exception ex)
        {
            System.out.println("Exception in Update password is "+ex);
        }
        
        return flag;
    }
}
