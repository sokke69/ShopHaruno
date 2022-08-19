package domain;

public class UserType {
	
	private Integer id;
	private String typeName;
	
	public UserType(Integer id, String typeName) {
		this.id = id;
		this.typeName = typeName;
	}

	public UserType() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	

}
