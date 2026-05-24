package ecoMarket.carro_microservicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecoMarket.carro_microservicio.model.Carro;
import ecoMarket.carro_microservicio.repository.CarroRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public Carro save(Carro carro) {
        return carroRepository.save(carro);
    }

    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    public Carro findById(Long id) {
        return carroRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        carroRepository.deleteById(id);
    }

    /*public Carro modificar(Long id, Carro carro) {

        Carro existente = carroRepository.findById(id).orElse(null);

        if (existente != null) {

            existente.setTotal(carro.getTotal());
            existente.setSubtotal(carro.getSubtotal());
            existente.setListaProductos(carro.getListaProductos());

            return carroRepository.save(existente);
        }

        return null;
    }*/
}