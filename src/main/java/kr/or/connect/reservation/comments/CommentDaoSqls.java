package kr.or.connect.reservation.comments;

public enum CommentDaoSqls {
	
	Comments(
			"insert into reservation_user_comment(id, product_id, reservation_info_id, user_id, score, comment, create_date, modify_date)\r\n" + 
			"values (?, ?, ?, ?, ?, '????', now(), now()) "),
	
	GET_COMMENTS(
			"select c.id, c.product_id as productId, c.reservation_info_id as reservationInfoId,\r\n" + 
			"c.score,u.email as reservationEmail,c.comment,c.create_date as createDate,\r\n" + 
			"c.modify_date as modifyDate\r\n" + 
			"from reservation_user_comment as c\r\n" + 
			"inner join user as u on c.user_id=u.id\r\n" + 
			"where c.product_id=:productId\r\n" + 
			"order by c.id desc\r\n" + 
			"limit :start,:limit"),
	GET_COMMENTS_CNT(
			"select count(*)\r\n" + 
			"from reservation_user_comment as c\r\n" + 
			"where c.product_id=:productId;");
	

	
	private String sql;

	CommentDaoSqls(String string) {
		this.sql=string;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

}
