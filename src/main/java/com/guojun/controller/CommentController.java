package com.guojun.controller;

import com.guojun.domain.Comment;
import com.guojun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping
    public Result save(@RequestBody Comment comment) {
        boolean flag = commentService.save(comment);
        Integer code = flag ? Code.SAVE_OK : Code.SAVE_ERR;
        return new Result(code,flag);
    }

    @GetMapping("/{blogId}")
    public Result getAll(@PathVariable Integer blogId) {
        List<Comment> commentList = commentService.getAll(blogId);
//        System.out.println(commentList);
        Integer code = commentList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = commentList != null ? "" : "查询失败，请重新查询!";
        return new Result(code,commentList,msg);
    }

//    @GetMapping("/{id}")
//    public Result getById(@PathVariable Integer id) {
//        System.out.println(id);
//        List<Comment> commentList = commentService.getById(id);
//        Integer code = commentList != null ? Code.GET_OK : Code.GET_ERR;
//        String msg = commentList != null ? "" : "查询失败，请重新查询!";
//        return new Result(code,commentList,msg);
//    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = commentService.Delcomment(id);
        Integer code = flag ? Code.DELETE_OK : Code.DELETE_ERR;
        return new Result(code,flag);
    }


}
