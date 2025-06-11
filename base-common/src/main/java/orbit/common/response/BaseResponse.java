package orbit.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import orbit.common.util.json.JsonSerializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse extends JsonSerializable {

    private String resultMessage;
    private ResponseCode responseCode;
}
