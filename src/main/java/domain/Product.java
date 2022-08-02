package domain;

import java.util.Date;

public class Product {
	
	private Integer id;
	private String productName;
	public Product(Integer id, String productName, String productUrl, Integer categoryA, Integer categoryB01,
			Integer categoryB02, Integer categoryB03, String imgMain, String imgSub01, String imgSub02, String imgSub03,
			String imgSub04, String imgSub05, String imgSub06, String imgSub07, String imgSub08, Date registDate,
			Integer registBy, Date updateDate, Integer updateBy) {
		super();
		this.id = id;
		this.productName = productName;
		this.productUrl = productUrl;
		this.categoryA = categoryA;
		this.categoryB01 = categoryB01;
		this.categoryB02 = categoryB02;
		this.categoryB03 = categoryB03;
		this.imgMain = imgMain;
		this.imgSub01 = imgSub01;
		this.imgSub02 = imgSub02;
		this.imgSub03 = imgSub03;
		this.imgSub04 = imgSub04;
		this.imgSub05 = imgSub05;
		this.imgSub06 = imgSub06;
		this.imgSub07 = imgSub07;
		this.imgSub08 = imgSub08;
		this.registDate = registDate;
		this.registBy = registBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
	}
	
	private String productUrl;
	private Integer categoryA;
	private Integer categoryB01;
	private Integer categoryB02;
	private Integer categoryB03;
	private String imgMain;
	private String imgSub01;
	private String imgSub02;
	private String imgSub03;
	private String imgSub04;
	private String imgSub05;
	private String imgSub06;
	private String imgSub07;
	private String imgSub08;
	private Date registDate;
	private Integer registBy;
	private Date updateDate;
	private Integer updateBy;
	
	public Product() {
		
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
	public Integer getCategoryB01() {
		return categoryB01;
	}
	public void setCategoryB01(Integer categoryB01) {
		this.categoryB01 = categoryB01;
	}
	public Integer getCategoryB02() {
		return categoryB02;
	}
	public void setCategoryB02(Integer categoryB02) {
		this.categoryB02 = categoryB02;
	}
	public Integer getCategoryB03() {
		return categoryB03;
	}
	public void setCategoryB03(Integer categoryB03) {
		this.categoryB03 = categoryB03;
	}
	public String getImgMain() {
		return imgMain;
	}
	public void setImgMain(String imgMain) {
		this.imgMain = imgMain;
	}
	public String getImgSub01() {
		return imgSub01;
	}
	public void setImgSub01(String imgSub01) {
		this.imgSub01 = imgSub01;
	}
	public String getImgSub02() {
		return imgSub02;
	}
	public void setImgSub02(String imgSub02) {
		this.imgSub02 = imgSub02;
	}
	public String getImgSub03() {
		return imgSub03;
	}
	public void setImgSub03(String imgSub03) {
		this.imgSub03 = imgSub03;
	}
	public String getImgSub04() {
		return imgSub04;
	}
	public void setImgSub04(String imgSub04) {
		this.imgSub04 = imgSub04;
	}
	public String getImgSub05() {
		return imgSub05;
	}
	public void setImgSub05(String imgSub05) {
		this.imgSub05 = imgSub05;
	}
	public String getImgSub06() {
		return imgSub06;
	}
	public void setImgSub06(String imgSub06) {
		this.imgSub06 = imgSub06;
	}
	public String getImgSub07() {
		return imgSub07;
	}
	public void setImgSub07(String imgSub07) {
		this.imgSub07 = imgSub07;
	}
	public String getImgSub08() {
		return imgSub08;
	}
	public void setImgSub08(String imgSub08) {
		this.imgSub08 = imgSub08;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Integer getRegistBy() {
		return registBy;
	}
	public void setRegistBy(Integer registBy) {
		this.registBy = registBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

}