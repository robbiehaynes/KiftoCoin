package haynes.main;

import java.net.*;

public class Internet
{
    //Checks and returns a boolean for if the user is connected to the internet
    public static boolean isConnected()
    {
        try
        {
            URL url = new URL("https://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
}
