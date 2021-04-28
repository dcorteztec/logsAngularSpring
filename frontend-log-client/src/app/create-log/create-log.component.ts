import { LogService } from '../log.service';
import { Log } from '../log';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-log',
  templateUrl: './create-log.component.html',
  styleUrls: ['./create-log.component.css']
})
export class CreateLogComponent implements OnInit {

  log: Log = new Log();
  submitted = false;

  constructor(private logService: LogService,
    private router: Router) { }

  ngOnInit() {
  }

  newLog(): void {
    this.submitted = false;
    this.log = new Log();
  }

  save() {
    this.logService
    .createLog(this.log).subscribe(data => {
      console.log(data)
      this.log = new Log();
      this.gotoList();
    },
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/logs']);
  }

}
