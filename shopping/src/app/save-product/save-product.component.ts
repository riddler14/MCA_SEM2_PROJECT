import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-save-product',
  templateUrl: './save-product.component.html',
  styleUrl: './save-product.component.css'
})
export class SaveProductComponent  {
  product:any;






constructor(private productService:ProductService) {
  this.product={
    id:'',
    name:'',
    imageUrl:'',
    price:''
    
  }

  
}
 
saveUser() {
  this.productService.saveProduct(this.product).subscribe((res)=>{
    alert("product saved sucessfully")
  })
  }
// getUserData(data:any){
//     this.productService.saveProduct(data).subscribe((res)=>{
//       console.warn();
      
//     }
      
//     )
  //}

}
