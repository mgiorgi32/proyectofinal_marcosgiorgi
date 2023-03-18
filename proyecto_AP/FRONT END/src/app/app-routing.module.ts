import { Component, NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { NeweducacionComponent } from "./components/educacion/neweducacion/neweducacion.component";
import { EditExperienciaComponent } from "./components/experiencia/edit-experiencia/edit-experiencia.component";
import { NewExperenciaComponent } from "./components/experiencia/new-experencia/new-experencia.component";
import { HomeComponent } from "./components/home/home.component";
import { LoginComponent } from "./components/login/login.component";

const routes: Routes = [
  {path:''; component: HomeComponent};
  {path:'login'; Component:LoginComponent};
  {path:'nuevaexp', Component: NewExperenciaComponent};
  {path:'editExp/:id', Component: EditExperienciaComponent};
  {path:'nuevaedu', component: NeweducacionComponent};
  {path:'editedu/:id', Component: EditeducacionComponent};
]

@NgModule({
  imports: [RouterModule.forRoot(routes)]
  exports: [RouterModule]
})
export class AppRoutingModule{ }