package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import domain.Product;

public class ProductDaoImpl implements ProductDao{
	
	private DataSource ds;
	
	public ProductDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Product> findAll() throws Exception {
		List<Product> productList = new ArrayList<>();
		
		try (Connection con = ds.getConnection()){
			String sql = "SELECT"
					+ " products.id, product_name, product_url,"
					+ " as_categories.a_category_name AS a_category_name,"
					+ " img, "
					+ " regist_date, regist_by, update_date, update_by"
					+ " FROM products"
					+ " LEFT JOIN as_categories ON products.category_a = as_categories.id";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				productList.add(mapToProduct2(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return productList;
	}
	
	@Override
	public List<Product> findAllDesc() throws Exception {
		List<Product> productList = new ArrayList<>();
		
		try (Connection con = ds.getConnection()){
			String sql = "SELECT"
					+ " products.id, product_name, product_url,"
					+ " as_categories.a_category_name AS a_category_name,"
					+ " img, "
					+ " regist_date, regist_by, update_date, update_by"
					+ " FROM products"
					+ " LEFT JOIN as_categories ON products.category_a = as_categories.id"
					+ " ORDER BY id DESC";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				productList.add(mapToProduct2(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return productList;
	}
	
	@Override
	public List<Product> findByAId(Integer id) throws Exception {
		List<Product> productList = new ArrayList<>();
		try (Connection con = ds.getConnection()){
			String sql = "SELECT"
					+ " products.id, product_name, product_url,"
					+ " as_categories.a_category_name AS a_category_name,"
					+ " img, "
					+ " regist_date, regist_by, update_date, update_by"
					+ " FROM products"
					+ " LEFT JOIN as_categories ON products.category_a = as_categories.id"
					+ " WHERE category_a=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				productList.add(mapToProduct2(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return productList;
	}
	
	@Override
	public List<Product> findByAIdDesc(Integer id) throws Exception {
		List<Product> productList = new ArrayList<>();
		try (Connection con = ds.getConnection()){
			String sql = "SELECT"
					+ " products.id, product_name, product_url,"
					+ " as_categories.a_category_name AS a_category_name,"
					+ " img, "
					+ " regist_date, regist_by, update_date, update_by"
					+ " FROM products"
					+ " LEFT JOIN as_categories ON products.category_a = as_categories.id"
					+ " WHERE category_a=?"
					+ " ORDER BY id DESC";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				productList.add(mapToProduct2(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return productList;
	}

	
	private Product mapToProduct(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		String productName = rs.getString("product_name");
		String productUrl = rs.getString("product_url");
		Integer categoryA = (Integer) rs.getObject("category_a");
		Integer img = (Integer) rs.getObject("img");
		Date registDate = rs.getTimestamp("regist_date");
		String registBy = rs.getString("regist_by");
		Date updateDate = rs.getTimestamp("update_date");
		String updateBy = rs.getString("update_by");
		
		return new Product(id, productName, productUrl, categoryA,
				img,
				registDate, registBy, updateDate, updateBy);
	}
	
	private Product mapToProduct2(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		String productName = rs.getString("product_name");
		String productUrl = rs.getString("product_url");
		String categoryA = rs.getString("a_category_name");
		Integer img = (Integer) rs.getObject("img");
		Date registDate = rs.getTimestamp("regist_date");
		String registBy = rs.getString("regist_by");
		Date updateDate = rs.getTimestamp("update_date");
		String updateBy = rs.getString("update_by");
		
		return new Product(id, productName, productUrl, categoryA,
				img,
				registDate, registBy, updateDate, updateBy);
	}
	
	@Override
	public Product findById(Integer id) throws Exception {
		Product product = new Product();
		
		try (Connection con = ds.getConnection()){
			String sql = "SELECT"
					+ " products.id, product_name, product_url,"
					+ " as_categories.a_category_name AS a_category_name,"
					+ " bs_categories.b_category_name AS b_category_name,"
					+ " img, "
					+ " regist_date, regist_by, update_date, update_by"
					+ " FROM products"
					+ " LEFT JOIN as_categories ON products.category_a = as_categories.id"
					+ " LEFT JOIN bs_categories ON products.category_b = bs_categories.a_category_id"
					+ " WHERE products.id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product = mapToProduct2(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		
		return product;
	}

	@Override
	public void insert(Product product) throws Exception {
		try (Connection con = ds.getConnection()){
			//あとで追加したい：category_a, category_b01, category_b02, category_b03,regist_by
			String sql = "INSERT INTO"
					+ " products (product_name, product_url,category_a, img, regist_date, regist_by)"
					+ " VALUES (?, ?, ?, ?, NOW() , ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getProductUrl());
			stmt.setObject(3, product.getCategoryA(),Types.INTEGER);
			stmt.setObject(4, product.getImg(),Types.INTEGER);
			stmt.setString(5, product.getRegistBy());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void update(Product product) throws Exception {
		try (Connection con = ds.getConnection()){
			String sql = "UPDATE products SET"
					+ " product_name=?, product_url=?,"
					+ " category_a=?,"
					+ " update_date= NOW(), update_by=?"
					+ " WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getProductUrl());
			stmt.setObject(3, product.getCategoryA(),Types.INTEGER);
			stmt.setString(4, product.getUpdateBy());
			stmt.setObject(5, product.getId(),Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void delete(Product product) throws Exception {
		try (Connection con = ds.getConnection()){
			String sql = "DELETE FROM products WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, product.getId(),Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Integer findLatestIdPlusOne() throws Exception {
		Integer latestId = null;
		Integer latestIdPlusOne = null;
		
		try (Connection con = ds.getConnection()){
			String sql = "SELECT MAX(id) from products";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Object object = rs.getObject("MAX(id)");
				if (object == null) {
					latestIdPlusOne = 1;
					return latestIdPlusOne;
				}
				latestId = (Integer) object;
				latestIdPlusOne = latestId + 1;
			}
			
		} catch (Exception e) {
			throw e;
		}
		return latestIdPlusOne;
	}

	@Override
	public Integer findAIdById(Integer id) throws Exception {
		Integer aId = null;
		try (Connection con = ds.getConnection()){
			String sql = "SELECT category_a FROM products WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				aId = (Integer) rs.getObject("category_a");
				return aId;
			}
		} catch (Exception e) {
			throw e;
		}
		return aId;
	}

	@Override
	public Integer countId() throws Exception {
		Integer countedId;
		try (Connection con = ds.getConnection()){
			String sql = "SELECT COUNT(id) FROM products";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Object object = rs.getObject("COUNT(id)");
				String countTypeIdStr = object.toString();
				countedId = Integer.parseInt(countTypeIdStr);
				return countedId;
			}
			} catch (Exception e) {
			throw e;
		}
		
		return null;
	}
	
}
