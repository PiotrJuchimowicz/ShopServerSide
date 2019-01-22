package com.company.dishes.repository;

import com.company.dishes.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {
    UserEntity findByUsername(String username);

    UserEntity findByUsernameAndPassword(String username, String password);
}
