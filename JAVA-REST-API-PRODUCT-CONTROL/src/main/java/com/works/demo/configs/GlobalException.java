package com.works.demo.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity save(MethodArgumentNotValidException ex) {

        Map<String, Object> hm = new LinkedHashMap<>();
        List<Object> errors = new ArrayList<>();

        for (int i = 0; i < ex.getFieldErrors().size(); i++) {
            Map<String, Object> hm2 = new LinkedHashMap<>();
            hm2.put("field", ex.getFieldErrors().get(i).getField());
            hm2.put("defaultMessage", ex.getFieldErrors().get(i).getDefaultMessage());
            hm2.put("code", ex.getFieldErrors().get(i).getCode());
            errors.add(hm2);
        }
        hm.put("status", false);
        hm.put("result", errors);
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }

}




