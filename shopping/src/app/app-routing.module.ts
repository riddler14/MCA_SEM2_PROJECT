import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { ProductBuyComponent } from './product-buy/product-buy.component';
import { SaveProductComponent } from './save-product/save-product.component';
import { MyOrdersComponent } from './my-orders/my-orders.component';



const routes: Routes = [
  {path:'' , redirectTo:'menu', pathMatch:'full'},
  {path:'menu',component:MenuComponent},
  {path:'buy',component:ProductBuyComponent},
  {path:'save',component:SaveProductComponent},
  {path:'order',component:MyOrdersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
