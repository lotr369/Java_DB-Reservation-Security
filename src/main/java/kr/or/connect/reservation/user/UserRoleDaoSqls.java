package kr.or.connect.reservation.user;

public class UserRoleDaoSqls {
	public static final String SELECT_ALL_BY_EMAIL = 
			"SELECT ur.id, ur.user_id, ur.role_name \r\n" + 
			"FROM user_role ur \r\n" + 
			"JOIN user u ON ur.user_id = u.id \r\n" + 
			"WHERE u.email = :email";
}