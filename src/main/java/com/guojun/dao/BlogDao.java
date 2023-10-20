package com.guojun.dao;

import com.guojun.domain.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogDao {
    @Insert("insert into blog values (null,#{title},#{context},#{createdTime},#{classId},#{userId})")
    public int save(Blog blog);

    @Update("update blog set title = #{title}, context = #{context}, classId = #{classId} where id = #{id}")
    public int update(Blog blog);

    @Delete("delete from blog where id = #{id}")
    public int delete(Integer id);

    @Select("select * from blog where id = #{id}")
    public Blog getById(Integer id);



    @Select("select * from blog ")
    public List<Blog> getAll();


    public List<Blog> getAll2();

    public List<Blog> getByTitle(String title);
}
