import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule} from "@angular/forms";
import { StartPageComponent } from "./start-page/start-page.component";
import { HttpClientModule} from "@angular/common/http";

@NgModule({
    imports:      [ BrowserModule, HttpClientModule, FormsModule ],
    declarations: [ StartPageComponent ],
    bootstrap:    [ StartPageComponent ]
})

export class AppModule { }