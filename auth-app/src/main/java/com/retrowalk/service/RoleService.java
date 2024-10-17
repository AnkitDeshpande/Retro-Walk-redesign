package com.retrowalk.service;

import com.retrowalk.entities.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);

    Role getRoleById(Long id);

    List<Role> getAllRoles();

    Role updateRole(Long id, Role role);

    void deleteRole(Long id);
}
