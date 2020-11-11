package com.example.mysql.control;

import com.example.mysql.dao.TimeReadDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2020/11/11
 */
@Controller
@RequestMapping("/time1")
public class TimeControl {

    private Logger logger = LoggerFactory.getLogger(TimeControl.class);

    @Resource
    private TimeReadDao timeReadDao;

    @RequestMapping(value = "/date")
    @ResponseBody
    public String testDateControl(){
        logger.info("222");
        return timeReadDao.selectDate().toString()+ timeReadDao.selectDate2().toString();
    }

}
