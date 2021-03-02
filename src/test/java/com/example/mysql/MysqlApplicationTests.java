package com.example.mysql;

import com.alibaba.fastjson.JSON;
import com.example.mysql.dao.InsertMoreDatasDao;
import com.example.mysql.dao.TimeReadDao;
import com.example.mysql.mod.UserInfo;
import com.example.mysql.service.moreData.InsertDataService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.security.sasl.SaslServer;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MysqlApplicationTests {

    @Autowired
    private InsertDataService insertDataService;

    @Resource
    private TimeReadDao timeReadDao;

    private List<UserInfo> userInfos = new ArrayList<>();

    @BeforeEach
    public  void createInsertData() {
        String json = "{\n" +
                "    \"userName\":\"testName\",\n" +
                "    \"pass\":\"123123dsfsadasdassewrerwhds\",\n" +
                "    \"phone\":\"1234451321\",\n" +
                "    \"email\":\"dsaasd12312312@qq\",\n" +
                "    \"department\":\"test_department\",\n" +
                "    \"idNum\":\"esdfds234234f\",\n" +
                "    \"realName\":\"中国人\",\n" +
                "    \"roleName\":\"江苏人\",\n" +
                "    \"type\":1,\n" +
                "    \"status\":0\n" +
                "}";
        UserInfo info = JSON.parseObject(json, UserInfo.class);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        info.setCreateTime(format.format(date));

        for (int i = 0; i < 3000; i++) {
            userInfos.add(info);
        }
    }

    /**
     * sql批量插入
     */
    @Test
    public void sqlInsert() {

        long start = System.currentTimeMillis();
        insertDataService.insertSqlService(userInfos);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }

    /**
     * 批处理
     */
    @Test
    public void piInsert() {
        long start = System.currentTimeMillis();
        insertDataService.insertPiService(userInfos);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }

    /**
     * xml1:全部一次拼接
     */
    @Test
    public void xmlInsert1() {
        long start = System.currentTimeMillis();
        insertDataService.insertByXmlService1(userInfos);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }

    /**
     * xml1:截取拼接拼接
     */
    @Test
    @Transactional
    public void xmlInsert2() {
        long start = System.currentTimeMillis();
        insertDataService.insertByXmlService2(userInfos);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }





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

        List<Integer>[] data = new List[1];
        data[0] = new ArrayList<Integer>();
        data[0].add(1);
        Math.min(1, 2);

        System.out.println(Arrays.toString(data));

    }

    @Test
    void SelectTime() {

    }

}
