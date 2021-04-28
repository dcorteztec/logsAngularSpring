import { LogDetailsComponent } from './log-details/log-details.component';
import { CreateLogComponent } from './create-log/create-log.component';
import { UploadFilesComponent } from './components/upload-files/upload-files.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LogListComponent } from './log-list/log-list.component';
import { UpdateLogComponent } from './update-log/update-log.component';

const routes: Routes = [
  { path: '', redirectTo: 'employee', pathMatch: 'full' },
  { path: 'logs', component: LogListComponent },
  { path: 'add', component: CreateLogComponent },
  { path: 'upload', component: UploadFilesComponent},
  { path: 'update/:id', component: UpdateLogComponent },
  { path: 'details/:id', component: LogDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
