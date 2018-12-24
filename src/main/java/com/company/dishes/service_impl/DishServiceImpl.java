package com.company.dishes.service_impl;

import com.company.dishes.dto.DishDto;
import com.company.dishes.mapper.BaseMapper;
import com.company.dishes.mapper.DishMapper;
import com.company.dishes.model.DishEntity;
import com.company.dishes.repository.BaseRepository;
import com.company.dishes.repository.DishRepository;
import com.company.dishes.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DishServiceImpl extends BaseServiceImpl<DishDto, DishEntity, Long> implements DishService {

    @Autowired
    public DishServiceImpl(BaseRepository<DishEntity> repository, BaseMapper<DishDto, DishEntity> mapper) {
        super(repository, mapper);
    }

    @Override
    public List<DishDto> readByOrder(Long orderId) {
        List<DishEntity> dishEntities = this.getDishRepository().findByOrderId(orderId);
        log.info("Found entities: " + dishEntities);
        List<DishDto> dishDtos = this.getMapper().entitiesToDtos(dishEntities);
        log.info("Mapped entities to dtos: " + dishDtos);
        return dishDtos;
    }

    private DishRepository getDishRepository() {
        return (DishRepository) this.getRepository();
    }

}
