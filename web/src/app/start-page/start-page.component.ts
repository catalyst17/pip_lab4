import { Component } from '@angular/core';

/*class User{
    login: string;
    password: string;

    constructor(login: string, password: string) {
        this.login = login;
        this.password = password;
    }
}*/

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
    
    
    <form (ngSubmit)="formSubmit()">
        <div class="form-group">
            <label for="login">Логин:</label>
            <input type="text" id="login" class="form-control" [(ngModel)]="data.username">
        </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" id="password" class="form-control">
        </div>
        <button type="submit" class="btn-default btn">Войти</button>
    </form>
`
    // templateUrl: '/start-page.component.html'
})

export class StartPageComponent {
    //model = new User(,);

    data = {};
    submitted = false;

    constructor() {
    }

    ngOnInit() {
        this.startTime();
    }

    async startTime() {
        const today = new Date();
        setTimeout(document.getElementById('time').innerText = today.getHours()
            + ':' + today.getMinutes() + ':' + today.getSeconds(), 1000);
    }

    formSubmit() {
        console.log(this.data);
        this.submitted = true;
    }

    // TODO: Remove this when we're done
    //get diagnostic() { return JSON.stringify(this.model); }
}