import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LogoAPComponent } from './components/logo-ap/logo-ap.component';
import { BannerComponent } from './components/banner/banner.component';
import { AcercadeComponent } from './components/acercade/acercade.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { FormsModule } from '@angular/forms';
import { HardComponent } from './components/hard/hard.component';
import { ProyectoComponent } from './components/proyecto/proyecto.component';
import { FooterComponent } from './components/footer/footer.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { InterceptorServiceComponent } from './service/interceptor-service/interceptor-service.component'
import { InterceptorProvider } from './service/interceptor-service';
import { NewExperenciaComponent } from './components/experiencia/new-experencia/new-experencia.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia/edit-experiencia.component';
import { NeweducacionComponent } from './components/educacion/neweducacion/neweducacion.component';
import { EditeduComponent } from './components/educacion/editedu/editedu.component';
import { EditskillComponent } from './components/hard/editskill/editskill.component';
import { NewskillComponent } from './components/hard/newskill/newskill.component';
import { EditacercadeComponent } from './components/acercade/editacercade/editacercade.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoAPComponent,
    BannerComponent,
    AcercadeComponent,
    ExperienciaComponent,
    EducacionComponent,
    HardComponent,
    ProyectoComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    InterceptorServiceComponent,
    NewExperenciaComponent,
    EditExperienciaComponent,
    NeweducacionComponent,
    EditeduComponent,
    EditskillComponent,
    NewskillComponent,
    EditacercadeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    NgCircleProgressModule.forRoot({}),
    HttpClient
    HttpClientModule
  ],
  providers: [
    InterceptorProvider,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
