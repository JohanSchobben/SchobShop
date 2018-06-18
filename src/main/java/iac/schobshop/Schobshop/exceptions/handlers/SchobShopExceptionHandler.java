package iac.schobshop.Schobshop.exceptions.handlers;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

public interface SchobShopExceptionHandler {
    ModelAndView handleException(Exception exception);
}
