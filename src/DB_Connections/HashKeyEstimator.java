/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connections;

import GUI.DataKepper;
import MD5.FileByteReader;
import MD5.MD5Hash;
import java.io.File;
import java.sql.Statement;
import java.util.ArrayList;

public class HashKeyEstimator 
{
    public boolean isDBSafe()
    {
        boolean flag=true;
        try
        {
            //Statement st=new DB_Driver().getConnection();
            
            String terminalKey = new TerminalKeyOperation().fetchTerminalKey(new DB_Driver().getTerminalKeyConnection());   
            ArrayList<ArrayList<Object>> dbFileInfo= new FetchUploadedInfo().isFetchFileInfo();
            dbFileInfo.sort((list1, list2) -> {
                // Assuming the first element is a string representing a number
                    return Integer.compare(
                        Integer.parseInt((String) list1.get(0)),
                        Integer.parseInt((String) list2.get(0))
                    );
                });
            System.out.println("DB File Info :"+dbFileInfo);
            if(dbFileInfo.size()==0)
                {
                    flag=true;
                }
            else if(dbFileInfo.size()==1)
            {
                ArrayList row = (ArrayList)dbFileInfo.get(0);
                String dbTerminalKey = row.get(2).toString();
                if(!terminalKey.equals(dbTerminalKey))
                {
                    flag=false;
                }
            }
            else
            {
                String allDbHash = "";
                for (int i = 0; i < dbFileInfo.size(); i++) {
                    ArrayList row = (ArrayList)dbFileInfo.get(i);
                    allDbHash=allDbHash+row.get(2).toString();
                }
                String dbTerminalKey = new MD5Hash().MDfive(allDbHash);
                System.out.println("DB Terminal Key : "+dbTerminalKey+"\n og terminal key : "+terminalKey);
                if(!terminalKey.equals(dbTerminalKey))
                {
                    flag=false;
                }
            }

 
        }
        catch(Exception ex)
        {
            System.out.println("Exception in HashKeyEstimator is "+ex);
        }
        return flag;
    }
    
    public String isCalculateNewTerminalKey(String currentHash)
    {
        String newTerminalKey = "";
        ArrayList<ArrayList<Object>> dbFileInfo= new FetchUploadedInfo().isFetchFileInfo();
        dbFileInfo.sort((list1, list2) -> {
            // Assuming the first element is a string representing a number
                return Integer.compare(
                    Integer.parseInt((String) list1.get(0)),
                    Integer.parseInt((String) list2.get(0))
                );
            });
        System.out.println("DB File Info :"+dbFileInfo);
        if(dbFileInfo.size()!=0)
        {
            String allDbHash = "";
            for (int i = 0; i < dbFileInfo.size(); i++) {
                ArrayList row = (ArrayList)dbFileInfo.get(i);
                allDbHash=allDbHash+row.get(2).toString();
            }
            newTerminalKey = new MD5Hash().MDfive(allDbHash+currentHash);
        }
        else
            newTerminalKey=currentHash;
        System.out.println("new Terminal key generated : "+ newTerminalKey);
        
        return newTerminalKey;
    }
}
