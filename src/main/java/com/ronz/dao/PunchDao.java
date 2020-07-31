package com.ronz.dao;

import com.ronz.domain.Punch;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PunchDao {

    /**
     * 保存打卡信息
     * @param punch
     */
    @Insert("insert into punch_info (no,date,physical_state,address) values(#{no},#{date},#{physical_state},#{address})")
    void saveInfo(Punch punch);

    /**
     * 查询打卡信息
     * @param no 学/工 号
     * @return
     */
    @Select("select * from punch_info where no = #{no} order by date desc")
    List<Punch> findInfo(Integer no);

    /**
     * 查询打卡天数
     * @param no 学/工 号
     * @return
     */
    @Select("select count(*) from punch_info where no = #{no}")
    Integer findCount(Integer no);

    /**
     * 上传打卡信息
     * @return
     */
    @Insert("insert into punch_info (no,date,physical_state,address) values (#{no},#{date},#{physical_state},#{address})")
    Integer uploadInfo(Punch punch);
}
