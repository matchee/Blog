package com.guojun.dao;

import com.guojun.domain.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CommentDao {

    @Insert("insert into comment values (null,#{context},#{createdTime},#{userId},#{blogId})")
    public int save(Comment comment);

//    @Select("select * from comment ")
    public List<Comment> getAll(Integer id);

    @Select("select * from comment where blogId = #{blogid}")
    public List<Comment>  getById(Integer id);

    @Delete("delete from comment where blogId = #{blogId} ;")
    public int DelcommentAll(Integer blogId);

    @Delete("delete from comment where id = #{id} ;")
    public boolean Delcomment(Integer blogId);

}
