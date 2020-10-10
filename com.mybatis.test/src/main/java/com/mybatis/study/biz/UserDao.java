package com.mybatis.study.biz;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;


public interface UserDao {

    User findById(Long id);

    Page<User> find(Long id);

    @Select(value = "select * from user where name=#{name} limit 1")
    User findByName(String name);
}
