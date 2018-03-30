package com.lckiss.mapper.slave;

import com.lckiss.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SlaveAlphaMapper {
    @Insert("insert into user(name) values(#{name})")
    void insertUser(@Param("name") String name);

    @Select("select * from user where id=#{id}")
    User selectUserById(@Param("id") Integer id);
}
