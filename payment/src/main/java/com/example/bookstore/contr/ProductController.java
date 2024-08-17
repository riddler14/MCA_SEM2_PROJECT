package com.example.bookstore.contr;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.entity.OrderDetails;
import com.example.bookstore.entity.Product;
import com.example.bookstore.entity.TransactionDetails;
import com.example.bookstore.service.ProductService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    
    
    @GetMapping("/all")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/get/product/{id}")
    public Optional<Product> getProduct(@PathVariable Long id){
    	return productService.getProduct(id);
    }

    
    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
    	return productService.saveProduct(product);
    }
    
    
    @PostMapping("/order")
    public OrderDetails saveOrder(@RequestBody OrderDetails orderDetails) {
    	return productService.saveOrder(orderDetails);
    }
    
    @GetMapping("/createTransaction/{amount}")
    public TransactionDetails createTransaction(@PathVariable int amount) {
    	return productService.createTransaction(amount);
    }
    // Add methods for other API endpoints...
 
    @GetMapping("/orderdetails")
    public List<OrderDetails> getAllOrderDetails(){
    	return productService.getAllOrderDetails();
    }
    
    
    
    
    
    
}