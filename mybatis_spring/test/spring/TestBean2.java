package spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;
import dao.UserMapper;

public class TestBean2 {
    private ApplicationContext ac;
    
    private UserMapper userMapper;
    
    @Before
    public void before() {
        String spring = "applicationContext.xml";
        ac = new ClassPathXmlApplicationContext(spring);
        userMapper = ac.getBean(UserMapper.class);
    }
    
    @Test
    public void testBean() {
        User user = userMapper.selectByPrimaryKey(new Integer(1));
        System.out.println(user);
    }
}
