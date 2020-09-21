package kr.or.connect.reservation.category;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/categories")
public class CategoryApiController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public Map<String, Object> getCategories(){
		return categoryService.getCategories();
	}

}
