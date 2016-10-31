import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }   from './app.component';
import { HelloUserComponent }   from './hello-user.component';
@NgModule({
  imports:      [ BrowserModule ],
  declarations: [ AppComponent, HelloUserComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
