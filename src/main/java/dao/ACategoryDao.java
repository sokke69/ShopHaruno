package dao;

import java.util.List;

import domain.ACategory;

public interface ACategoryDao {
	
	List<ACategory> findAll() throws Exception;
	ACategory findById(Integer id) throws Exception;
	void insert(ACategory aCategory) throws Exception;
	void update(ACategory aCategory) throws Exception;
	void delete(ACategory aCategory) throws Exception;
	Integer countAId() throws Exception;
}
