package s.m.learn.product.lib.entity.listener;


import s.m.learn.product.lib.entity.common.AbstractEntity;

import javax.persistence.*;

public class EntityAuditor {

    @PostPersist
    private void auditCreate(final AbstractEntity abstractEntity) {

    }

    @PostUpdate
    private void auditUpdate(final AbstractEntity abstractEntity) {

    }

}
