package productservice8apr.productservice8apr.services;

import productservice8apr.productservice8apr.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getProducts();
    Product updateProduct(Long id,Product product);
}
