package orbit.common.exception;

import lombok.Getter;
import orbit.common.response.ResponseCode;

@Getter
public class BusinessException extends ServiceException {

    public BusinessException(ResponseCode responseCode) {
        super(responseCode);
    }

    public BusinessException(String message, ResponseCode responseCode) {
        super(message, responseCode);
    }
}
