package ecoMarket.carro_microservicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecoMarket.carro_microservicio.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    
}
