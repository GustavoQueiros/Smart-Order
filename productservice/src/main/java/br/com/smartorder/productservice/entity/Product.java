package br.com.smartorder.productservice.entity;

import br.com.smartorder.productservice.dto.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static org.springframework.util.ObjectUtils.isEmpty;

@Entity
@Table(name = "PRODUCT")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void updateFields(ProductRequestDTO request) {
        this.name = !isEmpty(request.getName()) ? request.getName() : this.name;
        this.description = !isEmpty(request.getDescription()) ? request.getDescription() : this.description;
        this.price = !isEmpty(request.getPrice()) ? request.getPrice() : this.price;
    }
}