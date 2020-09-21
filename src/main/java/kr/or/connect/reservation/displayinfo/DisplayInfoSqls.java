package kr.or.connect.reservation.displayinfo;

enum DisplayInfoSqls {
	
	GET_DISPLAY_INFOS(
			"select p.id,p.category_id as categoryId,d.id as displayInfoId,c.name as name,"
			+" p.description,p.content,p.event,d.opening_hours as openingHours,d.place_name as placeName,"
			+" d.place_lot as placeLot, d.place_street as placeStreet,d.tel, d.homepage, d.email,"
			+" p.create_date as createDate, p.modify_date as modifyDate,pi.file_id as fileId"
			+" from product as p" 
			+" inner join display_info as d on p.id=d.product_id"
			+" inner join category as c on p.category_id=c.id"
			+" inner join product_image as pi on p.id=pi.product_id and pi.type like 'ma'"
			+" group by p.id"
			),
	GET_DISPLAY_INFOS_LIMIT(
			"select p.id,p.category_id as categoryId,d.id as displayInfoId,c.name as name,"
			+" p.description,p.content,p.event,d.opening_hours as openingHours,d.place_name as placeName,"
			+" d.place_lot as placeLot, d.place_street as placeStreet,d.tel, d.homepage, d.email,"
			+" p.create_date as createDate, p.modify_date as modifyDate,pi.file_id as fileId"
			+" from product as p"
			+" inner join display_info as d on p.id=d.product_id"
			+" inner join category as c on p.category_id=c.id"
			+" inner join product_image as pi on p.id=pi.product_id and pi.type like 'ma'"
			+" where c.id=:categoryId"
			+" group by p.id"
			+" limit :start,:limit"
			),
	GET_DISPLAY_INFOS_CNT("select count(*) from product where category_id=:categoryId"),
	GET_DISPLAY_INFO(
			"select p.id,p.category_id as categoryId,d.id as displayInfoId,c.name as name,\r\n" + 
			"p.description,p.content,p.event,d.opening_hours as openingHours,d.place_name as placeName,\r\n" + 
			"d.place_lot as placeLot, d.place_street as placeStreet,d.tel, d.homepage, d.email,\r\n" + 
			"p.create_date as createDate, p.modify_date as modifyDate,pi.file_id as fileId\r\n" + 
			"from product as p \r\n" + 
			"inner join display_info as d on p.id=d.product_id \r\n" + 
			"inner join category as c on p.category_id=c.id \r\n" + 
			"inner join product_image as pi on p.id=pi.product_id and pi.type like 'ma'\r\n" + 
			"where d.id=:displayId \r\n" + 
			"group by p.id"
			),
	GET_PRODUCT_IMAGES(
			"select d.product_id as productId,pi.id as productImageId,pi.type,f.id as fileInfoId,\r\n" + 
			"f.file_name as fileName,f.save_file_name as saveFileName,f.content_type as contentType,\r\n" + 
			"f.delete_flag as deleteFlag,f.create_date as createDate, f.modify_date as modifyDate\r\n" + 
			"from display_info as d\r\n" + 
			"inner join product_image as pi on d.product_id=pi.product_id and pi.type like 'ma'\r\n" + 
			"inner join file_info as f on pi.file_id=f.id\r\n" + 
			"where d.id=:displayId"
			),
	GET_DISPLAY_INFO_IMAGES(
			"select di.id as id,d.id as displayInfoId,di.file_id as fileId,\r\n" + 
			"f.file_name as fileName,f.save_file_name as saveFileName,\r\n" + 
			"f.content_type as contentType,f.delete_flag as deleteFlag,\r\n" + 
			"f.create_date as createDate,f.modify_date as modifyDate\r\n" + 
			"from display_info as d\r\n" + 
			"inner join display_info_image as di on d.id=di.display_info_id\r\n" + 
			"inner join file_info as f on di.file_id=f.id\r\n" + 
			"where d.id=:displayId;"
			),
	GET_AVG_SCORE(
			"select avg(r.score)\r\n" + 
			"from display_info as d\r\n" + 
			"inner join reservation_user_comment as r on d.product_id=r.product_id\r\n" + 
			"where d.id=:displayId\r\n" + 
			"group by r.product_id;"
			),
	GET_PRODUCT_PRICES(
			"select pp.id,pp.product_id as productId,pp.price_type_name as priceTypeName,\r\n" + 
			"pp.price, pp.discount_rate as discountRate, pp.create_date as createDate,\r\n" + 
			"pp.modify_date as modifyDate\r\n" + 
			"from display_info as d\r\n" + 
			"inner join product_price as pp on d.product_id=pp.product_id\r\n" + 
			"where d.id=:displayId\r\n" + 
			"order by pp.id desc;"
			);
	
	private String sql;

	DisplayInfoSqls(String string) {
		this.sql=string;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	
}
