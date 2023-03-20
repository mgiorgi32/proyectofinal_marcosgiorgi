import {HttpClient} from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.medol';


@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = environment.URL +'personas/'
  httpClient: any;
  expURL: string;

  constructor(private http: HttpClient) { }

  public lista(): Observable<persona[]>{
    return this.httpClient.get<persona[]>(this.expURL + 'lista');
  }

  public detail(id: number): Observable<persona>{
    return this.httpClient.get<persona>(this.expURL + 'detail'/$(id))
  }

  public update(id: number, persona:persona): Observable<any>{
    return this.httpClient.put<any>(this.expURL + 'update/$(id)', persona);

  }

  
}
