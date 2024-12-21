/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connections;

import GUI.DownloadFrame;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 4756
 */
public class FetchUploadedInfo {
    public boolean isFetchData()
    {
        boolean flag = false;
        try
        {
             Statement st1= new DB_Driver().getConnection();
            Statement st2= new DB_Driver().getConnection();
            
            String query = "select * from file_info";
            System.out.println("Query = "+query);
            ResultSet rs1=st1.executeQuery(query);
            ResultSet rs2=st2.executeQuery(query);
            int x=0;
            while(rs1.next())
            {
                x++;
                flag=true;
            }
            String data1[][]=new String[x][4];
            int n=0;
            while(rs2.next())
            {
                data1[n][0]=rs2.getString(1);
                data1[n][1]=rs2.getString(2);
                data1[n][2]=rs2.getString(3);
                data1[n][3]=rs2.getString(4);
                n++;   
            }
            DownloadFrame.data=data1;
        }
        catch(Exception ex)
        {
            System.out.println("Exception in Fetching Uploaded Info is : "+ex);
        }
        return flag;
    }
    
    public String isFetchHash( String srNum)
    {
        String priHash= "";
        try
        {
             Statement st=new DB_Driver().getConnection();
            String query = "select * from file_info where sr='"+srNum+"'";
//            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
            {
                priHash=rs.getString(5);
                System.out.println("");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception in Fetching Previous Hashkey is "+ex);
        }
        
        return priHash;
    }
    
    public ArrayList isFetchFileInfo()
    {
        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
        try
        {
             Statement st=new DB_Driver().getConnection();
            String query = "select * from file_info";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
            {
                ArrayList<Object> rowdata  = new ArrayList<Object>(); 
                rowdata.add(rs.getString(1));
                rowdata.add(rs.getString(3));
                rowdata.add(rs.getString(5));
                data.add(rowdata);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception in Fetching Previous Hashkey is "+ex);
        }
        
        return data;
    }
    
}
