package productservice8apr.productservice8apr.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name ;
    private String description;
    @OneToMany
    private List<Product> topProducts;
    @OneToMany(mappedBy ="category")
    private List<Product> AllProducts;


}
