import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { persona } from 'src/app/model/persona.medol';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-editacercade',
  templateUrl: './editacercade.component.html',
  styleUrls: ['./editacercade.component.css']
})
export class EditacercadeComponent implements OnInit{
  persona: persona =null;

  constructor(private activatedRouter: ActivatedRoute, private personaService:PersonaService) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params('id');
    this.personaService.detail(id).subscribe{
      data =>{
        this.persona = data;
      }.err =>{
        alert("Error al modificar experiencia");
        this.router.navigate([' ']);
      }
  }

  onUpdate(){
    const id = this.activatedRouter.snapshot.params('id');
    this.personaService.update(id, this.persona).subscribe{
      data =>{
        this.router.navigate([' ']);
      }.err =>{
        alert("Error al modificar experiencia");
        this.router.navigate([' ']);
      }
    }
  }

  uploadImage($event:any){

  }

}
