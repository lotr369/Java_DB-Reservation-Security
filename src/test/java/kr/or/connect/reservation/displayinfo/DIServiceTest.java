package kr.or.connect.reservation.displayinfo;


import java.util.Map;

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
public class DIServiceTest {

	@Autowired
	DisplayInfoService displayInfoService;
	
//	@Test
//	public void getDisplayInfos() {
////		Map<String, Object> map=displayInfoService.getDisplayInfos(0, 0, 0);
//		Map<String, Object> map=displayInfoService.getDisplayInfos(3, 1);
//		for(String string:map.keySet()) {
//			System.out.println(string+" "+map.get(string));
//		}.
	
//	}
	
	@Test
	public void getDisplayInfo() {
		Map<String, Object> map=displayInfoService.getDisplayInfo(1);
		for(String string:map.keySet()) {
			System.out.println(string+" "+map.get(string));
		}
		
	}
}
