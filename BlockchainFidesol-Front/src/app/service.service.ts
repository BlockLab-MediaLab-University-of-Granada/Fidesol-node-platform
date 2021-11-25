import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Project } from './Model/Project';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {


  constructor(private http:HttpClient) { }

  //http header that contains the user token which is necesary to call the back-end enpoints.
  httpOptions = {
      headers: new HttpHeaders({
        'x-api-key': localStorage.getItem("token") || ''
      })
    };

  //endpoints urls
  Url1='http://localhost:8080/bcp/user-management/';
  Url2='http://localhost:8080/bcp/project-management/';

  //this method calls the list projects enpoint
  getProyectos(){
    
    return this.http.get<Project[]>(this.Url2+'list',this.httpOptions)
  }

  //this method send the user parameters and obtains the token
  login(username: string, password: string) {
    var data= {
      username,
      password
    }
    return this.http.post<string>(this.Url1 + 'login',data)
  }

  //this method sends the proyect variables and set a new project. Returns the new project id if it's ok.
  addProyecto(name:String, url:String, descripcion:String){
    var proyecto={
      name,
      url,
      descripcion
    }
    return this.http.post(this.Url2 + 'add', proyecto, this.httpOptions)
  }

  //this method calls the getRol enpoint with the username
  getRol():Observable<number>{

    let user:string=localStorage.getItem("user") || '';
    return this.http.post<number>(this.Url1 + 'rol', user,this.httpOptions)
  }
}
