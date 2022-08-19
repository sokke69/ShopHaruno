package dao;

import java.util.List;

import domain.Admin;

public interface AdminDao {
	
	List<Admin> findAll() throws Exception;
	Admin findById(Integer id) throws Exception;
	Admin findById2(Integer id) throws Exception;
	Integer findTypeIdById(Integer id) throws Exception;
	void insert(Admin admin) throws Exception;
	void update(Admin admin) throws Exception;
	void delete(Admin admin) throws Exception;
	Admin findByLoginIdAndLoginPass(String userId, String userPass) throws Exception;

}
