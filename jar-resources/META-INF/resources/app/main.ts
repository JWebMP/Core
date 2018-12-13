// @ts-ignore
import {bootstrap} from 'angular2/platform/browser';
// @ts-ignore
import {Component} from 'angular2/core';
//import {AppComponent} from './app.component';

export class Hero {
    id: number;
    name: string;
}

@Component({
    selector: 'my-app',
    template: '<div>stuff?</div>'
})
export class AppComponent {
    title = 'Tour of Heroes';
    hero: Hero = {
        id: 1,
        name: 'Windstorm'
    };
}

bootstrap(AppComponent);
