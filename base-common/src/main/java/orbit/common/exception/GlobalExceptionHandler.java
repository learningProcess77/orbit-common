package orbit.common.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orbit.common.response.ErrorResponse;
import orbit.common.response.ResponseCode;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex, WebRequest request) {
        // request.getDescription(false)는 "uri=/your/api/path"와 같은 형태를 반환 --> "uri=" 접두사를 제거 필요
        String requestPath = request.getDescription(false).substring(4);
        String message = getMessage(ex.getResponseCode(), ex.getMessage(), ex.getMessageArgs());
        ErrorResponse errorResponse = ErrorResponse.from(ex.getResponseCode(), requestPath, message);

        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
    }

    private String getMessage(ResponseCode responseCode, String messageCode, Object [] messageArgs) {
        String message;
        try {
            message = messageSource.getMessage(messageCode, messageArgs, LocaleContextHolder.getLocale());
        } catch(Exception e1) {
            try {
                message = messageSource.getMessage(
                        responseCode.getMessageCode(), messageArgs, LocaleContextHolder.getLocale());
            } catch(Exception e2) {
                message = "Result in Failure.";
            }
        }
        log.debug("GlobalExceptionHandler, {}", message);
        return message;
    }
}
