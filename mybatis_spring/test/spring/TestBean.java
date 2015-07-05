package spring;

import java.util.Date;

import mapper.UserMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bean.User;
import dao.impl.UserDAOImpl;

// 使用Spring的测试框架
@RunWith(SpringJUnit4ClassRunner.class)
//加载spring的配置文件
@ContextConfiguration("/applicationContext.xml")
public class TestBean {
    
    //自动依赖注入
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private UserDAOImpl dao;
    
    @Test
    public void testAdd() {
        User user = new User();
        user.setName("tom");
        user.setBirthday(new Date());
        user.setSalary(20.0);
        
        userMapper.insert(user);
    }
    
    /**
     * 测试org.mybatis.spring.SqlSessionTemplate
     */
    @Test
    public void testUserDAO() {
        User user = new User();
        user.setName("tom");
        user.setBirthday(new Date());
        user.setSalary(20.0);
        
        dao.add(user);
    }
    
    @Test
    public void testCache(){
        userMapper.selectByPrimaryKey(1);
        
        userMapper.selectByPrimaryKey(1);
    }
}
