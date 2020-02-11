/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import java.util.regex.Pattern;

/**
 *
 * @author roman
 */
public class PhoneValidator implements IValidation {
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false; 
        }
        return pattern.matcher(strNum).matches();
    }
    
    @Override
    public void Validate(Object data) {
        try{
            String phone = (String) data;//check on string
            if(phone.equals("")){
                throw new IllegalArgumentException("Phone Field is empty");
            } 
            if(!isNumeric(phone)){
                throw new IllegalArgumentException("Phone is not numeric");
            }
            if(phone.length() > 15){
                throw new IllegalArgumentException("Phone is too long");
            }
        }catch(ClassCastException e){
            throw new IllegalArgumentException("Phone is not of type string");
        }
    }
    
}
