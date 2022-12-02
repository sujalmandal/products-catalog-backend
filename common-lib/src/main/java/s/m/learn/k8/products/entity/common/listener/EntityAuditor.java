package s.m.learn.k8.products.entity.common.listener;


import s.m.learn.k8.products.entity.common.AbstractEntity;

import javax.persistence.*;

public class EntityAuditor {

    @PostPersist
    private void auditCreate(final AbstractEntity abstractEntity) {

    }

    @PostUpdate
    private void auditUpdate(final AbstractEntity abstractEntity) {

    }

}
