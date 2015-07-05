package dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import bean.User;
import dao.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO {
    
    private SqlSessionTemplate sqlSessionTemplate;
    
    public void add(User user) {
        String statement = "mapper.UserMapper.insert";
        sqlSessionTemplate.insert(statement, user);
    }
    
    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }
    
    @Resource
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    
}
