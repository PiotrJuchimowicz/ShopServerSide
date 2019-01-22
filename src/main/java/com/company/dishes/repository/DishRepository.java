package com.company.dishes.repository;

import com.company.dishes.model.DishEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends BaseRepository<DishEntity> {
    @Query("SELECT dishEntity " +
            "FROM DishOrderEntity dishOrderEntity JOIN DishEntity dishEntity " +
            "WHERE dishOrderEntity.id=:orderId")
    List<DishEntity> findByOrderId(@Param("orderId") Long orderId);
}
