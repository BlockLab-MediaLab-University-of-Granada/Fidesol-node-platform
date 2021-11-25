import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MainComponent } from './main/main.component';
import { NetworkStatusComponent } from './network-status/network-status.component';
import { ProjectsComponent } from './projects/projects.component';

//List of the navigable routes
const routes: Routes = [
  // {path : '', component: AppComponent},
  {path : '', redirectTo: '/projects', pathMatch: 'full' },
  {path : 'projects', component: ProjectsComponent},
  {path : 'main', component: MainComponent},
  {path : 'network-status', component: NetworkStatusComponent},
  {path : 'login', component: LoginComponent},
  
  {path : '**', redirectTo:'/projects', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
