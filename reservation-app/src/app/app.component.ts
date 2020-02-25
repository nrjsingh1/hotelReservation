import { Component } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ReservationService } from './reservation.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'reservation-app';

  constructor(private reservationService: ReservationService){}
  rooms:Room[];
  roomSearchForm: FormGroup;
  currCheckinVal: string;
  currCheckoutVal: string;
  currRoomNumber: number;
  currPrice:  number;

  ngOnInit(){

    this.roomSearchForm = new FormGroup({
      checkin:  new FormControl(''),
      checkout: new FormControl(''),
      roomNumber: new FormControl('')
    });

    this.roomSearchForm.valueChanges.subscribe(form=>{

      this.currCheckinVal = form.checkin;
      this.currCheckoutVal = form.checkout;
      if(form.roomNumber){
        let roomValues:string[] = form.roomNumber.split('|');//value from backend will be a pipe separated tokens of string
        this.currRoomNumber =  Number(roomValues[0]);
        this.currPrice  = Number(roomValues[1]);
      }
      console.log(this.currCheckinVal);
      console.log(this.currCheckoutVal);
      console.log(this.currRoomNumber);
    });
  this.rooms= [
    new Room("124","234","150"),
    new Room("125","235","151"),
    new Room("126","236","152")

  ];

  };
}

export class Room{
  id:string;
  roomNumber:string;
  price:string;

  constructor(id:string, roomNumber:string, price:string){
    this.id=id;
    this.price=price;
    this.roomNumber=roomNumber;
  }

}
