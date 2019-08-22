/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Interfaz para ejecutar operaciones CRUD
 *
 * @param <T>
 * @param <Id>
 * @author Patricia Benitez
 */
public interface DaoBase<T, Id extends Serializable> {

    public T save(T obj);
    
    public void save(List<T> lista);

    public T update(T obj);

    public void delete(T obj);

    public boolean contains(T obj);

    public List<T> findAll();

    public List<T> findBy(String field, String value, Boolean isString);

    public T findById(Id id);

    public List<T> executeQuery(String jpql, Object... values);

    public List executeQueryObject(String jpql, Object... values);
    
}
