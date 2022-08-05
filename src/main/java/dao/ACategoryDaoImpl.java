package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.ACategory;

public class ACategoryDaoImpl implements ACategoryDao{
	
	private DataSource ds;

	public ACategoryDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<ACategory> findAll() throws Exception {
		
		List<ACategory> aCategoryList = new ArrayList<>();
		try (Connection con = ds.getConnection()){
			String sql = "SELECT * FROM as_categories ORDER BY id ASC";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				aCategoryList.add(mapToACategory(rs));
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		return aCategoryList;
	}

	@Override
	public ACategory findById(Integer id) throws Exception {
		ACategory aCategory = new ACategory();
		try (Connection con = ds.getConnection()){
			String sql = "SELECT"
					+ " * FROM as_categories WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				aCategory = mapToACategory(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return aCategory;
	}

	@Override
	public void insert(ACategory aCategory) throws Exception {
		try (Connection con = ds.getConnection()){
			String sql = "INSERT INTO as_categories (a_category_name) values (?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, aCategory.getaCategoryName());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void update(ACategory aCategory) throws Exception {
		try (Connection con = ds.getConnection()){
			String sql = "UPDATE as_categories SET a_category_name=? WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, aCategory.getaCategoryName());
			stmt.setObject(2, aCategory.getId(),Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void delete(ACategory aCategory) throws Exception {
		try (Connection con = ds.getConnection()){
			String sql = "DELETE FROM as_categories WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, aCategory.getId(),Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public ACategory  mapToACategory(ResultSet rs) throws Exception {
		ACategory aCategory = new ACategory();
		aCategory.setId((Integer)rs.getObject("id"));
		aCategory.setaCategoryName(rs.getString("a_category_name"));
		return aCategory;
	}

}
