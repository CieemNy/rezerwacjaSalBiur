import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'zeto-fronted';


  images =[
    {
      imageSrc:
      'https://szczechy.pl/wp-content/uploads/2019/11/Sala-V4-1.jpg',
      imageAlt: 'sala1',
    },
    {
      imageSrc:
      'https://www.konferencje.pl/media/cache/article_horizontal/d/r/u/A/druA0iGBJDRl2UZ5ak4o.jpeg',
      imageAlt: 'sala2',
    },
    {
      imageSrc:
      'https://www.prawo.pl/gfx/prawopl/_thumbs/pl/wkdokumenty/000/422/728/1/biuro-00025-thinkstockphotos,nICD62SaolTLo7bXW5mZ.jpg',
      imageAlt: 'sala3',
    },
    {
      imageSrc:
      'https://wimgix.wedding.pl/vendor_background_image/wYXVy1gUUIgSCjuJKj2Jf1RzhzJneMudfm1WV36n.jpeg?w=530&h=350',
      imageAlt: 'sala4',
    },
    {
      imageSrc:
      'https://szczechy.pl/wp-content/uploads/2019/11/Sala-V4-1.jpg',
      imageAlt: 'sala5',
    }
  ]
}
