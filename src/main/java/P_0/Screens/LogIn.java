package P_0.Screens;

public class LogIn extends Screen{


    public LogIn(String name, String route) {
        super("LogIn", "/LogIn");
    }

    @Override
    public String render() {
        String ConsoleText = " Please provide your personal access tokens below: /n" +
                               "Token: /n" +
                                "<";
        return ConsoleText;
    }
}
