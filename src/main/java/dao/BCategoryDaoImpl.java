package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.BCategory;

public class BCategoryDaoImpl implements BCategoryDao{
	
	private DataSource ds;
	
	public BCategoryDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<BCategory> findAll() throws Exception {
		List<BCategory> bCategoryList = new ArrayList<>();
		try (Connection con = ds.getConnection()){
			String sql = "SELECT "
					+ " bs_categories.id, b_category_name, as_categories.a_category_name as a_category_name"
					+ " FROM bs_categories "
					+ " JOIN as_categories"
					+ " ON bs_categories.a_category_id = as_categories.id"
					+ " ORDER BY bs_categories.id ASC";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				bCategoryList.add(mapToBCategory(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		//System.out.println("bCategoryListのsize()は" + bCategoryList.size() + "です。");
		return bCategoryList;
	}

	@Override
	public BCategory findById(Integer id) throws Exception {
		BCategory bCategory = new BCategory();
		try (Connection con = ds.getConnection()){
			String sql = "SELECT"
					+ " bs_categories.id, b_category_name, as_categories.a_category_name as a_category_name"
					+ " FROM bs_categories "
					+ " JOIN as_categories"
					+ " ON bs_categories.a_category_id = as_categories.id"
					+ " WHERE bs_categories.id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				bCategory = mapToBCategory(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return bCategory;
	}
	
	public List<BCategory> pickByAId(Integer id) throws Exception{
		List<BCategory> bCategoryListByAId = new ArrayList<>();
		try (Connection con = ds.getConnection()){
			String sql = "SELECT"
					+ " bs_categories.id, b_category_name, as_categories.a_category_name as a_category_name"
					+ " FROM bs_categories "
					+ " JOIN as_categories"
					+ " ON bs_categories.a_category_id = as_categories.id"
					+ " WHERE bs_categories.a_category_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				bCategoryListByAId.add(mapToBCategory(rs));
			}
			
		} catch (Exception e) {
			throw e;
		}
		//System.out.println("pickByAIdでid=" + id + "のbCategoryListを返します。");
		//System.out.println("bCategoryListのsize()は" + bCategoryListByAId.size() + "です。");
		return bCategoryListByAId;
		
	}

	@Override
	public void insert(BCategory bCategory) throws Exception {
		try (Connection con = ds.getConnection()){
			String sql = "INSERT INTO bs_categories (b_category_name, a_category_id) values (?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, bCategory.getbCategoryName());
			stmt.setObject(1, bCategory.getaCategoryId());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(BCategory bCategory) throws Exception {
		try (Connection con = ds.getConnection()){
			String sql = "UPDATE bs_categories SET b_category_name=?, a_category_id=? WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, bCategory.getbCategoryName());
			stmt.setObject(1, bCategory.getaCategoryId());
			stmt.setObject(3, bCategory.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void delete(BCategory bCategory) throws Exception {
		try (Connection con = ds.getConnection()){
			String sql = "DELETE FROM bs_categories WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, bCategory.getId(),Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public BCategory  mapToBCategory(ResultSet rs) throws Exception {
		BCategory bCategory = new BCategory();
		bCategory.setId((Integer)rs.getObject("id"));
		bCategory.setbCategoryName(rs.getString("b_category_name"));
		bCategory.setaCategoryName(rs.getString("a_category_name"));
		return bCategory;
	}

}
