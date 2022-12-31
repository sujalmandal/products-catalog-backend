package s.m.learn.product.entity.common;

import s.m.learn.product.entity.listener.EntityAuditor;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(EntityAuditor.class)
public abstract class AbstractEntity {

    @Id @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="created_date")
    private Long createdDate;

    @Column(name="modified_by")
    private String modifiedBy;

    @Column(name="modified_date")
    private Long modifiedDate;

    @Column(name="is_active")
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
