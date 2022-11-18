package com.project.seed.service;

import com.project.seed.model.BaseEntity;


import java.util.List;
import java.util.Optional;

public interface BaseEntityService {
    BaseEntity save(BaseEntity baseEntity);

    List<BaseEntity> list();

    Optional<BaseEntity> getById(Integer codEntity);

    BaseEntity update(Integer codEntity, BaseEntity entity);

    void deleteById(Integer codEntity);
}
