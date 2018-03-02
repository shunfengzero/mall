package com.test.service;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Component
@WebService
public class FirstService {

    @WebMethod
    public String print() {
        return "hello World";
    }
}
