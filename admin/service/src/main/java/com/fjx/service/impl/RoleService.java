package com.fjx.service.impl;

import com.fjx.dao.IRoleDao;
import com.fjx.domain.Role;
import com.fjx.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    IRoleDao dao;

    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Role role) {
        dao.save(role);
    }

    @Override
    public Role findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Role findRoleByIdAndAllPermission(String id) {
        return dao.findRoleByIdAndAllPermission(id);
    }

    @Override
    public void addPermissionsToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            dao.addPermissionToRole(roleId,permissionId);
        }
    }

}
