package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.Admin;

public class AdminDaoImpl implements AdminDao {

	private DataSource ds;

	public AdminDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Admin> findAll() throws Exception {
		List<Admin> userList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT"
					+ " users.id, users.user_name, users.user_pass,"
					+ " user_types.type_name as type"
					+ " FROM users "
					+ " JOIN user_types"
					+ " ON users.user_type = user_types.id";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				userList.add(mapToAdmin(rs));
			}
		} catch (Exception e) {
			throw e;
		}

		return userList;
	}

	@Override
	public Admin findById(Integer id) throws Exception {
		Admin admin = new Admin();

		try (Connection con = ds.getConnection();) {
			String sql = "SELECT"
					+ " id, user_name, user_pass,"
					+ " user_type as type"
					+ " FROM users"
					+ " WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				admin = mapToAdmin(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return admin;
	}

	@Override
	public Admin findById2(Integer id) throws Exception {
		Admin admin = new Admin();

		try (Connection con = ds.getConnection();) {
			String sql = "SELECT"
					+ " id, user_name, user_pass,"
					+ " user_types.type_name as type"
					+ " FROM users JOIN user_types"
					+ " ON users.user_type = user_types.id"
					+ " WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				admin = mapToAdmin(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return admin;
	}

	@Override
	public void insert(Admin admin) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO users (user_name, user_pass, user_type)"
					+ " VALUES (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, admin.getUserName());
			stmt.setString(2, admin.getUserPass());
			stmt.setObject(3, admin.getTypeId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void update(Admin admin) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE users SET"
					+ " user_name=?, user_type=?"
					+ " WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, admin.getUserName());
			stmt.setObject(2, admin.getTypeId(), Types.INTEGER);
			stmt.setObject(3, admin.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Admin admin) throws Exception {
		try (Connection con = ds.getConnection()){
			String sql = "DELETE FROM users WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, admin.getId(),Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public Admin findByLoginIdAndLoginPass(String userName, String userPass) throws Exception {
		Admin admin = null;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT"
					+ " users.id, users.user_name, users.user_pass,"
					+ " user_types.type_name as type"
					+ " FROM users "
					+ " JOIN user_types"
					+ " ON users.user_type = user_types.id"
					+ " WHERE user_name=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(userPass, rs.getString("user_pass"))) {
					admin = mapToAdmin(rs);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return admin;
	}

	private Admin mapToAdmin(ResultSet rs) throws Exception {
		Admin admin = new Admin();
		admin.setId((Integer) rs.getObject("id"));
		admin.setUserName(rs.getString("user_name"));
		admin.setUserPass(rs.getString("user_pass"));
		admin.setTypeName(rs.getString("type"));

		return admin;

	}

}
