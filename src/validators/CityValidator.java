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
public class CityValidator implements IValidation{

    @Override
    public void Validate(Object data) {
        try{
            String city = (String) data;//Check on string
            if(city.equals("")){
                throw new IllegalArgumentException("City Field is empty");
            } 
            if(city.length() == 20){
                throw new IllegalArgumentException("City field is too long");
            }
        }catch(ClassCastException e){
                throw new IllegalArgumentException("City field is not of type string");
        }
    }
    
}
