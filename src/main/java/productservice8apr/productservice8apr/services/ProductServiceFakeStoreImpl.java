package productservice8apr.productservice8apr.services;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import productservice8apr.productservice8apr.models.Product;

@Service("ProductServiceFakeStoreImpl")
//@Primary  -- its one way to solve conflict in multiple services

public class ProductServiceFakeStoreImpl implements ProductService {
     @Override
     public Product createProduct(Product product) {
         return null;
     }
}
