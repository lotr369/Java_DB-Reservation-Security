package kr.or.connect.reservation.promotion;

public enum PromotionDaoSqls {
	
	GET_PROMOTIOMS(
			"select pm.id,pm.product_id as productId,p.category_id as categoryId,\r\n" + 
			"c.name as categoryName,p.description as description,pi.file_id as fileId\r\n" + 
			"from promotion as pm\r\n" + 
			"inner join product as p on pm.product_id=p.id\r\n" + 
			"inner join product_image as pi on p.id=pi.product_id and pi.type like 'th'\r\n" + 
			"inner join category as c on p.category_id=c.id;"
			);
	
	private String sql;

	PromotionDaoSqls(String string) {
		this.sql=string;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	
}
