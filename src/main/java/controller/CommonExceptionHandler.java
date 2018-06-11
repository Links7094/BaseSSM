package controller;

import web.JsonResult;
import web.ResultCode;
import exception.ValidateException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class CommonExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public JsonResult handle(Exception e) {
        // todo log
        return new JsonResult(ResultCode.SERVICE_ERROR);
    }

    @ExceptionHandler(ValidateException.class)
    public JsonResult handleValidateException(ValidateException e) {
        // todo log
        return new JsonResult(ResultCode.VALIDATE_ERROR, e.getMessage());
    }

}
