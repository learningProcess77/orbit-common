package orbit.common.domain;

import lombok.Getter;
import orbit.common.util.json.JsonSerializable;

import java.io.Serializable;
import java.util.UUID;

@Getter
public class DomainEntity extends JsonSerializable implements Serializable {

    private static final long serialVersionUID = 756389810720937871L;

    private String entityId;
    private long entityVersion;

    protected DomainEntity() {
        this.entityId = UUID.randomUUID().toString();
    }

    protected DomainEntity(String entityId) {
        this.entityId = entityId;
    }

    protected DomainEntity(DomainEntity entity) {
        this.entityId = entity.getEntityId();
        this.entityVersion = entity.getEntityVersion();
    }

    public String toString() {
        return toJson();
    }

    public String toPrettyString() {
        return toPrettyJson();
    }
}
