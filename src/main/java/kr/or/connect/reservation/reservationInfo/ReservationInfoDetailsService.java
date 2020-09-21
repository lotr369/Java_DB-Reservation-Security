package kr.or.connect.reservation.reservationInfo;

import java.security.Principal;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.user.User;
import kr.or.connect.reservation.user.UserDao;

@Service
public class ReservationInfoDetailsService {
	
	@Autowired
	ReservationInfoDao reservationInfoDao;
	@Autowired
	UserDao userDao;
	DateFormat dateFormat;
	
	@Autowired
	public void init(DateFormat dateFormat) {
		this.dateFormat=dateFormat;
	}
	
	//주문 정보 가져오기
	public Map<String,Object> getRsvtInfoByUserId(Principal princepal){
		//로그인 중인 유저 id 알아 오기
		User user=userDao.getUserByEmail(princepal.getName());
		int userId=user.getId().intValue();
		
		List<ReservationInfoDetails> list=reservationInfoDao.getRsvtInfoByUserId(userId);
		Map<String,Object> map=new HashMap<>();
		map.put("size",list.size());
		map.put("items",list);
		return map;
	}

	@Transactional
	public Map<String, Object> deleteRsvtInfo(Map<String, Object> map) {
		int id=(int)map.get("id");
		
		//jdbc에서 성공시 1, 실패시 0 리턴 
		int isDelPrice=reservationInfoDao.deleteRsvtInfoPrice(id);
		int isDelRsvt=reservationInfoDao.deleteRsvtInfo(id);
		
		//result : 성공 시 success, 실패시 fail
		String result=(isDelPrice==1&&isDelRsvt==1)?"success":"fail";
		Map<String,Object> resultMap=new HashMap<>();
		resultMap.put("result", result);
		return resultMap;
	}

}
