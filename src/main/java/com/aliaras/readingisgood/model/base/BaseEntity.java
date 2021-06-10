package com.aliaras.readingisgood.model.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
public class BaseEntity {
    @CreatedBy
    @NotNull
    String creator;

    @LastModifiedBy
    String modifier;

    @CreatedDate
    @NotNull
    Instant createdAt;

    @LastModifiedDate
    Instant modifiedAt;
}
