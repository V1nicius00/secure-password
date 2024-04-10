package com.example.securepassword.controller;

import com.example.securepassword.dto.BodyRequest;
import com.example.securepassword.dto.FailureResponse;
import com.example.securepassword.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final PasswordService passwordService;

    public ApiController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/validate-password")
    public ResponseEntity<FailureResponse> validatePassword(@RequestBody BodyRequest request){

        var failures = passwordService.validatePassword(request.password());

        if(failures.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(new FailureResponse(failures));
    }

}
