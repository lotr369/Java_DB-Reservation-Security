package kr.or.connect.reservation.reservationInfo;

enum ReservationInfoSqls {
	
	INSERT_RESERVATION_INFO("insert into reservation_info (\r\n" + 
			"product_id, display_info_id, user_id, reservation_date,\r\n" + 
			"create_date, modify_date) \r\n" + 
			"values ( :productId, :displayInfoId, :userId, :reservationDate, now(), now())"),
	INSERT_PRICES("insert into reservation_info_price (\r\n" + 
			"reservation_info_id, product_price_id, count) \r\n" + 
			"values (:reservationInfoId, :productPriceId, :count);"),
	GET_RSVT_INFO_BY_ID("select * from reservation_info where id=:id"),
	GET_PRICES_BY_RSVT_ID("select * from reservation_info_price "
			+ "where reservation_info_id=:reservationInfoId"),
	GET_RSVT_INFOS_BY_USER_ID("select ri.id,ri.product_id,ri.display_info_id,ri.user_id,\r\n" + 
			"ri.reservation_date,ri.create_date,ri.modify_date\r\n" + 
			",sum(price)  as sumPrice,\r\n" + 
			"p.description as productDescription,\r\n" + 
			"p.content as productContent\r\n" + 
			"from reservation_info as ri\r\n" + 
			"inner join reservation_info_price as rip\r\n" + 
			"on ri.id=rip.reservation_info_id\r\n" + 
			"inner join product_price as pp\r\n" + 
			"on rip.product_price_id=pp.id\r\n" + 
			"inner join product as p\r\n" + 
			"on ri.product_id=p.id\r\n" + 
			"where ri.user_id=:userId\r\n" + 
			"group by ri.id;"),
	DEL_RSVT_INFO_PRICE("delete from reservation_info_price where reservation_info_id=:id;"),
	DEL_RSVT_INFO("delete from reservation_info where id=:id");
	
	private String sql;

	ReservationInfoSqls(String string) {
		this.sql=string;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	
}
