package br.com.smartorder.productservice.dto;

import br.com.smartorder.productservice.entity.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    public ProductResponseDTO(Product product) {
        this.id = product.getId();
        this.nome = product.getName();
        this.descricao = product.getDescription();
        this.preco = product.getPrice();
    }
}
