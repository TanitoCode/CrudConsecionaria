package com.example.demo.repositories;

import com.example.demo.models.AutoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AutoRepository extends CrudRepository<AutoModel, Long> {

    //CrudRepository hace toda la magia de Spring
    //***********2da etapa***************

    public abstract ArrayList<AutoModel> findByMarca(String marca);

}
