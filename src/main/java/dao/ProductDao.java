package dao;

import java.util.List;

import domain.Product;

public interface ProductDao {
	
	List<Product> findAll() throws Exception;
	List<Product> findAllDesc() throws Exception;
	Product findById(Integer id) throws Exception;
	List<Product> findByAId(Integer id) throws Exception;
	List<Product> findByAIdDesc(Integer id) throws Exception;
	void insert(Product product) throws Exception;
	void update(Product product) throws Exception;
	void delete(Product product) throws Exception;
	Integer findLatestIdPlusOne() throws Exception;
	Integer findAIdById(Integer id) throws Exception;
	Integer countId() throws Exception;
	Integer findCountImg(Integer id) throws Exception;
}
