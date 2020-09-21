package kr.or.connect.reservation.promotion;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/promotions")
public class PromotionApiController {
	
	@Autowired
	private PromotionService promotionService;
	
	@GetMapping
	public Map<String, Object> getPromotions(){
		return promotionService.getPromotions();
	}

}
