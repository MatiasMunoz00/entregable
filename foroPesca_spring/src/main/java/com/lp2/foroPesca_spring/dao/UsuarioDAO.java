/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.foroPesca_spring.dao;

import com.lp2.foroPesca_spring.modelo.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Addis Flerida Muñoz
 */
public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

    @Override
    List<Usuario> findAll();
    public Usuario findByCorreoAndContrasena (String user , String pass);
 
}
