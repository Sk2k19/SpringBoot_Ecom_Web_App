package productservice8apr.productservice8apr.dtos.fakestore;

import lombok.Getter;
import lombok.Setter;
import productservice8apr.productservice8apr.models.Product;

@Setter
@Getter
public class FakeStoreProductCreateRequestDto {
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
    public static FakeStoreProductCreateRequestDto fromProduct(Product product){
        FakeStoreProductCreateRequestDto fakeStoreProductCreateRequestDto = new FakeStoreProductCreateRequestDto();
        fakeStoreProductCreateRequestDto.title = product.getTitle();
        fakeStoreProductCreateRequestDto.description = product.getDescription();
        fakeStoreProductCreateRequestDto.price = product.getPrice();
        fakeStoreProductCreateRequestDto.category = product.getCategory().getName();
        fakeStoreProductCreateRequestDto.image = product.getImageUrl();
        return fakeStoreProductCreateRequestDto;
    }

}
