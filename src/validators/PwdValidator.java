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
public class PwdValidator implements IValidation{

    @Override
    public void Validate(Object data) {
        try{
            String pwd = (String) data;
            if(pwd.equals("")){
                throw new IllegalArgumentException("Password Field is empty");
            } 
            if(pwd.length() == 12){
                throw new IllegalArgumentException("Password is too long");
            }
        }catch (ClassCastException e) {
            throw new IllegalArgumentException("Password is not of type string");
        }
    }
}
