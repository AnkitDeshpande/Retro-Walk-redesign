package com.retrowalk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditOverrides;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Audited
@AuditOverrides(@AuditOverride(forClass = CommonBaseModel.class))
public class AuditCommonBaseModel extends CommonBaseModel {

    /**
     * Model created at timestamp.
     */
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private final Date createdDate = new Date();

    /**
     * Model updated at timestamp.
     */
    @Column(name = "last_modified_date")
    @LastModifiedDate
    private Date lastModifiedDate;

    /**
     * Who created the object.
     */
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    /**
     * who modified the object.
     */
    @Column(name = "last_modified_by")
    @LastModifiedBy
    private String lastModifiedBy;
}