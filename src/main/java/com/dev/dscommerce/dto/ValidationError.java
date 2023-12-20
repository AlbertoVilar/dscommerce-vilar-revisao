package com.dev.dscommerce.dto;

import lombok.Getter;


import com.dev.dscommerce.customerrors.CustomError;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Getter
public class ValidationError extends CustomError {
private List<FildMessage> errors = new ArrayList<>();
    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public void addError(String fildName, String fildMassage) {
        errors.add(new FildMessage(fildName, fildMassage));
    }
}
