package dao;

import java.util.List;

import domain.UserType;

public interface UserTypeDao {
	
	List<UserType> findAll() throws Exception;
	Integer countTypeId() throws Exception;

}
