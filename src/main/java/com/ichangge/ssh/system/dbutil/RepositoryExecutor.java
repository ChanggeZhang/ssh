package com.ichangge.ssh.system.dbutil;

import com.mysql.cj.util.StringUtils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RepositoryExecutor {

    private Session session;
    private Transaction transaction;

    private void init(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.session = sessionFactory.openSession();
        this.transaction = session.getTransaction();
    }

    public <T> List<T> query(String sql, Class<T> clazz){
        List<T> result = new ArrayList<T>();
        try {
            init();
            SQLQuery query = session.createSQLQuery(sql).addEntity(clazz);
            result = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
//            closeSession();
            return result;
        }
    }

    private void closeSession() {
        if(session != null){
            if(session.isConnected() || session.isOpen()){
                if(transaction != null && transaction.isActive()){
                    transaction.commit();
                }
                session.flush();
                session.close();
                session.disconnect();
            }
        }
    }


}
