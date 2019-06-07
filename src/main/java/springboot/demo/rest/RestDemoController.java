package springboot.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.demo.model.Persona;
import springboot.demo.repo.IPersonaRepo;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class RestDemoController {

    @Autowired
    private IPersonaRepo repo;
    @GetMapping
    public List<Persona> listar(){
        return repo.findAll();
    }

    @PostMapping
    public void insertar(@RequestBody Persona persona){ //con request body tomar el json y convertirlo en un objeto java
        repo.save(persona);
    }

    @PutMapping
    public void modificar(@RequestBody Persona persona){ //con request body tomar el json y convertirlo en un objeto java
        repo.save(persona);
    }
    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable("id") Integer id){ //PathVariable podemos capturar el id que se le pasa por url
        repo.deleteById(id);
    }


}
