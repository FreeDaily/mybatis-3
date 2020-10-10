package com.mybatis.study;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mybatis.study.biz.Sex;
import com.mybatis.study.biz.User;
import com.mybatis.study.biz.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

@Slf4j
public class MainTest {

    public static void main(String[] args) throws Exception {

        log.info("start .....");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {

            UserDao mapper = session.getMapper(UserDao.class);
            PageHelper.startPage(1, 10);
            Page<User> users = mapper.find(1L);
            log.info("{}", JSON.toJSONString(users));

            User user = mapper.findById(1L);
            log.info("{}", user);

            Object selectOne = session.selectOne("com.mybatis.study.biz.UserDao.findByName", "LI");
            log.info("selectOne:{}", selectOne);
        }
    }
}
