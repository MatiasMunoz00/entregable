package com.lp2.foroPesca_spring.dao;


import com.lp2.foroPesca_spring.modelo.Aguas;
import com.lp2.foroPesca_spring.modelo.Peces;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AguasDAO extends CrudRepository<Aguas, Integer> {
    
    @Override
    List<Aguas> findAll();
    public List<Aguas> findAllById(int i);
 
}
