/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author roman
 */
public class CurrentUser {
    
   private static CurrentUser current_user;
    private  String name,status,email,password;
    private static boolean initialized = false;
    
    private CurrentUser(){}
    
    
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String s){
        this.email = s;
    }
    public void setPassword(String name) {
        this.password = name;
    }
    
    public void setStatus(String s){
        this.status = s;
    }
    
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public  String getStatus(){
        return status;
    }
    
    public  String getName(){
        return name;
    }
    
    public void init(){
        getStatus();
        getEmail();
        getPassword();
    }
    
    
    public static CurrentUser getInstance() {
        
        if(initialized) return current_user;
        current_user = new CurrentUser();
        current_user.init();
        initialized = true;
        return current_user;
                
    }     

    
       
}
