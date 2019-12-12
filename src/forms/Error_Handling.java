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

/**
 *
 * @author roman
 */
public class Error_Handling {
    private ArrayList<String> err_list = new ArrayList<String>();
    private static final String EMAIL_PATTERN = 
    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
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
    
    
    ///EMAIL
    public boolean Valid_Email(JTextField s){
        boolean stm;
        if(s.getText().equals("")){
            err_list.add("Email Field is empty\n");
            stm = true;
        }else{
            if(VerifyEmail(s)){
                stm = true;
            }else{
                stm = false;
            }
        }
        System.out.println();
        return stm;
    }
    
    
    
    
    ///NAME
    public boolean Valid_Name(JTextField s){
        boolean stm;
        if(s.getText().equals("")){
            err_list.add("Name Field is empty\n");
            stm = true;
            
        }else{
            if(ValidLenght(s,"50")){
                stm = false;
            }else{
                stm = true;
            }
        }
        return stm;
    }
    
    
    ///PHONE
    public boolean Valid_Phone(JTextField s){
        boolean stm;
        if(s.getText().equals("")){
            err_list.add("Phone Field is empty\n");
            stm = true;
            
        }else{
            if(isNumeric(s)){
                if(ValidLenght(s,"15")){
                    stm = false;
                }else{
                    stm = true;
                } 
            }else{
                stm = true;
            }
        }
        return stm;
    }
    
    
    ////City
    public boolean Valid_City(JTextField s){
        boolean stm;
        if(s.getText().equals("")){
            err_list.add("City Field is empty\n");
            stm = true;
            
        }else{
            stm = false;
        }
        return stm;
    }
    
    
    ///CLASS
    public boolean Valid_Class(JTextField s){
        boolean stm;
        if(s.getText().equals("")){
            err_list.add("Class Field is empty\n");
            stm = true;
            
        }else{
            if(isNumeric(s)){
                if(ValidLenght(s,"2")){
                    stm = false;
                }else{
                    stm = true;
                } 
            }else{
                stm = true;
            }
        }
        return stm;
    }
    
    public boolean Valid_Password(JTextField s){
        boolean stm;
        if(s.getText().equals("")){
            err_list.add("Password Field is empty\n");
            stm = true;
            
        }else{
            stm = false;
        }
        return stm;
    }
    
    public boolean Valid_ID(JTextField s){
        boolean stm;
        if(s.getText().equals("")){
            err_list.add("ID Field is empty\n");
            stm = true;
            
        }else{
            if(isNumeric(s)){
                if(ValidLenght(s,"6")){
                    stm = false;
                }else{
                    stm = true;
                } 
            }else{
                stm = true;
            }
            
            
        }
        return stm;
    }
    
    
    public boolean Valid_Amount(JTextField s){
        boolean stm;
        System.out.println(s.getText());
        if(s.getText().equals("")){
            err_list.add("Amout Field is empty\n");
            stm = true;
        }else{
            if(isNumeric(s)){
                if(ValidLenght(s,"6")){
                    stm = false;
                }else{
                    stm = true;
                } 
            }else{
                stm = true;
            }
        }
        return stm;
    }
    
    
    public boolean Valid_Debt(JTextField s){
        boolean stm;
        System.out.println(s.getText());
        if(s.getText().equals("")){
            err_list.add("Debt Field is empty\n");
            stm = true;
        }else{
            if(isNumeric(s)){
                if(ValidLenght(s,"6")){
                    stm = false;
                }else{
                    stm = true;
                } 
            }else{
                stm = true;
            }
        }
        return stm;
    }
    
    public boolean Valid_Field(JTextField s){
        boolean stm;
        if(s.getText().equals("")){
            err_list.add("Empty\n");
            stm = true;
        }else{
            stm = false;
        }
        System.out.println();
        return stm;
    }
    
    
    private boolean VerifyEmail(JTextField s){
        boolean stm;
        System.out.println(s.getText());
        if (s.getText().matches(EMAIL_PATTERN)) {
            stm = true;
        }else{
            err_list.add("Email incorrect \n");
            stm = false;
        }
        return stm;
        
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
    
    private boolean ValidLenght(JTextField s,String ln){
        boolean stm;
        
        if(s.getText().matches("[A-Za-z0-9]{0,"+ln+"}")){
            stm = true;
        }else{
            err_list.add("Error in with text ("+s.getText()+")\n"+"Field must have length of "+ln+" number\n");
            stm = false;
        }
        return stm;
    }
    
        public boolean isNumeric(JTextField str) {

        // null or empty
        if (str.getText() == null || str.getText().length() == 0) {
            return true;
        }

        for (char c : str.getText().toCharArray()) {
            if (!Character.isDigit(c)) {
                err_list.add("Is not numeric ("+str.getText()+")\n");
                return false;
            }
        }

        return true;

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
