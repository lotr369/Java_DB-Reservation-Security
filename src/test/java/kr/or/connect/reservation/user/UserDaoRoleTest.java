package kr.or.connect.reservation.user;

import java.util.List;

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
public class UserDaoRoleTest {
	
	@Autowired
	UserRoleDao userRoleDao;
	
	@Test
	public void getUserByEmail() {
		List<UserRole> userRoles=userRoleDao.getRolesByEmail("carami@connect.co.kr");
		for(UserRole userRole:userRoles) {
			System.out.println(userRole);
		}
	}

}
