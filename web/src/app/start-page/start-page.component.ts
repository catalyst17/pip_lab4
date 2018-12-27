import {Component, OnInit} from '@angular/core';

@Component({
    selector: 'app-start-page',
    template: `
        <div onload="startTime()">
            <div id="txt">
                <p id="time"></p>
            </div>
        </div>
        <div class="page-header">
            <h1> Вход в систему </h1>
        </div>


        <form name="form" (ngSubmit)="formSubmit()" #f="ngForm">
            <div class="form-group">
                <label for="login">Логин:</label>
                <input type="text" class="form-control" name="username" [(ngModel)]="model.username" #username="ngModel" required/>
            </div>
            <div class="form-group">
                <label for="password">Пароль:</label>
                <input type="password" class="form-control" name="password" [(ngModel)]="model.password" #password="ngModel" required/>
            </div>
            <button class="btn-default btn">Войти</button>
        </form>
    `
    // templateUrl: '/start-page.component.html'
})

export class StartPageComponent implements OnInit {
    model: any = {};

    constructor() {
    }

    ngOnInit() {
        //this.startTime();
    }

    formSubmit() {
        alert(this.model.username + this.model.password);
    }

    async startTime() {
        const today = new Date();
        setTimeout(document.getElementById('time').innerText = today.getHours()
            + ':' + today.getMinutes() + ':' + today.getSeconds(), 1000);
    }
}