package domain;

import java.util.Date;

public class Product {
	
	private Integer id;
	private String productName;
	private String productUrl;
	private Integer categoryA;
	private Integer categoryB;
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
	private String categoryAStr;
	private String categoryBStr;
	
	public Product() {
		
	}
	
	public Product(Integer id, String productName, String productUrl, Integer categoryA, Integer categoryB,
			String imgMain, String imgSub01, String imgSub02, String imgSub03,
			String imgSub04, String imgSub05, String imgSub06, String imgSub07, String imgSub08, Date registDate,
			Integer registBy, Date updateDate, Integer updateBy) {
		super();
		this.id = id;
		this.productName = productName;
		this.productUrl = productUrl;
		this.categoryA = categoryA;
		this.categoryB = categoryB;
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
	
	public Product(Integer id, String productName, String productUrl, String categoryAStr, String categoryBStr,
			String imgMain, String imgSub01, String imgSub02, String imgSub03,
			String imgSub04, String imgSub05, String imgSub06, String imgSub07, String imgSub08, Date registDate,
			Integer registBy, Date updateDate, Integer updateBy) {
		super();
		this.id = id;
		this.productName = productName;
		this.productUrl = productUrl;
		this.categoryAStr = categoryAStr;
		this.categoryBStr = categoryBStr;
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
	public Integer getCategoryB() {
		return categoryB;
	}
	public void setCategoryB(Integer categoryB01) {
		this.categoryB = categoryB01;
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

	public String getCategoryAStr() {
		return categoryAStr;
	}

	public void setCategoryAStr(String categoryAStr) {
		this.categoryAStr = categoryAStr;
	}

	public String getCategoryBStr() {
		return categoryBStr;
	}

	public void setCategoryBStr(String categoryBStr) {
		this.categoryBStr = categoryBStr;
	}

}
