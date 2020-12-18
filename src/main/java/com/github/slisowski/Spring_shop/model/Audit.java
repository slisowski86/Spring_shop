package com.github.slisowski.Spring_shop.model;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;


@Embeddable
class Audit {

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist
    void prePersist(){
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate(){
        updatedDate = LocalDateTime.now();
    }
}
