/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connections;
import java.sql.*;
import java.util.*;

/**
 *
 * @author 4756
 */
public class Edit_Profile {
    public boolean isEdit(Statement st, String name, String mob, String email, String username, String pass)
    {
        boolean flag = false;
        try
        {
            String query = "update registration_info set name='"+name+"', mobile='"+mob+"', email='"+email+"', password='"+pass+"' where username='"+username+"'";;
            int x = st.executeUpdate(query);
            if(x>0)
                flag=true;
        }
        catch(Exception ex)
        {
            System.out.println("Exception in edit Profile is "+ex);
        }
        
        return flag;
    }
    
    public ArrayList isFetch(Statement st, String username)
    {
        ArrayList<String> data = new ArrayList();
        try
        {
            String query = "select * from registration_info where username='"+username+"'";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
            {
                data.add(rs.getString(1));
                data.add(rs.getString(2));
                data.add(rs.getString(3));
                data.add(rs.getString(4));
                data.add(rs.getString(5));
                
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception in edit Profile is "+ex);
        }
        
        return data;
    }
}
