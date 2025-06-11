package orbit.common.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse extends BaseResponse {

    private final String message;
    private final int status;
    private final LocalDateTime timestamp;
    private final String path;

    public static ErrorResponse from(ResponseCode responseCode, String path, String message) {
        return ErrorResponse.builder()
                .message(message)
                .status(responseCode.getStatus())
                .timestamp(LocalDateTime.now())
                .path(path)
                .build();
    }
}
