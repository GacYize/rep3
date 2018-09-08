package com.ali.dao;

import com.ali.domain.Dept;
import com.ali.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
//    @Select("select * from user")
    List<User> findAll();
    List<User> findAll(Dept dept);
    User findById(int id);

}
