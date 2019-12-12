/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author roman
 */
public class Payment {
    //All final attributes
    
    
    private static Payment payment;
    private String status;
    private int amount;
    Date date,logDate;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private DateFormat logFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static boolean initialized = false;
    
    
    private Payment(){}

    public void setAmount(int s){
        this.amount = s;
    }
    public void setAmount(String s){
        this.amount = Integer.parseInt(s);
    }
    
    
    
    public int getAmount(){
        return amount;
    }
    
    public  String getDate(){
        this.date = Calendar.getInstance().getTime();
        return dateFormat.format(date);
    }
    
    public String getLogDate(){
        this.logDate = Calendar.getInstance().getTime();
        return logFormat.format(logDate);
    }
    
    public void init(){
        getDate();
        getAmount();
        getLogDate();
    }
    
    
    public static Payment getInstance() {
        
        if(initialized) return payment;
        payment = new Payment();
        payment.init();
        initialized = true;
        return payment;
                
    } 
}
