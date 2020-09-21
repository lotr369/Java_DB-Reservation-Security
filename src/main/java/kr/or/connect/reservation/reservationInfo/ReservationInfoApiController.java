package kr.or.connect.reservation.reservationInfo;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/reservationInfos")
public class ReservationInfoApiController {
	
	@Autowired
	ReservationInfoService reservationInfoService;
	@Autowired
	ReservationInfoDetailsService rsvtInfoDetailsService;
	
	//예약 등록하기
	@PostMapping
	@ResponseBody
	public Map<String, Object> insertRsvtInfoAndPrices(@RequestBody Map<String, Object> map) {
		return reservationInfoService.insertRsvtInfoAndPrices(map);
	}
	
	//주문 정보 구하기
	@GetMapping
	public Map<String, Object> getRsvtInfo(Principal principal){
		return rsvtInfoDetailsService.getRsvtInfoByUserId(principal);
	}
	
	//예약 취소하기
	@PutMapping
	@ResponseBody
	public Map<String, Object> deleteRsvtInfo(@RequestBody Map<String, Object> map){
		return rsvtInfoDetailsService.deleteRsvtInfo(map);
	}

}
