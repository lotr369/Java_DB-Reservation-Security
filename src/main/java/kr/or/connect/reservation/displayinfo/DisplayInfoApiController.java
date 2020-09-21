package kr.or.connect.reservation.displayinfo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/displayinfos")
public class DisplayInfoApiController {
	
	@Autowired
	DisplayInfoService displayInfoService;
	
	@GetMapping
	public Map<String,Object> getDisplayInfos(
			@RequestParam(name="categoryId", required=false, defaultValue="0") int categoryId,
			@RequestParam(name="start", required=false, defaultValue="0") int start) {
		return displayInfoService.getDisplayInfos(categoryId, start);
	}
	
	@GetMapping(path="/{displayId}")
	public Map<String,Object> getDisplayInfo(
			@RequestParam(name="displayId", required=false, defaultValue="0") int displayId){
		return displayInfoService.getDisplayInfo(displayId);
	}

}
