import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  //login variables
  userForm: string = "";
  passwordForm: string = "";

  // initialize the router and service variables, used for navigation and calls to the back-end services
constructor(private service:ServiceService, private router:Router) { }

  ngOnInit(): void {
    // in case of the local variable token is set, the user is redirected to the home page.
    if (localStorage.getItem("token")!==null){
      this.router.navigateByUrl("/projects")
    }
  }

  //login method.
  //Set the local variables user, token and dateLogin after calling the login service
  public login(user: string, password: string) {
    this.service.login(user, password).subscribe(response => {
      localStorage.setItem("user", user);
      localStorage.setItem("token", response);
      localStorage.setItem("dateLogin", new Date().getTime().toString());
      this.router.navigateByUrl('/projects');
    }
    )
  }

  //set the username from the html form
  setUser(user: string) {
    this.userForm = user;
  }

  //set the password
  setPassword(password: string) {
    this.passwordForm = password;
  }

}
