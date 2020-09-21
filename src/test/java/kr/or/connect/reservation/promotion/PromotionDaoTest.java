package kr.or.connect.reservation.promotion;

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
public class PromotionDaoTest {
	
	@Autowired
	PromotionDao promotionDao;
	
	@Test
	public void getPromotions() {
		for(Promotion promotion:promotionDao.getPromotions()) {
			System.out.println(promotion);
		}
	}

}
