import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';
import { Orderdetails } from './orderdetails';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  api="http://localhost:9090/api/products"

  public getAllProduct():Observable<Product[]>{
    return this.http.get<Product[]>('http://localhost:9090/api/products/all');
}

public getProductDetails(id:any):Observable<any>{
  return this.http.get<Product>('http://localhost:9090/api/products/get/product/'+id);
}

public saveProduct(data:any):Observable<any>{
return this.http.post('http://localhost:9090/api/products/save',data);
}
public saveOrder(data:any):Observable<any>{
  return this.http.post('http://localhost:9090/api/products/order',data);
  }

  public  createTransaction(amount:any){
  return this.http.get('http://localhost:9090/api/products/createTransaction/'+amount)
  }

  public getAllOrderDetails():Observable<Orderdetails[]>{
    return this.http.get<Orderdetails[]>("http://localhost:9090/api/products/orderdetails")
  }
}