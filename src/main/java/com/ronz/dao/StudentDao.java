package com.ronz.dao;

import com.ronz.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-03 20:42
 **/

@Repository
public interface StudentDao {

    /**
     * 1. 根据学号查询个人信息
     * */
    @Select("select * from student where no = #{no}")
    @Results(id="findOne", value = {
            @Result(id = true, property ="id" , column = "id"),
            @Result(property = "no", column = "no"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "email", column = "email"),
            @Result(property = "classNo", column = "classNo"),
            @Result(property = "status", column = "status"),
            @Result(property = "days", column = "no", one = @One(select = "com.ronz.dao.PunchDao.findCount")),
            @Result(column = "no", property = "punches", many = @Many(select = "com.ronz.dao.PunchDao.findInfo"))
    })
    Student findByStudentNo(int no);

    /**
     * 2. 查询出所有学生的信息
     * */
    @Select("select * from student limit #{currentPage}, #{size}")
    @ResultMap(value = "findOne")
    List<Student> findAll(@Param("currentPage") int currentPage, @Param("size") int size);

    /**
     * 3. 增加学生
     * */
    @Insert("insert into student(id,no,password,name,sex,email,classNo,status,days) " +
            "values (#{id},#{no},#{password},#{name},#{sex},#{email},#{classNo},#{status},#{days})")
    void addStudent(Student student);

    /**
     * 4. 查询今日未打卡学生
     * */
    @Select("select * from student where status = 'N' limit #{currentPage}, #{pageSize}")
    @ResultMap(value="findOne")
    List<Student> findNoPunch(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    @Select("select * from student where status = 'N'")
    List<Student> findAllNoPunch();

    /**
     * 5. 查找指定班级的所有学生
     * */
    @Select("select * from student where classNo = #{classNo}")
    List<Student> findAllStu(Integer classNo);

    /**
     * 6. 查找指定班级学生数
     * */
    @Select("select count(*) from student where classNo = #{classNo}")
    Integer findAllStuNums(Integer classNo);


    /**
     * 7. 查询指定班级的所有未打卡学生
     * */
    @Select("select * from student where classNo = #{classNo} and status = 'N'")
    List<Student> findNoPunchInClass(int classNo);

    /**
     * 8. 保存学生的个人信息
     * */
    @Update("update student set no=#{no}, name=#{name},sex=#{sex},email=#{email},classNo=#{classNo} where no = #{no}")
    Integer saveInfo(Student student);

    /**
     * 9. 修改密码
     * */
    @Update("update student set password=#{password} where no=#{no}")
    Integer modifyPwd(@Param("password") String password, @Param("no") Integer no);

    /**
     * 10. 更新学生打卡状态信息
     * */
    @Update("update student set status = #{status} where no = #{no}")
    void updateStatus(@Param("no") Integer no, @Param("status") String s);

    /**
     * 查询总的学生数
     * @return
     */
    @Select("select count(*) from student")
    Integer findCount();

    /**
     * 查询未打卡的学生的数
     * @return
     */
    @Select("select count(*) from student where status = 'N'")
    Integer findNoPunchCount();

    /**
     * 重置所有学生的打卡状态为 'N'
     */
    @Update("update student set status = 'N'")
    void updateAllStatus();

    /**
     * 更新主页个人信息
     */
    @Update("update student set email = #{email} where no = #{no} ")
    void updateInfo(@Param("no") int no, @Param("email") String email);

}
