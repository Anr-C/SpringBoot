package com.lckiss.mapper;

import com.lckiss.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "baseCache")
@Mapper
public interface UserMapper {

    @Cacheable
    @Select("select * from user where id=#{id}")
    User selectUserById(@Param("id") Integer id);
}
