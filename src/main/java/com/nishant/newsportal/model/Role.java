package com.nishant.newsportal.model;


import com.nishant.newsportal.baseModel.BaseEntity;
import com.nishant.newsportal.enums.RolesEnums;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "roles")
@Entity
public class Role extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @NotBlank(message = "Role-Name cannot be empty!")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true )
    private RolesEnums roleName;


    @ManyToMany(mappedBy = "userRoles")
    private Set<User> users = new HashSet<>();
}
