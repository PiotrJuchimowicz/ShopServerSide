package com.company.dishes.service_impl;

import com.company.dishes.dto.RestaurantDto;
import com.company.dishes.mapper.BaseMapper;
import com.company.dishes.model.RestaurantEntity;
import com.company.dishes.repository.BaseRepository;
import com.company.dishes.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl extends BaseServiceImpl<RestaurantDto, RestaurantEntity> implements RestaurantService {
    @Autowired
    public RestaurantServiceImpl(BaseRepository<RestaurantEntity> repository, BaseMapper<RestaurantDto, RestaurantEntity> mapper) {
        super(repository, mapper);
    }
}
