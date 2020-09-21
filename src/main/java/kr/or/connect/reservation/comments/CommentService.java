package kr.or.connect.reservation.comments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	private final int limit=5;
	
	public Map<String, Object> getComments(int productId,int start){
		Map<String, Object> map=new HashMap<>();
		List<Comment> commentsImagesList=getCommentsImages(productId, start);
		map.put("totalCount", commentDao.getCommentsCnt(productId));
		map.put("commentCount", commentsImagesList.size());
		map.put("reservationUserComments", commentsImagesList);
		
		return map;
	}
	
	// 코멘트 객체 안에 이미지 배열 넣어 이중 구조 JSON 만들기
	public List<Comment> getCommentsImages(int productId,int start){
		List<Comment> commentsList=commentDao.getComments(productId, start, limit);
		for(Comment comment:commentsList) {
			comment.setCommentImagesList(new ArrayList<>());
		}
		return commentsList;
	}
}
