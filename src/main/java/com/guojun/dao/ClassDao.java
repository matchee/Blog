package com.guojun.dao;


import com.guojun.domain.Class;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface ClassDao {

    @Select("select * from class")
    public List<Class> getAll();



}
