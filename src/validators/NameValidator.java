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
public class NameValidator implements IValidation{

    @Override
    public void Validate(Object data) {
        try{
            String name = (String) data;//Check on string
            if(name.equals("")){
                throw new IllegalArgumentException("Name Field is empty");
            } 
            if(name.length() == 50){
                throw new IllegalArgumentException("Name is too long");
            }
        }catch(ClassCastException e){
                throw new IllegalArgumentException("Name is not of type string");
        }
    }
}
