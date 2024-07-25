import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Demo } from '../modals/demo.model';

@Injectable({
  providedIn: 'root'
})
export class DemoService {
  private apiUrl = 'http://localhost:8089/SaFeAgile/Demo';

  constructor(private http: HttpClient) { }

  getDemobyID(id: string): Observable<Demo> {
    return this.http.get<Demo>(`${this.apiUrl}/${id}`);
  }

  updateDemoById(id: string, demo: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, demo);
  }
  



}