package s.m.learn.product.entity.listener;


import s.m.learn.product.entity.common.AbstractEntity;

import javax.persistence.*;

public class EntityAuditor {

    @PostPersist
    private void auditCreate(final AbstractEntity abstractEntity) {

    }

    @PostUpdate
    private void auditUpdate(final AbstractEntity abstractEntity) {

    }

}
