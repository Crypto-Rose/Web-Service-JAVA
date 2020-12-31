import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PostService } from '../post.service';

@Component({
  selector: 'app-new-post',
  templateUrl: './new-post.component.html',
  styleUrls: ['./new-post.component.css']
})
export class NewPostComponent implements OnInit {
  
  public names;
  public post;
  public observation;
  constructor(
    private postService: PostService,
    private router: Router 
  ) { }
 
  ngOnInit(): void {
  }

  public send(){
    const post = {  
        'name': this.names,
        'description':this.post,
        'observation':this.observation

    }    
    this.postService.save(post)
    .subscribe(response => {
      console.log(response);
      this.router.navigate(['/']);
    })
  }

}
