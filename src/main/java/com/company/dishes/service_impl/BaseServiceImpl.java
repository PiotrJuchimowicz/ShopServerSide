package com.company.dishes.service_impl;

import com.company.dishes.dto.BaseDto;
import com.company.dishes.mapper.BaseMapper;
import com.company.dishes.model.BaseEntity;
import com.company.dishes.repository.BaseRepository;
import com.company.dishes.service.BaseService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Transactional
@Slf4j
@RequiredArgsConstructor
@Getter(AccessLevel.PROTECTED)
public abstract class BaseServiceImpl<D extends BaseDto, E extends BaseEntity> implements BaseService<D> {
    private final BaseRepository<E> repository;
    private final BaseMapper<D, E> mapper;

    @Override
    public D read(Long id) {
        log.info("Getting object with id:  " + id);
        Optional<E> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            E entity = entityOptional.get();
            log.info("Got entity: " + entity);
            D dto = mapper.entityToDto(entity);
            log.info("Mapped entity to dto: " + dto);
            return dto;
        } else {
            throw new EntityNotFoundException("Unable to find object with id: " + id);
        }
    }

    @Override
    public List<D> readAll() {
        log.info("Getting all objects");
        List<E> entities = repository.findAll();
        log.info("Found: " + entities);
        List<D> dtos = mapper.entitiesToDtos(entities);
        log.info("Mapped to dtos: " + dtos);
        return dtos;
    }

    @Override
    public D create(D dto) {
        E entity = this.getMapper().dtoToEntity(dto);
        log.info("Mapped  dto to entity: " + entity);
        entity = repository.save(entity);
        log.info("Saved object : " + entity);
        return mapper.entityToDto(entity);
    }
}
