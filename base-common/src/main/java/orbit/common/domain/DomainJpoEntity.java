package orbit.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import orbit.common.util.json.JsonSerializable;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@NoArgsConstructor
@MappedSuperclass // 이 클래스 자체는 테이블로 매핑되지 않고, 이를 상속받는 하위 엔티티들이 공통 필드를 상속
@EntityListeners(AuditingEntityListener.class)
public class DomainJpoEntity extends JsonSerializable {

    @Column(unique = true)
    protected String entityId;
    @Version
    protected long entityVersion;
    @CreatedBy
    @Column(nullable = false, updatable = false)
    protected long createUser;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createDate;
    @LastModifiedBy
    protected long updateUser;
    @LastModifiedDate
    protected LocalDateTime updateDate;

    protected DomainJpoEntity(String entityId) {
        this.entityId = entityId;
        this.entityVersion = 0L;
    }

    protected DomainJpoEntity(DomainEntity domainEntity) {
        this.entityId = domainEntity.getEntityId();
        this.entityVersion = domainEntity.getEntityVersion();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainJpoEntity that = (DomainJpoEntity) o;
        return entityId.equals(that.entityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entityId);
    }

    public String toString() {
        return toJson();
    }
}
