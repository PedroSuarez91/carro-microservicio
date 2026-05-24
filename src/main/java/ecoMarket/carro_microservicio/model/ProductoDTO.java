package ecoMarket.carro_microservicio.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Long id;
    private String marca;
    private String nombre;
    private int precio;
    private String categoria;

    private int stock_tienda;
    private int stock_catalogo;
    private int stock_inventario;

    private List<String> description;
}
