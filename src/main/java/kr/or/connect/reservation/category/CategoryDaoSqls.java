package kr.or.connect.reservation.category;

enum CategoryDaoSqls {
	
	GET_CATEGORIES("select c.id, c.name, count(p.category_id) as count "
			+ "from category as c inner join product as p "
			+ "on c.id=p.category_id group by p.category_id");
	
	private String sql;

	CategoryDaoSqls(String string) {
		this.sql=string;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	
}
