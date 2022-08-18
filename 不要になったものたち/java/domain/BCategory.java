package domain;

public class BCategory {
	
	private Integer id;
	private String bCategoryName;
	private Integer aCategoryId;
	private String aCategoryName;
	
	public BCategory() {
	}

	public BCategory(Integer id, String bCategoryName, String aCategoryName) {
		super();
		this.id = id;
		this.bCategoryName = bCategoryName;
		this.aCategoryName = aCategoryName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getbCategoryName() {
		return bCategoryName;
	}

	public void setbCategoryName(String bCategoryName) {
		this.bCategoryName = bCategoryName;
	}

	public Integer getaCategoryId() {
		return aCategoryId;
	}

	public void setaCategoryId(Integer aCategoryId) {
		this.aCategoryId = aCategoryId;
	}

	public String getaCategoryName() {
		return aCategoryName;
	}

	public void setaCategoryName(String aCategoryName) {
		this.aCategoryName = aCategoryName;
	}
	

}
