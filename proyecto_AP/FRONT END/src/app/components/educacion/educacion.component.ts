import { Component } from '@angular/core';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent {
  experiencia: EducacionComponent[] = []

  constructor(private sEducacion: sEducacionService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarEducacion();
    if (this.TokenService = true) {
      ;
    } else {
      this.isLogged = false;
    }
  }

  cargarEducacion(): void {
    this.SEducacionService.lista().subscribe(data => Educacion = data)
  }
  delete(id: number) {
    if(id != undefined){
      this.sEducacion.delete(id).subscribe{
        this.cargarEducacion();
      },err =>{
        alert("No se puede borrar la educacion")
      }
    }
  }
}
