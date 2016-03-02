/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.repository;

import java.util.List;

/**
 *
 * @author Irbis
 */
public interface GenericRepository<T> {
    T findById(Integer id);
    T save(T entity);
    List<T> findAll();
    void delete(T entity);
}
