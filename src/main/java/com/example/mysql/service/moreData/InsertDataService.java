package com.example.mysql.service.moreData;

import com.example.mysql.dao.InsertMoreDatasDao;
import com.example.mysql.mod.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2021/3/2
 */
@Service
public class InsertDataService {


    @Resource
    private InsertMoreDatasDao insertMoreDatasDao;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * xml拼接sql批量插入1
     * @param infos
     */
    @Transactional
    public void insertByXmlService1(List<UserInfo> infos) {
        insertMoreDatasDao.insertUserInfosXmlDao(infos);
    }

    /**
     * xml拼接sql批量插入2
     * 将list成小list分批次插入
     * @param infos
     */
    @Transactional
    public void insertByXmlService2(List<UserInfo> infos) {

        int size = infos.size();
        int index = size / 10;
        for (int i = 0; i <= index; i++) {
            int end = (i == index) ? size  : (i * 10) + 10;
            List<UserInfo> infos1 = infos.subList(i * 10, (i * 10) + 10);
            insertMoreDatasDao.insertUserInfosXmlDao(infos1);
        }

    }


    /**
     * 循环单次插入sql语句
     */
    @Transactional
    public void insertSqlService(List<UserInfo> infos) {

        for (UserInfo info : infos) {
            insertMoreDatasDao.insertUserInfoDao(info);

        }
    }

    /**
     * 批处理
     */
    @Transactional
    public void insertPiService(List<UserInfo> infos) {
        SqlSession session = sqlSessionFactory.openSession();
        InsertMoreDatasDao datasDao = session.getMapper(InsertMoreDatasDao.class);
        for (int i = 0; i < infos.size(); i++) {
            datasDao.insertUserInfoDao(infos.get(i));
            if (i % 1000 == 999) {
                session.commit();
                session.clearCache();

            }
        }
        session.commit();
        session.clearCache();

    }


}
