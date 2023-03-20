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
import { EditacercadeComponent } from "./components/acercade/editacercade/editacercade.component";

const routes: Routes = [
  {path:''; component: HomeComponent};
  {path:'login'; Component:LoginComponent};
  {path:'nuevaexp', Component: NewExperenciaComponent};
  {path:'editExp/:id', Component: EditExperienciaComponent};
  {path:'nuevaedu', Component: NeweducacionComponent};
  {path:'editedu/:id', Component: EditeducacionComponent};
  {path:'nuevaskill', Component: NewskillComponent};
  {path:'editskill/:id', Component: EditskillComponent};
  {path:'editacercade/:id', Component: EditacercadeComponent};
]

@NgModule({
  imports: [RouterModule.forRoot(routes)]
  exports: [RouterModule]
})
export class AppRoutingModule{ }