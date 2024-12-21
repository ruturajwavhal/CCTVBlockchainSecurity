/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author RUTU
 */
public class DateTime {
    public String getDate()
    {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String p = dateFormat.format(cal.getTime());
//        System.out.println("Date calculation done");
        return p;
    }
    public String getTime()
    {
        Calendar cal = new GregorianCalendar();
        String am_pm;
        int hour= cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        if(cal.get(cal.AM_PM)==0)
        {
            am_pm = "AM";
        }else
            am_pm = "PM";
        String gg = hour+":"+minute+":"+second+" "+am_pm;
//        System.out.println("time calculation done");
        return gg;
    }
}
