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
					+ " users.id, users.user_nick_name, users.user_name, users.user_pass,"
					+ " users_types.type_name as type"
					+ " FROM users "
					+ " JOIN users_types"
					+ " ON users.user_type = users_types.id";
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
					+ " users.id, user_nick_name, user_name, user_pass,"
					+ " user_type as type"
					+ " FROM users"
					+ " JOIN users_types"
					+ "	ON users.user_type = users_types.id"
					+ " WHERE users.id = ?";
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
					+ " users.id, user_nick_name, user_name, user_pass,"
					+ " users_types.type_name as type"
					+ " FROM users JOIN users_types"
					+ " ON users.user_type = users_types.id"
					+ " WHERE users.id = ?";
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
			String sql = "INSERT INTO users (user_nick_name, user_name, user_pass, user_type)"
					+ " VALUES (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, admin.getUserNickName());
			stmt.setString(2, admin.getUserName());
			stmt.setString(3, admin.getUserPass());
			stmt.setObject(4, admin.getTypeId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void update(Admin admin) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE users SET"
					+ " user_nick_name=?, user_name=?, user_type=?"
					+ " WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, admin.getUserNickName());
			stmt.setString(2, admin.getUserName());
			stmt.setObject(3, admin.getTypeId(), Types.INTEGER);
			stmt.setObject(4, admin.getId(), Types.INTEGER);
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
	public boolean findByLoginIdAndLoginPass(String userName, String userPass) throws Exception {
		boolean findIs = false;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT"
					+ " user_pass"
					+ " FROM users "
					+ " WHERE user_name=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(userPass, rs.getString("user_pass"))) {
					findIs = true;
					return findIs;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return findIs;
	}

	private Admin mapToAdmin(ResultSet rs) throws Exception {
		Admin admin = new Admin();
		admin.setId((Integer) rs.getObject("id"));
		admin.setUserName(rs.getString("user_name"));
		admin.setUserPass(rs.getString("user_pass"));
		admin.setTypeName(rs.getString("type"));
		admin.setUserNickName(rs.getString("user_nick_name"));

		return admin;

	}
	
	private Admin mapToAdmin2(ResultSet rs) throws Exception {
		Admin admin = new Admin();
		admin.setId((Integer) rs.getObject("id"));
		admin.setUserName(rs.getString("user_name"));
		admin.setUserPass(rs.getString("user_pass"));
		admin.setTypeId(rs.getInt("user_type"));
		admin.setUserNickName(rs.getString("user_nick_name"));

		return admin;

	}

	@Override
	public Integer findTypeIdById(Integer id) throws Exception {
		Integer typeId = null;
		try (Connection con = ds.getConnection()){
			String sql = "SELECT user_type FROM users WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				typeId = (Integer) rs.getObject("user_type");
				return typeId;
			}
		} catch (Exception e) {
			throw e;
		}
		return typeId;
	}

	@Override
	public boolean checkUserName(String oldLoginId,String newLoginId) throws Exception {
		List<String> nameList = new ArrayList<>();
		try (Connection con = ds.getConnection()){
			String sql = "SELECT user_name FROM users WHERE user_name NOT IN (?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, oldLoginId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				nameList.add(rs.getString("user_name"));
			}
		} catch (Exception e) {
			throw e;
		}

		boolean check = nameList.contains(newLoginId);
		
		/* DB?????????????????????ID???????????????true????????? */
		if (check) {
			return false;
		} else if (!check){
			return true;
		}
		
		return false;
	}

	@Override
	public void insertNoUserType(Admin admin) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO users (user_nick_name, user_name, user_pass)"
					+ " VALUES (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, admin.getUserNickName());
			stmt.setString(2, admin.getUserName());
			stmt.setString(3, admin.getUserPass());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateNickNameAndUserId(Admin admin) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE users SET"
					+ " user_nick_name=?, user_name=?"
					+ " WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, admin.getUserNickName());
			stmt.setString(2, admin.getUserName());
			stmt.setObject(3, admin.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updatePassword(Integer id, String newPass) throws Exception {
		try (Connection con = ds.getConnection()){
			String sql = "UPDATE users SET"
					+ " user_pass=? WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, newPass);
			stmt.setObject(2, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public boolean checkPassword(Integer id, String oldPass) throws Exception {
		
		try (Connection con = ds.getConnection()){
			String sql = "SELECT user_pass FROM users WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				if (BCrypt.checkpw(oldPass, rs.getString("user_pass"))) {
					return true;
				}

			}
			
		} catch (Exception e) {
			throw e;
		}

		return false;
	}

	@Override
	public Admin findByUserName(String userName) throws Exception {
		Admin admin = new Admin();
		try (Connection con = ds.getConnection()){
			String sql = "SELECT * FROM users WHERE user_name=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				admin = mapToAdmin2(rs);
				return admin;
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	@Override
	public String findLoginIdById(Integer id) throws Exception {
		String loginId;
		try (Connection con = ds.getConnection()){
			String sql = "SELECT user_name FROM users WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				loginId = rs.getString("user_name");
				return loginId;
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	@Override
	public boolean checkUserName2(String loginId) throws Exception {
		List<String> nameList = new ArrayList<>();
		try (Connection con = ds.getConnection()){
			String sql = "SELECT user_name FROM users";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				nameList.add(rs.getString("user_name"));
			}
		} catch (Exception e) {
			throw e;
		}

		boolean check = nameList.contains(loginId);
		
		/* DB?????????????????????ID???????????????true????????? */
		if (check) {
			return false;
		} else if (!check){
			return true;
		}
		
		return false;
	}

}
