package com.project.seed.service;

import com.project.seed.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseEntityService {
    public BaseEntity save(BaseEntity baseEntity);

    public List<BaseEntity> list();

    public Optional<BaseEntity> getById(Integer id);

    public BaseEntity update(BaseEntity baseEntity);

    public void deleteById(Integer id);
}
