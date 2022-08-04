package domain;

public class ACategory {
	
	private Integer id;
	private String aCategoryName;
	
	public ACategory() {
	}

	public ACategory(Integer id, String aCategoryName) {
		super();
		this.id = id;
		this.aCategoryName = aCategoryName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getaCategoryName() {
		return aCategoryName;
	}

	public void setaCategoryName(String aCategoryName) {
		this.aCategoryName = aCategoryName;
	}
	
}
