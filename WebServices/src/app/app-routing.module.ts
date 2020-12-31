import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommentComponent } from './comment/comment.component';
import { NewPostComponent } from './new-post/new-post.component';
import { PostsComponent } from './posts/posts.component';
import {ProductComponent} from './product/product.component';

const routes: Routes = [
  {
    path:'',
    redirectTo: 'posts',
    pathMatch:'full'
  },
  {    
    path: 'products',
    component: ProductComponent
  },
  {
    path:'posts',
    component: PostsComponent
  },
  {
    path:'new-post',
    component: NewPostComponent
  },
  {
    path:'post/:id',
    component: CommentComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }