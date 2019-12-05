/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package current_user;

/**
 *
 * @author roman
 */
public class Singleton {
    
   private static Singleton current_user;
    private  String name,status,email;
    private static boolean initialized = false;
    
    private Singleton(){}
    
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String s){
        this.email = s;
    }
    
    public void setStatus(String s){
        this.status = s;
    }
    
    public String getEmail(){
        return email;
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
    }
    
    
    public static Singleton getInstance() {
        
        if(initialized) return current_user;
        current_user = new Singleton();
        current_user.init();
        initialized = true;
        return current_user;
                
    }     

    
       
}
