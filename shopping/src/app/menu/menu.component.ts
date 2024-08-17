import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent implements OnInit {

  products: Product[] = []; 
  price:any;
  


  constructor(private productService:ProductService,private activetRoute:ActivatedRoute,private router:Router) {
  
  }
  ngOnInit(): void {
    this.getProductList();
  }

getProductList() : void{
  this.productService.getAllProduct().subscribe(
    {
      next : (res : Product[])=>{
        this.products=res;
        
      },
      error: (err: HttpErrorResponse)=>{
        console.log(err)
      }
    }
  )
}

calculator(amount : number):void{

//console.log(amount);
}

buyProduct(id: any){
this.router.navigate(['/buy',{id}]);
}

}
