/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integritor;

import Admin.AdminDataKepper;
import Admin.CCTVIntegrity;
import DB_Connections.FetchUploadedInfo;
import FileOperation.ReadFile;
import FileOperation.WriteFile;
import GUI.DataKepper;
import GUI.DateTime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author 4756
 */
public class newIntegrity extends Thread
{
    ArrayList orgFileName=new ArrayList();
    ArrayList byteList = new ArrayList();
    
    
    
    public void run()
    {
        File f = new File(DataKepper.uploadPath);
        String fileList[] = f.list();
        for (int i = 0; i < fileList.length; i++) 
        {
            byte[] byteData = new ReadFile().readContentIntoByteArray(DataKepper.uploadPath+fileList[i]);
            orgFileName.add(fileList[i]);
            byteList.add(byteData);
                        
        }
        System.out.println("Backup Completed !!");
        
         ArrayList<ArrayList<Object>> dbFileInfo= new FetchUploadedInfo().isFetchFileInfo();
            dbFileInfo.sort((list1, list2) -> {
            // Assuming the first element is a string representing a number
                return Integer.compare(
                    Integer.parseInt((String) list1.get(0)),
                    Integer.parseInt((String) list2.get(0))
                );
            });
            
               
               System.out.println("\"\\nAfter sorting DB Info :\"");
               for (int i = 0; i < dbFileInfo.size(); i++)
               {
                    ArrayList row=(ArrayList)dbFileInfo.get(i);
                    System.out.println(row);
                }
        while(true)
        {
            String dateTime = new DateTime().getDate()+"/"+new DateTime().getTime();
             for (int i = 0; i < dbFileInfo.size(); i++)
               {
             ArrayList row=(ArrayList)dbFileInfo.get(i);
             String dbfilename=(String)row.get(1);
             String uploadedFilePath = "D:\\CCTV Video\\"+dbfilename;
             File f1 = new File(uploadedFilePath);
             if(!f1.exists())
             {
                 //CCTVIntegrity.jTextArea1.setText(CCTVIntegrity.jTextArea1.getText()+"\nData is Unsecured\n");  
                 for (int j = 0; j < orgFileName.size(); j++) 
                 {
                     String filename = orgFileName.get(j).toString();
                     if(dbfilename.equals(filename))
                     {
                         byte byteData[] = (byte[])byteList.get(j);
                         
                         if(new WriteFile().isWrite(uploadedFilePath, byteData))
                         {
                             String status = "\nCCTV Video file name "+filename+" has been deleted at "+dateTime+" by the Intruder and file has been restored succesfully by the System. \n";;
                             System.out.println(filename+"File Restore Successfully !!");
                             CCTVIntegrity.jTextArea1.setText(CCTVIntegrity.jTextArea1.getText()+status);
                         }
                     }
                 }
             }
             else
             {
                  byte[] currentFileByte = new ReadFile().readContentIntoByteArray(uploadedFilePath);
                 //CCTVIntegrity.jTextArea1.setText(CCTVIntegrity.jTextArea1.getText()+"\nData is Unsecured\n"); 
                 for (int j = 0; j < orgFileName.size(); j++) 
                 {
                     String filename = orgFileName.get(j).toString();
                     if(dbfilename.equals(filename))
                     {
                        byte byteData[] = (byte[])byteList.get(j);
                                                
                        boolean flag = true;
                                
                        for (int l = 0; l < byteData.length; l++) 
                        {
                            if(currentFileByte[l]!=byteData[l])
                            {
                                flag=false;
                                break;
                            }    
                        }
                         
                         if(!flag)
                        {
                           new WriteFile().isWrite(uploadedFilePath, byteData);
                           String status = "\nCCTV Video file name "+filename+" has been Modified at "+dateTime+" by the Intruder and file has been restored succesfully by the System. \n";
                           System.out.println(dbfilename+"File Restore Successfully !!");
                           CCTVIntegrity.jTextArea1.setText(CCTVIntegrity.jTextArea1.getText()+status);
                        }
                         
                         
                     }
                 }
     
             }
             
             
                 
             }
            CCTVIntegrity.jTextArea1.setText(CCTVIntegrity.jTextArea1.getText()+"\nData is Secured\n"); 
            
         
            try {
                    Thread.sleep(5000);
                } catch (Exception ex) {

                }
        }
    }
}






