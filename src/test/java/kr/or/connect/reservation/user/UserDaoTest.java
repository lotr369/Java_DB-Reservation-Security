package kr.or.connect.reservation.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.config.MvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MvcConfig.class, ApplicationConfig.class })
public class UserDaoTest {
	
	@Autowired
	UserDao userDao;
	
	@Test
	public void getUserByEmail() {
		User user=userDao.getUserByEmail("carami@connect.co.kr");
		System.out.println(user);
	}

}
