package com.Revature.Jamaal_Smith_P0_Project.Screens;

import java.io.BufferedReader;

public abstract class Screen {

    protected String name;
    protected String route;
    protected BufferedReader consoleReader;


    public Screen(String name, String route, BufferedReader consoleReader){
        this.name = name;
        this.route=route;
        this.consoleReader = consoleReader;
    }

    public Screen(String logIn, String route) {
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }



    public abstract void render() throws Exception;
}
