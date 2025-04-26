package productservice8apr.productservice8apr.dtos.product;

import lombok.Getter;
import lombok.Setter;
import productservice8apr.productservice8apr.models.Category;
import productservice8apr.productservice8apr.models.Product;

import java.util.Optional;
@Getter
@Setter
public class UpdateProductDto {
    private String title;
    private String description;
    private Double price;
    private String category;
    private String imageUrl;
    public Product toProduct(){
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        if(this.category != null && !this.category.isEmpty()){
            Category category1 = new Category();
            category1.setName(this.category);
            product.setCategory(category1);
        }
//        product.setCategory(category);
        product.setImageUrl(this.imageUrl);
        return product;
    }

}
