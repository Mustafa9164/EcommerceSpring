package com.tcs.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreatedDate
    @Column(nullable = false,updatable = false)
    private Instant createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private Instant updateddAt;

    @PrePersist   //automatically called before the entity is saved for the first time
    public void onCreated() {
        Instant now=Instant.now();
        this.createdAt =now;
        this.updateddAt = now;
    }

    @PreUpdate
    public void onUpdate(){
        this.updateddAt=Instant.now();
    }
}
