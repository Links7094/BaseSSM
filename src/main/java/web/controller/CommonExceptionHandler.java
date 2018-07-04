package web.controller;

import exception.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import web.JsonResult;
import web.JsonResult.ResultCode;

@ControllerAdvice
@ResponseBody
public class CommonExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public JsonResult handle(Exception e) {
        logger.error("系统异常", e);
        return new JsonResult(ResultCode.SERVICE_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        logger.error("校验异常");
        logger.error("request params --> {}", e.getBindingResult().getTarget().toString());
        return new JsonResult(ResultCode.VALIDATE_ERROR, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(ValidateException.class)
    public JsonResult handleValidateException(ValidateException e) {
        logger.error("ValidateException");
        logger.error("params --> {}", e.getParams().toString());
        logger.error("error message --> {}", e.getMessage());
        return new JsonResult(ResultCode.VALIDATE_ERROR, e.getMessage());
    }

}
