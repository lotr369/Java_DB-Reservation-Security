package kr.or.connect.reservation.category;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {
	
	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
    
    public CategoryDao(DataSource dataSource) {
    	this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Category> getCategories() {
		return jdbc.query(CategoryDaoSqls.GET_CATEGORIES.getSql(),rowMapper);
    }

}
