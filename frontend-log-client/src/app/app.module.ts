import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { CreateLogComponent } from './create-log/create-log.component';
import { LogDetailsComponent } from './log-details/log-details.component';
import { LogListComponent } from './log-list/log-list.component';
import { UpdateLogComponent } from './update-log/update-log.component';
import { UploadFilesComponent } from './components/upload-files/upload-files.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateLogComponent,
    LogDetailsComponent,
    LogListComponent,
    UpdateLogComponent,
    UploadFilesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
