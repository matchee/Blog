package com.guojun.service;

import com.guojun.domain.Comment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CommentService {

    public boolean save(Comment comment);

    public List<Comment> getAll(Integer blogid);

    public  List<Comment> getById(Integer id);

    public boolean Delcomment(Integer id);
}
