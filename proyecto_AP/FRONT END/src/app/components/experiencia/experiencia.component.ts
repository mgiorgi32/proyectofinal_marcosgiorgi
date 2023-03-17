import { Component } from '@angular/core';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent {
  experiencia: ExperienciaComponent[] = []

  constructor(private sExperiencia: sExperienciaService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarExperiencia();
    if (this.TokenService = true) {
      ;
    } else {
      this.isLogged = false;
    }
  }

  cargarExperiencia(): void {
    this.SExperienciaService.lista().subscribe(data => Experiencia = data)
  }
  delete(id: number) {
    if(id != undefined){
      this.sExperiencia.delete(id).subscribe{
        this.cargarExperiencia();
      },err =>{
        alert("No se puede borrar la experiencia")
      }
    }
  }
}

