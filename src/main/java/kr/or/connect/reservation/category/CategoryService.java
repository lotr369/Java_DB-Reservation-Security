package kr.or.connect.reservation.category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao categoryDao;
	
	public Map<String, Object> getCategories(){
		Map<String, Object> map = new HashMap<>();
		List<Category> cList=categoryDao.getCategories();
		// 카테고리 수
		map.put("size", cList.size());
		// 카테고리 목록
		map.put("items", cList);
		return map;
	}
}
