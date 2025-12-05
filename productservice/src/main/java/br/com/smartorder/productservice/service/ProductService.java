package br.com.smartorder.productservice.service;

import br.com.smartorder.productservice.dto.ProductRequestDTO;
import br.com.smartorder.productservice.dto.ProductResponseDTO;
import br.com.smartorder.productservice.entity.Product;
import br.com.smartorder.productservice.exception.ProductNotFoundException;
import br.com.smartorder.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public ProductResponseDTO create(ProductRequestDTO request) {
        return new ProductResponseDTO(repository.save(request.toEntity()));
    }

    public List<ProductResponseDTO> list() {
        return repository.findAll().stream()
                .map(ProductResponseDTO::new)
                .toList();
    }

    public ProductResponseDTO getById(Long id) throws ProductNotFoundException {
        return repository.findById(id)
                .map(ProductResponseDTO::new)
                .orElseThrow(ProductNotFoundException::new);
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO request) throws ProductNotFoundException {
        Product product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
        product.updateFields(request);
        return new ProductResponseDTO(repository.save(product));
    }

    public void delete(Long id) throws ProductNotFoundException {
        Product product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
        repository.delete(product);
    }
}
