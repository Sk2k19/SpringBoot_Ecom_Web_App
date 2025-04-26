package productservice8apr.productservice8apr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import productservice8apr.productservice8apr.models.Product;

import java.util.List;
import java.util.Optional;

public interface productRepository extends JpaRepository<Product,Long> {

//  save method use for both create/update
//    if product id is exist then it update that product otherwise it just create

    @Override
    Product save(Product product);
    
   @Override
    void deleteById(Long id);

    List<Product> findAll();

    @Override
    Optional<Product> findById(Long id);
}
