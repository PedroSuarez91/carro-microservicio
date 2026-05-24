package ecoMarket.carro_microservicio.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ecoMarket.carro_microservicio.model.ProductoDTO;

@Service
public class ProductoClientService {

    @Value("${producto.service.url}")
    private String productoServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public ProductoDTO obtenerProductoPorId(Long idProducto) {
        String url = productoServiceUrl + "/" + idProducto;
        return restTemplate.getForObject(url, ProductoDTO.class);
    }
}
