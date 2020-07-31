package com.ronz.dao;

import com.ronz.domain.Student;
import com.ronz.domain.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-07 11:03
 **/
@Repository
public interface TeacherDao {

    /**
     * 1. 查询所有教师
     * */
    @Select("select * from teacher limit #{currentPage}, #{size}")
    @Results(id = "findTeacher", value = {
            @Result(id = true, column = "jobNo", property = "no"),
            @Result(column = "password", property = "password"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "email", property = "email"),
            @Result(column = "status", property = "status"),
            @Result(column = "jobNo", property = "days", one = @One(select = "com.ronz.dao.PunchDao.findCount")),
            @Result(column = "jobNo", property = "roles", many = @Many(select = "com.ronz.dao.RoleDao.findRoles")),
            @Result(column = "jobNo", property = "punches", many = @Many(select = "com.ronz.dao.PunchDao.findInfo"))
    })
    List<Teacher> findAll(@Param("currentPage") int currentPage,@Param("size") int size);

    /**
     * 2. 分页查询未打卡教师
     * */
    @Select("select * from teacher where status = 'N' limit #{currentPage}, #{size}")
    @ResultMap("findTeacher")
    List<Teacher> findNoPunchByPage(@Param("currentPage") int currentPage, @Param("size") int size);

    /**
     * 查询所有未打卡教师
     * @return
     */
    @Select("select * from teacher where status = 'N'")
    List<Teacher> findAllNoPunch();

    /**
     * 3. 根据工号查询教师
     * */
    @Select("select * from teacher where jobNo = #{jobNo}")
    @ResultMap(value = "findTeacher")
    Teacher findOne(Integer jobNo);

    /**
     * 4. 删除指定工号教师的所有角色
     * */
    @Delete("delete from teacher_role where tid = #{jobNo}")
    void deleteRoles(int jobNo);

    /**
     * 5. 给指定工号的教师添加角色
     *      注意：需要传递多个参数的时候，一定要指定参数对应的数据库中的列名
     * */
    @Insert("insert into teacher_role values (#{tid}, #{rid})")
    int addRoles(@Param("tid") int tid, @Param("rid") int rid);

    /**
     * 更新教师打卡信息
     * @param jobNo 工号
     * @param status 打卡状态
     */
    @Update("update teacher set status = #{status} where jobNo = #{jobNo}")
    void updateStatus(@Param("jobNo") Integer jobNo, @Param("status") String status);

    /**
     * 查询教师个数
     * @return
     */
    @Select("select count(*) from teacher")
    Integer findCount();

    /**
     * 查询未打卡教师个数
     * @return
     */
    @Select("select count(*) from teacher where status = 'N'")
    Integer findNoPunchCount();

    /**
     * 重置所有教师的打卡状态为 'N'
     */
    @Update("update teacher set status = 'N'")
    void updateAllStatus();

    /**
     * 更新主页个人信息
     * @param no
     * @param email
     */
    @Update("update teacher set email = #{email} where jobNo = #{no}")
    void updateInfo(@Param("no") int no, @Param("email") String email);

    /**
     * 8. 保存教师的个人信息
     * */
    @Update("update teacher set jobNo=#{no}, name=#{name},sex=#{sex},email=#{email} where jobNo = #{no}")
    Integer saveInfo(Teacher teacher);

}
