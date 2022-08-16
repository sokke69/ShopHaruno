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
			String sql = "SELECT * FROM products";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				productList.add(mapToProduct(rs));
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
		Integer categoryB = (Integer) rs.getObject("category_b");
		String imgMain = rs.getString("img_main");
		String imgSub01 = rs.getString("img_sub01");
		String imgSub02 = rs.getString("img_sub02");
		String imgSub03 = rs.getString("img_sub03");
		String imgSub04 = rs.getString("img_sub04");
		String imgSub05 = rs.getString("img_sub05");
		String imgSub06 = rs.getString("img_sub06");
		String imgSub07 = rs.getString("img_sub07");
		String imgSub08 = rs.getString("img_sub08");
		Date registDate = rs.getTimestamp("regist_date");
		String registBy = rs.getString("regist_by");
		Date updateDate = rs.getTimestamp("update_date");
		String updateBy = rs.getString("update_by");
		
		return new Product(id, productName, productUrl, categoryA, categoryB,
				imgMain, imgSub01, imgSub02, imgSub03, imgSub04, imgSub05, imgSub06, imgSub07, imgSub08,
				registDate, registBy, updateDate, updateBy);
	}
	
	private Product mapToProduct2(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		String productName = rs.getString("product_name");
		String productUrl = rs.getString("product_url");
		String categoryA = rs.getString("a_category_name");
		String categoryB = rs.getString("b_category_name");
		String imgMain = rs.getString("img_main");
		String imgSub01 = rs.getString("img_sub01");
		String imgSub02 = rs.getString("img_sub02");
		String imgSub03 = rs.getString("img_sub03");
		String imgSub04 = rs.getString("img_sub04");
		String imgSub05 = rs.getString("img_sub05");
		String imgSub06 = rs.getString("img_sub06");
		String imgSub07 = rs.getString("img_sub07");
		String imgSub08 = rs.getString("img_sub08");
		Date registDate = rs.getTimestamp("regist_date");
		String registBy = rs.getString("regist_by");
		Date updateDate = rs.getTimestamp("update_date");
		String updateBy = rs.getString("update_by");
		
		return new Product(id, productName, productUrl, categoryA, categoryB,
				imgMain, imgSub01, imgSub02, imgSub03, imgSub04, imgSub05, imgSub06, imgSub07, imgSub08,
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
					+ " img_main, img_sub01, img_sub02, img_sub03, img_sub04, "
					+ " img_sub05, img_sub06, img_sub07, img_sub08, "
					+ " regist_date, regist_by, update_date, update_by"
					+ " FROM products"
					+ " LEFT JOIN as_categories ON products.category_a = as_categories.id"
					+ " LEFT JOIN bs_categories ON products.category_b = bs_categories.a_category_id"
					+ " WHERE products.id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
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
					+ " products (product_name, product_url,category_a, img_main, img_sub01, img_sub02, img_sub03, img_sub04,"
					+ " img_sub05, img_sub06, img_sub07, img_sub08, regist_date, regist_by)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW() , ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getProductUrl());
			stmt.setObject(3, product.getCategoryA(),Types.INTEGER);
			stmt.setString(4, product.getImgMain());
			stmt.setString(5, product.getImgSub01());
			stmt.setString(6, product.getImgSub02());
			stmt.setString(7, product.getImgSub03());
			stmt.setString(8, product.getImgSub04());
			stmt.setString(9, product.getImgSub05());
			stmt.setString(10, product.getImgSub06());
			stmt.setString(11, product.getImgSub07());
			stmt.setString(12, product.getImgSub08());
			stmt.setString(13, product.getRegistBy());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void update(Product product) throws Exception {
		try (Connection con = ds.getConnection()){
			String sql = "UPDATE products SET"
					+ " product_name=?, product_url=?, img_main=?,"
					+ " img_sub01=?, img_sub02=?, img_sub03=?, img_sub04=?, img_sub05=?, img_sub06=?, img_sub07=?, img_sub08=?,"
					+ " update_date= NOW(), update_by=?"
					+ " WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getProductUrl());
			stmt.setString(3, product.getImgMain());
			stmt.setString(4, product.getImgSub01());
			stmt.setString(5, product.getImgSub02());
			stmt.setString(6, product.getImgSub03());
			stmt.setString(7, product.getImgSub04());
			stmt.setString(8, product.getImgSub05());
			stmt.setString(9, product.getImgSub06());
			stmt.setString(10, product.getImgSub07());
			stmt.setString(11, product.getImgSub08());
			stmt.setString(12, product.getUpdateBy());
			stmt.setObject(13, product.getId(),Types.INTEGER);
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
				latestId = (Integer)rs.getObject("MAX(id)");
				latestIdPlusOne = latestId + 1;
			}
			
		} catch (Exception e) {
			throw e;
		}
		return latestIdPlusOne;
	}

}
