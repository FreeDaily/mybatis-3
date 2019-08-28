package com.mybatis.study;

import com.mybatis.study.biz.User;
import com.mybatis.study.biz.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            User user = mapper.findById(1L);
            log.info("{}", user);
        }
    }
}
