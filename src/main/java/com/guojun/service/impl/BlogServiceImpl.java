package com.guojun.service.impl;

import com.guojun.dao.BlogDao;
import com.guojun.dao.CommentDao;
import com.guojun.domain.Blog;
import com.guojun.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private CommentDao commentDao;

    @Override
    public boolean save(Blog blog) {
        blog.setCreatedTime(new Date());
        return blogDao.save(blog) > 0;
    }

    @Override
    public boolean update(Blog blog) {
        return blogDao.update(blog) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        commentDao.DelcommentAll(id);
        return blogDao.delete(id) > 0;
    }

    @Override
    public Blog getById(Integer id) {
        return blogDao.getById(id);
    }

    @Override
    public List<Blog> getAll() {
        return blogDao.getAll();
    }

    @Override
    public List<Blog> getAll2() {
        return blogDao.getAll2();
    }

    @Override
    public List<Blog> getByTitle(String title) {
        return  blogDao.getByTitle(title);

    }


}
