package com.company.dishes.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Table(name = "order_t")
@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class OrderEntity extends BaseEntity {
    private LocalDateTime orderDate;
    //TODO :  auto filled - converted from longitude and latitude from Android client
    private String country;
    private String city;
    private String postalCode;
    private String address;

    public OrderEntity() {
        orderDate = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "orderEntity", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<DishOrderEntity> dishOrderEntities = new LinkedHashSet<>();
}
