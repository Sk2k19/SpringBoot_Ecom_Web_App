package productservice8apr.productservice8apr.services;

import org.springframework.stereotype.Service;
import productservice8apr.productservice8apr.Exceptions.productNotFoundException;
import productservice8apr.productservice8apr.models.Category;
import productservice8apr.productservice8apr.models.Product;
import productservice8apr.productservice8apr.repositories.categoryRepository;
import productservice8apr.productservice8apr.repositories.productRepository;

import java.util.List;
import java.util.Optional;

@Service("productServiceDbImpl")
public class ProductServiceDBImpl implements ProductService {
    private final productRepository productRepo;
    private final categoryRepository categoryRepo;

    public ProductServiceDBImpl(productRepository productRepository,categoryRepository categoryRepository) {
        this.productRepo = productRepository;
        this.categoryRepo = categoryRepository;
    }

    @Override
 public Product createProduct(Product product){
        String categoryName = product.getCategory().getName();
        Optional<Category> category = categoryRepo.findByName(categoryName);
        Category toBePutCategory = null;
        if(category.isEmpty()){
            Category category1 = new Category();
            category1.setName(categoryName);
           toBePutCategory =  categoryRepo.save(category1);
        }else {
            toBePutCategory = category.get();
        }
        product.setCategory(toBePutCategory);
     Product savedProduct = productRepo.save(product);
     return savedProduct;
 }
 @Override
    public List<Product> getProducts(){
     return productRepo.findAll();
 }
 @Override
    public Product updateProduct(Long productId,Product product){
        Optional<Product> productToBeUpdated = productRepo.findById(productId);
        if(productToBeUpdated.isEmpty()){
             throw new productNotFoundException("Product with id " + productId + " not found");
        }
        Product toBeUpdatedProduct = productToBeUpdated.get();
        if(product.getDescription()!=null){
            toBeUpdatedProduct.setDescription(product.getDescription());
        }
        if(product.getTitle()!=null){
            toBeUpdatedProduct.setTitle(product.getTitle());
        }
        if(product.getPrice() !=null){
            toBeUpdatedProduct.setPrice(product.getPrice());
        }
        if(product.getImageUrl()!=null){
            toBeUpdatedProduct.setImageUrl(product.getImageUrl());
        }
        if(product.getCategory()!=null){
            String categoryName = product.getCategory().getName();
            Optional<Category> category = categoryRepo.findByName(categoryName);
            Category toBePutCategory = null;
            if(category.isEmpty()){
                Category newCategory = new Category();
                newCategory.setName(categoryName);
                toBePutCategory = categoryRepo.save(newCategory);

            }else{
                toBePutCategory = category.get();
            }
            toBeUpdatedProduct.setCategory(toBePutCategory);
        }
     return productRepo.save(toBeUpdatedProduct);
    }

 @Override
    public void deleteProduct(Long productId){
        productRepo.deleteById(productId);
   }
   @Override
    public Product getProductById(Long ProductIid){
        Optional<Product> frtchedProduct= productRepo.findById(ProductIid);
        if(frtchedProduct.isEmpty()){
            throw new productNotFoundException("Product with id " + ProductIid + " not found");
        }
       Product ProductResult = productRepo.findById(ProductIid).get();
        return ProductResult;
   }
}
