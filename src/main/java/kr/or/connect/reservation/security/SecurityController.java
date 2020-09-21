package kr.or.connect.reservation.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/users")
public class SecurityController {

    @GetMapping("/loginform")
    public String loginform(){
        return "users/loginform";
    }

    @PostMapping("/loginerror")
    public String loginerror(
    		HttpServletRequest request,
    		ModelMap modelMap
    		){
    	modelMap.addAttribute("errorMessage", request.getAttribute("errorMessage"));
        return "users/loginerror";
    }

}
