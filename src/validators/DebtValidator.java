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
public class DebtValidator implements IValidation{
    
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
            String debt = (String) data;//check on string
            if(debt.equals("")){
                throw new IllegalArgumentException("Debt Field is empty");
            } 
            if(!isNumeric(debt)) {
                throw new IllegalArgumentException("Debt is not numeric");
            }
            if(debt.length() > 6){
                throw new IllegalArgumentException("Debt is too long");
            }
        }catch(ClassCastException e){
            throw new IllegalArgumentException("Debt is not of type string");
        }
    }
    
}
