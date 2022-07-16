package com.example.demo.controllers;

import com.example.demo.models.AutoModel;
import com.example.demo.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("autos") // mapea /autos
public class AutoController {

    @Autowired
    AutoService autoService;

    @CrossOrigin  // Para solucionar error "cors"
    @GetMapping() // Trae todos los autos y lo mapea /autos
    public ArrayList<AutoModel> obtenerAutos(){
        return autoService.obtenerAutos();
    }

    @CrossOrigin
    @PostMapping() // Graba un auto
    public AutoModel guardarAuto(@RequestBody AutoModel auto){
        return this.autoService.guardarAuto(auto);
    }

    @CrossOrigin
    @GetMapping(path = "/{id}") // Trae un auto segun id
    public Optional<AutoModel> obtenerAutoPorId(@PathVariable("id") Long id){
        return this.autoService.obtenerPorId(id);
    }

    @CrossOrigin
    @GetMapping("/query") // Trae los autos con determinada prioridad
    public ArrayList<AutoModel> obtenerAutoPorMarca(@RequestParam("marca") String marca){
        return this.autoService.obtenerPorMarca(marca);
    }

    @CrossOrigin
    @DeleteMapping(path = "/{id}") // Borra un auto con determinado id
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.autoService.eliminarAuto(id);
        if(ok){
            return "Se eliminó el auto con id " + id;
        }else{
            return "No pudo eliminar el auto con id " +id;
        }
    }
}
