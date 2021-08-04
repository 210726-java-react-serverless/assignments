package com.Revature.Jamaal_Smith_P0_Project.Routers;

import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;

public class ProfFlow {
    public final ScreenRouter profFlow = new ScreenRouter();



    public void render() {
        profFlow.navigate("/UserType");

        System.out.println("go ahead");
    }
}
