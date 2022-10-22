package com.zph.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.zph.model.User;

/**
 * @auther zph
 * @date 2022/9/25 - 17:17
 */
@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"username","usernameEmpty");
        User user = (User)o;
        if (user.getPassword().length()<4){
            errors.rejectValue("password","password长度不能小于4位");
        }else if (user.getPassword().length()>10){
            errors.rejectValue("password","password长度不能大于10位");
        }
    }
}
