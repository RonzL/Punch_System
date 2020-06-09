package com.ronz.dao;

import com.ronz.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    /**
     * 1. 查询指定教师的角色  （教师和角色是多对多的关系）
     * */
    @Select("select * from role where roleId in (select rid from teacher_role where tid = #{jobNo})")
    List<Role> findRoles(Integer jobNo);
}
