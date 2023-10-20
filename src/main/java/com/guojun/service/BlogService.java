package com.guojun.service;

import com.guojun.domain.Blog;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BlogService {

    /**
     * 保存

     */
    public boolean save(Blog blog);

    /**
     * 修改
     */
    public boolean update(Blog blog);

    /**
     * 根据id删除
     */
    public boolean delete(Integer id);

    /**
     * 根据id查询

     */
    public Blog getById(Integer id);

    /**
     * 查询所有

     */
    public List<Blog> getAll();
    /**
     * 查询所有

     */
    public List<Blog> getAll2();

    /**
     * 根据title查询

     */
    public List<Blog> getByTitle(String title);
}
