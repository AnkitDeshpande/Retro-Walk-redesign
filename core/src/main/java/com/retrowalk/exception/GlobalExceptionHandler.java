package com.retrowalk.exception;

import com.retrowalk.models.ErrorResponse;
import com.retrowalk.utility.MessageUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private HttpServletRequest httpServletRequest;

    private MessageUtils messageUtils;

    @ExceptionHandler(value = {RetrowalkException.class})
    protected ResponseEntity<ErrorResponse<RetrowalkException>> handleConflict(final RetrowalkException exception) {
        ErrorResponse<RetrowalkException> errorResponse = new ErrorResponse<>();
        errorResponse.setStatusCode(exception.getCode());
        errorResponse.setMessage(messageUtils.getMessage(exception.getMessage(), null));
        errorResponse.setUrl(httpServletRequest.getRequestURI());
        errorResponse.setExceptionTrace(exception.toString());
        return errorResponse.getResponseEntity();
    }
}
