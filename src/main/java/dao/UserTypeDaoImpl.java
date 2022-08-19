package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.UserType;

public class UserTypeDaoImpl implements UserTypeDao {

	private DataSource ds;

	public UserTypeDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<UserType> findAll() throws Exception {
		List<UserType> userTypeList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * From users_types ORDER BY id ASC";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				userTypeList.add(mapToUserType(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return userTypeList;
	}

	private UserType mapToUserType(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		String typeName = rs.getString("type_name");
		return new UserType(id, typeName);

	}

	@Override
	public Integer countTypeId() throws Exception {
		Integer countTypeId = null;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT COUNT(id) FROM users_types";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Object object = rs.getObject("COUNT(id)");
				String countTypeIdStr = object.toString();
				countTypeId = Integer.parseInt(countTypeIdStr);
				return countTypeId;
			}
		} catch (Exception e) {
			throw e;
		}
		return countTypeId;
	}
}
