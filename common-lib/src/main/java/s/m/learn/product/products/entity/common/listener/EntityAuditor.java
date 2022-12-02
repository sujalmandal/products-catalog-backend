package s.m.learn.product.products.entity.common.listener;


import s.m.learn.product.products.entity.common.AbstractEntity;

import javax.persistence.*;

public class EntityAuditor {

    @PostPersist
    private void auditCreate(final AbstractEntity abstractEntity) {

    }

    @PostUpdate
    private void auditUpdate(final AbstractEntity abstractEntity) {

    }

}
