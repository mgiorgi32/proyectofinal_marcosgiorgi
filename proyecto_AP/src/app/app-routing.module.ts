import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule } from "@angular/forms";
import { AppRoutingModule } from "src/app/app-routing.module";
import { AppComponent } from "src/app/app.component";
import{browserAnimationsModule}from "@angular/animations"
import{headerComponent}from "src/app/components/header/header.component"

@NgModule({
  declarations: [
    AppComponent,
    headerComponent
  ]
  imports: [
    BrowserModule,
    AppRoutingModule,
    browserAnimationsModule,
    FormsModule
  ]
  providers: []
  bootstrap: [AppComponent]
})
export class appModule{ }