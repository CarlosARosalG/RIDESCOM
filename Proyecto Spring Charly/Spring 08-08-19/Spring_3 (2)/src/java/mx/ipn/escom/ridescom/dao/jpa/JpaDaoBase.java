/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.dao.jpa;

import mx.ipn.escom.ridescom.dao.DaoBase;
import mx.ipn.escom.ridescom.model.Alumno;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.logging.Level;
import javax.management.Query;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import mx.ipn.escom.ridescom.model.BaseEntity;

/**
 * Implementacion para ejecutar operaciones CRUD
 *
 * @author Patricia Benitez
 * @param <T>
 * @param <Id>
 */
@Transactional
public class JpaDaoBase<T extends BaseEntity, Id extends Serializable> implements DaoBase<T, Id>{
    
    protected Class<T> clase;
    protected EntityManager entityManager;
    protected static Logger writeFileLog = LogManager.getLogger(JpaDaoBase.class.getName());

    public static Logger getWriteFileLog() {
        return writeFileLog;
    }

    public static void setWriteFileLog(Logger writeFileLog) {
        JpaDaoBase.writeFileLog = writeFileLog;
    }
    protected String Query;
    
    /**
     * {@inheritDoc}
     *
     * @param jpql
     * @param values
     * @return
     */

    @Override
    public T save(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(List<T> lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T update(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> findBy(String field, String value, Boolean isString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findById(Id id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List executeQueryObject(String jpql, Object... values) {
        javax.persistence.Query q = entityManager.createQuery(jpql);
        int i = 1;
        for (Object object : values) {
            q.setParameter(i, object);
            i++;
        }
        List<T> result = (List<T>) q.getResultList();
        return result;
    }

    @Override
    public List<T> executeQuery(String jpql, Object... values) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
