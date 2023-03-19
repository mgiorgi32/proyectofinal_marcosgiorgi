import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Educacion } from '../model/educacion';
import { enviroment } from 'enviroments/enviroments';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {
  expURL = enviroment.URL + 'edu/'

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Educacion[]>{
    return this.httpClient.get<Educacion[]>(this.expURL + 'lista');
  }

  public detail(id: number): Observable<Educacion>{
    return this.httpClient.get<Educacion>(this.expURL + 'detail'/$(id))
  }

  public save(Educacion: Educacion): Observable<any>{
    return this.httpClient.post<any>(this.expURL + 'create', educacion);
  }

  public update(id: number, Educacion:Educacion): Observable<any>{
    return this.httpClient.put<any>(this.expURL + 'update/$(id)', educacion);

  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.expURL + 'delete/$(id)');
  }

}
