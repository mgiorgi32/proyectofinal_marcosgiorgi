import { Component } from '@angular/core';
import { SExprienciaService } from 'src/app/service/sexpriencia.service';

@Component({
  selector: 'app-new-experencia',
  templateUrl: './new-experencia.component.html',
  styleUrls: ['./new-experencia.component.css']
})
export class NewExperenciaComponent implements OnInit {
  nombreE: string = ' ';
  desripcionE: string = ' ';

  constructor(private sExperiencia: SExprienciaService, private router: router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const expe = new Experiencia(this.nombreE, this.desripcionE);
    this.sExperiencia.save(expe).subscribe(data => {
      alert("Experiencia añadida");
      this.router.navigate({ ' '});
    }, err => {
      alert("false");
      this.router.navigate({ ' '});
    })
  }
}
