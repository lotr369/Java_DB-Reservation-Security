package kr.or.connect.reservation.reservationInfo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationInfoDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationInfo> rsvtInfoRowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
	private RowMapper<Price> priceRowMapper = BeanPropertyRowMapper.newInstance(Price.class);
	private RowMapper<ReservationInfoDetails> rsvtInfoDetailsRowMapper = BeanPropertyRowMapper.newInstance(ReservationInfoDetails.class);
	
	public ReservationInfoDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
	}

	//예약 등록하기
	public Long insert(ReservationInfo reservationInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
		// 마지막 id 값 가져오기
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(ReservationInfoSqls.INSERT_RESERVATION_INFO.getSql(),params,keyHolder);
		return (Long)keyHolder.getKey();
	}
	
	//가격 넣기
	public int insertPrices(Price price) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(price);
		return jdbc.update(ReservationInfoSqls.INSERT_PRICES.getSql(),params);
	}
	
	//예약 정보 가져오기
	public ReservationInfo getRsvtInfoById(Long reservationInfoId) {
		Map<String, Long> paramMap= Collections.singletonMap("id", reservationInfoId);
		return jdbc.queryForObject(ReservationInfoSqls.GET_RSVT_INFO_BY_ID.getSql(),
				paramMap, rsvtInfoRowMapper);
	}
	
	//가격 가져오기
	public List<Price> getPrices(Long reservationInfoId) {
		Map<String, Long> paramMap= Collections.singletonMap("reservationInfoId", reservationInfoId);
		return jdbc.query(ReservationInfoSqls.GET_PRICES_BY_RSVT_ID.getSql()
				, paramMap, priceRowMapper);
	}
	
	//주문 정보 구하기
	public List<ReservationInfoDetails> getRsvtInfoByUserId(int userId){
		Map<String, Integer> paramMap= Collections.singletonMap("userId", userId);
		return jdbc.query(ReservationInfoSqls.GET_RSVT_INFOS_BY_USER_ID.getSql(),
				paramMap, rsvtInfoDetailsRowMapper);
	}
	
	//예약 취소하기
	//// 예약 가격 삭제
	public int deleteRsvtInfoPrice(int id) {
		Map<String, Integer> paramMap= Collections.singletonMap("id", id);
		return jdbc.update(ReservationInfoSqls.DEL_RSVT_INFO_PRICE.getSql()
				, paramMap);
	}
	//// 예약 정보 삭제
	public int deleteRsvtInfo(int id) {
		Map<String, Integer> paramMap= Collections.singletonMap("id", id);
		return jdbc.update(ReservationInfoSqls.DEL_RSVT_INFO.getSql()
				, paramMap);
	}

}
