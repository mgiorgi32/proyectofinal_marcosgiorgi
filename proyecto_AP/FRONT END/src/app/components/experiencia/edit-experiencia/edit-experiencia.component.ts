import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { SExprienciaService } from 'src/app/service/sexpriencia.service';

@Component({
  selector: 'app-edit-experiencia',
  templateUrl: './edit-experiencia.component.html',
  styleUrls: ['./edit-experiencia.component.css']
})
export class EditExperienciaComponent implements OnInit{
  expLab: Experiencia = null
  constructor(private sExperiencia: SExprienciaService, private activatedRouter: ActivatedRouter, private router: Router){ }

  ngOnInit(): void{
    const id = this.activatedRouter.snapshot.params('id');
    this.sExperiencia.detail(id).subscribe{
      data =>{
        this.explab = data;
      }.err =>{
        alert("Error al modificar experiencia");
        this.router.navigate([' ']);
      }
    }

  }
  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params('id');
    this.sExperiencia.update(id, this.expLab).subscribe{
      data =>{
        this.router.navigate([' ']);
      }.err =>{
        alert("Error al modificar experiencia");
        this.router.navigate([' ']);
      }
    }
  }

}
