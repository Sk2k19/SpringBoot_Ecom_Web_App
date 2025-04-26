package productservice8apr.productservice8apr.dtos.product;

import lombok.Getter;
import lombok.Setter;
import productservice8apr.productservice8apr.models.Product;

@Getter
@Setter
public class CreateProductResponseDto {
    Long id;
    String title;
    String description;
    String category;
    Double price;
    String imageUrl;

    public static CreateProductResponseDto fromProduct(Product product){
        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setDescription(product.getDescription());
        responseDto.setImageUrl(product.getImageUrl());
        responseDto.setPrice(product.getPrice());
        responseDto.setCategory(product.getCategory().getName());
        return responseDto;
    }

}
