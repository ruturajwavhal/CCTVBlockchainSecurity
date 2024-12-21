/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integritor;


import Admin.AdminDataKepper;
import Admin.CCTVIntegrity;
import FileOperation.ReadFile;
import FileOperation.WriteFile;
import DB_Connections.FetchUploadedInfo;
import GUI.DataKepper;
import GUI.DateTime;
import MD5.FileByteReader;
import MD5.MD5Hash;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author 4756
 */
public class GetIntegrity extends Thread {
int dbcount=0, current_count=0;
    public void run() {
        
        while (true) 
        {
            
            
           ArrayList dbfileData = new FetchUploadedInfo().isFetchFileInfo();
            //System.out.println("DB Data : "+dbfileData);
            File f = new File(DataKepper.uploadPath);
            ArrayList allFiles = new ArrayList();
            
            String[] currentFileList = f.list();
            for (int i = 0; i < currentFileList.length; i++) {
                allFiles.add(currentFileList[i]);
            }
            current_count = allFiles.size();
            dbcount = dbfileData.size();
            //Date And Time Calculation
            String dateTime = new DateTime().getDate()+"/"+new DateTime().getTime();
                String current_hashkey = "";
                ArrayList dbSrNum = new ArrayList();
                for (int i = 0; i < dbfileData.size(); i++) 
                {
                    ArrayList row = (ArrayList)dbfileData.get(i);
                    dbSrNum.add(row.get(0));
                }
                Collections.sort(dbSrNum);
                int bigSr=dbSrNum.size();
                ArrayList lastRowData = (ArrayList)dbfileData.get(bigSr-1);
                //System.out.println("Last row data : "+lastRowData);
                //Final hash 
                String finalHash = lastRowData.get(2).toString();
                

                for (int i = 0; i < dbSrNum.size(); i++) 
                {
                    for (int j = 0; j < dbfileData.size(); j++) 
                    {
                        ArrayList rowData = (ArrayList) dbfileData.get(j);
                        String srNum = rowData.get(0).toString();
                        
                        if(dbSrNum.get(i).equals(srNum))
                        {
                            String filename = rowData.get(1).toString();
                            if (!srNum.equals("1"))
                            {
                                String byte_data = new FileByteReader().readContentIntoByteArray(new File(DataKepper.uploadPath + filename));
                                byte_data = byte_data + current_hashkey;
                                current_hashkey = new MD5Hash().MDfive(byte_data);
                            }
                            else 
                            {
                                String byte_data = new FileByteReader().readContentIntoByteArray(new File(DataKepper.uploadPath + filename));
                                current_hashkey = new MD5Hash().MDfive(byte_data);
                            }
                        }
                    }
                }
                
                //System.out.println("Final Hash : "+finalHash);
                //System.out.println("Current Hash : "+current_hashkey);
            
            
             if(dbcount>current_count) // file Deleted
            {
//                System.out.println("Current All Files : "+allFiles);
                ArrayList deleteFileList = new ArrayList();
                deleteFileList.addAll(AdminDataKepper.allFileName);
//                System.out.println("Backuped All Files : "+deleteFileList);
                deleteFileList.removeAll(allFiles);
//                System.out.println("Deleted Files : "+deleteFileList);
                
                if(deleteFileList.size()>0)
                {

                    for (int i = 0; i < AdminDataKepper.allFileBackupData.size(); i++)
                    {
                        ArrayList singleFileData = (ArrayList)AdminDataKepper.allFileBackupData.get(i);
                        String filename = AdminDataKepper.allFileName.get(i).toString();
                        System.out.println("File Data : "+singleFileData);
                        for (int j = 0; j < deleteFileList.size(); j++)
                        {
                            if(filename.equals(deleteFileList.get(j)))
                            {

                                byte byteData[] = (byte[])singleFileData.get(0);
                                if(new WriteFile().isWrite(DataKepper.uploadPath+filename, byteData))
                                {
                                    System.out.println(filename + " Restored Succesfully !!");
                                    String status = "\nCCTV Video file name "+filename+" was deleted at "+dateTime+" by the Intruder and file has been restored succesfully by the System. \n";
                                    CCTVIntegrity.jTextArea1.setText(CCTVIntegrity.jTextArea1.getText()+status);
                                }
                            }
                        }
                    }
                }
                
                //===================================================
                
                            
//                System.out.println(dbfileData);
               
                
            }
//            else if( dbcount<current_count) // File added
//            {
//                
//                
//            }
             else if(!current_hashkey.equals(finalHash)) // need to check for modification
            {
                
                CCTVIntegrity.jTextArea1.setText(CCTVIntegrity.jTextArea1.getText()+"\nData is UnSecured at "+dateTime+"\n");
                     
                    ArrayList AllCurrentFileByteInfo = new ArrayList();
                     ArrayList AllCurrentFileName = new ArrayList();
                    for (int i = 0; i < currentFileList.length; i++) 
                    {
                        byte[] byteData = new ReadFile().readContentIntoByteArray(DataKepper.uploadPath+currentFileList[i]);
                        
                        AllCurrentFileName.add(currentFileList[i]);//current File name
                        //System.out.println(currentFileList[i]);
                        AllCurrentFileByteInfo.add(byteData);// current file data
                    }
                    
                    for (int i = 0; i < AdminDataKepper.allFileName.size() ; i++) 
                    {
                        String backupFilename = AdminDataKepper.allFileName.get(i).toString();
                        for (int j = 0; j < AllCurrentFileName.size(); j++) 
                        {
                            String currentFilename = AllCurrentFileName.get(j).toString();
                            if(backupFilename.equals(currentFilename))
                            {
                                String backupFileByteData = AdminDataKepper.allFileBackupData.get(i).toString();
                                
                                String currentFileByteData = AllCurrentFileByteInfo.get(j).toString();
                                System.out.println("backupFileByteData : "+backupFileByteData+"\n currentFileByteData : "+currentFileByteData);
                                if(!backupFileByteData.equals(currentFileByteData))
                                {
                                    System.out.println("    AAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaa");
                                    File f1 = new File(DataKepper.uploadPath+currentFilename);
                                    if(f1.delete())
                                    {
                                        ArrayList singleFileData = (ArrayList)AdminDataKepper.allFileBackupData.get(i);
                                        //System.out.println("AdminDataKepper.allFileBackupData "+AdminDataKepper.allFileBackupData.get(i));
                                        byte byteData[] = (byte[])singleFileData.get(0);
                                        System.out.println("byte data : "+AdminDataKepper.allFileBackupData.get(i));
                                        if(new WriteFile().isWrite(DataKepper.uploadPath+backupFilename, byteData))
                                        {
                                            System.out.println(backupFilename + " Restored Succesfully !!");
                                            String status = "\nCCTV Video file name "+backupFilename+" was modified at "+dateTime+" by the Intruder and file has been restored succesfully by the System. \n";
                                            CCTVIntegrity.jTextArea1.setText(CCTVIntegrity.jTextArea1.getText()+status);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                else
                {
                    CCTVIntegrity.jTextArea1.setText(CCTVIntegrity.jTextArea1.getText()+"\nData is Secured at "+dateTime+"\n");
                }
                try {
                    Thread.sleep(5000);
                } catch (Exception ex) {

                }
            }
        }
}

            
        
