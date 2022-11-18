package com.project.seed.service;

import com.project.seed.exception.NotFoundException;
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
    public Optional<BaseEntity> getById(Integer codEntity) {
        return baseEntityRepository
                .findById(codEntity);
    }

    @Override
    public BaseEntity update(Integer codEntity, BaseEntity entity) {
        BaseEntity baseEntity = baseEntityRepository.findById(codEntity).
                orElseThrow(() -> new NotFoundException("The base entity cannot be found!"));

        baseEntity.setCodEntity(entity.getCodEntity());
        baseEntity.setName(entity.getName());
        return baseEntityRepository.save(baseEntity);

    }

    @Override
    public void deleteById(Integer codEntity) {
        BaseEntity baseEntity = baseEntityRepository.findById(codEntity).
                orElseThrow(() -> new NotFoundException("The base entity cannot be found!"));

        baseEntityRepository
                .deleteById(baseEntity.getCodEntity());
    }
}

