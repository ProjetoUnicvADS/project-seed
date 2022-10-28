package com.project.seed.service;

import com.project.seed.model.BaseEntity;
import com.project.seed.repository.BaseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseEntityServiceImpl implements BaseEntityService {
    @Autowired
    private BaseEntityRepository baseEntityRepository;

    @Override
    public BaseEntity save(BaseEntity baseEntity) {
        return baseEntityRepository
                .save(baseEntity);
    }

    @Override
    public List<BaseEntity> list() {
        return baseEntityRepository
                .findAll();
    }

    @Override
    public Optional<BaseEntity> getById(Integer id) {
        return baseEntityRepository
                .findById(id);
    }

    @Override
    public BaseEntity update(BaseEntity baseEntity) {
        return baseEntityRepository
                .save(baseEntity);
    }

    @Override
    public void deleteById(Integer id) {
        baseEntityRepository
                .deleteById(id);
    }

}

