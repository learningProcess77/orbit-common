package orbit.common.response;

import lombok.Getter;

@Getter
public class CommonResponse<T> extends BaseResponse {

    private T result;

    public CommonResponse(String resultMessage, ResponseCode responseCode, T result) {
        super(resultMessage, responseCode);
        this.result = result;
    }

    public CommonResponse(ResponseCode responseCode, T result) {
        super(responseCode.getMessageCode(), responseCode);
        this.result = result;
    }

    public static <T> CommonResponse success(T result) {
        return new CommonResponse<>(ResponseCode.SUCCESSFUL, result);
    }
}
