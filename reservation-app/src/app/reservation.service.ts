import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http:HttpClient){}
  private baseUrl:string  = 'http://localhost:8080'
  private reservationUrl:string = this.baseUrl  + '/room/v1/reservation';
}
