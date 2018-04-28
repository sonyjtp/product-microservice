package com.myretail.product.service;

import java.util.List;

import com.myretail.product.exception.MyRetailException;

public interface MyRetailService<T, ID> {

	List<T> findAll() throws MyRetailException;

	T find(ID id)  throws MyRetailException;

	void create(T t)  throws MyRetailException;

	void save(T t)  throws MyRetailException;

	void delete(T t)  throws MyRetailException;

	boolean exists(ID id)  throws MyRetailException;

}
