import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product';
import { HttpErrorResponse } from '@angular/common/http';
import { isEmpty } from 'rxjs';



declare var Razorpay:any;
@Component({
  selector: 'app-product-buy',
  templateUrl: './product-buy.component.html',
  styleUrl: './product-buy.component.css'
})
export class ProductBuyComponent implements OnInit {


 id:any;

 data: any; 
 productDetail :Product[]=[]
 orderdetail:any;
 transaction:any;
 status:any;
  
constructor(private productService:ProductService,private router:Router,private activateRouter:ActivatedRoute) {
  this.data={
    id:'',
    name:'',
    imageUrl:'',
    price:''
    
  }
 this.orderdetail={
  transaction_id:'',
  order_name:'',
  address:'',
  number:'',
  alternateNumber:'',
  product_name:'',
  amount:''


 }

 this.transaction={
  amount:'',
  currency:'',
  INR:'',
  orderId:''
 }
//  amount
//  : 
//  100000
//  currency
//  : 
//  "INR"
//  key
//  : 
//  "rzp_test_ZSM8tz7GWLSm7z"
//  orderId
//  : 
//  "order_NGbpSPcnHbX2IE"
 
 
 
}
  ngOnInit(): void {
  this.id=this.activateRouter.snapshot.params['id']
  this.productService.getProductDetails(this.id).subscribe((res)=>{
    
    this.data=res;
  }
  
  )
 

}

saveOrder() {

  this.orderdetail.product_name=this.data.name
  this.orderdetail.amount=this.data.price
  this.orderdetail.transaction_id=this.transaction.orderId
  console.log(this.orderdetail)
  
    this.productService.saveOrder(this.orderdetail).subscribe((res)=>{
      
      //console.log(res);
      
    })
    
  }
  
  createTransaction(amount:any) {
   
   this.productService.createTransaction(amount).subscribe((res)=>{
    this.openTransaction(res)
    //console.log(res);
    this.transaction=res;
   }
   )
  
 }
   

 openTransaction(response:any){
  var options={
    order_id:response.orderId,
    key:response.key,
    amount:response.amount,
    currency:response.currency,
    name:'Make a Payment',
    description:'Payment of shopping',
    image:'',
    handler:(response:any)=>{
     this.processResponce(response)
     
    
    },
    prefill :{
      name:'razorpay',
      email:'adityaguddad12@gmail.com',
      contact:'9004895657'
    },
    notes:{
      address:'Online Shopping'
    },
    theme:{
      color:'#F37254'
    }
    
  }
  console.log(options.key)
  var razorpayObject=new Razorpay(options);
  razorpayObject.open();
 }
processResponce(resp:any){
  console.log(resp);
  this.saveOrder();
  alert("your order will delievered within 4-5 days")
 
}
 



  }

    // private String order_name;
    
    // private String address;
    // private int number;
    // private int alternateNumber;
    // private String product_name;
    // private int amount;
    