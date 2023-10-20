package com.guojun.service.impl;

import com.guojun.domain.Class;
import com.guojun.dao.ClassDao;
import com.guojun.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;


    @Override
    public List<Class> getAll() {
        return classDao.getAll();
    }


}
