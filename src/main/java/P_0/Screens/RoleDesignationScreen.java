package P_0.Screens;

public class RoleDesignationScreen extends Screen{

    public RoleDesignationScreen(String name, String route) {
        super("HomeScreen", "/HomeScreen");

        }


    @Override
    public String render() {
        String ConsoleText = "Please select your relationship to the University:/n" +
                "1 - Student/n" +
                "2 - Professor/n";

        return ConsoleText;

    }
}

