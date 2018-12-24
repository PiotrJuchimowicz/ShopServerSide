package com.company.dishes.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Table(name = "user_t")
@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class UserEntity extends BaseEntity {
    private String username;
    private String password;
    private String name;
    private String surname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity", orphanRemoval = true)
    private Set<OrderEntity> orderEntities = new LinkedHashSet<>();
}
