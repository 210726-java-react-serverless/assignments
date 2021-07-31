package P_0.Screens;

public class UserType extends Screen{
    public UserType(String name, String route) {
        super("UserType", "/UserType");
    }

    @Override
    public String render() {
        String ConsoleText = "Welcome to RevRoll. Please select one of the following: /n" +
                             "1 - This is my first time using RevRoll /n" +
                             "2 -  I am a returning RevRoll user /n";

        return ConsoleText;
    }
}
