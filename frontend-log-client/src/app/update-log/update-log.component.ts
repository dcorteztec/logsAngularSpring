import { Component, OnInit } from '@angular/core';
import { Log } from '../log';
import { ActivatedRoute, Router } from '@angular/router';
import { LogService } from '../log.service';

@Component({
  selector: 'app-update-log',
  templateUrl: './update-log.component.html',
  styleUrls: ['./update-log.component.css']
})
export class UpdateLogComponent implements OnInit {

  id: number;
  log: Log;

  constructor(private route: ActivatedRoute,private router: Router,
    private logService: LogService) { }

  ngOnInit() {
    this.log = new Log();

    this.id = this.route.snapshot.params['id'];

    this.logService.getLog(this.id)
      .subscribe(data => {
        console.log(data)
        this.log = data;
      }, error => console.log(error));
  }

  updateLog() {
    this.logService.updateLog(this.id, this.log)
      .subscribe(data => {
        console.log(data);
        this.log = new Log();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateLog();
  }

  gotoList() {
    this.router.navigate(['/logs']);
  }

}
