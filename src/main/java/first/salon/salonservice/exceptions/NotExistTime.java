package first.salon.salonservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NotExistTime extends Exception {
    public NotExistTime(String message) {
        super(message);
    }
}
