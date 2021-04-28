import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Log } from "../log";
import { LogService } from "../log.service";

import { Router } from '@angular/router';

@Component({
  selector: 'app-log-list',
  templateUrl: './log-list.component.html',
  styleUrls: ['./log-list.component.css']
})
export class LogListComponent implements OnInit {

  logs: Observable<Log[]>;

  constructor(private logService: LogService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.logs = this.logService.getLogsList();
  }

  deleteLog(id: number) {
    this.logService.deleteLog(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  logDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateLog(id: number){
    this.router.navigate(['update', id]);
  }

}
