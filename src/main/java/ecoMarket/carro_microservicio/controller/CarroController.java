package ecoMarket.carro_microservicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ecoMarket.carro_microservicio.model.Carro;
import ecoMarket.carro_microservicio.service.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> getCarros() {

        List<Carro> carros = carroService.findAll();

        if (carros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(carros, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Carro> postCarro(@RequestBody Carro carro) {

        Carro nuevo;

        try {
            nuevo = carroService.save(carro);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarro(@PathVariable Long id) {

        Carro buscado = carroService.findById(id);

        if (buscado == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(buscado, HttpStatus.OK);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<Carro> updateCarro(
            @PathVariable Long id,
            @RequestBody Carro carro) {

        Carro actualizado = carroService.modificar(id, carro);

        if (actualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable Long id) {

        try {
            carroService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

