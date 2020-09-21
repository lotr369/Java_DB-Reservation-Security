package kr.or.connect.reservation.comments;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/comments")
public class CommentApiController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping
	public Map<String,Object> getComments(
			@RequestParam(name="productId", required=false, defaultValue="0") int productId,
			@RequestParam(name="start", required=false, defaultValue="0") int start){
		return commentService.getComments(productId, start);
	}
	
}
