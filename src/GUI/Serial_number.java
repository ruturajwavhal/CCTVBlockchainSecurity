/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import DB_Connections.SerialNumberFetcher;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
import java.sql.Statement;
public class Serial_number 
{
    public String getSerial_number()
    {
        int sr_no=0;
        ArrayList serial_num=new SerialNumberFetcher().getSr_no();
        
        if(serial_num.isEmpty())
        {
            sr_no=1;
        }
        else
        {
            String num1=(String)serial_num.get(0);
            int big=Integer.parseInt(num1);
            for (int i = 0; i < serial_num.size(); i++) 
            {
                String num2=(String)serial_num.get(i);
                int s=Integer.parseInt(num2);
                
                if(s>big)
                {
                    big=s;
                }
            }
            
            sr_no=big+1;
            System.out.println("sr_no is "+sr_no);
        }
        String str_srno=Integer.toString(sr_no);
        System.out.println("str_sr_no is "+str_srno);
        return str_srno;
    }
}
