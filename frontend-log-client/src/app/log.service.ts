import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LogService {

  private baseUrl = 'http://localhost:8080/prevent-senior';

  constructor(private http: HttpClient) { }

  getLog(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/log/${id}`);
  }

  createLog(log: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/create-log`, log);
  }

  updateLog(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/edit-log/${id}`, value);
  }

  deleteLog(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete-log/${id}`, { responseType: 'text' });
  }

  getLogsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/listLogs`);
  }
}
