import { Component } from '@angular/core';

class Item{
    purchase: string;
    done: boolean;
    price: number;

    constructor(purchase: string, price: number) {

        this.purchase = purchase;
        this.price = price;
        this.done = false;
    }
}

@Component({
    selector: 'lab4-app',
    template: `<div class="page-header">
        <h1> Вход в систему </h1>
    </div>
    <div class="panel">
        Логин:<br>
        <input id="input" type="text" size="30" pInputText [(ngModel)]="text"><br>
        Пароль:<br>
        <input type="password" pPassword [(ngModel)]="property"/><br><br>
        <button class="btn btn-default" (click)="login()">Войти</button>
    </div>`
})
export class AppComponent {
    login(): void {
    }
}