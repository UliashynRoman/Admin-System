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
public class ValidatorsFactory {
    public static IValidation make(ValidationType type) {
        if (type == ValidationType.ID_VALIDATOR) {
            return new IdValidator();
        }else if (type == ValidationType.NAME_VALIDATOR) {
            return new NameValidator();
        }else if(type == ValidationType.EMAIL_VALIDATOR){
            return new EmailValidator();
        }else if(type == ValidationType.PASSWORD_VALIDATOR){
            return new PwdValidator();
        }else if(type == ValidationType.PHONE_VALIDATOR){
            return new PhoneValidator();
        }else if(type == ValidationType.CITY_VALIDATOR){
            return new CityValidator();
        }else if(type == ValidationType.CLASS_VALIDATOR){
            return new ClassValidator();
        }else if(type == ValidationType.AMOUNT_VALIDATOR){
            return new AmtValidator();
        }else if(type == ValidationType.DEBT_VALIDATOR){
            return new DebtValidator();
        }else if(type == ValidationType.NEW_PASSWORD_VALIDATOR){
            return new NewPasswordValidator();
        }
        else {
            throw new IllegalArgumentException("Unknown validator");
        }
    }
}
