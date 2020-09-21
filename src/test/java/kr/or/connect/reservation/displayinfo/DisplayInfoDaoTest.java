package kr.or.connect.reservation.displayinfo;

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
public class DisplayInfoDaoTest {
	
	@Autowired
	DisplayInfoDao displayInfoDao;
	
//	@Test
//	public void getDisplayInfosCnt() throws Exception {
//		System.out.println(displayInfoDao.getDisplayInfosCnt(3));
//	}
//	
//	@Test
//	public void getDisplayInfosLimit() throws Exception {
//		for(DisplayInfo displayInfo:displayInfoDao.getDisplayInfosLimit(3, 0, 4)) {
//			System.out.println(displayInfo);
//		}
//	}
	
//	@Test
//	public void getDisplayInfos() throws Exception {
//		for(DisplayInfo displayInfo:displayInfoDao.getDisplayInfos()) {
//			System.out.println(displayInfo);
//		}
//	}
	
	//한개 구하기 테스트
//	@Test
//	public void getDisplayInfo() throws Exception {
//		System.out.println(displayInfoDao.getDisplayInfo(1));
//	}
	
	//상품 이미지 가져오기 테스트
//	@Test
//	public void getProductImages() throws Exception {
//		System.out.println(displayInfoDao.getProductImages(1));
//	}
	
	//디스플레이 이미지 가져오기 테스트
//	@Test
//	public void getDisplayInfoImages() throws Exception {
//		System.out.println(displayInfoDao.getDisplayInfoImages(1));
//	}
	
	//평균 점수 테스트
//	@Test
//	public void getAvgScore() throws Exception {
//		System.out.println(displayInfoDao.getAvgScore(1));
//	}
	
	//productPrices : 상품 가격 정보들
	@Test
	public void getProductPrices() throws Exception {
		System.out.println(displayInfoDao.getProductPrices(1));
	}

}
