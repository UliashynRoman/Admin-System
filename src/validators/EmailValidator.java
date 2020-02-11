/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

/**
 *
 * @author roman
 */
public class EmailValidator implements IValidation{
    private static final String EMAIL_PATTERN = 
       "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
       + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    @Override
    public void Validate(Object data) {
        try {
            String email = (String) data;
            if(email.equals("")){
                throw new IllegalArgumentException("Email Field is empty");
            } 
            if(email.length() >= 50){
                throw new IllegalArgumentException("Email is too long");
            }
            if(!email.matches(EMAIL_PATTERN)){
                throw new IllegalArgumentException("Email incorrect");
            }
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Email is not of type string");
        }
    }
    
    
}
