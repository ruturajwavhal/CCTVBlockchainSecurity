/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MD5;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileByteReader
{


     public  String readContentIntoByteArray(File file)
   {
      FileInputStream fileInputStream = null;
//      FileInputStream fileInputStream1 = null;
      
      byte[] bFile = new byte[(int) file.length()];
      String text="";
      try
      {
         //convert file into array of bytes
         fileInputStream = new FileInputStream(file);
         fileInputStream.read(bFile);
         fileInputStream.close();
//         boolean executeDenied = file.setExecutable(false);
//         File f1 = file.getParentFile();
//         fileInputStream1 = new FileInputStream(f1);
//         fileInputStream1.notify();
         text = new String(bFile);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
       
//       
//       String fileContent="";
//       try {
//            byte[] byteData = Files.readAllBytes(Paths.get(filepath));
//            System.out.println("\nFile data in bytes (using Files.readAllBytes):");
//            fileContent = new String(byteData);
//            for (byte b : byteData) {
//                System.out.print(b + " ");
//            }
//            System.out.println("fileContent : "+fileContent);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//      return fileContent;

return text;
   }
}
