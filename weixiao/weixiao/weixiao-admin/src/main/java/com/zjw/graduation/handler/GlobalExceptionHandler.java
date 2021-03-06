package com.zjw.graduation.handler;

import com.zjw.graduation.mvc.JsonResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    public JsonResult entityNotFoundException(HttpServletRequest request, Exception e){
        EntityNotFoundException entityNotFoundException = (EntityNotFoundException) e;
        String message = entityNotFoundException.getMessage();
        return JsonResult.error(message);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public JsonResult constraintViolation(HttpServletRequest request, Exception e){
        ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
        String message = constraintViolationException.getMessage();
        return JsonResult.error(message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public JsonResult methodArgumentNotValidException(HttpServletRequest request, Exception e){
        MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
        String message = methodArgumentNotValidException.getMessage();
        return JsonResult.error(message);
    }
}
