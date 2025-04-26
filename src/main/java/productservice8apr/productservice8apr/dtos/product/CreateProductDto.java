package productservice8apr.productservice8apr.dtos.product;

import lombok.Getter;
import lombok.Setter;
import productservice8apr.productservice8apr.models.Product;
@Getter
@Setter
public class CreateProductDto {
    private Long id;
    private String title;
    private String description;
    private String categoryName;
    private Double price;
    private String imageUrl;

    public static CreateProductDto fromProduct(Product product){
        CreateProductDto responseDto = new CreateProductDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setDescription(product.getDescription());
        responseDto.setCategoryName(product.getCategory().getName());
        responseDto.setImageUrl(product.getImageUrl());
        responseDto.setPrice(product.getPrice());
        return responseDto;
    }
    public  Product toProduct() {
        Product product1 = new Product();
        if (this.id == null) {
            throw new IllegalArgumentException("Product ID cannot be null for update");
        }
        product1.setTitle(this.getTitle());
        product1.setId(this.getId());
        product1.setDescription(this.getDescription());
        product1.setPrice(this.getPrice());
        product1.getCategory().setName(this.getCategoryName());
        product1.setImageUrl(this.getImageUrl());
        return product1;
    }
}
