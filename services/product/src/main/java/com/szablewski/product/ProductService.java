package com.szablewski.product;

import com.szablewski.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    Integer createProduct(ProductRequest request) {
        var product = mapper.toProduct(request);

        return repository.save(product).getProductId();
    }

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();

        var storedProducts = repository.findAllByProductIdInOrderByProductId(productIds);

        if (productIds.size() != storedProducts.size()) {
            throw new EntityNotFoundException("One or more products dose not exist");
        }

        var storedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();

        var purchasedProduct = new ArrayList<ProductPurchaseResponse>();

        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storedRequest.get(i);

            if (product.getAvailableQuantity() < productRequest.quantity()) {
                throw new ProductPurchaseException(String.format("Insufficient stock quantity for product with ID:: %s", productRequest.productId()));
            }

            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);

            repository.save(product);
            purchasedProduct.add(mapper.toProductPurchaseResponse(product, productRequest.quantity()));
        }

        log.info("Success product purchased:: {}", purchasedProduct);
        return purchasedProduct;
    }

    ProductResponse findById(Integer productId) {
        return repository.findById(productId)
                .map(mapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product not found withe the ID:: %s", productId)));
    }

    List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .toList();
    }
}
