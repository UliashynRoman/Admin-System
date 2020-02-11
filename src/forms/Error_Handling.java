/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import utils.Query;
import utils.CurrentUser;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utils.CurrentUser;
import utils.Query;

/**
 *
 * @author roman
 */
public class Error_Handling {
    private ArrayList<String> err_list = new ArrayList<String>();
    CurrentUser current_user = CurrentUser.getInstance();
    private Query qr = new Query();
    
    public Error_Handling(ArrayList<String> err_list){
        this.err_list = err_list;
    }
    
    public boolean isMainHere(){
        if(current_user.getStatus().toLowerCase().equals("main")){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isCounter(){
        if(current_user.getStatus().toLowerCase().equals("counter")){
            return true;
        }else{
            return false;
        }
    }
    
    ///CURENT USER
    public boolean Check_Permission(String compare){
        boolean ableToChange = true;
        if(compare.toLowerCase().equals("main")){
            System.out.println(current_user.getStatus() +"==="+compare);
            
            if(current_user.getStatus().toLowerCase().equals(compare.toLowerCase())) {
                System.out.println("Can change");
                ableToChange = true;
            }else {
                System.out.println("Cannot");
                ableToChange = false;
                err_list.add("You have no permission to CRUD others admins");
            }
        }
        return ableToChange;
    }
    
    public boolean EqualPasswords(String prev,JTextField next){
        boolean stm;
        if(prev.equals(next.getText())){
            stm = true;
        }else{
            err_list.add("Current password is incorrect\n");
            stm = false;
        }
        return stm;
    }
    
    public void Print_Errors(){
        String stm = "";
        for(int i = 0; i < err_list.size(); ++i){stm += err_list.get(i);}
        JOptionPane.showMessageDialog(null, stm);
        err_list.clear();
    }

    
    boolean Exist_Email(JTextField s,String db) {
        qr.setDb_name(db);
        if(!qr.emailExist(s.getText())){
            err_list.add("User with email "+s.getText()+" exist");
            return false;
        }else{
            return true;
        }
    }
}
