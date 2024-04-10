package com.example.securepassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    public List<String> validatePassword(String password){
        List<String> failures = new ArrayList<>();

        validateLength(password, failures);

        return failures;
    }

    private void validateLength(String password, List<String> failures) {
        if(password != null && password.length() < 8){
            failures.add("A senha precisa conter pelo menos 8 caracteres!");
        }
    }

}
