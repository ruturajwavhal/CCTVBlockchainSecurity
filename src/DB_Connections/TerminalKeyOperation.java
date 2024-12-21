/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connections;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 4756
 */
public class TerminalKeyOperation {
    public boolean isUpdateTerminalKey(Statement st, String newTerminalKey)
    {
        boolean flag = false;
        try
        {
            String query = "update key_info set tkey='"+newTerminalKey+"' where sid='1'";
            System.out.println(query);
            int x = st.executeUpdate(query);
            if(x>0)
                flag=true;
            System.out.println("Flag of isUpdateTerminalKey : "+flag );
        }
        catch(Exception ex)
        {
            System.out.println("Exception in Updating Terminal Key : "+ex);
        }
        return flag;
    }
    
    
    public String fetchTerminalKey(Statement st)
    {
        String terminalKey = "";
        try
        {
            String query = "select * from key_info where sid='1'";
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
                terminalKey=rs.getString(2);
        }
        catch(Exception ex)
        {
            System.out.println("Exception while fetching terminal key : "+ex);
        }
        return terminalKey;
    }
}
