import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { User } from 'src/app/model/user';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: User = new User(undefined!, undefined!, undefined!, undefined!, undefined!, undefined!, undefined!);
  invalid: boolean = false;

  constructor(
    private accountService: AccountService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.findUser();
  }

  updateProfile() {
    this.validateFields();
    if (!this.invalid) {
      this.accountService.updateProfile(this.user);
      this.route.paramMap
      .pipe(
        switchMap(params => this.accountService.updateProfile(this.user)
      ))
      .subscribe(user => {
        this.user = user;
      });
    }
  }

  findUser(){
    this.route.paramMap
      .pipe(
        switchMap(params => this.accountService.findById(localStorage.getItem('userLoggedRol')!, +params.get('id')!)
      ))
      .subscribe(user => {
        this.user = user;
      });
  }

  validateFields() {
    if (this.user.fullname == '' || this.user.email == "") {
      this.invalid = true;
    } else {
      this.invalid = false;
    }
  }

}
