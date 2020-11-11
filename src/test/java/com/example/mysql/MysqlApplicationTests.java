package com.example.mysql;

import com.example.mysql.dao.TimeReadDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MysqlApplicationTests {

    @Resource
    private TimeReadDao timeReadDao;

    @Test
    void contextLoads() {

        //java date:Wed Nov 11 00:00:00 CST 2020
        System.out.println("java date:" + timeReadDao.selectDate());
        //sql date:2020-11-11
        System.out.println("sql date:" + timeReadDao.selectDate2());
        //String date:2020-11-11
        System.out.println("String date:" + timeReadDao.stringDate());

        //String time:01:11:11
        System.out.println("String time:" + timeReadDao.stringTime());
        //sql time:09:11:11
        System.out.println("sql time:" + timeReadDao.sqlTime());
        //Timer time:null
        System.out.println("Timer time:" + timeReadDao.timerTime());

        //String timestamp:2020-11-11 13:57:18
        System.out.println("String timestamp:" + timeReadDao.stringTimestamp());
        //sql timestamp:2020-11-12 01:49:17.0 后面有.0
        System.out.println("sql timestamp:" + timeReadDao.sqlTimestamp());
        //null
        System.out.println("com.sun.jmx.snmp.Timestamp:" + timeReadDao.javaTimestamp());
        //Thu Nov 12 01:49:17 CST 2020
        System.out.println("util date timestamp:" + timeReadDao.utilTimestamp());

        //java date datetime:Wed Nov 11 14:06:06 CST 2020
        System.out.println("java date datetime:" + timeReadDao.utilDateDateTime());
        //sql date->datetime:2020-11-11
        System.out.println("sql date->datetime:" + timeReadDao.sqlDateDatetime());
        //String datetime:2020-11-11 06:06:06
        System.out.println("String datetime:" + timeReadDao.stringDatetime());

        //String year:2020-01-01
        System.out.println("String year:" + timeReadDao.stringYear());

    }

    @Test
    void SelectTime() {

    }

}
