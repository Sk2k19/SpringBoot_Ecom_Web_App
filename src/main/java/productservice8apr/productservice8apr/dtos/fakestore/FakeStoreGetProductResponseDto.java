package productservice8apr.productservice8apr.dtos.fakestore;

import lombok.Getter;
import lombok.Setter;
import productservice8apr.productservice8apr.models.Product;

@Getter
@Setter
public class FakeStoreGetProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
    public  Product toProduct() {
        Product product1 = new Product();
        product1.setTitle(this.getTitle());
        product1.setId(this.getId());
        product1.setDescription(this.getDescription());
        product1.setPrice(this.getPrice());
        product1.setCategoryName(this.getCategory());
        product1.setImageUrl(this.getImage());
        return product1;
    }
}
