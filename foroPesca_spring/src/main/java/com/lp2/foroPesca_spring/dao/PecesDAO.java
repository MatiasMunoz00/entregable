/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.foroPesca_spring.dao;

import com.lp2.foroPesca_spring.modelo.Peces;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Addis Flerida Muñoz
 */
public interface PecesDAO extends CrudRepository<Peces, Integer> {

    @Override
    List<Peces> findAll();

    public Peces findById(int id);

}
