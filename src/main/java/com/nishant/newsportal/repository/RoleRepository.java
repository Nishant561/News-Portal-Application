package com.nishant.newsportal.repository;

import com.nishant.newsportal.enums.RolesEnums;
import com.nishant.newsportal.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRoleName(RolesEnums roleName);

}
