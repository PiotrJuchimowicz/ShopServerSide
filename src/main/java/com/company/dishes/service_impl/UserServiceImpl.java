package com.company.dishes.service_impl;

import com.company.dishes.dto.UserDto;
import com.company.dishes.mapper.BaseMapper;
import com.company.dishes.mapper.UserMapper;
import com.company.dishes.model.UserEntity;
import com.company.dishes.repository.BaseRepository;
import com.company.dishes.repository.UserRepository;
import com.company.dishes.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<UserDto, UserEntity, Long> implements UserService {

    @Autowired
    public UserServiceImpl(BaseRepository<UserEntity> repository, BaseMapper<UserDto, UserEntity> mapper) {
        super(repository, mapper);
    }

    @Override
    public UserDto create(UserDto dto) {
        UserEntity userEntity = this.getMapper().dtoToEntity(dto);
        log.info("Mapped user entity to dto: " + dto);
        userEntity = getUserRepository().save(userEntity);
        log.info("Saved user entity: " + userEntity);
        return getMapper().entityToDto(userEntity);
    }

    @Override
    public UserDto update(UserDto dto) {
        UserEntity userEntity = findUserEntity(dto.getId());
        log.info("Found entity: " + userEntity);
        this.getUserMapper().updateUserWithoutOrders(dto, userEntity);
        this.getRepository().save(userEntity);
        log.info("Updated entity: " + userEntity);
        UserDto userDto = this.getMapper().entityToDto(userEntity);
        log.info("Mapped entity to dto: " + userDto);
        return userDto;
    }

    @Override
    public void delete(Long userId) {
        UserEntity userEntity = findUserEntity(userId);
        log.info("Found entity: " + userEntity);
        this.getRepository().delete(userEntity);
        log.info("Removed entity");
    }

    private UserEntity findUserEntity(Long id) {
        return this.getUserRepository()
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Object with id: " + id + " not found!"));
    }

    private UserRepository getUserRepository() {
        return (UserRepository) this.getRepository();
    }

    private UserMapper getUserMapper() {
        return (UserMapper) this.getMapper();
    }
}
