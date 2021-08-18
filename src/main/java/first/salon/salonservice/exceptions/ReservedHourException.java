package first.salon.salonservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ReservedHourException extends RuntimeException{
    public ReservedHourException(String message) {
        super(message);
    }
}
