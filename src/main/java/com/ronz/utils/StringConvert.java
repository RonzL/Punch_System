package com.ronz.utils;

/**
 * @Description:
 * @Author: Ronz ronz_liu@163.com
 * @Date: Created in 11:26 2020/7/24
 */

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将字符串对象转换为 Date 对象
 * S:表示接受的类型， T： 表示目标类型
 **/
public class StringConvert implements Converter<String, Date> {
    /**
     * 把字符串对象转换成 Date 对象
     * */
    @Override
    public Date convert(String source) {
        if (source == null || "".equals(source)){
            throw new RuntimeException("日期输入为空");
        } try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("日期转换错误");
        }
    }
}