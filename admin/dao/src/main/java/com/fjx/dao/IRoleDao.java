package com.fjx.dao;

import com.fjx.domain.Permission;
import com.fjx.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IRoleDao {

   /* private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<User> users;*/

    @Select("select * from role where id in(select roleId from user_role where userId=#{id})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "com.fjx.dao.IPermissionDao.findPermissionsByRoleId"))
    })
    public List<Role> findRolesByUserId(String id);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(id,roleName,roleDesc) values (#{id},#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.fjx.dao.IPermissionDao.findPermissionsByRoleId"))
    })
    Role findById(String id);

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "roleName",column="roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.fjx.dao.IPermissionDao.findPermissions"))
    })
    Role findRoleByIdAndAllPermission(String id);

    @Insert("insert into role_permission values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
