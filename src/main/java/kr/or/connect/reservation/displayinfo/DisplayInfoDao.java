package kr.or.connect.reservation.displayinfo;

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
public class DisplayInfoDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	private RowMapper<ProductImage> productImageMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	private RowMapper<DisplayInfoImage> displayInfoImageMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	private RowMapper<ProductPrice> productPriceMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);
	
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	//카테고리에 해당되는 상품 수 구하기
	public int getDisplayInfosCnt(int categoryId) {
		Map<String, Integer> params = Collections.singletonMap("categoryId", categoryId);
		return jdbc.queryForObject(
				DisplayInfoSqls.GET_DISPLAY_INFOS_CNT.getSql(), 
				params,
				Integer.class);
	}
	
	//상품 목록 카테고리, start로 구하기
	public List<DisplayInfo> getDisplayInfosLimit(Integer categoryId,Integer start, Integer limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(
				DisplayInfoSqls.GET_DISPLAY_INFOS_LIMIT.getSql(), 
				params, 
				rowMapper);
	}
	
	//상품 목록 전체 구하기
	public List<DisplayInfo> getDisplayInfos(){
		return jdbc.query(
				DisplayInfoSqls.GET_DISPLAY_INFOS.getSql(), 
				rowMapper);
	}
	
	//상품 한개 구하기
	public DisplayInfo getDisplayInfo(int displayId) {
		Map<String, Integer> params = Collections.singletonMap("displayId", displayId);
		return jdbc.queryForObject(
				DisplayInfoSqls.GET_DISPLAY_INFO.getSql(),
				params,
				rowMapper);
	}
	
	//productImages 가져 오기
	public List<ProductImage> getProductImages(int displayId){
		Map<String, Integer> params = Collections.singletonMap("displayId", displayId);
		return jdbc.query(
				DisplayInfoSqls.GET_PRODUCT_IMAGES.getSql(),
				params,
				productImageMapper);
	}
	
	//displayInfoImages 가져 오기
	public List<DisplayInfoImage> getDisplayInfoImages(int displayId){
		Map<String, Integer> params = Collections.singletonMap("displayId", displayId);
		return jdbc.query(
				DisplayInfoSqls.GET_DISPLAY_INFO_IMAGES.getSql(),
				params,
				displayInfoImageMapper);
	}
	
	//댓글 점수의 평균 가져오기
	public int getAvgScore(int displayId) {
		Map<String, Integer> params = Collections.singletonMap("displayId", displayId);
		return jdbc.queryForObject(
				DisplayInfoSqls.GET_AVG_SCORE.getSql(), 
				params,
				Integer.class);
	}
	
	//productPrices : 상품 가격 정보들
	public List<ProductPrice> getProductPrices(int displayId) {
		Map<String, Integer> params = Collections.singletonMap("displayId", displayId);
		return jdbc.query(
				DisplayInfoSqls.GET_PRODUCT_PRICES.getSql(), 
				params,
				productPriceMapper);
	}
	

}
