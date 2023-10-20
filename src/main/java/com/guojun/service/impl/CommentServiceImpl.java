package com.guojun.service.impl;

import com.guojun.dao.CommentDao;
import com.guojun.domain.Comment;
import com.guojun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public boolean save(Comment comment) {
        comment.setCreatedTime(new Date());
        return commentDao.save(comment) > 0;
    }

    @Override
    public List<Comment> getAll(Integer blogId) {
        return commentDao.getAll(blogId);
    }

    @Override
    public List<Comment> getById(Integer id) {
        return commentDao.getById(id);
    }

    @Override
    public boolean Delcomment(Integer id) {
        return commentDao.Delcomment(id);
    }


}
