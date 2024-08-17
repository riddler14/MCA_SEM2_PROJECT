import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Orderdetails } from '../orderdetails';

@Component({
  selector: 'app-my-orders',
  templateUrl: './my-orders.component.html',
  styleUrl: './my-orders.component.css'
})
export class MyOrdersComponent implements OnInit{

orderdetails:Orderdetails[]=[];

  constructor(private productService:ProductService){

     
this.getAllOrderDetails();
     }
  ngOnInit(): void {
    this.getAllOrderDetails();
  }
    
     getAllOrderDetails(){
      this.productService.getAllOrderDetails().subscribe((res:Orderdetails[])=>{
       this.orderdetails=res
      })
     }


  }

