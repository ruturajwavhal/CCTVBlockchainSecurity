/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connections;

import GUI.DataKepper;
import java.io.File;
import java.nio.file.*;
import java.sql.Statement;

/**
 *
 * @author 4756
 */
public class UploadFileInfo {
    public boolean isUploadInfo(Statement st,String srNum, String username, String filename, String dateTime, String hash, String currentFilePath, String uploadFilePath)
    {
        boolean flag = false;
        try
        {
            
            Files.copy(Paths.get(currentFilePath), Paths.get(uploadFilePath+filename));
            System.out.println(currentFilePath+" >>>> "+uploadFilePath+filename);
            String query="insert into file_info values('"+srNum+"','"+username+"','"+filename+"','"+dateTime+"','"+hash+"')";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            System.out.println("Flag of isUploadInfo : "+flag );
        }
        catch(Exception ex)
        {
            System.out.println("Exception in File Upload Info is "+ex);
        }
        return flag;
    }
}
