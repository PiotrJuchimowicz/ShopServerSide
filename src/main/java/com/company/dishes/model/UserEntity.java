package com.company.dishes.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Table(name = "user_t")
@Entity
@Getter
@Setter
@ToString(callSuper = true, exclude = "orderEntities")
public class UserEntity extends BaseEntity {
    @Column(unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private String name;
    private String surname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity", orphanRemoval = true)
    private Set<OrderEntity> orderEntities = new LinkedHashSet<>();
}
