package productservice8apr.productservice8apr.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import productservice8apr.productservice8apr.dtos.product.*;
import productservice8apr.productservice8apr.models.Product;
import productservice8apr.productservice8apr.services.ProductService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService ;
    public ProductController(@Qualifier("ProductServiceFakeStoreImpl")ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public CreateProductResponseDto createProduct(@RequestBody
                                                  CreateProductRequestDto createProductRequesteDto){

        Product product = productService.createProduct(
                createProductRequesteDto.toProduct()
        );

        return CreateProductResponseDto.fromProduct(product);
    }
    @GetMapping
    public GetAllProductsResponseDto getAllProducts(){
        List<Product> products = productService.getProducts();
        GetAllProductsResponseDto responseDto = new GetAllProductsResponseDto();

        List<GetProductDto> productResponseDtos = new ArrayList<>();
        for(Product product:products){
            productResponseDtos.add(GetProductDto.from(product));
        }
        responseDto.setProducts(productResponseDtos);
        return responseDto;
    }
    @PatchMapping("/{id}")
    public PatchGetProductResponseDto upadateProduct(@PathVariable("id") Long productId,
                                                    @RequestBody CreateProductDto createProductDto){
        Product product = productService.updateProduct(
                productId,createProductDto.toProduct()
        );
        PatchGetProductResponseDto responseDto = new PatchGetProductResponseDto();
        responseDto.setGetProduct(GetProductDto.from(product));
        return null;

    }
    @GetMapping("/{id}")
    public String GetSingleProductById(@PathVariable("id") Long id){
        return "Details of product with id : " + id+" found";
    }



//    @PostMapping("/")
//    public String CreateProduct( @RequestBody CreateProductRequestDto requestDto){
//        requestDto.setPrice(120222L);
//        return "This is the price of product: " + requestDto.getPrice();
//
//
//    }
}
