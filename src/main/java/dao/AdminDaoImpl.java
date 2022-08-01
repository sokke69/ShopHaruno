package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.Admin;

public class AdminDaoImpl implements AdminDao{
	
	private DataSource ds;
	
	public AdminDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Admin> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Admin findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Admin admin) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void update(Admin admin) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void delete(Admin admin) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public Admin findByLoginIdAndLoginPass(String userName, String userPass) throws Exception {
		Admin admin = null;
		try (Connection con = ds.getConnection()){
			String sql = "SELECT "
					+ "id, user_name, user_pass FROM user WHERE user_name=?";
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
		admin.setId((Integer)rs.getObject("id"));
		admin.setUserName(rs.getString("user_name"));
		admin.setUserPass(rs.getString("user_pass"));
		return admin;
		
	}

}
