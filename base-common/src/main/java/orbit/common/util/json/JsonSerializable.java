package orbit.common.util.json;

public class JsonSerializable {

    protected String toJson() {
        return JsonUtil.toJson(this);
    }

    protected String toPrettyJson() {
        return JsonUtil.toPrettyJson(this);
    }
}
