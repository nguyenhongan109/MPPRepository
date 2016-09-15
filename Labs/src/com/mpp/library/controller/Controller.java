package com.mpp.library.controller;

import com.mpp.library.dataaccess.DataAccess;
import com.mpp.library.dataaccess.DataAccessImpl;
import com.mpp.library.entity.Entity;

abstract class Controller<E extends Entity> {
	public DataAccess<String, E> entitys = new DataAccessImpl<>();
	
	public Controller() {
		super();
	}
	
	
	public E save(E entity) {
		return entitys.add(entity.getID(), entity);
	}

	
	public E update(String key, E entity) {
		return entitys.update(key, entity);
	}

	
	public E get(String key) {
		return entitys.get(key);
	}

	
	public E delete(String key) {
		return entitys.delete(key);	
	}

}