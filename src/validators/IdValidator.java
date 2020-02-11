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
public class IdValidator implements IValidation {
    
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
            String id = (String) data;//check on string
            if(id.equals("")){
                throw new IllegalArgumentException("Id Field is empty");
            } 
            if(!isNumeric(id)) {
                throw new IllegalArgumentException("Id is not numeric");
            }
            if(id.length() >= 6){
                throw new IllegalArgumentException("Id is too long");
            }
        }catch(ClassCastException e){
            throw new IllegalArgumentException("Id is not of type string");
        }
    }
    
}
