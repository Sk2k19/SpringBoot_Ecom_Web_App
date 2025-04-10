package productservice8apr.productservice8apr.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDto {
    Long id;
    String title;
    String description;
    String category;
    Double price;
    String imageUrl;

}
