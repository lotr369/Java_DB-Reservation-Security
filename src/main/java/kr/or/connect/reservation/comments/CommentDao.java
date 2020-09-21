package kr.or.connect.reservation.comments;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Comment> commentRowMapper = 
			BeanPropertyRowMapper.newInstance(Comment.class);

	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	//댓글 목록 구하기
	public List<Comment> getComments(int productId, int start,int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(
				CommentDaoSqls.GET_COMMENTS.getSql(),
				params,
				commentRowMapper
				);
	}
	
	//댓글 전체 수 구하기
	public int getCommentsCnt(int productId) {
		Map<String, Integer> params = Collections.singletonMap("productId", productId);
		return jdbc.queryForObject(
				CommentDaoSqls.GET_COMMENTS_CNT.getSql(), 
				params,
				Integer.class);
	}
	
}
