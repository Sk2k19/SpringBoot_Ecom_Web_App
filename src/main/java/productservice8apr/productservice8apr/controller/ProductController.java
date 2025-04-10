package productservice8apr.productservice8apr.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import productservice8apr.productservice8apr.dtos.CreateProductRequestDto;
import productservice8apr.productservice8apr.dtos.CreateProductResponseDto;
import productservice8apr.productservice8apr.models.Product;
import productservice8apr.productservice8apr.services.ProductService;
import productservice8apr.productservice8apr.services.ProductServiceDBImpl;
import productservice8apr.productservice8apr.services.ProductServiceFakeStoreImpl;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService ;
    public ProductController(@Qualifier("ProductServiceFakeStoreImpl")ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public static CreateProductRequestDto createProduct(@RequestBody
                                                     CreateProductRequestDto createProductRequesteDto){

        Product product = productService.createProduct(
                createProductRequesteDto.toProduct();
        );
        return null;
    }


    @GetMapping("/{id}")
    public String GetSingleProductById(@PathVariable("id") Long id){
        return "Details of product with id : " + id+" found";
    }



    @PostMapping("/")
    public String CreateProduct( @RequestBody CreateProductRequestDto requestDto){
        requestDto.setPrice(120222L);
        return "This is the price of product: " + requestDto.getPrice();


    }
}
