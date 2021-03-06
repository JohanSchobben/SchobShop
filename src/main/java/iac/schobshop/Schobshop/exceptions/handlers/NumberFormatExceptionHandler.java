package iac.schobshop.Schobshop.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class NumberFormatExceptionHandler implements SchobShopExceptionHandler{

    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NumberFormatException.class)
    public ModelAndView handleException(Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/400");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
