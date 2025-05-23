package productservice8apr.productservice8apr.dtos.product;

import lombok.Getter;
import lombok.Setter;
import productservice8apr.productservice8apr.models.Category;
import productservice8apr.productservice8apr.models.Product;

@Getter
@Setter
public class CreateProductRequestDto {
    String title;
    String description;
    Double price;
    String categoryName;
    String imageUrl;

    public Product toProduct(){
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        Category newCategory = new Category();
        newCategory.setName(this.categoryName);
        product.setCategory(newCategory);
        product.setImageUrl(this.imageUrl);
        return product;
    }

}
