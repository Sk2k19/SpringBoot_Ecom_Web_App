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
    public ProductController(@Qualifier("productServiceDbImpl")ProductService productService) {
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
                                                    @RequestBody UpdateProductDto updateProductDto){

        Product product = productService.updateProduct(
                productId,updateProductDto.toProduct()
        );


        PatchGetProductResponseDto responseDto = new PatchGetProductResponseDto();
        responseDto.setGetProduct(GetProductDto.from(product));
        return responseDto;

    }
    @GetMapping("/{id}")
    public getProductResponseDto getProductById(@PathVariable("id") Long productIdd){
        Product product = productService.getProductById(productIdd);
        getProductResponseDto responseDtos = new getProductResponseDto();
        responseDtos.setProduct(GetProductDto.from(product));
        return responseDtos;
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

}
