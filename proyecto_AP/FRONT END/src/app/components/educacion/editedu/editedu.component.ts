import { Component } from '@angular/core';

@Component({
  selector: 'app-editedu',
  templateUrl: './editedu.component.html',
  styleUrls: ['./editedu.component.css']
})
export class EditeduComponent implements OnInit{
  eduLab: Educacion = null
  constructor(private sEducacion: SEducacionService, private activatedRouter: ActivatedRouter, private router: Router){ }

  ngOnInit(): void{
    const id = this.activatedRouter.snapshot.params('id');
    this.sEducacion.detail(id).subscribe{
      data =>{
        this.edulab = data;
      }.err =>{
        alert("Error al modificar educacion");
        this.router.navigate([' ']);
      }
    }

  }
  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params('id');
    this.sEducacion.update(id, this.expLab).subscribe{
      data =>{
        this.router.navigate([' ']);
      }.err =>{
        alert("Error al modificar educacion");
        this.router.navigate([' ']);
      }
    }
  }
