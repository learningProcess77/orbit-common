package orbit.common.response;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESSFUL(200, "response.success"),
    INVALID_INPUT_VALUE(400, "response.exception.invalid.input"),
    UNAUTHORIZED(401, "response.unauthorized"),
    HTTP_METHOD_NOT_SUPPORTED(405, "response.unauthorized"),
    ENTITY_NOT_FOUND(500, "response.http.not.supported"),
    ALREADY_EXISTS(500, "response.already.exists"),
    BUSINESS_FlOW_ERROR(500, "response.invalid.business.flow"),
    UNKNOWN_EXCEPTION(500, "response.unknown");

    private int status;
    private final String messageCode;

    ResponseCode(int status, String messageCode) {
        this.status = status;
        this.messageCode = messageCode;
    }
}
