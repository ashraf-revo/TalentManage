import {Component, Input, OnInit} from '@angular/core';
import {Interview} from "../../Domain/interview";

@Component({
  selector: 't-interview-item',
  templateUrl: './interview-item.component.html',
  styleUrls: ['./interview-item.component.css']
})
export class InterviewItemComponent implements OnInit {
  @Input()
  public interview: Interview;

  constructor() {
  }

  ngOnInit() {
  }

}
