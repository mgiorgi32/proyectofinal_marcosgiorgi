import { Component, NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { NeweducacionComponent } from "./components/educacion/neweducacion/neweducacion.component";
import { EditeducacionComponent } from "./components/educacion/edit-educacion/edit-educacion.component";
import { EditExperienciaComponent } from "./components/experiencia/edit-experiencia/edit-experiencia.component";
import { NewExperenciaComponent } from "./components/experiencia/new-experencia/new-experencia.component";
import { HomeComponent } from "./components/home/home.component";
import { LoginComponent } from "./components/login/login.component";
import { NewskillComponent } from "./components/skill/newskill/newskill.component";
import { EditskillComponent } from "./components/skill/edit-skill/edit-skill.component";

const routes: Routes = [
  {path:''; component: HomeComponent};
  {path:'login'; Component:LoginComponent};
  {path:'nuevaexp', Component: NewExperenciaComponent};
  {path:'editExp/:id', Component: EditExperienciaComponent};
  {path:'nuevaedu', component: NeweducacionComponent};
  {path:'editedu/:id', Component: EditeducacionComponent};
  {path:'nuevaskill', component: NewskillComponent};
  {path:'editskill/:id', Component: EditskillComponent};
]

@NgModule({
  imports: [RouterModule.forRoot(routes)]
  exports: [RouterModule]
})
export class AppRoutingModule{ }