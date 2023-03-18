import { Component } from '@angular/core';
import { Educacion } from 'src/app/model/educacion';

@Component({
  selector: 'app-neweducacion',
  templateUrl: './neweducacion.component.html',
  styleUrls: ['./neweducacion.component.css']
})
export class NeweducacionComponent implements OnInit {
  nombreE: string = ' ';
  desripcionE: string = ' ';

  constructor(private sEducacion: SEducacionService, private router: router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const edu = new Educacion(this.nombreE, this.desripcionE);
    this.sEducacion.save(edu).subscribe(data => {
      alert("Educacion añadida");
      this.router.navigate({ ' '});
    }, err => {
      alert("false");
      this.router.navigate({ ' '});
    })
  }
}

