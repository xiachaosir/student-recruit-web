package com.student.recruit.controller;

import com.student.recruit.domain.ErrorInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * 全局异常处理类 .
 * Created by xiachao on 2017/3/7.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

  /*  @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest httpServletRequest, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex.getMessage());
        modelAndView.addObject("url", httpServletRequest.getRequestURL().toString());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;

    }*/
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> defaultExceptionHandler(HttpServletRequest req,MyException e){
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
