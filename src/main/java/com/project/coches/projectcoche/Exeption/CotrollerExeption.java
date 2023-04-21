package com.project.coches.projectcoche.Exeption;

import org.hibernate.mapping.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.Collections;
@RestControllerAdvice
public class CotrollerExeption {
    public ResponseEntity<Map<String ,String>> emailExeption(EmailValidatorExeption emailValidatorExeption) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("Error",emailValidatorExeption.getMessage()));
    }
}
