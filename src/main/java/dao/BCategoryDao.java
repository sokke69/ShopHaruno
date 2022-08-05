package dao;

import java.util.List;

import domain.BCategory;

public interface BCategoryDao {
	
	List<BCategory> findAll() throws Exception;
	BCategory findById(Integer id) throws Exception;
	void insert(BCategory bCategory) throws Exception;
	void update(BCategory bCategory) throws Exception;
	void delete(BCategory bCategory) throws Exception;

}
