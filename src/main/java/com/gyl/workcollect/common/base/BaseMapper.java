package com.gyl.workcollect.common.base;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseMapper {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    protected <T> T selectOne(String statement, Object parameter) {
        return sqlSessionTemplate.selectOne(statement, parameter);
    }

    protected <T> T selectOne(String statement) {
        return sqlSessionTemplate.selectOne(statement);
    }

    protected <T> List<T> selectList(String statement, Object parameter) {
        return sqlSessionTemplate.selectList(statement, parameter);
    }

    protected <T> List<T> selectList(String statement) {
        return sqlSessionTemplate.selectList(statement);
    }

    protected <T> List<T> selectPage(String statement, Object parameter, RowBounds rowBounds) {
        return sqlSessionTemplate.selectList(statement, parameter, rowBounds);
    }

    protected int insert(String statement, Object parameter) {
        return sqlSessionTemplate.insert(statement, parameter);
    }

    protected int delete(String statement, Object parameter) {
        return sqlSessionTemplate.delete(statement, parameter);
    }

    protected int update(String statement, Object parameter){
        return sqlSessionTemplate.update(statement,parameter);
    }


}
