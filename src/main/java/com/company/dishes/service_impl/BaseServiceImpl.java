package com.company.dishes.service_impl;

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
import java.util.Optional;


@Transactional
@Slf4j
@RequiredArgsConstructor
@Getter(AccessLevel.PROTECTED)
public abstract class BaseServiceImpl<D, E extends BaseEntity, T> implements BaseService<D, T> {
    private final BaseRepository<E> repository;
    private final BaseMapper<D, E> mapper;

    @Override
    public D read(T id) {
        log.info("Getting object with id:  " + id);
        Optional<E> entityOptional = repository.findById((Long) id);
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
}
