package com.onlineBankingSystem1.Dao;


import org.springframework.data.repository.CrudRepository;

import com.onlineBankingSystem1.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
