package com.dev.dscommerce.services;

public class ResourceNotFoundException extends RuntimeException {

    //Esse construtor exige que seja informada uma mensagem...
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
