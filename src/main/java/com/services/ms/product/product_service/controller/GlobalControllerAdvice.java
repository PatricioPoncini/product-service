package com.services.ms.product.product_service.controller;

import com.services.ms.product.product_service.exceptions.CategoryNotFoundException;
import com.services.ms.product.product_service.exceptions.ProductNotFoundException;
import com.services.ms.product.product_service.model.dto.ErrorResponse;
import com.services.ms.product.product_service.utils.ErrorCatalog;
import org.aspectj.bridge.Message;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleProductNotFoundException() {
        return ErrorResponse.builder().message(ErrorCatalog.PRODUCT_NOT_FOUND.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorResponse handleCategoryNotFoundException() {
        return ErrorResponse.builder().message(ErrorCatalog.CATEGORY_NOT_FOUND.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        return ErrorResponse.builder()
                .message(ErrorCatalog.INVALID_PRODUCT_PARAMETERS.getMessage()).
                errors(bindingResult.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleInternalServerError(Exception exception) {
        return ErrorResponse.builder()
                .message(ErrorCatalog.INTERNAL_SERVER_ERROR.getMessage())
                .errors(Collections.singletonList(exception.getMessage()))
                .build();
    }

    // Dejar los generales para el final
}
