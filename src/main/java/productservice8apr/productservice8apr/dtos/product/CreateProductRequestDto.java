package productservice8apr.productservice8apr.dtos.product;

import lombok.Getter;
import lombok.Setter;
import productservice8apr.productservice8apr.models.Product;

@Getter
@Setter
public class CreateProductRequestDto {
    String title;
    String description;
    double price;
    String category;
    String imageUrl;

    public Product toProduct(){
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setCategoryName(this.category);
        product.setImageUrl(this.imageUrl);
        return product;
    }

}
