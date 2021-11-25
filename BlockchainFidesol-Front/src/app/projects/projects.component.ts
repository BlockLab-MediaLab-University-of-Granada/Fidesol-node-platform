import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project } from '../Model/Project';
import {ServiceService} from '../service.service';
import Swal from 'sweetalert2'
import { waitForAsync } from '@angular/core/testing';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  nameForm:String='';
  urlForm:String='';
  descForm:String='';
  rol:number=1;
  proyectos:Project[]=[];

  // initialize the router and service variables, used for navigation and calls to the back-end services
constructor(private service:ServiceService, private router:Router) { }

  ngOnInit(): void {

    // in case of the local variable token is unset, the user is going to be redirected to the welcome page.
    if (localStorage.getItem("token")==null){
      this.router.navigateByUrl("/main")
    }

    //get tthe user rol (admin or user)
    this.getRol();

    //get the proyect list
    this.actualizar();
    
  }

  //call the getProyectos servicen and store the data
  actualizar(){
    this.service.getProyectos().subscribe(data=>{
      this.proyectos=data;
    })
  }

  //call the getRol servicen and store the data
  getRol(){
    this.service.getRol().subscribe(data=>{
      this.rol=data;
    })
  }

    //logout: clear the local variables and redirect to the wlcome page
    logout(){
      localStorage.clear();
      this.router.navigateByUrl('/main');
    }

  //method for adding proyect. It calls the add service, show an alert when it's done and reload the proyect list.
  public add(name:String, url:String, desc:String){
    this.service.addProyecto(name,url,desc).subscribe(data=>{});
    Swal.fire({
      title:"El proyecto se ha añadido con éxito",
      confirmButtonColor:'#0d6efd'
    })
    waitForAsync
    this.actualizar();
  }

  //Set the form variables
  setName(user: string) {
    this.nameForm = user;
  }

  setUrl(password: string) {
    this.urlForm = password;
  }
  setDesc(user: string) {
    this.descForm = user;
  }


}
