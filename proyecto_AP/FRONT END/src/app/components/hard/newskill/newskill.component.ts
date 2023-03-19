import { Component } from '@angular/core';
import { Skill } from 'src/app/model/skill';
import {router} from '@angular/router';
import { SkillService } from 'src/app/service/skill.service';
@Component({
  selector: 'app-newskill',
  templateUrl: './newskill.component.html',
  styleUrls: ['./newskill.component.css']
})
export class NewskillComponent {
  export class NewSkillComponent implements OnInit {
  nombre: string;
  porcenatje: number;

  constructor(private skillS: SkillService, private router: router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const expe = new Skill(this.nombre, this.porcenatje);
    this.skillS.save(expe).subscribe(data => {
      alert("Skill añadida");
      this.router.navigate({ ' '});
    }, err => {
      alert("false");
      this.router.navigate({ ' '});
    })
  }
}
