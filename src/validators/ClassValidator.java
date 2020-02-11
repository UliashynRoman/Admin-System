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
public class ClassValidator implements IValidation{
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
            String clas = (String) data;//check on string
            if(clas.equals("")){
                throw new IllegalArgumentException("Class Field is empty");
            } 
            if(!isNumeric(clas)) {
                throw new IllegalArgumentException("Class is not numeric");
            }
            if(clas.length() > 2){
                throw new IllegalArgumentException("Class is too long");
            }
        }catch(ClassCastException e){
            throw new IllegalArgumentException("Class is not of type string");
        }
    }
    
}
