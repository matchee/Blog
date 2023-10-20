package com.guojun.controller;


import com.guojun.domain.Class;
import com.guojun.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;


    @GetMapping
    public Result getAll() {
        List<Class> classList = classService.getAll();
        Integer code = classList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = classList != null ? "" : "查询失败，请重新查询!";
        return new Result(code,classList,msg);
    }
}
