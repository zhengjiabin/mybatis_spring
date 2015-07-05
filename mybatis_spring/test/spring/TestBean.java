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

// ʹ��Spring�Ĳ��Կ��
@RunWith(SpringJUnit4ClassRunner.class)
//����spring�������ļ�
@ContextConfiguration("/applicationContext.xml")
public class TestBean {
    
    //�Զ�����ע��
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
     * ����org.mybatis.spring.SqlSessionTemplate
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
