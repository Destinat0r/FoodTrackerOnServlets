package org.training.food_tracker.dao;

import java.util.List;

public interface CrudDao<T> {
    
    T create(T t) throws DaoException;
    
    T findById(Long id) throws DaoException;
    
    T update(T t);
    
    List<T> findAll();
    
    void deleteById(Long id);
}
