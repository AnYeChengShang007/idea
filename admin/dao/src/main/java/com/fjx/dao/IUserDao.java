package com.fjx.dao;

import com.fjx.domain.Role;
import com.fjx.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    @Select("select * from users")
    @Results({
            @Result(id=true,property="id",column = "id"),
            @Result(property="username",column = "username"),
            @Result(property="email",column="email"),
            @Result(property="password",column="password"),
            @Result(property="phoneNum",column="phoneNum"),
            @Result(property="status",column="status")
    })
    List<UserInfo> findAll();

    @Insert("insert into users (id,username,password,email,phoneNum,status) " +
            "values (#{id},#{username},#{password},#{email},#{phoneNum},#{status})")
    void save(UserInfo userInfo);


    /*private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;*/
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",javaType = java.util.List.class,column = "id",
                    many = @Many(select = "com.fjx.dao.IRoleDao.findRolesByUserId"))
    })
    UserInfo findById(String id);

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",javaType = java.util.List.class,column = "id",
                    many = @Many(select = "com.fjx.dao.IRoleDao.findRolesByUserId"))
    })
    UserInfo findByUsername(String username);

    @Select("select * from role where id not in(select roleId from user_role where userId = #{id})")
    List<Role> findAllRoleByUserId(String id);

    @Insert("insert into user_role(roleId,userId) values(#{id},#{userId})")
    void addRoleToUser(@Param("userId") String userId, @Param("id") String id);
}
