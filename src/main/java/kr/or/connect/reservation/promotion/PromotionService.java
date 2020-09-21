package kr.or.connect.reservation.promotion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
	
	@Autowired
	private PromotionDao promotionDao;
	
	public Map<String, Object> getPromotions(){
		Map<String, Object> map=new HashMap<>();
		List<Promotion> list=promotionDao.getPromotions();
		map.put("size", list.size());
		map.put("items", list);
		return map;
	}

}
