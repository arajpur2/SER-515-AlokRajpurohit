import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public final static void clearConsole()
    {
        try
        {
            for(int i=0; i<50; i++){
                System.out.println();
            }
        }
        catch (final Exception e)
        {
            System.out.println("SOMETHING WENT WRONG!");
        }
    }
    public static void main(String[] args) throws IOException {
        Facade facade = new Facade();
        Scanner sc = new Scanner(System.in);
        String continueLogin;

        do {
            clearConsole();
            boolean loginSuccessful = facade.login();
            if(loginSuccessful){
                System.out.println("\n\nSUCCESSFULLY LOGGED INTO YOUR ACCOUNT!");
                break;
            } else {
                System.out.println("\n\nLOGIN ATTEMPT FAILED. USERNAME OR PASSWORD IS INCORRECT!");
                System.out.println("\nPRESS Y TO TRY AGAIN. ANYTHING ELSE TO EXIT THE APPLICATION.");
                continueLogin = sc.nextLine();
            }
        } while (continueLogin.equalsIgnoreCase("y"));
    }
}
