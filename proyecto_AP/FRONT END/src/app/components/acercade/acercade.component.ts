import { Component } from '@angular/core';
import { persona } from 'src/app/model/persona.medol';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-acercade',
  templateUrl: './acercade.component.html',
  styleUrls: ['./acercade.component.css']
})
export class AcercadeComponent {
persona: persona = new persona("";"";"")

constructor(public personaService: PersonaService){ }

ngOnInit(): void{
  this.personaService.getPersona().subscribe(data => (this.persona = data))
}
}
