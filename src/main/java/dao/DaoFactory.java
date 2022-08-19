package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoFactory {

	public static AdminDao createAdminDao() {
		return new AdminDaoImpl(getDataSource());
	}
	
	public static ProductDao createProductDao() {
		return new ProductDaoImpl(getDataSource());
	}
	
	public static ACategoryDao createACategoryDao() {
		return new ACategoryDaoImpl(getDataSource());
	}
	
	public static UserTypeDao createUserTypeDao() {
		return new UserTypeDaoImpl(getDataSource());
		
	}
	
	private static DataSource getDataSource() {
		InitialContext ctx = null;
		DataSource ds = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/shopharunodb");
		} catch (NamingException e) {
			if (ctx != null) {
				try {
					ctx.close();
				} catch (NamingException e1) {
					throw new RuntimeException(e1);
				}
			}
			throw new RuntimeException(e);
		}
		return ds;
	}
}