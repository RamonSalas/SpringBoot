package com.example.SpringBoot4.Controller;

import com.example.SpringBoot4.Entidades.Laptop;
import com.example.SpringBoot4.Repository.LaptopRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class LaptopController {

    private LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopRepository.class);
    private Long id;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
/*
    delete()

    deleteAll()*/

    /* Metodo  findAll() */

    @GetMapping("/laptops")
    @Operation(summary= "Lista de las laptop disponibles")
    public List<Laptop> findAll() {
        //Devolver todos los productos.
        return laptopRepository.findAll();
    }

    /* Metodo findOneById()*/
    @GetMapping("/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@Parameter(description = "Clave primaria tipo Long Id") @PathVariable Long id) {
        this.id = id;
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if (laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return
                    ResponseEntity.notFound().build();

    }


    /* Metodo  create */
    @PostMapping("/laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (laptop.getId() != null) {
            log.warn("El Producto ya existe.Metodo equivocado");

            System.out.println("El Producto ya existe.Metodo equivocado");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    /* Metodo update*/
    @PutMapping("/laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {

        if (laptop.getId() == null) { //no tiene id , seria una creacion.
            log.warn("El Producto no existe, no se puede actualizar.Metodo equivocado");
            System.out.println("El Producto no existe, no se puede actualizar.Metodo equivocado");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("El Producto no existe, no se puede actualizar.Metodo equivocado");
            System.out.println("El Producto no existe, no se puede actualizar.Metodo equivocado");
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    /*Metodo  delete() */
    @DeleteMapping("/laptop/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {
        if (!laptopRepository.existsById(id)) {
            log.warn("El Producto no existe, no se puede Eliminar.");
            System.out.println("El Producto no existe, no se puede Eliminar.");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/laptops")
    public ResponseEntity<Laptop> deleteall() {
        if (laptopRepository.count()==0) {
            log.warn("No existe data en la bd, no se puede Eliminar.");
            System.out.println("No existe data en la bd, no se puede Eliminar.");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }
}
