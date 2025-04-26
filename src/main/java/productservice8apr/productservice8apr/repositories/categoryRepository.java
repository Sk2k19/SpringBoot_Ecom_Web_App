package productservice8apr.productservice8apr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import productservice8apr.productservice8apr.models.Category;

import java.util.Optional;

public interface categoryRepository extends JpaRepository<Category, Long> {
//    @Override
////    Optional<Category> findById(Long aLong);

    Optional<Category> findByName(String name);
    Category save(Category category);
}
