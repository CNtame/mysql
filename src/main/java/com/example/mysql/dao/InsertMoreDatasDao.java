package com.example.mysql.dao;

import com.example.mysql.mod.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liu
 * @version 1.0
 * @description 大量数据插入方式
 * @createDate 2021/3/2
 */
@Mapper
public interface InsertMoreDatasDao {


    /**
     * 单条插入
     * 反复执行单条插入语句
     */
    void insertUserInfoDao(UserInfo userInfo);


    /**
     * xml拼接sql插入数据
     */
    void insertUserInfosXmlDao(List<UserInfo> infos);




}
