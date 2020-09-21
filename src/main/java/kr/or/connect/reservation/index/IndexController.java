package kr.or.connect.reservation.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(path="/")
    public String main(ModelMap modelMap){
        return "index";
    }

}
