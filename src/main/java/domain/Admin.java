package domain;

public class Admin {
	
	private Integer id;
	private String userName;
	private String userPass;
	private Integer typeId;
	private String typeName;
	
	
	public Admin() {
		super();
	}	
	
	public Admin(Integer id, String userName, String userPass, String typeName) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPass = userPass;
		this.typeName = typeName;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	

}
