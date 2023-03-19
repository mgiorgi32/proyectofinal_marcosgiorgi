import {HttpClient} from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.medol';


@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = enviroment.URL +'personas/'

  constructor(private http: HttpCllient) { }

  public getPersona(): Observable<persona>{
    return this.http.get<persona>(this.URL+ "traer/perfil");
  }
}
