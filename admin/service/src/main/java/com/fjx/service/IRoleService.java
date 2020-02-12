package com.fjx.service;

import com.fjx.domain.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> findAll();

    void save(Role role);

    Role findById(String id);

    Role findRoleByIdAndAllPermission(String id);

    void addPermissionsToRole(String roleId, String[] permissionIds);
}
