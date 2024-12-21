/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileOperation;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 *
 * @author 4756
 */
public class ReadFile {
    public  byte[] readContentIntoByteArray(String filepath)
   {
       File file = new File(filepath);
      FileInputStream fileInputStream = null;
      byte[] bFile = new byte[(int) file.length()];
      
      try
      {
         fileInputStream = new FileInputStream(file);
         fileInputStream.read(bFile);
         
         fileInputStream.close();

         
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return bFile;
    }
}
