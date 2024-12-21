/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author 4756
 */
public class WriteFile {
    public boolean isWrite(String filepath,byte []fileByteData)
    {
        boolean flag = false;
        try
        {
            Path path = Paths.get(filepath);
            Files.write(path, fileByteData);
            flag = true;
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
        return flag;
    }
}
