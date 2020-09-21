package kr.or.connect.reservation.reservationInfo;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationInfoService {
	
	@Autowired
	ReservationInfoDao reservationInfoDao;
	DateFormat dateFormat;
	
	@Autowired
	public void init(DateFormat dateFormat) {
		this.dateFormat=dateFormat;
	}
	
	//예약 정보 및 가격 삽입
	@Transactional
	public Map<String, Object> insertRsvtInfoAndPrices(Map<?,?> map) {
		Long reservationInfoId=insertRsvtInfo(map);
		insertPrices(map, reservationInfoId);
		Map<String, Object> resultMap=new HashMap<>();
		resultMap.put("reservationInfo", getRsvtInfoAndPrices(reservationInfoId));
		return resultMap;
	}
	
	//예약 정보 삽입
	public Long insertRsvtInfo(Map<?,?> map) {
		ReservationInfo reservationInfo=new ReservationInfo();
		reservationInfo.setProductId((int) map.get("productId"));
		reservationInfo.setDisplayInfoId((int) map.get("displayInfoId"));
		reservationInfo.setUserId((int) map.get("userId"));
		try {
			Date date=dateFormat.parse((String) map.get("reservationYearMonthDay"));
			reservationInfo.setReservationDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//예약 넣고 id값 가져오기
		return reservationInfoDao.insert(reservationInfo);
	}
	
	//가격 삽입
	public void insertPrices(Map<?,?> map,Long reservationInfoId) {
		//가격 넣기
		List<Map> prices=(ArrayList<Map>) map.get("prices");
		Price price=new Price();
		price.setCount((int) prices.get(0).get("count"));
		price.setProductPriceId((int) prices.get(0).get("productPriceId"));
		price.setReservationInfoId(reservationInfoId);
		reservationInfoDao.insertPrices(price);
	}
	
	//예약 정보 및 가격 삽입시 응답 결과
	public ReservationInfo getRsvtInfoAndPrices(Long reservationInfoId){
		//예약 정보 가져오기
		ReservationInfo reservationInfo=getRsvtInfo(reservationInfoId);
		//가격 가져오기
		List<Price> prices=getPrices(reservationInfoId);
		//Json을 위해 예약, 가격 합치기
		reservationInfo.setPrices(prices);
		return reservationInfo;
	}
	
	//예약 정보 가져오기
	public ReservationInfo getRsvtInfo(Long reservationInfoId) {
		return reservationInfoDao.getRsvtInfoById(reservationInfoId);
	}
	
	//가격 가져오기
	public List<Price> getPrices(Long reservationInfoId){
		return reservationInfoDao.getPrices(reservationInfoId);
	}

}
