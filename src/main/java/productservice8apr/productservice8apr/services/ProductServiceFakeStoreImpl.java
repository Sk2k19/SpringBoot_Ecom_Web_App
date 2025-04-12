package productservice8apr.productservice8apr.services;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import productservice8apr.productservice8apr.Exceptions.InvalidProductIdExp;
import productservice8apr.productservice8apr.dtos.fakestore.FakeStoreProductCreateRequestDto;
import productservice8apr.productservice8apr.dtos.fakestore.FakeStoreGetProductResponseDto;
import productservice8apr.productservice8apr.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service("ProductServiceFakeStoreImpl")
//@Primary  -- its one way to solve conflict in multiple services

public class ProductServiceFakeStoreImpl implements ProductService {

//    Throwable Eception
    private RestTemplate restTemplate;
    public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }
     @Override
     public Product createProduct(Product product) {
         FakeStoreProductCreateRequestDto request = new FakeStoreProductCreateRequestDto();
         request.setTitle(product.getTitle());
         request.setDescription(product.getDescription());
         request.setPrice(product.getPrice());
         request.setCategory(product.getCategoryName());
         request.setImage(product.getImageUrl());

         FakeStoreGetProductResponseDto response = restTemplate.postForObject("https://fakestoreapi.com/products", request, FakeStoreGetProductResponseDto.class);
//         Product product1 = new Product();
//         product1.setTitle(response.getTitle());
//         product1.setId(response.getId());
//         product1.setDescription(response.getDescription());
//         product1.setPrice(response.getPrice());
//         product1.setCategoryName(response.getCategory());
//         product1.setImageUrl(response.getImage());
         return response.toProduct();
     }
     @Override
    public List<Product> getProducts(){
       FakeStoreGetProductResponseDto[] response =  restTemplate.getForObject(
               "https://fakestoreapi.com/products",
               FakeStoreGetProductResponseDto[].class );
       List<FakeStoreGetProductResponseDto>listOfresponseDto = Stream.of(response).toList();
       List<Product> products = new ArrayList<Product>();
       for(FakeStoreGetProductResponseDto dto : listOfresponseDto){
           products.add(dto.toProduct());
       }
       return products;
     }
     @Override
    public Product updateProduct(Long productId,Product product) {
        if(productId <=0){
            throw new InvalidProductIdExp("Product id invalid "+productId);

        }
        FakeStoreGetProductResponseDto productResponse =  restTemplate.patchForObject(
                "https://fakestoreapi.com/products/{id}"+productId,
                FakeStoreProductCreateRequestDto.fromProduct(product),
               FakeStoreGetProductResponseDto.class
        );
        return productResponse.toProduct();
     }
}
