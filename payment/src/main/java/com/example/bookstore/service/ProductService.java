package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.entity.OrderDetails;
import com.example.bookstore.entity.Product;
import com.example.bookstore.entity.TransactionDetails;
import com.example.bookstore.repo.OrderRepository;
import com.example.bookstore.repo.ProductRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class ProductService {
	
private static final String KEY="rzp_test_ngzhKoRTvYeZEb";
private static final String SECRET_KEY="q66dwLWCI2FlzGS5pwu0iwkA";
private static final String CURRENY="INR";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Optional<Product> getProduct(Long id) {
    	return productRepository.findById(id);
    }
    
    public Product saveProduct(Product product) {
    	return productRepository.save(product);
    }
    
    public OrderDetails saveOrder(OrderDetails orderDetails) {
    	return orderRepository.save(orderDetails);
    }
    
    public List<OrderDetails> getAllOrderDetails(){
    	return orderRepository.findAll();
    }
    
    
    public TransactionDetails createTransaction(int amount) {
    	try {
    		
    		JSONObject jsonObject=new JSONObject();
    		jsonObject.put("amount", amount * 100);
    		jsonObject.put("currency", CURRENY);	
    	RazorpayClient razorpayClient= new RazorpayClient(KEY, SECRET_KEY);
    	
    	
    Order order=razorpayClient.orders.create(jsonObject);
    System.out.println(order);
    TransactionDetails transactionDetails= prepareTransaction(order);
    	return transactionDetails;
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    return null;	
    }
    
    private TransactionDetails prepareTransaction(Order order) {
    	String orderId=order.get("id");
    	String currency=order.get("currency");
    	int amount=order.get("amount");
    	
    	
    	TransactionDetails transactionDetails=new TransactionDetails(orderId, currency, amount,KEY);
    	return transactionDetails;
    }
    
    
    
    
    
    
}