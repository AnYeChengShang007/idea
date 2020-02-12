package com.fjx.dao;

import com.fjx.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionsByRoleId(String id);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissions(String id);
}
