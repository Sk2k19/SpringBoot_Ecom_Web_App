package productservice8apr.productservice8apr.services;

import org.springframework.stereotype.Service;
import productservice8apr.productservice8apr.dtos.product.PatchGetProductResponseDto;
import productservice8apr.productservice8apr.models.Product;

import java.util.List;

@Service
public class ProductServiceDBImpl implements ProductService {
 @Override
 public Product createProduct(Product product){
     return null;
 }
 @Override
    public List<Product> getProducts(){
     return null;
 }
 @Override
    public Product updateProduct(Long id,Product product){
     return null;
 }
}
