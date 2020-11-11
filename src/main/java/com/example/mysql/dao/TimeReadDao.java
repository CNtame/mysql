package com.example.mysql.dao;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;

/**
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2020/11/11
 */
@Mapper
public interface TimeReadDao {

    /**
     * java.util.Date
     */
    Date selectDate();

    /**
     *java.sql.Date
     */
    java.sql.Date selectDate2();

    /**
     * String接收date
     */
    String stringDate();

    /**
     * String接收datetime
     */
    String stringDatetime();

    /**
     * String接收timestamp
     */
    String stringTimestamp();

    /**
     * String接收year
     */
    String stringYear();

    /**
     * String接收time
     */
    String stringTime();

    /**
     *sql查询Time
     */
    Time sqlTime();

    /**
     * Timer 查询time
     * 错误查询为空
     */
    Timer timerTime();

    /**
     * sql查询timestamp
     */
    Timestamp sqlTimestamp();

    com.sun.jmx.snmp.Timestamp javaTimestamp();

    /**
     * java util.date接收timestamp
     */
    Date utilTimestamp();

    /**
     * java date 接收datetime
     */
    Date utilDateDateTime();

    java.sql.Date sqlDateDatetime();


}
