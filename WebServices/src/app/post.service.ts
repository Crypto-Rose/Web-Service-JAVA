import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private uri='http://'+window.location.hostname +':8080/api/v1';

  constructor(
    private http: HttpClient
  ) {
     
  }

  public save(post){
    return this.http.post(this.uri+'/posts/',post);
  }
  public addComment(idPost, comment){
    return this.http.post(this.uri+'/posts/'+idPost+'/addComment',comment);
  }
  public findAll(){
    return this.http.get(this.uri+'/posts/');
  }

  public find(idPost){
    return this.http.get(this.uri+'/post/'+idPost);
  }
}
