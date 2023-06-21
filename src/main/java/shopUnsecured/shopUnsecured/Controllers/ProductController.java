package shopUnsecured.shopUnsecured.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopUnsecured.shopUnsecured.models.Product;
import shopUnsecured.shopUnsecured.services.ProductService;

import java.util.List;
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping("products/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/products")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "products/{id}")
    public void updateProduct(@RequestBody Product product,@PathVariable int id){
        productService.updateProduct(product,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "products/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
}
