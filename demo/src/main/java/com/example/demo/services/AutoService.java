package com.example.demo.services;

import com.example.demo.models.AutoModel;
import com.example.demo.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AutoService {
    @Autowired
    AutoRepository autoRepository;
    public ArrayList<AutoModel> obtenerAutos(){
        return (ArrayList<AutoModel>)  autoRepository.findAll();
        // findAll método de CrudRepository
    }
    public AutoModel guardarAuto(AutoModel auto){
        return autoRepository.save(auto); //save método de CrudRepository
    }//************** 2da etapa
    public Optional<AutoModel> obtenerPorId(Long id){
        return autoRepository.findById(id);
    }
    public ArrayList<AutoModel> obtenerPorMarca(String marca){
        return autoRepository.findByMarca(marca);
    }
    public boolean eliminarAuto(Long id){
        try{
            autoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
