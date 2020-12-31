import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PostService } from '../post.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {
  private idPost;
  public post;
  public name;
  public comment;

  constructor(
    private route: ActivatedRoute,
    private service: PostService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.idPost = this.route.snapshot.paramMap.get('id');
    this.service.find(this.idPost)
      .subscribe(response => {      
        this.post = response        
      }, error => {
        this.router.navigate(['/']);
      });
    console.log(this.idPost)
  }

  public send(){
    const data= {
      'comment':this.comment,
      'name': this.name
    }
    this.service.addComment(this.post.id,data)
    .subscribe(response => {
      this.ngOnInit();
    })
  }

}
