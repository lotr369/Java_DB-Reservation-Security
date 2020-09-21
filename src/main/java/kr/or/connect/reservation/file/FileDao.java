package kr.or.connect.reservation.file;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;



@Repository
public class FileDao {

	private final String getFiles="select * from file";
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<UpFile> rowMapper = BeanPropertyRowMapper.newInstance(UpFile.class);
	
	public FileDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("file").usingGeneratedKeyColumns("id");
		
	}
	
	public Long insert(UpFile upFile) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(upFile);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public List<UpFile> getFiles(){
		return jdbc.query(getFiles, rowMapper);
	}
	
	}
