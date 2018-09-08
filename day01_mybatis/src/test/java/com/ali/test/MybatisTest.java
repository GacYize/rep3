package com.ali.test;

import com.ali.dao.UserDao;
import com.ali.domain.Dept;
import com.ali.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test1() throws IOException {
        //读取配置文件
        InputStream is= Resources.getResourceAsStream("SqlConfig.xml");
        //创建SqlSessionFactoryBuilder的构建者对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //创建工厂对象
        SqlSessionFactory factory = builder.build(is);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //创建dao的接口代理对象
        UserDao userDao = session.getMapper(UserDao.class);
//        List<User> users = userDao.findAll(new Dept());
        User user = userDao.findById(43);

        System.out.println(user);
        /*for (User user : users) {
            System.out.println(user);
        }*/
        //释放资源
        session.close();
        is.close();
    }
}
