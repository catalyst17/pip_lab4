import { Component } from '@angular/core';

class User{
    login: string;
    password: string;

    constructor(login: string, password: string) {
        this.login = login;
        this.password = password;
    }
}

@Component({
    selector: 'lab4-app',
    templateUrl: '/index.html',
    template: `        
    <div class="page-header">
        <h1> Вход в систему </h1>
    </div>
    <div class="panel">
        <form>
            Логин:<br>
            <input id="login" type="text" size="30" pInputText [(ngModel)]="text"><br>
            Пароль:<br>
            <input id="password" type="password" pPassword [(ngModel)]="property"/><br>
            <button class="btn btn-default" type="submit" class="btn btn-success">Войти</button>
        </form>
    </div>
    `
})
export class AppComponent {
    //model = new User(,);

    submitted = false;

    onSubmit() { this.submitted = true; }

    // TODO: Remove this when we're done
    //get diagnostic() { return JSON.stringify(this.model); }
}