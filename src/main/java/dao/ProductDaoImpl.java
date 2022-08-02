package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		Integer categoryB01 = (Integer) rs.getObject("category_b01");
		Integer categoryB02 = (Integer) rs.getObject("category_b02");
		Integer categoryB03 = (Integer) rs.getObject("category_b03");
		String imgMain = rs.getString("img_main");
		String imgSub01 = rs.getString("img_sub01");
		String imgSub02 = rs.getString("img_sub02");
		String imgSub03 = rs.getString("img_sub03");
		String imgSub04 = rs.getString("img_sub04");
		String imgSub05 = rs.getString("img_sub05");
		String imgSub06 = rs.getString("img_sub06");
		String imgSub07 = rs.getString("img_sub07");
		String imgSub08 = rs.getString("img_sub08");
		Date registDate = rs.getDate("regist_date");
		Integer registBy = (Integer) rs.getObject("regist_by");
		Date updateDate = rs.getDate("update_date");
		Integer updateBy = (Integer) rs.getObject("update_by");
		
		return new Product(id, productName, productUrl, categoryA, categoryB01, categoryB02, categoryB03,
				imgMain, imgSub01, imgSub02, imgSub03, imgSub04, imgSub05, imgSub06, imgSub07, imgSub08,
				registDate, registBy, updateDate, updateBy);
	}
	
	
	@Override
	public Product findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Product product) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void update(Product product) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void delete(Product product) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
