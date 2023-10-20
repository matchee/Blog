package com.guojun.dao;

import com.guojun.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserDao {
    /**
     * 根据用户名和密码查询用户对象
     */
    @Select("select * from Users where email = #{email} and password = #{password}")
    public User selectByUser(User user);

    /**
     * 根据用户名查询用户对象

     */
    @Select("select * from Users where userName = #{userName}")
    public User selectByUserName(String userName);

    /**
     * 添加用户
     */
    @Insert("insert into Users values(null, #{userName},#{password},#{email},#{power})")
    public int add(User user);
}
