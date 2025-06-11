package orbit.common.exception;

import lombok.Getter;
import orbit.common.response.ResponseCode;

@Getter
public abstract class ServiceException extends RuntimeException {

    private Object[] messageArgs;
    private ResponseCode responseCode;

    public ServiceException(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public ServiceException(Object[] messageArgs) {
        this.messageArgs = messageArgs;
    }

    public ServiceException(Object[] messageArgs, ResponseCode responseCode) {
        this.messageArgs = messageArgs;
        this.responseCode = responseCode;
    }

    public ServiceException(String message, ResponseCode responseCode) {
        super(message);
        this.responseCode = responseCode;
    }

    public ServiceException(String message, Object[] messageArgs) {
        super(message);
        this.messageArgs = messageArgs;
    }

    public ServiceException(String message, Object[] messageArgs, ResponseCode responseCode) {
        super(message);
        this.messageArgs = messageArgs;
        this.responseCode = responseCode;
    }

    public ServiceException(String message, Throwable cause, ResponseCode responseCode) {
        super(message, cause);
        this.responseCode = responseCode;
    }

    public ServiceException(String message, Throwable cause, Object[] messageArgs) {
        super(message, cause);
        this.messageArgs = messageArgs;
    }

    public ServiceException(String message, Throwable cause, Object[] messageArgs, ResponseCode responseCode) {
        super(message, cause);
        this.messageArgs = messageArgs;
        this.responseCode = responseCode;
    }

    public ServiceException(Throwable cause, ResponseCode responseCode) {
        super(cause);
        this.responseCode = responseCode;
    }

    public ServiceException(Throwable cause, Object[] messageArgs) {
        super(cause);
        this.messageArgs = messageArgs;
    }

    public ServiceException(Throwable cause, Object[] messageArgs, ResponseCode responseCode) {
        super(cause);
        this.messageArgs = messageArgs;
        this.responseCode = responseCode;
    }
}
