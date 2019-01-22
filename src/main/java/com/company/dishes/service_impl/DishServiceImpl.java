package com.company.dishes.service_impl;

import com.company.dishes.dto.DishDto;
import com.company.dishes.mapper.BaseMapper;
import com.company.dishes.model.DishEntity;
import com.company.dishes.model.RestaurantEntity;
import com.company.dishes.repository.BaseRepository;
import com.company.dishes.repository.DishRepository;
import com.company.dishes.repository.RestaurantRepository;
import com.company.dishes.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DishServiceImpl extends BaseServiceImpl<DishDto, DishEntity> implements DishService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public DishServiceImpl(BaseRepository<DishEntity> repository, BaseMapper<DishDto, DishEntity> mapper,
                           RestaurantRepository restaurantRepository) {
        super(repository, mapper);
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<DishDto> readByOrder(Long orderId) {
        List<DishEntity> dishEntities = this.getDishRepository().findByOrderId(orderId);
        log.info("Found entities: " + dishEntities);
        List<DishDto> dishDtos = this.getMapper().entitiesToDtos(dishEntities);
        log.info("Mapped entities to dtos: " + dishDtos);
        return dishDtos;
    }

    @Override
    public DishDto create(DishDto dto) {
        DishEntity entity = this.getMapper().dtoToEntity(dto);
        log.info("Mapped  dto to entity: " + entity);
        RestaurantEntity restaurantEntity = restaurantRepository.getOne(dto.getRestaurantId());
        if (restaurantEntity == null) {
            throw new IllegalStateException("Restaurant with id: " + dto.getRestaurantId() + "does not exist");
        }
        entity.setRestaurantEntity(restaurantEntity);
        entity = getRepository().save(entity);
        log.info("Saved object : " + entity);
        return getMapper().entityToDto(entity);
    }

    private DishRepository getDishRepository() {
        return (DishRepository) this.getRepository();
    }

}
