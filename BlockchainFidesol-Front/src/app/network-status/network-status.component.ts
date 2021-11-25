import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-network-status',
  templateUrl: './network-status.component.html',
  styleUrls: ['../index-styles.css']
})
export class NetworkStatusComponent implements OnInit {

  // initialize the router and service variables, used for navigation and calls to the back-end services
constructor(private service:ServiceService, private router:Router) { }

  ngOnInit(): void {
    // in case of the local variable token is unset, the user is going to be redirected to the welcome page.
if (localStorage.getItem("token")==null){
      this.router.navigateByUrl("/main")
    }
  }

    //logout: clear the local variables and redirect to the welcome page
    logout(){
      localStorage.clear();
      this.router.navigateByUrl('/main');
    }

}
