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
public class AmtValidator implements IValidation{
    
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false; 
        }
        return pattern.matcher(strNum).matches();
    }
    @Override
    public void Validate(Object data) {
        try {
            String amount = (String) data;
            if(amount.equals("")){
                throw new IllegalArgumentException("Amount Field is empty");
            } 
            if(!isNumeric(amount)) {
                throw new IllegalArgumentException("Amount is not numeric");
            }
            if(amount.length() >= 10){
                throw new IllegalArgumentException("Amount is too long");
            }
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Amount is not of type string");
        }
    }
    
}
