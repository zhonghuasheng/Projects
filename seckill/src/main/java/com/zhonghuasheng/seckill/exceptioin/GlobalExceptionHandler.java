package com.zhonghuasheng.seckill.exceptioin;

import com.zhonghuasheng.seckill.common.CodeMsg;
import com.zhonghuasheng.seckill.common.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        ex.printStackTrace();
        if (ex instanceof GlobalException) {
            GlobalException globalException = (GlobalException) ex;

            return Result.error(globalException.getCm());
        } else if(ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            List<ObjectError> errors = bindException.getAllErrors();
            ObjectError error = errors.get(0);
            String defaultMessage = error.getDefaultMessage();

            return Result.error(CodeMsg.BIND_ERROR.fillArgs(defaultMessage));
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
