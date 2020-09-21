package kr.or.connect.reservation.reservationinfo;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.config.MvcConfig;
import kr.or.connect.reservation.reservationInfo.ReservationInfo;
import kr.or.connect.reservation.reservationInfo.ReservationInfoDao;
import kr.or.connect.reservation.reservationInfo.ReservationInfoDetailsService;
import kr.or.connect.reservation.reservationInfo.ReservationInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MvcConfig.class, ApplicationConfig.class })
public class ReservationInfoTest {
	
	@Autowired
	ReservationInfoDao reservationInfoDao;
	@Autowired
	ReservationInfoService reservationInfoService;
	@Autowired
	ReservationInfoDetailsService rsvtInfoDetailsService;
	
//	@Test
//	public void insert() {
//		ReservationInfo reservationInfo=new ReservationInfo();
//		reservationInfo.setProductId(1);
//		reservationInfo.setDisplayInfoId(1);
//		reservationInfo.setUserId(1);
//		DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
//		try {
//			reservationInfo.setReservationYearMonthDay(format.parse("2020.01.02"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		System.out.println(reservationInfo);
//		System.out.println(reservationInfoDao.insert(reservationInfo));
//	}
	
	//서비스 테스트
//	@Test
//	public void RIServiceTest() {
//		reservationInfoService.insert(1, 1, 1, "2020.01.02");
//	}
	
	//예약 정보 가져오기
//	@Test
//	public void getRsvtInfo() {
//		System.out.println(reservationInfoDao.getRsvtInfoById((long) 32));
//	}
	
	//가격 가져오기
//	@Test
//	public void getPrices() {
//		System.out.println(reservationInfoDao.getPrices((long) 32));
//	}
	
	//예약 정보 및 가격 삽입시 응답 결과
//	@Test
//	public void getResult() {
//		System.out.println(reservationInfoService.getRsvtInfoAndPrices((long) 32));
//	}
	
	//주문 정보 가져 오기 DAO 테스트
//	@Test
//	public void getRsvtInfoByUserId() {
//		System.out.println(reservationInfoDao.getRsvtInfoByUserId(1));
//	}
	
	//DAO삭제 테스트
	@Test
	public void deleteRsvtInfo() {
		Map<String,Object> map=new HashMap<>();
		map.put("id",32);
		rsvtInfoDetailsService.deleteRsvtInfo(map);
	}
}
