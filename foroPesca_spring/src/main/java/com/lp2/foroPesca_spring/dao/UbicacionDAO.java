/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.foroPesca_spring.dao;


import com.lp2.foroPesca_spring.modelo.Ubicacion;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Addis Flerida Muñoz
 */
public interface UbicacionDAO extends CrudRepository<Ubicacion, Integer> {

    @Override
    List<Ubicacion> findAll();
    public Ubicacion findById(int id);
    public List<Ubicacion> findAllById(int i);
}
