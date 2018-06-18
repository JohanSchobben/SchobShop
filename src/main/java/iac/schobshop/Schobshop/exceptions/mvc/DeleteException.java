package iac.schobshop.Schobshop.exceptions.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class DeleteException extends RuntimeException {

    public DeleteException(String message) {
        super(message);
    }
}
