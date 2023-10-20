package com.guojun.service;


import com.guojun.domain.Class;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ClassService {

    public List<Class> getAll();


}
