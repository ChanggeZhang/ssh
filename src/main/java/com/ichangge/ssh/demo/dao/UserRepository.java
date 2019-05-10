package com.ichangge.ssh.demo.dao;

import com.ichangge.ssh.demo.model.UserEntity;
import com.ichangge.ssh.system.dbutil.DbConnector;
import com.ichangge.ssh.system.dbutil.RepositoryExecutor;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private RepositoryExecutor repositoryExecutor;

    public void setRepositoryExecutor(RepositoryExecutor repositoryExecutor) {
        this.repositoryExecutor = repositoryExecutor;
    }

    public List<UserEntity> listUser() {
        String sql = " SELECT * FROM user ";
        return repositoryExecutor.query(sql,UserEntity.class);
    }
}
