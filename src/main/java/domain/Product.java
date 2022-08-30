package domain;

import java.util.Date;

public class Product {
	
	private Integer id;
	private String productName;
	private String productUrl;
	private Integer categoryA;
	private Integer img;
	private Date registDate;
	private String registBy;
	private Date updateDate;
	private String updateBy;
	private String categoryAStr;
	
	public Product() {
		
	}
	
	public Product(Integer id, String productName, String productUrl, Integer categoryA,
			Integer img, Date registDate,
			String registBy, Date updateDate, String updateBy) {
		this.id = id;
		this.productName = productName;
		this.productUrl = productUrl;
		this.categoryA = categoryA;
		this.img = img;
		this.registDate = registDate;
		this.registBy = registBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
	}
	
	public Product(Integer id, String productName, String productUrl, String categoryAStr, 
			Integer img, Date registDate,
			String registBy, Date updateDate, String updateBy) {
		this.id = id;
		this.productName = productName;
		this.productUrl = productUrl;
		this.categoryAStr = categoryAStr;
		this.img = img;
		this.registDate = registDate;
		this.registBy = registBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	public Integer getCategoryA() {
		return categoryA;
	}
	public void setCategoryA(Integer categoryA) {
		this.categoryA = categoryA;
	}
	public Integer getImg() {
		return img;
	}
	public void setImg(Integer countImg) {
		this.img = countImg;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public String getRegistBy() {
		return registBy;
	}
	public void setRegistBy(String registBy) {
		this.registBy = registBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getCategoryAStr() {
		return categoryAStr;
	}

	public void setCategoryAStr(String categoryAStr) {
		this.categoryAStr = categoryAStr;
	}

}
