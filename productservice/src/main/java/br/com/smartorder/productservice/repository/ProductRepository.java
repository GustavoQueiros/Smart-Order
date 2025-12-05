package br.com.smartorder.productservice.repository;

import br.com.smartorder.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

