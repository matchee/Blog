package com.guojun.controller;

import com.guojun.domain.Blog;
import com.guojun.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public Result save(@RequestBody Blog blog) {
        boolean flag = blogService.save(blog);
        Integer code = flag ? Code.SAVE_OK : Code.SAVE_ERR;
        return new Result(code,flag);
    }


    @PutMapping
    public Result update(@RequestBody Blog blog) {
        boolean flag = blogService.update(blog);
        Integer code = flag ? Code.UPDATE_OK : Code.UPDATE_ERR;
        return new Result(code,flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = blogService.delete(id);
        Integer code = flag ? Code.DELETE_OK : Code.DELETE_ERR;
        return new Result(code,flag);
    }


    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Blog blog = blogService.getById(id);
        Integer code = blog != null ? Code.GET_OK : Code.GET_ERR;
        String msg = blog != null ? "" : "查询失败，请重新查询!";
        return new Result(code,blog,msg);
    }



    @GetMapping
    public Result getAll2() {
        List<Blog> blogList = blogService.getAll2();
        Integer code = blogList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = blogList != null ? "" : "查询失败，请重新查询!";
        return new Result(code,blogList,msg);

    }


    // @GetMapping(value = "/title/{title}", produces = "application/json;charset=UTF-8")
    @GetMapping("/title")
    public Result getByTitle(
            // @PathVariable String title,
        @RequestParam(name = "title") String title
    ) throws UnsupportedEncodingException {

        String decodedTitle = URLDecoder.decode(title, "UTF-8");


        List<Blog> blog = blogService.getByTitle(decodedTitle);
        
        Integer code = blog != null ? Code.GET_OK : Code.GET_ERR;
        String msg = blog != null ? "" : "查询失败，请重新查询!";

        return new Result(code,blog,msg);
    }
}
