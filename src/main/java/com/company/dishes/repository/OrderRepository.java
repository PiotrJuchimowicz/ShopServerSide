package com.company.dishes.repository;

import com.company.dishes.model.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository<OrderEntity> {
    @Query("SELECT orderEntity " +
            "FROM OrderEntity orderEntity " +
            "WHERE orderEntity.userEntity.id=:userId")
    List<OrderEntity> findByUserId(@Param("userId") Long userId);
}
