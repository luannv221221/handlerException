package com.ra.validation;

import com.ra.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductValidateUnique implements ConstraintValidator<UserUnique,String> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        return !userRepository.existsByUserName(userName);
    }
}
