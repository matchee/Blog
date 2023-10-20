package com.guojun.service;

import com.guojun.dao.BlogDao;
import com.guojun.domain.Blog;
import com.guojun.service.impl.BlogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class blogServie {

    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private BlogDao blogDao;

    @Test
    public void testGetById(){

        List<Blog> all2 = blogService.getAll2();
        System.out.println(all2);

    }



}
