package com.example.securepassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    public List<String> validatePassword(String password){
        List<String> failures = new ArrayList<>();

        validateLength(password, failures);
        validateUppercase(password, failures);
        validateLowercase(password, failures);
        validateNumber(password, failures);
        validateSpecialChar(password, failures);

        return failures;
    }

    private void validateLength(String password, List<String> failures) {
        if(password != null && password.length() < 8){
            failures.add("A senha deve conter pelo menos 8 caracteres.");
        }
    }

    private void validateUppercase(String password, List<String> failures){
        if(!Pattern.matches(".*[A-Z].*", password)){
            failures.add("A senha deve conter pelo menos 1 letra maiúscula.");
        }
    }

    private void validateLowercase(String password, List<String> failures) {
        if(!Pattern.matches(".*[a-z].*", password)){
            failures.add("A senha deve conter pelo menos 1 letra minúscula.");
        }
    }

    private void validateNumber(String password, List<String> failures) {
        if(!Pattern.matches(".*[0-9].*", password)){
            failures.add("A senha deve conter pelo menos 1 número.");
        }
    }

    private void validateSpecialChar(String password, List<String> failures) {
        if(!Pattern.matches(".*[\\W].*", password)){
            failures.add("A senha deve conter pelo menos 1 caractere especial ex:(!@#$%...).");
        }
    }

}
