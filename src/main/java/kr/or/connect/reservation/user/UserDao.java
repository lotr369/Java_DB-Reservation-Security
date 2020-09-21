package kr.or.connect.reservation.user;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
	
	public UserDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public User getUserByEmail(String email){
		Map<String, Object> map = new HashMap<>();
		map.put("email", email);
		return jdbc.queryForObject(UserDaoSqls.SELECT_ALL_BY_EMAIL, map, rowMapper);
	}

}
