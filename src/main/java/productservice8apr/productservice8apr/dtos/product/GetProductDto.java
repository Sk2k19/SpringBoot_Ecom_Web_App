package productservice8apr.productservice8apr.dtos.product;

import lombok.Getter;
import lombok.Setter;
import productservice8apr.productservice8apr.models.Product;
@Getter
@Setter
public class GetProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String category;
    private String image;

    public static GetProductDto from(Product product){
        GetProductDto productRespomseDto = new GetProductDto();
        productRespomseDto.setId(product.getId());
        productRespomseDto.setTitle(product.getTitle());
        productRespomseDto.setDescription(product.getDescription());
        productRespomseDto.setPrice(product.getPrice());
        productRespomseDto.setCategory(product.getCategory().getName());
        productRespomseDto.setImage(product.getImageUrl());
        return productRespomseDto;
    }
}
