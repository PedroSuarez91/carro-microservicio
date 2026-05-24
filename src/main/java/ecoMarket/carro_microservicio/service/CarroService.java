package ecoMarket.carro_microservicio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecoMarket.carro_microservicio.model.Carro;
import ecoMarket.carro_microservicio.model.ProductoDTO;
import ecoMarket.carro_microservicio.repository.CarroRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ProductoClientService productoClientService;

    public Carro save(Carro carro) {
        return carroRepository.save(carro);
    }

    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    public Carro findById(Long id) {
        return carroRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        carroRepository.deleteById(id);
    }

    public Carro agregarProductoAlCarro(Long idCarro, Long idProducto) {

        Carro carro = carroRepository.findById(idCarro).orElse(null);

        if (carro == null) {
            throw new RuntimeException("El carro no existe");
        }

        ProductoDTO producto = productoClientService.obtenerProductoPorId(idProducto);

        if (producto == null) {
            throw new RuntimeException("El producto no existe");
        }

        if (producto.getStock_catalogo() <= 0) {
            throw new RuntimeException("El producto no tiene stock disponible");
        }

        if (carro.getListaProductos() == null) {
            carro.setListaProductos(new ArrayList<>());
        }

        carro.getListaProductos().add(producto.getId());

        carro.setSubtotal(carro.getSubtotal() + producto.getPrecio());
        carro.setTotal(carro.getSubtotal());

        return carroRepository.save(carro);
    }
}